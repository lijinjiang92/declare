
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
@Table(name="mail")
public class Mail extends AbstractOperateEntity {

	private java.lang.Integer id;
	private java.lang.String smtp;
	private java.lang.String username;
	private java.lang.String password;
	private java.lang.Integer port;
	
	
	

}
