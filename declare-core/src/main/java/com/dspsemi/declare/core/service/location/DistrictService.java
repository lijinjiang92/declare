package com.dspsemi.declare.core.service.location;

import java.util.List;

import com.dspsemi.declare.core.pojo.location.District;

public interface DistrictService {

	/**
	 * 查找
	 * 
	 * @return
	 */
	List<District> list(int cityId);

	District load(int id);
	
	List<District> queryByCityName(String cityName);
}
