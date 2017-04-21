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
import com.dspsemi.declare.core.dao.declare.MailMapper;
import com.dspsemi.declare.core.pojo.declare.Mail;
import com.dspsemi.declare.core.service.AbstractService;
import com.dspsemi.declare.core.service.declare.MailService;
import com.dspsemi.declare.core.util.Constants;
import com.dspsemi.declare.core.util.Constants.SysUser;
import com.dspsemi.declare.core.util.R;

/**
 * @author 
 * 
 */
@Service("mailService")
public class MailServiceImpl extends AbstractService<Mail> implements
		MailService {

	@Autowired
	private MailMapper mailMapper;


	public Mail add(Mail mail) {
		this.save(mail);
		return mail;
	}

	public int update(Mail mail) {
		//TODO
		return 0;
	}

	public int delete(String id) {
		return 0;
		//return this.delete(SqlGrammar.instance(Mail.class).eq(R.Mail.id, id));
	}

	public Mail load(String id) {
		return this.get(id);
	}
	
	public int remove(String[] ids) {
		//TODO
		return 0;
		//return this.updateStatus(ids, ActivityStatus.DELETE);
	}
	

	@Override
	public DataPage<Mail> page(int pageNo,int pageSize) {
		//TODO
		return null;
	}
}