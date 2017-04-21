package com.dspsemi.declare.core.service.declare.impl;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dspsemi.common.error.ErrorContext;
import com.dspsemi.common.jdbc.SqlGrammar;
import com.dspsemi.common.lang.StringUtils;
import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.common.validate.Assert;
import com.dspsemi.declare.core.dao.declare.RoleGrantMapper;
import com.dspsemi.declare.core.pojo.declare.RoleGrant;
import com.dspsemi.declare.core.service.AbstractService;
import com.dspsemi.declare.core.service.declare.RoleGrantService;
import com.dspsemi.declare.core.util.Constants;
import com.dspsemi.declare.core.util.Constants.SysUser;
import com.dspsemi.declare.core.util.R;

/**
 * @author 
 * 
 */
@Service("roleGrantService")
public class RoleGrantServiceImpl extends AbstractService<RoleGrant> implements
		RoleGrantService {

	@Autowired
	private RoleGrantMapper roleGrantMapper;


	public RoleGrant add(RoleGrant roleGrant) {
		this.save(roleGrant);
		return roleGrant;
	}

	public int update(RoleGrant roleGrant) {
		//TODO
		return 0;
	}

	public int delete(String id) {
		return 0;
		//return this.delete(SqlGrammar.instance(RoleGrant.class).eq(R.RoleGrant.id, id));
	}

	public RoleGrant load(String id) {
		return this.get(id);
	}
	
	public int remove(String[] ids) {
		//TODO
		return 0;
		//return this.updateStatus(ids, ActivityStatus.DELETE);
	}
	

	@Override
	public DataPage<RoleGrant> page(int pageNo,int pageSize) {
		//TODO
		return null;
	}
}