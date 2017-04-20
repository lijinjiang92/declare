package com.dspsemi.declare.core.service.devboard.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dspsemi.common.enums.entity.status.CloseStatus;
import com.dspsemi.common.enums.entity.status.DeleteStatus;
import com.dspsemi.common.enums.entity.status.VerifyStatus;
import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.declare.core.enums.DevBoardProType;
import com.dspsemi.declare.core.enums.NoticeType;
import com.dspsemi.declare.core.pojo.devboard.DevBoardPro;
import com.dspsemi.declare.core.service.AbstractService;
import com.dspsemi.declare.core.service.devboard.DevBoardProService;
import com.dspsemi.declare.core.util.R;

/**
 * @author XiaoJin Wang
 *
 */
@Service("devBoardProService")
public class DevBoardProServiceImpl extends AbstractService<DevBoardPro> implements DevBoardProService {

	@Override
	public List<DevBoardPro> list() {
		return super.list(sql().ne(R.DevBoardPro.status, CloseStatus.DELETE));
	}
	@Override
	public List<DevBoardPro> list(int count) {
		return super.list(sql().column(R.DevBoardPro.title)
				     .column(R.DevBoardPro.id)
				     .column(R.DevBoardPro.createTime)
				     .ne(R.DevBoardPro.status, CloseStatus.DELETE)
				     .desc(R.DevBoardPro.createTime)
				     .limit(1, count));
	}

	@Override
	public DevBoardPro load(String id) {
		return super.get(sql()
				.eq(R.DevBoardPro.id, id)
				.ne(R.DevBoardPro.status, CloseStatus.DELETE));
	}

	@Override
	@Transactional
	public DevBoardPro add(DevBoardPro devBoardPro) {
		devBoardPro.setStatus(VerifyStatus.VERIFIED);// 默认的
		devBoardPro.setApplyManTime(0L);
		devBoardPro.setApplyNum(0L);
		super.save(devBoardPro);
		return devBoardPro;
	}
	
	@Override
	public int update(DevBoardPro devBoardPro) {
		return super.update(sql()
//				.updateNeed(R.DevBoardPro.applyManTime, devBoardPro.getApplyManTime())
//				.updateNeed(R.DevBoardPro.applyNum, devBoardPro.getApplyNum())
				.updateNeed(R.DevBoardPro.applyPrice, devBoardPro.getApplyPrice())
				.updateNeed(R.DevBoardPro.beginTime, devBoardPro.getBeginTime())
				.updateNeed(R.DevBoardPro.boardBaseId, devBoardPro.getBoardBaseId())
				.updateNeed(R.DevBoardPro.description, devBoardPro.getDescription())
				.updateNeed(R.DevBoardPro.endTime, devBoardPro.getEndTime())
				.updateNeed(R.DevBoardPro.intro, devBoardPro.getIntro())
				.updateNeed(R.DevBoardPro.marketPrice, devBoardPro.getMarketPrice())
				.updateNeed(R.DevBoardPro.maxNumPer, devBoardPro.getMaxNumPer())
				.updateNeed(R.DevBoardPro.pic, devBoardPro.getPic())
				.updateNeed(R.DevBoardPro.proType, devBoardPro.getProType())
				.updateNeed(R.DevBoardPro.remark, devBoardPro.getRemark())
				.updateNeed(R.DevBoardPro.sort, devBoardPro.getSort())
				.updateNeed(R.DevBoardPro.title, devBoardPro.getTitle())
				.updateNeed(R.DevBoardPro.totalNum, devBoardPro.getTotalNum())
				.eqAst(R.DevBoardPro.id, devBoardPro.getId())
				);
	}
	
	@Override
	public int updateApplySumById(String id,Long num){
		return this.update(sql()
				.updateByRawVal(R.DevBoardPro.applyNum, "#{applyNum}+"+num)
				.eq(R.DevBoardPro.id, id));
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
	public DataPage<DevBoardPro> page(int pageNo, int pageSize,String title,DevBoardProType proType) {
		return super.page(sql()
				.ne(R.DevBoardPro.status, CloseStatus.DELETE)
				.desc(R.DevBoardPro.createTime)
				.limit(pageNo, pageSize)
				.like(R.DevBoardPro.title, title)
				.eq(R.DevBoardPro.proType, proType)
				);
	}
	
}
