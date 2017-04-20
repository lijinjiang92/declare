package com.dspsemi.declare.core.service.location;

import java.util.List;

import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.declare.core.pojo.location.Province;

public interface ProvinceService {

	/**
	 * 查找
	 * @return
	 */
	List<Province> list();
	
	/**
	 * 详情
	 * @param id
	 * @return
	 */
	Province load(Integer id);
	
	/**
	 * 新增
	 * @param shop
	 * @return	应该实现返回数据能获取到主键
	 */
	Province add(Province province);
	
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
	DataPage<Province> page(int pageNo, int pageSize);
	
	
	/**
	 * 分页查找 传递给o2o的省市区信息
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<Province> list4O2O(int pageNo, int pageSize);
	
}
