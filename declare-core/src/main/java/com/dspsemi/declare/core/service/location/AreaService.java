package com.dspsemi.declare.core.service.location;

import java.util.List;

import com.dspsemi.declare.core.pojo.location.Area;

public interface AreaService {

	/**
	 * 查找
	 * @return
	 */
	List<Area> list(int districtId);
	
	Area load(int id);
}
