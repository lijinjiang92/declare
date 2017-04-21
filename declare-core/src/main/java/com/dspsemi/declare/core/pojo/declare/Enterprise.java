
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
@Table(name="enterprise")
public class Enterprise extends AbstractOperateEntity {

	private java.lang.String registrationNo;
	private java.lang.String creditCode;
	private java.lang.String enterpriseName;
	private java.lang.String legalRepresentative;
	private java.util.Date establishmentDate;
	private java.lang.String enterpriseStatus;
	private java.lang.String registrationInstitution;
	private java.lang.String jurisdictionUnit;
	private java.lang.Integer enterpriseType;
	private java.lang.Integer registeredCapital;
	private java.util.Date approvalTime;
	private java.lang.String fileNo;
	private java.lang.Integer corporateIndustry;
	private java.lang.String businessScope;
	private java.util.Date termValidity;
	private java.lang.String address;
	private java.lang.String telphone;
	private java.lang.String businessLicence;
	private java.lang.String verifiyStatus;
	
	
	

}

