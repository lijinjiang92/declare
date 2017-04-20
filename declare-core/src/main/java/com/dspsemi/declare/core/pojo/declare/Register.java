
package com.dspsemi.declare.core.pojo.declare;

import java.util.Date;

import com.dspsemi.common.enums.entity.status.CloseStatus;
import com.dspsemi.common.enums.entity.status.VerifyStatus;
import com.dspsemi.common.jpa.Add2Resource;
import com.dspsemi.common.jpa.Entity;
import com.dspsemi.common.jpa.Id;
import com.dspsemi.common.jpa.Table;
import com.dspsemi.common.lang.dto.AbstractEntity;
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
@Table(name="register")
public class Register extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -178971814089382056L;
	@Id
	@GeneratedValue(GeneratorEnum.REGISTER_ID)
	private java.lang.String id;
	private java.lang.String registeName;
	private java.lang.String registePassword;
	private java.lang.String creditCode;
	private java.lang.String telphone;
	private java.lang.String mobile;
	private java.lang.String email;
	private java.lang.String qq;
	private java.lang.String resume;
	private java.lang.String hash;
	private java.lang.String registeredIp;
	private java.lang.String lastLoginIp;
	private java.util.Date lastLoginTime;
	private CloseStatus userStatus;
	
	public java.lang.String getId() {
		return id;
	}
	public void setId(java.lang.String id) {
		this.id = id;
	}
	public java.lang.String getRegisteName() {
		return registeName;
	}
	public void setRegisteName(java.lang.String registeName) {
		this.registeName = registeName;
	}
	public java.lang.String getRegistePassword() {
		return registePassword;
	}
	public void setRegistePassword(java.lang.String registePassword) {
		this.registePassword = registePassword;
	}
	public java.lang.String getCreditCode() {
		return creditCode;
	}
	public void setCreditCode(java.lang.String creditCode) {
		this.creditCode = creditCode;
	}
	public java.lang.String getTelphone() {
		return telphone;
	}
	public void setTelphone(java.lang.String telphone) {
		this.telphone = telphone;
	}
	public java.lang.String getMobile() {
		return mobile;
	}
	public void setMobile(java.lang.String mobile) {
		this.mobile = mobile;
	}
	public java.lang.String getEmail() {
		return email;
	}
	public void setEmail(java.lang.String email) {
		this.email = email;
	}
	public java.lang.String getQq() {
		return qq;
	}
	public void setQq(java.lang.String qq) {
		this.qq = qq;
	}
	public java.lang.String getResume() {
		return resume;
	}
	public void setResume(java.lang.String resume) {
		this.resume = resume;
	}
	public java.lang.String getHash() {
		return hash;
	}
	public void setHash(java.lang.String hash) {
		this.hash = hash;
	}
	public java.lang.String getRegisteredIp() {
		return registeredIp;
	}
	public void setRegisteredIp(java.lang.String registeredIp) {
		this.registeredIp = registeredIp;
	}
	public java.lang.String getLastLoginIp() {
		return lastLoginIp;
	}
	public void setLastLoginIp(java.lang.String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}
	public java.util.Date getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(java.util.Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public void setUserStatus(CloseStatus userStatus) {
		this.userStatus = userStatus;
	}
	public CloseStatus getUserStatus() {
		return userStatus;
	}
	
	
	

}

