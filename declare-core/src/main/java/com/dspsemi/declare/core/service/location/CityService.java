package com.dspsemi.declare.core.service.location;

import java.util.List;

import com.dspsemi.common.enums.entity.YesNo;
import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.declare.core.bo.CityBo;
import com.dspsemi.declare.core.pojo.location.City;

public interface CityService {

	List<City> list(int provinceId);

	City load(int cityId);

	List<CityBo> listForApp(String cityName);

	DataPage<City> page(String cityName, int page, int pageSize);
 
	int update(Integer cityId, YesNo isHot, Integer sort);
}
