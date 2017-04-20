package com.dspsemi.declare.core.dao.location;

import java.util.List;
import java.util.Map;

import com.dspsemi.declare.core.pojo.location.District;

public interface DistrictMapper {
	List<District> queryByCityName(Map<String,Object> map);

}
