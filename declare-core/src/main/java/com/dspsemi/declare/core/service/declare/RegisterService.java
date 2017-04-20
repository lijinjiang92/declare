package com.dspsemi.declare.core.service.declare;


import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.declare.core.pojo.declare.Register;

/**
 * @author Feng Qian
 * 
 */
public interface RegisterService {
	
	/**
	 * 新增
	 * 
	 * @param activity
	 * @return
	 */
	Register add(Register register);

	/**
	 * 修改
	 * 
	 * @param activity
	 * @return
	 */
	int update(Register register);

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
	Register load(String id);

	/**
	 * 分页模糊查询列表
	 * 
	 * @param name
	 *            活动名称
	 * @param acType
	 *            活动类型
	 * @param startDate
	 *            活动开始时间
	 * @param endDate
	 *            活动结束时间
	 * @param pageNo
	 *            页码
	 * @param pageSize
	 *            每页显示数量
	 * @return
	 */
	DataPage<Register> page(int pageNo, int pageSize);

	
}