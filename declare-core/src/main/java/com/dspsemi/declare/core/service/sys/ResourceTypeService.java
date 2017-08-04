package com.dspsemi.declare.core.service.sys;

import java.util.List;

import com.dspsemi.common.enums.entity.status.CloseStatus;
import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.declare.core.pojo.sys.ResourceType;

/**
 * @author XiaoJin Wang
 * 
 */
public interface ResourceTypeService {

	/**
	 * 资源类型列表
	 * 
	 * @return
	 */
	List<ResourceType> list();

	/**
	 * 资源类型详情
	 * 
	 * @param id
	 * @return
	 */
	ResourceType load(Integer id);
	
	/**
	 * 根据类型名称查询
	 * @param name
	 * @return
	 */
	ResourceType getByTypeName(String name);

	/**
	 * 新增资源类型
	 * 
	 * @param resourceType
	 * @return 应该实现返回数据能获取到主键
	 */
	ResourceType add(ResourceType resourceType);

	/**
	 * 修改资源类型
	 * 
	 * @param resourceType
	 * @return
	 */
	int update(ResourceType resourceType);

	/**
	 * 逻辑删除资源类型
	 * 
	 * @param ids
	 * @return
	 */
	int remove(Integer[] ids);

	/**
	 * 物理删除资源类型
	 * 
	 * @param ids
	 * @return
	 */
	int removePhy(Integer[] ids);

	/**
	 * 资源类型分页
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	DataPage<ResourceType> page(int pageNo, int pageSize, String name,
			CloseStatus status);

}
