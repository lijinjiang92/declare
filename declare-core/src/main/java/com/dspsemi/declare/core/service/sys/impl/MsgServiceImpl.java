package com.dspsemi.declare.core.service.sys.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.declare.core.pojo.sys.Msg;
import com.dspsemi.declare.core.service.AbstractService;
import com.dspsemi.declare.core.service.sys.MsgService;

/**
 * @author XiaoJin Wang
 *
 */
@Service("msgService")
public class MsgServiceImpl extends AbstractService<Msg> implements MsgService {

	@Override
	public List<Msg> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Msg load(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Msg add(Msg msg) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int update(Msg msg) {
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
	public DataPage<Msg> page(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
