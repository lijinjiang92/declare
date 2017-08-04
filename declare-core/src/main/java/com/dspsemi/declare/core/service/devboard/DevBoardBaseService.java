package com.dspsemi.declare.core.service.devboard;

import java.util.List;

import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.declare.core.pojo.devboard.DevBoardBase;

/**
 * @author XiaoJin Wang
 *
 */
public interface DevBoardBaseService {

	/**
	 * 开发板基础表列表
	 * @return
	 */
	List<DevBoardBase> list();
	
	/**
	 * 开发板基础表详情
	 * @param id
	 * @return
	 */
	DevBoardBase load(String id);
	
	/**
	 * 新增开发板基础表
	 * @param devBoardBase
	 * @return	应该实现返回数据能获取到主键
	 */
	DevBoardBase add(DevBoardBase devBoardBase);
	
	/**
	 * 修改开发板基础表
	 * @param devBoardBase
	 * @return
	 */
	int update(DevBoardBase devBoardBase);
	
	/**
	 * 逻辑删除开发板基础表
	 * @param ids
	 * @return
	 */
	int remove(String[] ids);
	/**
	 * 开发板审核
	 * @param ids
	 * @return
	 */
	int verify(String[] ids);
	
	/**
	 * 物理删除开发板基础表
	 * @param ids
	 * @return
	 */
	int removePhy(String[] ids);
	
	/**
	 * 开发板基础表分页
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	DataPage<DevBoardBase> page(int pageNo, int pageSize, String name, String manufacturer);
	
}
