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

import com.alibaba.druid.filter.config.ConfigTools;
import com.dspsemi.common.enums.entity.status.CloseStatus;
import com.dspsemi.common.error.ErrorContext;
import com.dspsemi.common.jdbc.SqlGrammar;
import com.dspsemi.common.lang.StringUtils;
import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.common.validate.Assert;
import com.dspsemi.declare.core.dao.declare.RegisterMapper;
import com.dspsemi.declare.core.pojo.declare.Register;
import com.dspsemi.declare.core.service.AbstractService;
import com.dspsemi.declare.core.service.declare.RegisterService;
import com.dspsemi.declare.core.util.Constants;
import com.dspsemi.declare.core.util.Constants.SysUser;
import com.dspsemi.declare.core.util.R;

/**
 * @author 
 * 
 */
@Service("registerService")
public class RegisterServiceImpl extends AbstractService<Register> implements
		RegisterService {

	
	@Autowired
	private RegisterMapper registerMapper;


	public Register add(Register register) {
		this.save(register);
		return register;
	}

	public int update(Register register) {
		//TODO
		return 0;
	}

	public int delete(String id) {
		return 0;
		//return this.delete(SqlGrammar.instance(Register.class).eq(R.Register.id, id));
	}

	public Register load(String id) {
		return this.get(id);
	}
	
	public int remove(String[] ids) {
		//TODO
		return 0;
		//return this.updateStatus(ids, ActivityStatus.DELETE);
	}
	

	@Override
	public DataPage<Register> page(int pageNo,int pageSize,Register register) {
		
		return super.page(sql().like(R.Register.registeName, StringUtils.isBlank(register.getRegisteName())?null:register.getCreditCode())
				.eq(R.Register.creditCode, StringUtils.isBlank(register.getCreditCode())?null:register.getCreditCode())
//				.eq(R.Register.mobile, StringUtils.isBlank(register.getMobile())?null:register.getMobile())
				.eq(R.Register.mobile, isEmpty(register.getMobile()))
				.desc(R.Register.lastLoginTime)
				.limit(pageNo, pageSize));
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println(ConfigTools.encrypt("123"));
		
	}

	@Override
	public Register loadByRegisteName(String registeName) {
		return super.get(sql().eq(R.Register.registeName, registeName).eq(R.Register.userStatus, CloseStatus.OPEN));
	}

	@Override
	public int updateLoginInfo(String lastLoginIP, Date lastLoginTime, String id) {
		return super.update(sql().update(R.Register.lastLoginIp, lastLoginIP).update(R.Register.lastLoginTime, lastLoginTime).eq(R.Register.id, id));
	}
}