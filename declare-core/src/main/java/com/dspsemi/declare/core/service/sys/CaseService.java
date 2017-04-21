package com.dspsemi.declare.core.service.sys;

import java.util.List;

import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.declare.core.pojo.sys.Case;

/**
 * @author XiaoJin Wang
 *
 */
public interface CaseService {

	/**
	 * 案例列表
	 * @return
	 */
	List<Case> list();
	
	/**
	 * 案例详情
	 * @param id
	 * @return
	 */
	Case load(String id);
	
	/**
	 * 新增案例
	 * @param case
	 * @return	应该实现返回数据能获取到主键
	 */
	Case add(Case obj);
	
	/**
	 * 修改案例
	 * @param case
	 * @return
	 */
	int update(Case obj);
	
	/**
	 * 逻辑删除案例
	 * @param ids
	 * @return
	 */
	int remove(String[] ids);
	
	/**
	 * 物理删除案例
	 * @param ids
	 * @return
	 */
	int removePhy(String[] ids);
	
	/**
	 * 案例分页
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	DataPage<Case> page(String title,int pageNo, int pageSize);
	/**
	 * 判断是否有同标题的存在
	 * @param title
	 * @return
	 */
	boolean isExist(String title);
	
	/**
	 * 获取首页案例
	 * @return
	 */
	List<Case> case4Index();
}
