package com.dspsemi.declare.core.service.bbs.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dspsemi.common.jdbc.SqlGrammar;
import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.declare.core.enums.TopicStatus;
import com.dspsemi.declare.core.pojo.bbs.BbsTopicReply;
import com.dspsemi.declare.core.service.AbstractService;
import com.dspsemi.declare.core.service.bbs.BbsTopicReplyService;
import com.dspsemi.declare.core.util.R;

/**
 * @author XiaoJin Wang
 * 
 */
@Service("bbsTopicReplyService")
public class BbsTopicReplyServiceImpl extends AbstractService<BbsTopicReply>
		implements BbsTopicReplyService {

	@Override
	public List<BbsTopicReply> list() {
		SqlGrammar sqlGrammar = SqlGrammar.instance(BbsTopicReply.class)
				.columnAll(BbsTopicReply.class);
		return this.list(sqlGrammar, BbsTopicReply.class);
	}

	@Override
	public BbsTopicReply load(String id) {
		SqlGrammar sqlGrammar = SqlGrammar.instance(BbsTopicReply.class).eq(
				R.BbsTopicReply.id, id);
		return this.get(sqlGrammar);
	}

	@Override
	@Transactional
	public BbsTopicReply add(BbsTopicReply bbsTopicReply) {
		this.save(bbsTopicReply);
		return bbsTopicReply;
	}

	@Override
	public int update(BbsTopicReply bbsTopicReply) {
		SqlGrammar sqlGrammar = SqlGrammar
				.instance(BbsTopicReply.class)
				.update(R.BbsTopicReply.bbsTopic, bbsTopicReply.getBbsTopic())
				.update(R.BbsTopicReply.byReplier, bbsTopicReply.getByReplier())
				.update(R.BbsTopicReply.byReplierId,
						bbsTopicReply.getByReplierId())
				.update(R.BbsTopicReply.byReplytId,
						bbsTopicReply.getByReplytId())
				.update(R.BbsTopicReply.content, bbsTopicReply.getContent())
				.eq(R.BbsTopicReply.id, bbsTopicReply.getId());
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
	public DataPage<BbsTopicReply> page(BbsTopicReply bbsTopicReply,
			int pageNo, int pageSize) {
		SqlGrammar sqlGrammar = SqlGrammar.instance(BbsTopicReply.class)
				.columnAll(BbsTopicReply.class)
				.like(R.BbsTopicReply.content, bbsTopicReply.getContent())
				.like(R.BbsTopicReply.creator, bbsTopicReply.getCreator())
				.ne(R.BbsTopicReply.status, 9).desc(R.BbsTopicReply.createTime)
				.limit(pageNo, pageSize);
		return this.page(sqlGrammar, BbsTopicReply.class);
	}

	@Override
	public List<BbsTopicReply> loadByTopic(String topicId) {
		SqlGrammar sqlGrammar = SqlGrammar.instance(BbsTopicReply.class)
				.eq(R.BbsTopicReply.topicId, topicId)
				.ne(R.BbsTopicReply.status, 9);
		return this.list(sqlGrammar);
	}

}
