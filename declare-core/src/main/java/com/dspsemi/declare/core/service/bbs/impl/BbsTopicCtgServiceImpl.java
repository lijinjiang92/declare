package com.dspsemi.declare.core.service.bbs.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dspsemi.common.enums.entity.status.CloseStatus;
import com.dspsemi.common.jdbc.SqlGrammar;
import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.declare.core.pojo.bbs.BbsTopicCtg;
import com.dspsemi.declare.core.service.AbstractService;
import com.dspsemi.declare.core.service.bbs.BbsTopicCtgService;
import com.dspsemi.declare.core.util.R;

/**
 * @author XiaoJin Wang
 * 
 */
@Service("bbsTopicCtgService")
public class BbsTopicCtgServiceImpl extends AbstractService<BbsTopicCtg>
		implements BbsTopicCtgService {

	@Override
	public List<BbsTopicCtg> list() {
		SqlGrammar sqlGrammar = SqlGrammar.instance(BbsTopicCtg.class).eq(
				R.BbsTopicCtg.status, CloseStatus.OPEN);
		return this.list(sqlGrammar);
	}

	@Override
	public BbsTopicCtg load(String id) {
		SqlGrammar sqlGrammar = SqlGrammar.instance(BbsTopicCtg.class).eq(
				R.BbsTopicCtg.id, id);
		return this.get(sqlGrammar);
	}

	@Override
	@Transactional
	public BbsTopicCtg add(BbsTopicCtg bbsTopicCtg) {
		this.save(bbsTopicCtg);
		return bbsTopicCtg;
	}

	@Override
	public int update(BbsTopicCtg bbsTopicCtg) {
		return this.update(bbsTopicCtg);
	}

	@Override
	public int remove(String[] ids) {
		return super.updateStatus(ids, CloseStatus.CLOSE);
	}

	@Override
	public int removePhy(String[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DataPage<BbsTopicCtg> page(int pageNo, int pageSize) {
		SqlGrammar sqlGrammar = SqlGrammar.instance(BbsTopicCtg.class)
				.eq(R.BbsTopicCtg.status, CloseStatus.OPEN)
				.limit(pageNo, pageSize);
		return this.page(sqlGrammar);
	}

}
