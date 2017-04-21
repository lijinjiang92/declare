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
import com.dspsemi.declare.core.dao.declare.EnterpriseReportMapper;
import com.dspsemi.declare.core.pojo.declare.EnterpriseReport;
import com.dspsemi.declare.core.service.AbstractService;
import com.dspsemi.declare.core.service.declare.EnterpriseReportService;
import com.dspsemi.declare.core.util.Constants;
import com.dspsemi.declare.core.util.Constants.SysUser;
import com.dspsemi.declare.core.util.R;

/**
 * @author 
 * 
 */
@Service("enterpriseReportService")
public class EnterpriseReportServiceImpl extends AbstractService<EnterpriseReport> implements
		EnterpriseReportService {

	@Autowired
	private EnterpriseReportMapper enterpriseReportMapper;


	public EnterpriseReport add(EnterpriseReport enterpriseReport) {
		this.save(enterpriseReport);
		return enterpriseReport;
	}

	public int update(EnterpriseReport enterpriseReport) {
		//TODO
		return 0;
	}

	public int delete(String id) {
		return 0;
		//return this.delete(SqlGrammar.instance(EnterpriseReport.class).eq(R.EnterpriseReport.id, id));
	}

	public EnterpriseReport load(String id) {
		return this.get(id);
	}
	
	public int remove(String[] ids) {
		//TODO
		return 0;
		//return this.updateStatus(ids, ActivityStatus.DELETE);
	}
	

	@Override
	public DataPage<EnterpriseReport> page(int pageNo,int pageSize) {
		//TODO
		return null;
	}
}