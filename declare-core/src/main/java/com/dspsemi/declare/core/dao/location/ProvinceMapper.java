package com.dspsemi.declare.core.dao.location;

import java.util.List;
import java.util.Map;

import com.dspsemi.declare.core.pojo.location.Province;

public interface ProvinceMapper {
	/**
	 * 分页查询传给o2o的省市区信息
	 * @param map
	 * @return
	 */
	public  List<Province> list4O2O(Map<String,Object> map) ;


}
