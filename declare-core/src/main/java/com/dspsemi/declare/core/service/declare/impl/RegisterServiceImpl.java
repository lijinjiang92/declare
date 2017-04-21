package com.dspsemi.declare.core.service.declare.impl;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.druid.filter.config.ConfigTools;
import com.dspsemi.common.enums.entity.status.CloseStatus;
import com.dspsemi.common.error.CodeMsg;
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
		return this.update(sql().update(R.Register.userStatus, CloseStatus.DELETE).in(R.Register.id, ids));
	}
	

	@Override
	public DataPage<Register> page(int pageNo,int pageSize,Register register) {
		
		return super.page(sql().like(R.Register.registeName, StringUtils.isBlank(register.getRegisteName())?null:register.getCreditCode())
				.eq(R.Register.creditCode, StringUtils.isBlank(register.getCreditCode())?null:register.getCreditCode())
//				.eq(R.Register.mobile, StringUtils.isBlank(register.getMobile())?null:register.getMobile())
				.eq(R.Register.mobile, isEmpty(register.getMobile()))
				.ne(R.Register.userStatus, CloseStatus.DELETE)
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

	@Override
	public int updatePwd(String id, String oldPwd, String newPwd) {
		Register register = load(id);
		//用户不存在
		if(register==null){
			return 0;
		}
		//用户密码加密
		try {
			oldPwd = encoderByMd5(oldPwd, register.getHash());
			newPwd = encoderByMd5(newPwd, register.getHash());
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} 
		//修改密码
		if(oldPwd.equals(register.getRegistePassword())){
			return super.update(sql().update(R.Register.registePassword, newPwd).eq(R.Register.id, id));
		}
		
		return 0;
	}
	
	/**
	 * 加密密码
	 * @param pwd
	 * @param salt
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	private String encoderByMd5(String pwd,String salt) throws NoSuchAlgorithmException, UnsupportedEncodingException{
        //确定计算方法
		String newStr = pwd+salt;
        MessageDigest md5=MessageDigest.getInstance("MD5");
        
        return Base64.encodeBase64URLSafeString(md5.digest(newStr.getBytes("utf-8")));
    }

	@Override
	public int openClose(String[] ids, CloseStatus status) {
		return super.update(sql().update(R.Register.userStatus, status).in(R.Register.id, ids));
	}
	
}