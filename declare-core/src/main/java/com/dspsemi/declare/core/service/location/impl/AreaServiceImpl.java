package com.dspsemi.declare.core.service.location.impl;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dspsemi.common.jdbc.SqlGrammar;
import com.dspsemi.declare.core.pojo.location.Area;
import com.dspsemi.declare.core.service.AbstractService;
import com.dspsemi.declare.core.service.location.AreaService;
import com.dspsemi.declare.core.util.R;
@Service("areaService")
public class AreaServiceImpl extends AbstractService<Area> implements AreaService {
	@Override
	public List<Area> list(int districtId) {
		return this.list(SqlGrammar.instance(Area.class)
				.eq(R.Area.districtId, districtId));
	}
	@Override
	public Area load(int id) {
		return this.get(id);
	}
}
