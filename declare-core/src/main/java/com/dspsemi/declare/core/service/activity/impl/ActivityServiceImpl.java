package com.dspsemi.declare.core.service.activity.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dspsemi.common.enums.entity.status.VerifyStatus;
import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.declare.core.bo.DynamicBo;
import com.dspsemi.declare.core.dao.activity.ActivityMapper;
import com.dspsemi.declare.core.pojo.activity.Activity;
import com.dspsemi.declare.core.service.AbstractService;
import com.dspsemi.declare.core.service.activity.ActivityService;
import com.dspsemi.declare.core.util.R;

/**
 * @author XiaoJin Wang
 * 
 */
@Service("activityService")
public class ActivityServiceImpl extends AbstractService<Activity> implements
		ActivityService {

	@Resource
	private ActivityMapper activityMapper;
	
	@Override
	public List<Activity> list(String title) {
		super.list(sql().like(R.Activity.title, title).desc(R.Activity.sort)
				.desc(R.Activity.createTime));
		return null;
	}
	
	@Override
	public List<Activity> list() {
		return super.list(sql().desc(R.Activity.sort).eq(R.Activity.status,VerifyStatus.VERIFIED)
				.desc(R.Activity.createTime));
	}

	@Override
	public Activity load(String id) {
		return super.get(sql().eq(R.Activity.id, id));
	}

	@Override
	@Transactional
	public Activity add(Activity activity) {
		super.save(activity);
		return null;
	}

	@Override
	public int update(Activity activity) {
		return super.update(sql().update(R.Activity.title, activity.getTitle())
				.update(R.Activity.pic, activity.getPic())
				.update(R.Activity.intro, activity.getIntro())
				.update(R.Activity.detail, activity.getDetail())
				.eq(R.Activity.id, activity.getId()));
	}

	@Override
	public int remove(String[] ids) {
		return super.updateStatus(ids, VerifyStatus.SYS_DELETE);
	}

	@Override
	public int removePhy(String[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DataPage<Activity> page(int pageNo, int pageSize, String title) {
		return super.page(sql().desc(R.Activity.createTime)
				.ne(R.Activity.status, VerifyStatus.SYS_DELETE)
				.limit(pageNo, pageSize).like(R.Activity.title, title));
	}

	@Override
	public List<DynamicBo> dynamic4index() {
		return activityMapper.dynamic4index();
	}

	@Override
	public int browseNumUpdateByRawVal(String id) {
		return this.update(sql().updateByRawVal(R.Activity.browseNum, "#{browseNum}+1").eq(R.Activity.id, id));
	}

}
