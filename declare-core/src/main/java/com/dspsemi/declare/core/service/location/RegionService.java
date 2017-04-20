package com.dspsemi.declare.core.service.location;

import java.util.List;

import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.declare.core.pojo.location.Region;

public interface RegionService {

	/**
	 * 查找
	 * @return
	 */
	List<Region> list();
	
	/**
	 * 详情
	 * @param id
	 * @return
	 */
	Region load(Integer id);
	
	/**
	 * 新增
	 * @param shop
	 * @return	应该实现返回数据能获取到主键
	 */
	Region add(Region region);
	
	/**
	 * 逻辑删除
	 * @param id
	 * @return
	 */
	int remove(Integer id);
	
	/**
	 * 物理删除
	 * @param id
	 * @return
	 */
	int removePhy(Integer id);
	
	/**
	 * 分页查找
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	DataPage<Region> page(int pageNo, int pageSize);
	
}
