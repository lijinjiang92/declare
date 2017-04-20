package com.dspsemi.declare.core.service.sys.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dspsemi.common.enums.entity.status.CloseStatus;
import com.dspsemi.common.jdbc.SqlGrammar;
import com.dspsemi.common.lang.StringUtils;
import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.declare.core.pojo.sys.Case;
import com.dspsemi.declare.core.service.AbstractService;
import com.dspsemi.declare.core.service.sys.CaseService;
import com.dspsemi.declare.core.util.R;

/**
 * @author XiaoJin Wang
 * 
 */
@Service("caseService")
public class CaseServiceImpl extends AbstractService<Case> implements
		CaseService {

	@Override
	public List<Case> list() {
		// TODO Auto-generated method stub
		return this.list(SqlGrammar.instance(Case.class).eq(R.Case.status,
				CloseStatus.OPEN));
	}

	@Override
	public Case load(String id) {
		// TODO Auto-generated method stub
		return this.get(SqlGrammar.instance(Case.class).eq(R.Case.id, id));
	}

	@Override
	@Transactional
	public Case add(Case obj) {
		// TODO Auto-generated method stub
		this.save(obj);
		return obj;
	}

	@Override
	public int update(Case obj) {
		// TODO Auto-generated method stub
		return this.update(SqlGrammar.instance(Case.class)
				.update(R.Case.title, obj.getTitle())
				.update(R.Case.sort, obj.getSort())
				.update(R.Case.content, obj.getContent())
				.update(R.Case.summary, obj.getSummary())
				.update(R.Case.pic, obj.getPic()).eq(R.Case.id, obj.getId()));
	}

	@Override
	public int remove(String[] ids) {
		// TODO Auto-generated method stub
		return this.update(SqlGrammar.instance(Case.class)
				.update(R.Case.status, CloseStatus.CLOSE).in(R.Case.id, ids));
	}

	@Override
	public int removePhy(String[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DataPage<Case> page(String title, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return this.page(
				SqlGrammar
						.instance(Case.class)
						.column(R.Case.id)
						.column(R.Case.title)
						.column(R.Case.status)
						.column(R.Case.pic)
						.column(R.Case.sort)
						.column(R.Case.browseNum)
						.column(R.Case.createTime)
						.eq(R.Case.status, CloseStatus.OPEN)
						.like(R.Case.title,
								StringUtils.isEmpty(title) ? null : title
										.trim()).limit(pageNo, pageSize),
				Case.class);
	}

	public boolean isExist(String title) {
		Case caseObj = this.get(SqlGrammar.instance(Case.class).eq(
				R.Case.title, title.trim()));
		if (caseObj == null) {
			return false;
		} else {
			return true;
		}

	}

	@Override
	public List<Case> case4Index() {
		return super.list(sql().eq(R.Case.status, CloseStatus.OPEN)
				.limitByIndex(3));
	}

}
