
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
@Table(name="enterpriseInfo")
public class EnterpriseInfo extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 507141988251371503L;
	
	@Id
	@GeneratedValue(GeneratorEnum.UUID)
	private java.lang.String fileNo;
	private java.lang.String creditCode;
	private java.lang.String enterpriseNet;
	private java.lang.Double foreignCapital;
	private java.lang.Integer workers;
	private java.lang.Integer levelCredit;
	private java.lang.Double occupy;
	private java.lang.Integer infoDeptPeople;
	private java.lang.Integer computers;
	private java.lang.Integer netComputers;
	private java.lang.Integer broadBan;
	private java.lang.String superintendent;
	private java.lang.String superDept;
	private java.lang.String superTel;
	private java.lang.String superMobile;
	private java.lang.String superEmail;
	private java.lang.String finance;
	private java.lang.String financeDept;
	private java.lang.String financeTel;
	private java.lang.String financeMobile;
	private java.lang.String financeEmail;
	private java.lang.String human;
	private java.lang.String humanDept;
	private java.lang.String humanTel;
	private java.lang.String humanMobile;
	private java.lang.String humanEmail;
	private java.lang.String applySubject;
	private java.lang.String workSystem;
	private java.lang.String awards;
	
	
	public java.lang.String getFileNo() {
		return fileNo;
	}
	public void setFileNo(java.lang.String fileNo) {
		this.fileNo = fileNo;
	}
	public java.lang.String getCreditCode() {
		return creditCode;
	}
	public void setCreditCode(java.lang.String creditCode) {
		this.creditCode = creditCode;
	}
	public java.lang.String getEnterpriseNet() {
		return enterpriseNet;
	}
	public void setEnterpriseNet(java.lang.String enterpriseNet) {
		this.enterpriseNet = enterpriseNet;
	}
	public java.lang.Double getForeignCapital() {
		return foreignCapital;
	}
	public void setForeignCapital(java.lang.Double foreignCapital) {
		this.foreignCapital = foreignCapital;
	}
	public java.lang.Integer getWorkers() {
		return workers;
	}
	public void setWorkers(java.lang.Integer workers) {
		this.workers = workers;
	}
	public java.lang.Integer getLevelCredit() {
		return levelCredit;
	}
	public void setLevelCredit(java.lang.Integer levelCredit) {
		this.levelCredit = levelCredit;
	}
	public java.lang.Double getOccupy() {
		return occupy;
	}
	public void setOccupy(java.lang.Double occupy) {
		this.occupy = occupy;
	}
	public java.lang.Integer getInfoDeptPeople() {
		return infoDeptPeople;
	}
	public void setInfoDeptPeople(java.lang.Integer infoDeptPeople) {
		this.infoDeptPeople = infoDeptPeople;
	}
	public java.lang.Integer getComputers() {
		return computers;
	}
	public void setComputers(java.lang.Integer computers) {
		this.computers = computers;
	}
	public java.lang.Integer getNetComputers() {
		return netComputers;
	}
	public void setNetComputers(java.lang.Integer netComputers) {
		this.netComputers = netComputers;
	}
	public java.lang.Integer getBroadBan() {
		return broadBan;
	}
	public void setBroadBan(java.lang.Integer broadBan) {
		this.broadBan = broadBan;
	}
	public java.lang.String getSuperintendent() {
		return superintendent;
	}
	public void setSuperintendent(java.lang.String superintendent) {
		this.superintendent = superintendent;
	}
	public java.lang.String getSuperDept() {
		return superDept;
	}
	public void setSuperDept(java.lang.String superDept) {
		this.superDept = superDept;
	}
	public java.lang.String getSuperTel() {
		return superTel;
	}
	public void setSuperTel(java.lang.String superTel) {
		this.superTel = superTel;
	}
	public java.lang.String getSuperMobile() {
		return superMobile;
	}
	public void setSuperMobile(java.lang.String superMobile) {
		this.superMobile = superMobile;
	}
	public java.lang.String getSuperEmail() {
		return superEmail;
	}
	public void setSuperEmail(java.lang.String superEmail) {
		this.superEmail = superEmail;
	}
	public java.lang.String getFinance() {
		return finance;
	}
	public void setFinance(java.lang.String finance) {
		this.finance = finance;
	}
	public java.lang.String getFinanceDept() {
		return financeDept;
	}
	public void setFinanceDept(java.lang.String financeDept) {
		this.financeDept = financeDept;
	}
	public java.lang.String getFinanceTel() {
		return financeTel;
	}
	public void setFinanceTel(java.lang.String financeTel) {
		this.financeTel = financeTel;
	}
	public java.lang.String getFinanceMobile() {
		return financeMobile;
	}
	public void setFinanceMobile(java.lang.String financeMobile) {
		this.financeMobile = financeMobile;
	}
	public java.lang.String getFinanceEmail() {
		return financeEmail;
	}
	public void setFinanceEmail(java.lang.String financeEmail) {
		this.financeEmail = financeEmail;
	}
	public java.lang.String getHuman() {
		return human;
	}
	public void setHuman(java.lang.String human) {
		this.human = human;
	}
	public java.lang.String getHumanDept() {
		return humanDept;
	}
	public void setHumanDept(java.lang.String humanDept) {
		this.humanDept = humanDept;
	}
	public java.lang.String getHumanTel() {
		return humanTel;
	}
	public void setHumanTel(java.lang.String humanTel) {
		this.humanTel = humanTel;
	}
	public java.lang.String getHumanMobile() {
		return humanMobile;
	}
	public void setHumanMobile(java.lang.String humanMobile) {
		this.humanMobile = humanMobile;
	}
	public java.lang.String getHumanEmail() {
		return humanEmail;
	}
	public void setHumanEmail(java.lang.String humanEmail) {
		this.humanEmail = humanEmail;
	}
	public java.lang.String getApplySubject() {
		return applySubject;
	}
	public void setApplySubject(java.lang.String applySubject) {
		this.applySubject = applySubject;
	}
	public java.lang.String getWorkSystem() {
		return workSystem;
	}
	public void setWorkSystem(java.lang.String workSystem) {
		this.workSystem = workSystem;
	}
	public java.lang.String getAwards() {
		return awards;
	}
	public void setAwards(java.lang.String awards) {
		this.awards = awards;
	}
	
	
	

}

