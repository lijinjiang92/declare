package com.dspsemi.declare.core.service.sys.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dspsemi.common.enums.entity.status.CloseStatus;
import com.dspsemi.common.enums.entity.status.DeleteStatus;
import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.declare.core.enums.NoticeType;
import com.dspsemi.declare.core.pojo.sys.Notice;
import com.dspsemi.declare.core.service.AbstractService;
import com.dspsemi.declare.core.service.sys.NoticeService;
import com.dspsemi.declare.core.util.R;

/**
 * @author XiaoJin Wang
 *
 */
@Service("noticeService")
public class NoticeServiceImpl extends AbstractService<Notice> implements NoticeService {

	@Override
	public List<Notice> list() {
		return super.list(sql().ne(R.Notice.status, CloseStatus.DELETE));
	}

	@Override
	public Notice load(String id) {
		return super.get(sql()
				.eq(R.Notice.id, id)
				.ne(R.Notice.status, CloseStatus.DELETE));
	}

	@Override
	@Transactional
	public Notice add(Notice notice) {
//		CodeMsgExt.FAIL.msg("用户名{0}已被占用", company.getName());
//		Assert.notBlank(company.getCompanyNo(), ErrorCode.PARAM_BLANK, "商家ID");
//		Assert.notBlank(username, ErrorCode.PARAM_BLANK, "用户名");
		notice.setStatus(DeleteStatus.NEW);// 默认的
		notice.setVisitNum(0);// 默认的
		notice.setNoticeType(NoticeType.BBS);
		super.save(notice);
		return notice;
	}
	
	@Override
	public int update(Notice notice) {
		return super.update(sql()
				.updateNeed(R.Notice.title, notice.getTitle())
				.updateNeed(R.Notice.content, notice.getContent())
				.updateNeed(R.Notice.publicTime, notice.getPublicTime())
				.eqAst(R.Notice.id, notice.getId())
				);
	}

	@Override
	public int remove(String[] ids) {
		return super.updateStatus(ids, CloseStatus.DELETE);
	}
	
	@Override
	public int removePhy(String[] ids) {
		return 0;
	}

	@Override
	public DataPage<Notice> page(int pageNo, int pageSize,String titleQuery) {
		return super.page(sql()
				.ne(R.Notice.status, CloseStatus.DELETE)
				.desc(R.Notice.createTime)
				.limit(pageNo, pageSize)
				.like(R.Notice.title, titleQuery));
	}
	
}
