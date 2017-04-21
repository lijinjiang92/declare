
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
@Table(name="subject")
public class Subject extends AbstractOperateEntity {

	private java.lang.String subjectNo;
	private java.lang.String creditCode;
	private java.lang.String subjectName;
	private java.lang.String registeredService;
	private java.lang.String serviceProvider;
	private java.lang.String declarationOpinion;
	private java.util.Date declarationTime;
	private java.lang.String departmentOpinion;
	private java.util.Date departmentDate;
	private java.util.Date subjectStartTime;
	private java.util.Date subjectEndTime;
	private java.lang.String bookPerson;
	private java.lang.String examinePerson;
	private java.lang.String subjectUpload;
	private java.lang.Double subjectMoney;
	
	
	

}

