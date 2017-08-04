package com.dspsemi.declare.core.service.bbs.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dspsemi.common.enums.entity.YesNo;
import com.dspsemi.common.jdbc.SqlGrammar;
import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.declare.core.dao.bbs.BbsTopicMapper;
import com.dspsemi.declare.core.enums.TopicStatus;
import com.dspsemi.declare.core.pojo.bbs.BbsTopic;
import com.dspsemi.declare.core.service.AbstractService;
import com.dspsemi.declare.core.service.bbs.BbsTopicService;
import com.dspsemi.declare.core.util.R;

/**
 * @author XiaoJin Wang
 * 
 */
@Service("BbsTopicService")
public class BbsTopicServiceImpl extends AbstractService<BbsTopic> implements
		BbsTopicService {

	@Resource
	private BbsTopicMapper bbsTopicMapper;
	
	@Override
	public List<BbsTopic> list() {
		SqlGrammar sqlGrammar = SqlGrammar.instance(BbsTopic.class).columnAll(
				BbsTopic.class);
		return this.list(sqlGrammar, BbsTopic.class);
	}

	@Override
	public BbsTopic load(String id) {
		return this.get(id);
	}

	@Override
	@Transactional
	public BbsTopic add(BbsTopic bbsTopic) {
		this.save(bbsTopic);
		return bbsTopic;
	}

	@Override
	public int update(BbsTopic bbsTopic) {
		SqlGrammar sqlGrammar = SqlGrammar.instance(BbsTopic.class)
				.update(R.BbsTopic.bbsSection, bbsTopic.getBbsSection())
				.update(R.BbsTopic.bbsTopicCtg, bbsTopic.getBbsTopicCtg())
				.update(R.BbsTopic.collectNum, bbsTopic.getCollectNum())
				.update(R.BbsTopic.content, bbsTopic.getContent())
				.update(R.BbsTopic.ctgId, bbsTopic.getCtgId())
				.update(R.BbsTopic.isElite, bbsTopic.getIsElite())
				.update(R.BbsTopic.isHot, bbsTopic.getIsHot())
				.update(R.BbsTopic.isReply, bbsTopic.getIsReply())
				.update(R.BbsTopic.isStick, bbsTopic.getIsStick())
				.update(R.BbsTopic.replyNum, bbsTopic.getReplyNum())
				.update(R.BbsTopic.sectionId, bbsTopic.getSectionId())
				.update(R.BbsTopic.sort, bbsTopic.getSort())
				.update(R.BbsTopic.title, bbsTopic.getTitle())
				.update(R.BbsTopic.visitNum, bbsTopic.getVisitNum() + 1);
		return this.update(sqlGrammar);
	}
	
	@Override
	public int remove(String[] ids) {
		return super.updateStatus(ids, TopicStatus.SYS_DELETE);
	}

	@Override
	public int removePhy(String[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DataPage<BbsTopic> page(BbsTopic topic, String status, int pageNo, int pageSize) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startRow", (pageNo-1)*pageSize);
		map.put("pageSize", pageSize);
		map.put("status", status);
		map.put("title", topic.getTitle());
		map.put("creator", topic.getCreator());
			
		
		DataPage<BbsTopic> datas = new DataPage<BbsTopic>();
		datas.setData(bbsTopicMapper.pageTopic(map));
		datas.setTotalCount(bbsTopicMapper.pageTopicCount(map));
		datas.setPageNo(pageNo);
		datas.setPageSize(pageSize);
		return datas;
	}
	
	@Override
	public DataPage<BbsTopic> pageBySectionId(String sectionId, String status, int pageNo, int pageSize) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startRow", (pageNo-1)*pageSize);
		map.put("pageSize", pageSize);
		map.put("status", status);
		map.put("sectionId", sectionId);
			
		
		DataPage<BbsTopic> datas = new DataPage<BbsTopic>();
		datas.setData(bbsTopicMapper.pageTopicBySectionId(map));
		datas.setTotalCount(bbsTopicMapper.pageTopicCountBySectionId(map));
		datas.setPageNo(pageNo);
		datas.setPageSize(pageSize);
		return datas;
	}
	
	
	
	
	

	
	
	
	

	@Override
	public int updateTopicStatus(String topicId, YesNo isReply, YesNo isElite,
			YesNo isHot, YesNo isStick, Integer sort) {
		SqlGrammar sqlGrammar = SqlGrammar.instance(BbsTopic.class)
				.update(R.BbsTopic.isReply, isReply)
				.update(R.BbsTopic.isElite, isElite)
				.update(R.BbsTopic.isHot, isHot)
				.update(R.BbsTopic.isStick, isStick)
				.update(R.BbsTopic.sort, sort).eq(R.BbsTopic.id, topicId);
		return this.update(sqlGrammar);
	}
}
