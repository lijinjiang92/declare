
package com.dspsemi.declare.core.pojo.declare;

import java.util.Date;

import com.dspsemi.common.enums.entity.status.VerifyStatus;
import com.dspsemi.common.jpa.Add2Resource;
import com.dspsemi.common.jpa.Entity;
import com.dspsemi.common.jpa.Id;
import com.dspsemi.common.jpa.Table;
import com.dspsemi.common.lang.dto.AbstractOperateEntity;
import com.dspsemi.declare.core.util.mybatis.GeneratedValue;
import com.dspsemi.declare.core.util.mybatis.GeneratorEnum;

/**
 * 
 * @author jinjiang li
 *
 */
@Entity
@Add2Resource
@Table(name="projectWz")
public class ProjectWz extends AbstractOperateEntity {

	private java.lang.String subjectNo;
	private java.lang.String wzType;
	private java.lang.String wzContent;
	private java.lang.Integer wzSum;
	private java.util.Date wzPayDate;
	private java.lang.Double wzMoney;
	private java.lang.String wzFinanceNo;
	private java.lang.String wzBillNo;
	private java.lang.String wzBill;
	
	
	

}

