package com.dspsemi.declare.core.service.location.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dspsemi.common.jdbc.SqlGrammar;
import com.dspsemi.declare.core.dao.location.DistrictMapper;
import com.dspsemi.declare.core.pojo.location.District;
import com.dspsemi.declare.core.service.AbstractService;
import com.dspsemi.declare.core.service.location.DistrictService;
import com.dspsemi.declare.core.util.R;

@Service("districtService")
public class DistrictServiceImpl extends AbstractService<District> implements
		DistrictService {
	@Autowired
	private DistrictMapper districtMapper;
	@Override
	public List<District> list(int cityId) {
		return this.list(SqlGrammar.instance(District.class).eq(
				R.District.cityId, cityId));
	}
	
	@Override
	public District load(int id) {
		return this.get(id);
	}

	@Override
	public List<District> queryByCityName(String cityName) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("cityName", cityName);
		
		return districtMapper.queryByCityName(map);
	}
}
