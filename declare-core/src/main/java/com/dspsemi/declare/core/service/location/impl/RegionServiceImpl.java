package com.dspsemi.declare.core.service.location.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.declare.core.pojo.location.Region;
import com.dspsemi.declare.core.service.AbstractService;
import com.dspsemi.declare.core.service.location.RegionService;

@Service("regionService")
public class RegionServiceImpl extends AbstractService<Region> implements RegionService {

	@Override
	public List<Region> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Region load(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Region add(Region region) {
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
	public DataPage<Region> page(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
