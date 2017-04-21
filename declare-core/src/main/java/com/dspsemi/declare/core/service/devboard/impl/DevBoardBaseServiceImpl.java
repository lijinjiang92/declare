package com.dspsemi.declare.core.service.devboard.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dspsemi.common.enums.entity.status.CloseStatus;
import com.dspsemi.common.enums.entity.status.DeleteStatus;
import com.dspsemi.common.enums.entity.status.VerifyStatus;
import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.declare.core.enums.NoticeType;
import com.dspsemi.declare.core.pojo.devboard.DevBoardBase;
import com.dspsemi.declare.core.service.AbstractService;
import com.dspsemi.declare.core.service.devboard.DevBoardBaseService;
import com.dspsemi.declare.core.util.R;

/**
 * @author XiaoJin Wang
 *
 */
@Service("devBoardBaseService")
public class DevBoardBaseServiceImpl extends AbstractService<DevBoardBase> implements DevBoardBaseService {

	@Override
	public List<DevBoardBase> list() {
		return super.list(sql()
				.ne(R.DevBoardBase.status, CloseStatus.DELETE)
				.desc(R.DevBoardBase.sort)
				.desc(R.DevBoardBase.createTime)
				);
	}

	@Override
	public DevBoardBase load(String id) {
		return super.get(sql()
				.eq(R.DevBoardBase.id, id)
				.ne(R.DevBoardBase.status, CloseStatus.DELETE));
	}

	@Override
	@Transactional
	public DevBoardBase add(DevBoardBase devBoardBase) {
		devBoardBase.setStatus(VerifyStatus.UNVERIFY);// 默认的
		super.save(devBoardBase);
		return devBoardBase;
	}
	
	@Override
	public int update(DevBoardBase devBoardBase) {
		return super.update(sql()
				.updateNeed(R.DevBoardBase.brandId, devBoardBase.getBrandId())
				.updateNeed(R.DevBoardBase.categoryId, devBoardBase.getCategoryId())
				.updateNeed(R.DevBoardBase.subCategoryId, devBoardBase.getSubCategoryId())
//				.updateNeed(R.DevBoardBase.devBoardApplys, devBoardBase.getDevBoardApplys())
//				.updateNeed(R.DevBoardBase.devBoardPros, devBoardBase.getDevBoardPros())
//				.updateNeed(R.DevBoardBase.devBoardReports, devBoardBase.getDevBoardPros())
				.updateNeed(R.DevBoardBase.intro, devBoardBase.getIntro())
				.updateNeed(R.DevBoardBase.manufacturer, devBoardBase.getManufacturer())
				.updateNeed(R.DevBoardBase.name, devBoardBase.getName())
				.updateNeed(R.DevBoardBase.pic, devBoardBase.getPic())
				.updateNeed(R.DevBoardBase.price, devBoardBase.getPrice())
				.updateNeed(R.DevBoardBase.remark, devBoardBase.getRemark())
				.updateNeed(R.DevBoardBase.sort, devBoardBase.getSort())
				.eqAst(R.DevBoardBase.id, devBoardBase.getId())
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
	public DataPage<DevBoardBase> page(int pageNo, int pageSize, String name, String manufacturer) {
		return super.page(sql()
				.ne(R.DevBoardBase.status, CloseStatus.DELETE)
				.desc(R.DevBoardBase.createTime)
				.desc(R.DevBoardBase.sort)
				.limit(pageNo, pageSize)
				.like(R.DevBoardBase.name, name)
				.like(R.DevBoardBase.manufacturer, manufacturer)
				);
	}

	@Override
	public int verify(String[] ids) {
		return super.updateStatus(ids, VerifyStatus.VERIFIED);
	}
	
}
