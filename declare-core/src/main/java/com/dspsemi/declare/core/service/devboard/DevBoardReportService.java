package com.dspsemi.declare.core.service.devboard;

import java.util.List;

import com.dspsemi.common.enums.entity.status.VerifyStatus;
import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.declare.core.pojo.devboard.DevBoardReport;

/**
 * @author XiaoJin Wang
 *
 */
public interface DevBoardReportService {
	
	/**
	 * 开发板报告审核
	 * @param ids
	 * @return
	 */
	int verify(String[] ids);

	/**
	 * 开发板报告表列表
	 * @return
	 */
	List<DevBoardReport> list();
	/**
	 * 开发板报告表列表(取前count条)
	 * @return
	 */
	List<DevBoardReport> list(int count);
	/**
	 *根据发布的产品ID获取试用报告列表
	 * @return
	 */
	List<DevBoardReport> getListByBaseId(String id);
	
	/**
	 * 开发板报告表详情
	 * @param id
	 * @return
	 */
	DevBoardReport load(String id);
	
	/**
	 * 新增开发板报告表
	 * @param devBoardReport
	 * @return	应该实现返回数据能获取到主键
	 */
	DevBoardReport add(DevBoardReport devBoardReport);
	
	/**
	 * 修改开发板报告表
	 * @param devBoardReport
	 * @return
	 */
	int update(DevBoardReport devBoardReport);
	
	/**
	 * 逻辑删除开发板报告表
	 * @param ids
	 * @return
	 */
	int remove(String[] ids);
	
	/**
	 * 物理删除开发板报告表
	 * @param ids
	 * @return
	 */
	int removePhy(String[] ids);
	
	/**
	 * 开发板报告表分页
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	DataPage<DevBoardReport> page(int pageNo, int pageSize,String title,VerifyStatus status);
	
	/**
	 * 开发板报告表分页
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	DataPage<DevBoardReport> forePage(int pageNo, int pageSize,String createId,VerifyStatus status);
	
	
	/**
	 * 修改开发板报告表(个人中心)
	 * @param devBoardReport
	 * @return
	 */
	int updateFore(DevBoardReport devBoardReport);
	
}
