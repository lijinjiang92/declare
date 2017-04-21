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
import com.dspsemi.declare.core.dao.declare.DdYearMapper;
import com.dspsemi.declare.core.pojo.declare.DdYear;
import com.dspsemi.declare.core.service.AbstractService;
import com.dspsemi.declare.core.service.declare.DdYearService;
import com.dspsemi.declare.core.util.Constants;
import com.dspsemi.declare.core.util.Constants.SysUser;
import com.dspsemi.declare.core.util.R;

/**
 * @author 
 * 
 */
@Service("ddYearService")
public class DdYearServiceImpl extends AbstractService<DdYear> implements
		DdYearService {

	@Autowired
	private DdYearMapper ddYearMapper;


	public DdYear add(DdYear ddYear) {
		this.save(ddYear);
		return ddYear;
	}

	public int update(DdYear ddYear) {
		//TODO
		return 0;
	}

	public int delete(String id) {
		return 0;
		//return this.delete(SqlGrammar.instance(DdYear.class).eq(R.DdYear.id, id));
	}

	public DdYear load(String id) {
		return this.get(id);
	}
	
	public int remove(String[] ids) {
		//TODO
		return 0;
		//return this.updateStatus(ids, ActivityStatus.DELETE);
	}
	

	@Override
	public DataPage<DdYear> page(int pageNo,int pageSize) {
		//TODO
		return null;
	}
}