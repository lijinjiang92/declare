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
import com.dspsemi.declare.core.dao.declare.SubjectMapper;
import com.dspsemi.declare.core.pojo.declare.Subject;
import com.dspsemi.declare.core.service.AbstractService;
import com.dspsemi.declare.core.service.declare.SubjectService;
import com.dspsemi.declare.core.util.Constants;
import com.dspsemi.declare.core.util.Constants.SysUser;
import com.dspsemi.declare.core.util.R;

/**
 * @author 
 * 
 */
@Service("subjectService")
public class SubjectServiceImpl extends AbstractService<Subject> implements
		SubjectService {

	@Autowired
	private SubjectMapper subjectMapper;


	public Subject add(Subject subject) {
		this.save(subject);
		return subject;
	}

	public int update(Subject subject) {
		//TODO
		return 0;
	}

	public int delete(String id) {
		return 0;
		//return this.delete(SqlGrammar.instance(Subject.class).eq(R.Subject.id, id));
	}

	public Subject load(String id) {
		return this.get(id);
	}
	
	public int remove(String[] ids) {
		//TODO
		return 0;
		//return this.updateStatus(ids, ActivityStatus.DELETE);
	}
	

	@Override
	public DataPage<Subject> page(int pageNo,int pageSize) {
		//TODO
		return null;
	}
}