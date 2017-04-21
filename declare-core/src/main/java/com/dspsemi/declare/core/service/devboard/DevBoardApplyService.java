package com.dspsemi.declare.core.service.devboard;

import java.util.List;

import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.declare.core.enums.DevBoardApplyStatus;
import com.dspsemi.declare.core.pojo.devboard.DevBoardApply;

/**
 * @author XiaoJin Wang
 *
 */
public interface DevBoardApplyService {

	/**
	 * 开发板申请表列表
	 * @return
	 */
	List<DevBoardApply> list(int count);
	/**
	 * 根据开发板ID获得开发板申请列表
	 * @return
	 */
	List<DevBoardApply> getListByBoardProId(String BoardProId);
	
	/**
	 * 开发板申请表详情
	 * @param id
	 * @return
	 */
	DevBoardApply load(String id);
	
	/**
	 * 新增开发板申请表
	 * @param devBoardApply
	 * @return	应该实现返回数据能获取到主键
	 */
	int add(DevBoardApply devBoardApply);
	
	/**
	 * 修改开发板申请表
	 * @param devBoardApply
	 * @return
	 */
	int update(DevBoardApply devBoardApply);
	
	/**
	 * 逻辑删除开发板申请表
	 * @param ids
	 * @return
	 */
	int remove(String[] ids);
	
	/**
	 * 物理删除开发板申请表
	 * @param ids
	 * @return
	 */
	int removePhy(String[] ids);
	
	/**
	 * 开发板申请表分页
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	DataPage<DevBoardApply> page(String name,DevBoardApplyStatus devStatus,int pageNo, int pageSize);
	/**
	 * 根据ID更改状态
	 * @param verifying
	 * @param id
	 * @return
	 */

	int updateStatusById(DevBoardApplyStatus verifying, String id);
	
	
	/**
	 * 开发板申请表分页 --- 个人中心
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	DataPage<DevBoardApply> forePage(String name,DevBoardApplyStatus devStatus,int pageNo, int pageSize,String createId);
	
	
}
