package com.dspsemi.declare.core.service.declare;


import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.declare.core.pojo.declare.EnterpriseSales;

/**
 * @author Feng Qian
 * 
 */
public interface EnterpriseSalesService {
	
	/**
	 * 新增
	 * 
	 * @param activity
	 * @return
	 */
	EnterpriseSales add(EnterpriseSales enterpriseSales);

	/**
	 * 修改
	 * 
	 * @param activity
	 * @return
	 */
	int update(EnterpriseSales enterpriseSales);

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
	EnterpriseSales load(String id);

	/**
	 * 分页模糊查询列表
	 * 
	 * @param pageNo
	 *            页码
	 * @param pageSize
	 *            每页显示数量
	 * @return
	 */
	DataPage<EnterpriseSales> page(int pageNo, int pageSize);

	
}