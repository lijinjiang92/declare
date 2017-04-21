package com.dspsemi.declare.core.service.declare;


import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.declare.core.pojo.declare.RoleGrant;

/**
 * @author Feng Qian
 * 
 */
public interface RoleGrantService {
	
	/**
	 * 新增
	 * 
	 * @param activity
	 * @return
	 */
	RoleGrant add(RoleGrant roleGrant);

	/**
	 * 修改
	 * 
	 * @param activity
	 * @return
	 */
	int update(RoleGrant roleGrant);

	/**
	 * 删除
	 * 
	 * @param activityId
	 * @return
	 */
	int delete(String id);

	/**
	 * 逻辑删除
	 * 
	 * @param activityIds
	 * @return
	 */
	int remove(String[] ids);

	/**
	 * 根据主键ID获取信息
	 * 
	 * @param activityId
	 * @return
	 */
	RoleGrant load(String id);

	/**
	 * 分页模糊查询列表
	 * 
	 * @param pageNo
	 *            页码
	 * @param pageSize
	 *            每页显示数量
	 * @return
	 */
	DataPage<RoleGrant> page(int pageNo, int pageSize);

	
}