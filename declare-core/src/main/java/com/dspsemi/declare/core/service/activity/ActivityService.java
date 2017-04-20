package com.dspsemi.declare.core.service.activity;

import java.util.List;

import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.declare.core.bo.DynamicBo;
import com.dspsemi.declare.core.pojo.activity.Activity;

/**
 * @author XiaoJin Wang
 * 
 */
public interface ActivityService {

	
	/**
	 * 添加阅读次数
	 * @param news
	 * @return
	 */
	int browseNumUpdateByRawVal(String id);
	/**
	 * 活动表列表
	 * 
	 * @return
	 */
	List<Activity> list(String title);
	/**
	 * 前台活动表列表
	 * 
	 * @return
	 */
	List<Activity> list();

	/**
	 * 活动表详情
	 * 
	 * @param id
	 * @return
	 */
	Activity load(String id);

	/**
	 * 新增活动表
	 * 
	 * @param activity
	 * @return 应该实现返回数据能获取到主键
	 */
	Activity add(Activity activity);

	/**
	 * 修改活动表
	 * 
	 * @param activity
	 * @return
	 */
	int update(Activity activity);

	/**
	 * 逻辑删除活动表
	 * 
	 * @param ids
	 * @return
	 */
	int remove(String[] ids);

	/**
	 * 物理删除活动表
	 * 
	 * @param ids
	 * @return
	 */
	int removePhy(String[] ids);

	/**
	 * 活动表分页
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	DataPage<Activity> page(int pageNo, int pageSize, String title);
	
	/**
	 * 首页获取动态列表
	 * @return
	 */
	List<DynamicBo> dynamic4index();

}
