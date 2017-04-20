package com.dspsemi.declare.core.service.user.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.declare.core.pojo.user.Collect;
import com.dspsemi.declare.core.service.AbstractService;
import com.dspsemi.declare.core.service.user.CollectService;

/**
 * @author XiaoJin Wang
 *
 */
@Service("collectService")
public class CollectServiceImpl extends AbstractService<Collect> implements CollectService {

	@Override
	public List<Collect> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collect load(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Collect add(Collect collect) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int update(Collect collect) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int remove(String[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int removePhy(String[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DataPage<Collect> page(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
