package com.dspsemi.declare.core.service.bbs.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dspsemi.common.enums.entity.status.CloseStatus;
import com.dspsemi.common.jdbc.SqlGrammar;
import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.declare.core.pojo.bbs.BbsSectionCtg;
import com.dspsemi.declare.core.service.AbstractService;
import com.dspsemi.declare.core.service.bbs.BbsSectionCtgService;
import com.dspsemi.declare.core.util.R;

/**
 * @author XiaoJin Wang
 *
 */
@Service("bbsSectionCtgService")
public class BbsSectionCtgServiceImpl extends AbstractService<BbsSectionCtg> implements BbsSectionCtgService {

	@Override
	public List<BbsSectionCtg> list(String name, CloseStatus status) {
		return super.list(sql()
				.like(R.BbsSectionCtg.name, name)
				.eq(R.BbsSectionCtg.status, status)
				.ne(R.BbsSectionCtg.status, CloseStatus.DELETE)
				.desc(R.BbsSectionCtg.sort)
				.desc(R.BbsSectionCtg.createTime)
				);	
	}

	@Override
	public BbsSectionCtg load(Integer id) {
		return super.get(sql()
				.eq(R.BbsSectionCtg.id, id)
				.ne(R.BbsSectionCtg.status, CloseStatus.DELETE));
	}

	@Override
	@Transactional
	public BbsSectionCtg add(BbsSectionCtg bbsSectionCtg) {
//		CodeMsgExt.FAIL.msg("用户名{0}已被占用", company.getName());
//		Assert.notBlank(company.getCompanyNo(), ErrorCode.PARAM_BLANK, "商家ID");
//		Assert.notBlank(username, ErrorCode.PARAM_BLANK, "用户名");
		bbsSectionCtg.setStatus(CloseStatus.OPEN);// 默认的
		super.save(bbsSectionCtg);
		return bbsSectionCtg;
	}
	
	@Override
	public int update(BbsSectionCtg bbsSectionCtg) {
		return super.update(sql()
				.updateNeed(R.BbsSectionCtg.name, bbsSectionCtg.getName())
				.updateNeed(R.BbsSectionCtg.sort, bbsSectionCtg.getSort())
				.updateNeed(R.BbsSectionCtg.status, bbsSectionCtg.getStatus())
				.eqAst(R.BbsSectionCtg.id, bbsSectionCtg.getId())
				);
	}

	@Override
	public int remove(Integer[] ids) {
		return super.updateStatus(ids, CloseStatus.DELETE);
	}
	
	@Override
	public int removePhy(Integer[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DataPage<BbsSectionCtg> page(int pageNo, int pageSize,String titleQuery) {
		return super.page(sql()
				.ne(R.BbsSectionCtg.status, CloseStatus.DELETE)
				.desc(R.BbsSectionCtg.createTime)
				.limit(pageNo, pageSize)
				.like(R.BbsSectionCtg.name, titleQuery));
	}
	@Override
	public boolean existname(String name, String excludeId){
		return this.exist(sql()
				.eqAst(R.BbsSectionCtg.name, name)
				.ne(R.BbsSectionCtg.status, CloseStatus.DELETE)
				.ne(R.BbsSectionCtg.id, excludeId)
				);
	}
	@Override
	public int openClose(String[] ids, CloseStatus status) {
		return super.updateStatus(ids, status);
	}
	
}
