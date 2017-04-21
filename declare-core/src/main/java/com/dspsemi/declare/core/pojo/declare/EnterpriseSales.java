
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
@Table(name="enterpriseSales")
public class EnterpriseSales extends AbstractOperateEntity {

	private java.lang.String fileNo;
	private java.lang.String crediCode;
	private java.lang.String infoType;
	private java.lang.String productsName;
	private java.lang.Double prodSales;
	private java.lang.String customerArea;
	private java.lang.Integer customers;
	
	
	

}
