package com.dspsemi.declare.core.service.sys.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dspsemi.common.enums.entity.status.CloseStatus;
import com.dspsemi.common.enums.entity.status.DeleteStatus;
import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.declare.core.pojo.sys.UsualIssueType;
import com.dspsemi.declare.core.service.AbstractService;
import com.dspsemi.declare.core.service.sys.UsualIssueTypeService;
import com.dspsemi.declare.core.util.R;

/**
 * @author XiaoJin Wang
 *
 */
@Service("usualIssueTypeService")
public class UsualIssueTypeServiceImpl extends AbstractService<UsualIssueType> implements UsualIssueTypeService {

	@Override
	public List<UsualIssueType> list() {
		return super.list(sql()
				.ne(R.UsualIssueType.status, CloseStatus.DELETE)
				.desc(R.UsualIssueType.sort)
				.desc(R.UsualIssueType.createTime)
				);
	}

	@Override
	public UsualIssueType load(Integer id) {
		return super.get(sql()
				.eq(R.UsualIssueType.id, id)
				.ne(R.UsualIssueType.status, CloseStatus.DELETE));
	}

	@Override
	@Transactional
	public UsualIssueType add(UsualIssueType usualIssueType) {
		usualIssueType.setStatus(DeleteStatus.NEW);
		super.save(usualIssueType);
		return usualIssueType;
	}
	
	@Override
	public int update(UsualIssueType usualIssueType) {
		return super.update(sql()
				.updateNeed(R.UsualIssueType.name, usualIssueType.getName())
				.updateNeed(R.UsualIssueType.sort, usualIssueType.getSort())
				.eqAst(R.UsualIssueType.id, usualIssueType.getId())
				);
	}

	@Override
	public int remove(Integer[] ids) {
		return super.updateStatus(ids, DeleteStatus.SYS_DELETE);
	}
	
	@Override
	public int removePhy(Integer[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DataPage<UsualIssueType> page(int pageNo, int pageSize, String nameQuery) {
		return super.page(sql()
				.ne(R.UsualIssueType.status, CloseStatus.DELETE)
				.desc(R.UsualIssueType.createTime)
				.limit(pageNo, pageSize)
				.like(R.UsualIssueType.name, nameQuery));
	}
	
}
