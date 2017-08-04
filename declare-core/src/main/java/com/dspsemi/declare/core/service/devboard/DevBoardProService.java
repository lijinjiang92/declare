package com.dspsemi.declare.core.service.devboard;

import java.util.List;

import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.declare.core.enums.DevBoardProType;
import com.dspsemi.declare.core.pojo.devboard.DevBoardPro;

/**
 * @author XiaoJin Wang
 *
 */
public interface DevBoardProService {

	/**
	 * 开发板产品表列表
	 * @return
	 */
	List<DevBoardPro> list();
	/**
	 * 开发板产品表列表(根据数量取，按照创建时间排序）
	 * @return
	 */
	List<DevBoardPro> list(int count);
	
	/**
	 * 开发板产品表详情
	 * @param id
	 * @return
	 */
	DevBoardPro load(String id);
	
	/**
	 * 新增开发板产品表
	 * @param devBoardPro
	 * @return	应该实现返回数据能获取到主键
	 */
	DevBoardPro add(DevBoardPro devBoardPro);
	
	/**
	 * 修改开发板产品表
	 * @param devBoardPro
	 * @return
	 */
	int update(DevBoardPro devBoardPro);
	
	/**
	 * 更新申请人数
	 * @param id
	 * @return
	 */
	int updateApplySumById(String id,Long num);
	
	/**
	 * 逻辑删除开发板产品表
	 * @param ids
	 * @return
	 */
	int remove(String[] ids);
	
	/**
	 * 物理删除开发板产品表
	 * @param ids
	 * @return
	 */
	int removePhy(String[] ids);
	
	/**
	 * 开发板产品表分页
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	DataPage<DevBoardPro> page(int pageNo, int pageSize,String title,DevBoardProType proType);
	
}
