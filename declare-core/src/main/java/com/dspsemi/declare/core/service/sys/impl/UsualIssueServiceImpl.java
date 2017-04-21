package com.dspsemi.declare.core.service.sys.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dspsemi.common.enums.entity.status.CloseStatus;
import com.dspsemi.common.enums.entity.status.DeleteStatus;
import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.declare.core.enums.NoticeType;
import com.dspsemi.declare.core.pojo.sys.UsualIssue;
import com.dspsemi.declare.core.service.AbstractService;
import com.dspsemi.declare.core.service.sys.UsualIssueService;
import com.dspsemi.declare.core.util.R;

/**
 * @author XiaoJin Wang
 *
 */
@Service("usualIssueService")
public class UsualIssueServiceImpl extends AbstractService<UsualIssue> implements UsualIssueService {

	@Override
	public List<UsualIssue> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsualIssue load(String id) {
		return super.get(sql()
				.join(R.UsualIssue.usualIssueType, "u")
				.column(R.UsualIssueType.name,R.UsualIssue.typeName)
				.columnAll(UsualIssue.class)
				.eq(R.UsualIssue.id, id)
				.ne(R.UsualIssue.status, CloseStatus.DELETE));
	}

	@Override
	@Transactional
	public UsualIssue add(UsualIssue usualIssue) {
		usualIssue.setStatus(CloseStatus.OPEN);// 默认的
		if(usualIssue.getBrowseNum()==null){
			usualIssue.setBrowseNum(0L);// 默认的
		}
		super.save(usualIssue);
		return usualIssue;
	}
	
	@Override
	public int update(UsualIssue usualIssue) {
		return super.update(sql()
				.updateNeed(R.UsualIssue.title, usualIssue.getTitle())
				.updateNeed(R.UsualIssue.issueTypeId, usualIssue.getIssueTypeId())
				.updateNeed(R.UsualIssue.content, usualIssue.getContent())
				.updateNeed(R.UsualIssue.publishTime, usualIssue.getPublishTime())
				.updateNeed(R.UsualIssue.sort, usualIssue.getSort())
				.updateNeed(R.UsualIssue.browseNum, usualIssue.getBrowseNum())
				.eqAst(R.UsualIssue.id, usualIssue.getId())
				);
	}

	@Override
	public int remove(String[] ids) {
		return super.updateStatus(ids, CloseStatus.DELETE);
	}
	
	@Override
	public int removePhy(String[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DataPage<UsualIssue> page(int pageNo, int pageSize, String titleQuery, Integer issueTypeId) {
		return super.page(sql()
				.join(R.UsualIssue.usualIssueType, "u")
				.column(R.UsualIssueType.name,R.UsualIssue.typeName)
				.columnAll(UsualIssue.class)
				.ne(R.UsualIssue.status, CloseStatus.DELETE)
				.eq(R.UsualIssueType.id, issueTypeId)
				.like(R.UsualIssue.title, titleQuery)
				.desc(R.UsualIssue.createTime)
				.limit(pageNo, pageSize)
				);
	}

	@Override
	public List<UsualIssue> listByTypeIds(Integer[] ids) {
		return super.list(sql()
				.ne(R.UsualIssue.status, CloseStatus.DELETE)
				.in(R.UsualIssue.issueTypeId, ids)
				);
	}
	
}
