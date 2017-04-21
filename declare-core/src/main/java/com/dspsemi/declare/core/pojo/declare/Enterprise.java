
package com.dspsemi.declare.core.pojo.declare;

import java.util.Date;

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
@Table(name="enterprise")
public class Enterprise extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1154790695599550583L;
	
	@Id
	@GeneratedValue(GeneratorEnum.UUID)
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
	public java.lang.String getRegistrationNo() {
		return registrationNo;
	}
	public void setRegistrationNo(java.lang.String registrationNo) {
		this.registrationNo = registrationNo;
	}
	public java.lang.String getCreditCode() {
		return creditCode;
	}
	public void setCreditCode(java.lang.String creditCode) {
		this.creditCode = creditCode;
	}
	public java.lang.String getEnterpriseName() {
		return enterpriseName;
	}
	public void setEnterpriseName(java.lang.String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}
	public java.lang.String getLegalRepresentative() {
		return legalRepresentative;
	}
	public void setLegalRepresentative(java.lang.String legalRepresentative) {
		this.legalRepresentative = legalRepresentative;
	}
	public java.util.Date getEstablishmentDate() {
		return establishmentDate;
	}
	public void setEstablishmentDate(java.util.Date establishmentDate) {
		this.establishmentDate = establishmentDate;
	}
	public java.lang.String getEnterpriseStatus() {
		return enterpriseStatus;
	}
	public void setEnterpriseStatus(java.lang.String enterpriseStatus) {
		this.enterpriseStatus = enterpriseStatus;
	}
	public java.lang.String getRegistrationInstitution() {
		return registrationInstitution;
	}
	public void setRegistrationInstitution(java.lang.String registrationInstitution) {
		this.registrationInstitution = registrationInstitution;
	}
	public java.lang.String getJurisdictionUnit() {
		return jurisdictionUnit;
	}
	public void setJurisdictionUnit(java.lang.String jurisdictionUnit) {
		this.jurisdictionUnit = jurisdictionUnit;
	}
	public java.lang.Integer getEnterpriseType() {
		return enterpriseType;
	}
	public void setEnterpriseType(java.lang.Integer enterpriseType) {
		this.enterpriseType = enterpriseType;
	}
	public java.lang.Integer getRegisteredCapital() {
		return registeredCapital;
	}
	public void setRegisteredCapital(java.lang.Integer registeredCapital) {
		this.registeredCapital = registeredCapital;
	}
	public java.util.Date getApprovalTime() {
		return approvalTime;
	}
	public void setApprovalTime(java.util.Date approvalTime) {
		this.approvalTime = approvalTime;
	}
	public java.lang.String getFileNo() {
		return fileNo;
	}
	public void setFileNo(java.lang.String fileNo) {
		this.fileNo = fileNo;
	}
	public java.lang.Integer getCorporateIndustry() {
		return corporateIndustry;
	}
	public void setCorporateIndustry(java.lang.Integer corporateIndustry) {
		this.corporateIndustry = corporateIndustry;
	}
	public java.lang.String getBusinessScope() {
		return businessScope;
	}
	public void setBusinessScope(java.lang.String businessScope) {
		this.businessScope = businessScope;
	}
	public java.util.Date getTermValidity() {
		return termValidity;
	}
	public void setTermValidity(java.util.Date termValidity) {
		this.termValidity = termValidity;
	}
	public java.lang.String getAddress() {
		return address;
	}
	public void setAddress(java.lang.String address) {
		this.address = address;
	}
	public java.lang.String getTelphone() {
		return telphone;
	}
	public void setTelphone(java.lang.String telphone) {
		this.telphone = telphone;
	}
	public java.lang.String getBusinessLicence() {
		return businessLicence;
	}
	public void setBusinessLicence(java.lang.String businessLicence) {
		this.businessLicence = businessLicence;
	}
	public java.lang.String getVerifiyStatus() {
		return verifiyStatus;
	}
	public void setVerifiyStatus(java.lang.String verifiyStatus) {
		this.verifiyStatus = verifiyStatus;
	}
	
	
	
	

}

