package com.dspsemi.declare.core.service.location.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dspsemi.common.jdbc.SqlGrammar;
import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.declare.core.dao.location.ProvinceMapper;
import com.dspsemi.declare.core.pojo.location.Province;
import com.dspsemi.declare.core.service.AbstractService;
import com.dspsemi.declare.core.service.location.ProvinceService;

@Service("provinceService")
public class ProvinceServiceImpl extends AbstractService<Province> implements ProvinceService {
	@Autowired
	private ProvinceMapper provinceMapper;
	@Override
	public List<Province> list() {
		return this.list(SqlGrammar.instance(Province.class));
	}

	@Override
	public Province load(Integer id) {
		return this.get(id);
	}

	@Override
	@Transactional
	public Province add(Province province) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int remove(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removePhy(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DataPage<Province> page(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Province> list4O2O(int pageNo, int pageSize) {
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("startRow", (pageNo-1)*pageSize);
		map.put("pageSize", pageSize);
		return provinceMapper.list4O2O(map);
	}
	
}
