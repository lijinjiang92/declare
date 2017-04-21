
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
@Table(name="enterpriseReport")
public class EnterpriseReport extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1420524369915830438L;
	
	@Id
	@GeneratedValue(GeneratorEnum.UUID)
	private java.lang.String fileNo;
	private java.lang.String creditCode;
	private java.lang.Integer financeYear;
	private java.lang.Double sales;
	private java.lang.Double profits;
	private java.lang.Double taxs;
	private java.lang.Double prodInputsHard;
	private java.lang.Double prodInputsSoft;
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
	public java.lang.Integer getFinanceYear() {
		return financeYear;
	}
	public void setFinanceYear(java.lang.Integer financeYear) {
		this.financeYear = financeYear;
	}
	public java.lang.Double getSales() {
		return sales;
	}
	public void setSales(java.lang.Double sales) {
		this.sales = sales;
	}
	public java.lang.Double getProfits() {
		return profits;
	}
	public void setProfits(java.lang.Double profits) {
		this.profits = profits;
	}
	public java.lang.Double getTaxs() {
		return taxs;
	}
	public void setTaxs(java.lang.Double taxs) {
		this.taxs = taxs;
	}
	public java.lang.Double getProdInputsHard() {
		return prodInputsHard;
	}
	public void setProdInputsHard(java.lang.Double prodInputsHard) {
		this.prodInputsHard = prodInputsHard;
	}
	public java.lang.Double getProdInputsSoft() {
		return prodInputsSoft;
	}
	public void setProdInputsSoft(java.lang.Double prodInputsSoft) {
		this.prodInputsSoft = prodInputsSoft;
	}
	
	
	

}

