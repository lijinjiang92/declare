package com.dspsemi.declare.core.service.devboard.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dspsemi.common.enums.entity.status.CloseStatus;
import com.dspsemi.common.enums.entity.status.DeleteStatus;
import com.dspsemi.common.enums.entity.status.VerifyStatus;
import com.dspsemi.common.jdbc.JoinType;
import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.declare.core.enums.NoticeType;
import com.dspsemi.declare.core.pojo.devboard.DevBoardReport;
import com.dspsemi.declare.core.service.AbstractService;
import com.dspsemi.declare.core.service.devboard.DevBoardReportService;
import com.dspsemi.declare.core.util.R;

/**
 * @author XiaoJin Wang
 *
 */
@Service("devBoardReportService")
public class DevBoardReportServiceImpl extends AbstractService<DevBoardReport> implements DevBoardReportService {

	@Override
	public List<DevBoardReport> list() {
		return super.list(sql().ne(R.DevBoardReport.status, CloseStatus.DELETE));
	}
	@Override
	public List<DevBoardReport> list(int count) {
		return super.list(sql().ne(R.DevBoardReport.status, CloseStatus.DELETE)
				     .limit(1, count));
	}
	public List<DevBoardReport> getListByBaseId(String id){
		return super.list(sql().eq(R.DevBoardReport.boardProId, id));
	}
	

	@Override
	public DevBoardReport load(String id) {
		return super.get(sql()
				.eq(R.DevBoardReport.id, id)
				.ne(R.DevBoardReport.status, CloseStatus.DELETE));
	}

	@Override
	@Transactional
	public DevBoardReport add(DevBoardReport devBoardReport) {
		devBoardReport.setStatus(VerifyStatus.UNVERIFY);// 默认的
		super.save(devBoardReport);
		return devBoardReport;
	}
	
	@Override
	public int update(DevBoardReport devBoardReport) {
		return super.update(sql()
				.updateNeed(R.DevBoardReport.title, devBoardReport.getTitle())
				.updateNeed(R.DevBoardReport.remark, devBoardReport.getRemark())
				.updateNeed(R.DevBoardReport.status, devBoardReport.getStatus())
				.updateNeed(R.DevBoardReport.sort, devBoardReport.getSort())
				.updateNeed(R.DevBoardReport.browseNum, devBoardReport.getBrowseNum())
				.eqAst(R.DevBoardReport.id, devBoardReport.getId())
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
	public DataPage<DevBoardReport> page(int pageNo, int pageSize,String title,VerifyStatus status) {
		return super.page(sql()
				.ne(R.DevBoardReport.status, CloseStatus.DELETE)
				.desc(R.DevBoardReport.createTime)
				.limit(pageNo, pageSize)
				.like(R.DevBoardReport.title, title)
				.eq(R.DevBoardReport.status, status)
				);
	}

	@Override
	public int verify(String[] ids) {
		return super.updateStatus(ids, VerifyStatus.VERIFIED);
	}
	@Override
	public DataPage<DevBoardReport> forePage(int pageNo, int pageSize, String createId, VerifyStatus status) {
		return super.page(sql()
				.join(R.DevBoardApply.devBoardPro, "devP", JoinType.INNER_JOIN)
				.column(R.DevBoardReport.id)
				.column(R.DevBoardReport.title)
				.column(R.DevBoardReport.createTime)
				.column(R.DevBoardReport.browseNum)
				.column(R.DevBoardReport.status)
				.column(R.DevBoardPro.intro,R.DevBoardReport.devBoardProIntro)
				.ne(R.DevBoardReport.status, CloseStatus.DELETE)
				.eq(R.DevBoardReport.status, status)
				.eq(R.DevBoardReport.creatorId, createId)
				.limit(pageNo, pageSize)
				);
	}
	
	@Override
	public int updateFore(DevBoardReport devBoardReport) {
		return super.update(sql()
				.updateNeed(R.DevBoardReport.title, devBoardReport.getTitle())
				.updateNeed(R.DevBoardReport.content, devBoardReport.getContent())
				.eqAst(R.DevBoardReport.id, devBoardReport.getId())
				);
	}
	
}
