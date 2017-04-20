package com.dspsemi.declare.core.service.location.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dspsemi.common.enums.entity.YesNo;
import com.dspsemi.common.jdbc.SqlGrammar;
import com.dspsemi.common.lang.StringUtils;
import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.declare.core.bo.CityBo;
import com.dspsemi.declare.core.dao.location.CityMapper;
import com.dspsemi.declare.core.pojo.location.City;
import com.dspsemi.declare.core.service.AbstractService;
import com.dspsemi.declare.core.service.location.CityService;
import com.dspsemi.declare.core.util.R;

@Service("cityService")
public class CityServiceImpl extends AbstractService<City> implements CityService {
	@Autowired
	CityMapper cityMapper;
	@Override
	public List<City> list(int provinceId) {
		return this.list(SqlGrammar.instance(City.class).eq(R.City.provinceId, provinceId));
	}

	@Override
	public City load(int cityId) {
		return this.get(cityId);
	}

	@Override
	public List<CityBo> listForApp(String cityName) {
		return cityMapper.getCityForAPP(cityName);
	}

	@Override
	public DataPage<City> page(String cityName, int page, int pageSize) {
		cityName = StringUtils.isEmpty(cityName) ? null : cityName.trim();
		if(cityName!=null){
			if(cityName.indexOf("市")!=-1)
				cityName = cityName.replace("市","");
			if(cityName.indexOf("shi")!=-1)
				cityName = cityName.replace("shi", "");
		}
		return this.page(SqlGrammar
				.instance(City.class)
				.or(SqlGrammar.instance(City.class).like(R.City.name, cityName)
						.like(R.City.pinyin, cityName)).desc(R.City.isHot).desc(R.City.sort)
				.limit(page, pageSize));
	}

	@Override
	@Transactional
	public int update(Integer cityId, YesNo isHot, Integer sort) {
		return this.update(SqlGrammar.instance(City.class).update(R.City.isHot, isHot)
				.update(R.City.sort, sort).eq(R.City.id, cityId));
	}
}
