package com.dspsemi.declare.core.service.declare;


import java.util.Date;

import com.dspsemi.common.enums.entity.status.CloseStatus;
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
	 * 更新用户登录信息
	 * 
	 * @param activity
	 * @return
	 */
	int updateLoginInfo(String lastLoginIP, Date lastLoginTime, String id);

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
	 * 根据主键ID获取信息
	 * 
	 * @param activityId
	 * @return
	 */
	Register loadByRegisteName(String registeName);

	/**
	 * 分页模糊查询列表
	 *
	 * @param pageNo
	 *            页码
	 * @param pageSize
	 *            每页显示数量
	 * @return
	 */
	DataPage<Register> page(int pageNo, int pageSize,Register register);
	
	/**
	 * 修改用户密码 0 失败 1成功
	 * @param id
	 * @param oldPwd
	 * @param newPwd
	 * @return
	 */
	int updatePwd(String id,String oldPwd,String newPwd);
	
	public int openClose(String[] ids, CloseStatus status);
	
	
	

	
}