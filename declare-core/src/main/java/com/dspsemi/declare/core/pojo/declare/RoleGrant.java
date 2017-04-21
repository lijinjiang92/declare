
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
@Table(name="roleGrant")
public class RoleGrant extends AbstractOperateEntity {

	private java.lang.String id;
	private java.lang.String grantName;
	private java.lang.String grantFlag;
	private java.lang.String grantPic;
	private java.lang.Integer grantType;
	private java.lang.String grantUrl;
	
	
	

}

