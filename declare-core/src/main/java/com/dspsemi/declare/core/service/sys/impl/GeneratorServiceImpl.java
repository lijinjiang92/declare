package com.dspsemi.declare.core.service.sys.impl;

import java.lang.reflect.Constructor;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dspsemi.common.enums.entity.YesNo;
import com.dspsemi.common.error.BaseException;
import com.dspsemi.common.generator.AbstractGenerator;
import com.dspsemi.common.generator.GeneratorType;
import com.dspsemi.common.jdbc.LockMode;
import com.dspsemi.common.jdbc.SqlGrammar;
import com.dspsemi.common.lang.StringUtils;
import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.common.lang.reflect.FieldUtils;
import com.dspsemi.declare.core.pojo.sys.Generator;
import com.dspsemi.declare.core.service.AbstractService;
import com.dspsemi.declare.core.service.sys.GeneratorService;
import com.dspsemi.declare.core.util.R;
import com.dspsemi.declare.core.util.mybatis.GeneratorEnum;

/**
 * @author XiaoJin Wang
 *
 */
@Transactional
@Service("generatorService")
public class GeneratorServiceImpl extends AbstractService<Generator> implements GeneratorService {

	private Lock lock = new ReentrantLock();
	
	@Override
	public List<Generator> list() {
		return super.list(sql().desc(R.Generator.createTime));
	}

	@Override
	public Generator load(GeneratorEnum generatorType) {
		return super.get(generatorType);
	}

	@Override
	@Transactional
	public int update(Generator generator) {
		if(StringUtils.isBlank(generator.getMaxVal()))
			generator.setMaxVal(null);
		super.get(sql()
				.eqAst(R.Generator.generatorType, generator.getGeneratorType())
				.lockMode(LockMode.UPGRADE)
				);
		
		if(generator.getGeneratorType().getGenerator() != null) {
			Class<?> type = generator.getGeneratorType().getRawGenerator().getClass();
			try {
				Constructor<?> cs = type.getConstructor(int.class, int.class, String.class, String.class, String.class, YesNo.class);
				AbstractGenerator<?> ge = (AbstractGenerator<?>)cs.newInstance(
						generator.getIncrement(), generator.getFetchSize(),
						generator.getInitialVal(), generator.getCurrentVal(),
						generator.getMaxVal(), generator.getIsCycle());
				generator.getGeneratorType().setGenerator(ge);
			} catch (Exception e) {
				throw new BaseException("Instance AbstractGenerator error.", e);
			}
		}
		
		return super.update(sql()
				.updateAst(R.Generator.initialVal, generator.getInitialVal())
				.updateAst(R.Generator.currentVal, generator.getCurrentVal())
				.updateAst(R.Generator.fetchSize, generator.getFetchSize())
				.updateAst(R.Generator.increment, generator.getIncrement())
				.updateAst(R.Generator.isCycle, generator.getIsCycle())
				.updateNeed(R.Generator.maxVal, generator.getMaxVal())
				.eqAst(R.Generator.generatorType, generator.getGeneratorType())
				);
	}
	
	@Override
	@Transactional
	public int updateIsCycle(GeneratorEnum generatorType, YesNo isCycle) {
		super.get(sql()
				.eqAst(R.Generator.generatorType, generatorType)
				.lockMode(LockMode.UPGRADE)
				);
		
		if(generatorType.getGenerator() != null) {
			try {
				FieldUtils.writeField(generatorType.getGenerator(), "isCycle", isCycle, true);
			} catch (Exception e) {
				throw new BaseException("Write isCycle field error.", e);
			}
		}
		
		return super.update(sql()
				.updateAst(R.Generator.isCycle, isCycle)
				.eqAst(R.Generator.generatorType, generatorType)
				);
	}

	@Override
	public DataPage<Generator> page(GeneratorEnum generatorType, 
			YesNo isCycle, int pageNo, int pageSize) {
		return super.page(sql()
				.eq(R.Generator.generatorType, generatorType)
				.eq(R.Generator.isCycle, isCycle)
				.desc(R.Generator.createTime)
				.limit(pageNo, pageSize)
				);
	}
	
	@Override
	@SuppressWarnings("rawtypes")
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public Generator incrementAndGet(GeneratorEnum generatorType) {
		Generator g = super.get(sql()
						.eq(R.Generator.generatorType, generatorType)
						.lockMode(LockMode.UPGRADE));
		if(g == null) {
			lock.lock();
			try {
				g = super.get(sql()
						.eq(R.Generator.generatorType, generatorType)
						.lockMode(LockMode.UPGRADE));
				g = g == null ? this.add(generatorType) : g;
			}finally {
				lock.unlock();
			}
		}
		AbstractGenerator ag = generatorType.getGenerator();
		boolean updateDbCurrentVal = ag == null || ag.getGenNum() >= ag.getFetchSize() ? true : false;
		if(ag == null) {
	    	ag = generatorType.getRawGenerator();
	    	generatorType.setGenerator(ag);
		}
		if(updateDbCurrentVal) {
			Object nextBatchStart = ag.nextStepVal(g.getCurrentVal());
			//nextBatchStart 返回下批数据的起始值。返回null则不更新数据库的CurrentVal，例：生成uuid只依据自己的规则，所以返回null
			if(nextBatchStart != null) {
				this.update(SqlGrammar.instance(Generator.class)
						.update(R.Generator.currentVal, nextBatchStart.toString())
						.eq(R.Generator.generatorType, generatorType));
			}
		}
		return g;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void incrementGenerator(GeneratorType generatorType) {
		incrementAndGet((GeneratorEnum)generatorType);
	}

	@Override
	@Transactional
	public int batchAdd() throws Exception {
		GeneratorEnum[] types = GeneratorEnum.values();
		int num = 0;
		for(GeneratorEnum type : types) {
			if(this.add(type) != null) num++;
		}
		return num;
	}
	
	@Transactional
	@SuppressWarnings("rawtypes")
	private Generator add(GeneratorEnum type) {
		if(type.getGenerator() == null) {
			//没有Generator的type才需要出入数据库
			Generator temp = super.get(type);
			if(temp == null) {
				AbstractGenerator ag = type.getRawGenerator();
				//数据库中不存在才插入数据库
				Generator g = new Generator();
				g.setGeneratorType(type);
		    	g.setInitialVal(ag.getInitialVal().toString());
		    	g.setCurrentVal(ag.getInitialVal().toString());
		    	g.setMaxVal(ag.getMaxVal() == null ? null : ag.getMaxVal().toString());
		    	g.setFetchSize(ag.getFetchSize());
		    	g.setIncrement(ag.getIncrement());
		    	g.setIsCycle(ag.getIsCycle());
		    	this.save(g);
		    	return g;
			}
		}
		return null;
	}
	
}
