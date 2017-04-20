package com.dspsemi.declare.core.dao.location;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dspsemi.declare.core.bo.CityBo;

public interface CityMapper {
	
	public String getMaxCode(int cityId);
	
	public List<CityBo> getCityForAPP(@Param(value = "cityName") String cityName);

}
