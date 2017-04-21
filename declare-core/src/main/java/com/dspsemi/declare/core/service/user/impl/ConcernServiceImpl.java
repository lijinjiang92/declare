package com.dspsemi.declare.core.service.user.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.declare.core.pojo.user.Concern;
import com.dspsemi.declare.core.service.AbstractService;
import com.dspsemi.declare.core.service.user.ConcernService;

/**
 * @author XiaoJin Wang
 *
 */
@Service("concernService")
public class ConcernServiceImpl extends AbstractService<Concern> implements ConcernService {

	@Override
	public List<Concern> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Concern load(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Concern add(Concern concern) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int update(Concern concern) {
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
	public DataPage<Concern> page(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
