package com.dspsemi.declare.core.service.bbs.impl;

import java.util.List;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dspsemi.common.enums.entity.status.CloseStatus;
import com.dspsemi.common.jdbc.JoinType;
import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.declare.core.bo.BbsSectionListBo;
import com.dspsemi.declare.core.pojo.bbs.BbsSection;
import com.dspsemi.declare.core.pojo.bbs.BbsSectionCtg;
import com.dspsemi.declare.core.service.AbstractService;
import com.dspsemi.declare.core.service.bbs.BbsSectionService;
import com.dspsemi.declare.core.util.R;

/**
 * @author XiaoJin Wang
 *
 */
@Service("bbsSectionService")
public class BbsSectionServiceImpl extends AbstractService<BbsSection> implements BbsSectionService {

	@Override
	public List<BbsSection> list(String name, CloseStatus status) {
		return super.list(sql()
				.like(R.BbsSection.name, name)
				.eq(R.BbsSection.status, status)
				.ne(R.BbsSection.status, CloseStatus.DELETE)
				.desc(R.BbsSection.sort)
				.desc(R.BbsSection.createTime)
				);	
	}

	@Override
	public BbsSection load(Integer id) {
		BbsSection bbsSection= super.get(sql()
				.join(R.BbsSection.bbsSectionCtg, "c", JoinType.LEFT_OUTER_JOIN)
				.columnAll(BbsSection.class)
				.column(R.BbsSectionCtg.name, "bbsSectionCtg.name")
				.eq(R.BbsSection.id, id)
				.ne(R.BbsSection.status, CloseStatus.DELETE));
		return bbsSection;
	}

	@Override
	@Transactional
	public BbsSection add(BbsSection bbsSection) {
		bbsSection.setStatus(CloseStatus.OPEN);// 默认的
		bbsSection.setConcernNum(NumberUtils.INTEGER_ZERO);// 默认的
		bbsSection.setTopicNum(NumberUtils.INTEGER_ZERO);// 默认的
		super.save(bbsSection);
		return bbsSection;
	}
	
	@Override
	public int update(BbsSection bbsSection) {
		return super.update(sql()
				.updateNeed(R.BbsSection.ctgId, bbsSection.getCtgId())
				.updateNeed(R.BbsSection.describes, bbsSection.getDescribes())
				.updateNeed(R.BbsSection.name, bbsSection.getName())
				.updateNeed(R.BbsSection.sort, bbsSection.getSort())
				.updateNeed(R.BbsSection.status, bbsSection.getStatus()              )
				.eqAst(R.BbsSection.id, bbsSection.getId())
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
	public DataPage<BbsSectionListBo> page(int pageNo, int pageSize,String titleQuery) {
		DataPage<BbsSectionListBo> dataPage=super.page(sql()
				.join(R.BbsSection.bbsSectionCtg, "c", JoinType.LEFT_OUTER_JOIN)
				.column(R.BbsSection.name,R.BbsSection.name)
				.column(R.BbsSection.id,R.BbsSection.id)
				.column(R.BbsSection.createTime,R.BbsSection.createTime)
				.column(R.BbsSection.creator,R.BbsSection.creator)
				.column(R.BbsSectionCtg.name, R.BbsSectionListBo.bbsSectionCtgName)
				.column(R.BbsSection.concernNum,R.BbsSection.concernNum)
				.column(R.BbsSection.topicNum,R.BbsSection.topicNum)
				.column(R.BbsSection.sort,R.BbsSection.sort)
				.column(R.BbsSection.status,R.BbsSection.status)
				.ne(R.BbsSection.status, CloseStatus.DELETE)
				.like(R.BbsSection.name, titleQuery)
				.limit(pageNo, pageSize)
				.desc(R.BbsSection.createTime)
				, BbsSectionListBo.class);
		return dataPage;
		
	}
	@Override
	public boolean existname(String name, String excludeId){
		return this.exist(sql()
				.eqAst(R.BbsSection.name, name)
				.ne(R.BbsSection.status, CloseStatus.DELETE)
				.ne(R.BbsSection.id, excludeId)
				);
	}
	@Override
	public int openClose(String[] ids, CloseStatus status) {
		return super.updateStatus(ids, status);
	}
	
}
