package com.dspsemi.declare.core.service.sys;

import java.util.List;

import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.declare.core.pojo.sys.Resource;

/**
 * @author XiaoJin Wang
 *
 */
public interface ResourceService {

	/**
	 * 资源列表
	 * @return
	 */
	List<Resource> list();
	
	/**
	 * 资源列表
	 * @return
	 */
	List<Resource> list(Integer resourceTypeId);
	
	/**
	 * 资源详情
	 * @param id
	 * @return
	 */
	Resource load(String id);
	
	/**
	 * 新增资源
	 * @param resource
	 * @return	应该实现返回数据能获取到主键
	 */
	Resource add(Resource resource);
	
	/**
	 * 修改资源
	 * @param resource
	 * @return
	 */
	int update(Resource resource);
	
	/**
	 * 逻辑删除资源
	 * @param ids
	 * @return
	 */
	int remove(String[] ids);
	
	/**
	 * 物理删除资源
	 * @param ids
	 * @return
	 */
	int removePhy(String[] ids);
	
	/**
	 * 资源分页
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	DataPage<Resource> page(int pageNo, int pageSize, String title, Integer resourceTypeId);
	
}
