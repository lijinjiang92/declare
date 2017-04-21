package com.dspsemi.declare.core.pojo.devboard;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.dspsemi.common.enums.entity.status.VerifyStatus;
import com.dspsemi.common.jpa.Add2Resource;
import com.dspsemi.common.jpa.Entity;
import com.dspsemi.common.jpa.Id;
import com.dspsemi.common.jpa.OneToMany;
import com.dspsemi.common.jpa.Table;
import com.dspsemi.common.jpa.Temporal;
import com.dspsemi.common.jpa.TemporalType;
import com.dspsemi.common.lang.dto.AbstractOperateEntity;
import com.dspsemi.declare.core.util.mybatis.GeneratedValue;
import com.dspsemi.declare.core.util.mybatis.GeneratorEnum;

/**
 * 开发板基础表 - 开发板基础表
 * @author XiaoJin Wang
 *
 */
@Entity
@Add2Resource
@Table(name="db_dev_board_base")
public class DevBoardBase extends AbstractOperateEntity {

	private static final long serialVersionUID = 5454155825314635342L;
	
	/**
	 * 主键 - 主
	 */
	@Id
	@GeneratedValue(GeneratorEnum.DEV_BOARD_BASE_ID)
	private String id;
	
	/**
	 * 一级分类
	 */
	private Integer categoryId;
	
	/**
	 * 二级分类
	 */
	private Integer subCategoryId;
	
	/**
	 * 品牌
	 */
	private Integer brandId;
	
	/**
	 * 开发板名
	 */
	private String name;
	
	/**
	 * 生产厂商
	 */
	private String manufacturer;
	
	/**
	 * 图片
	 */
	private String pic;
	
	/**
	 * 状态
	 */
	private VerifyStatus status;
	
	/**
	 * 排序值
	 */
	private Integer sort;
	
	/**
	 * 简介
	 */
	private String intro;
	
	/**
	 * 价格
	 */
	private BigDecimal price;
	
	/**
	 * 备注
	 */
	private String remark;
	
	/**
	 * 审核人ID
	 */
	private String verifierId;
	
	/**
	 * 审核人
	 */
	private String verifier;
	
	/**
	 * 审核时间
	 */
	@Temporal(TemporalType.TIMESTAMP)
	private Date verifyTime;

	@OneToMany(mappedBy="devBoardBase")
	private List<DevBoardReport> devBoardReports;
	
	@OneToMany(mappedBy="devBoardBase")
	private List<DevBoardPro> devBoardPros;
	
	@OneToMany(mappedBy="devBoardBase")
	private List<DevBoardApply> devBoardApplys;
	
	public DevBoardBase(){
	
	}

	public DevBoardBase(String id){
		this.id = id;
	}
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public Integer getCategoryId() {
		return categoryId;
	}
	
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	
	public Integer getSubCategoryId() {
		return subCategoryId;
	}
	
	public void setSubCategoryId(Integer subCategoryId) {
		this.subCategoryId = subCategoryId;
	}
	
	public Integer getBrandId() {
		return brandId;
	}
	
	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getManufacturer() {
		return manufacturer;
	}
	
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	public String getPic() {
		return pic;
	}
	
	public void setPic(String pic) {
		this.pic = pic;
	}
	
	public Integer getSort() {
		return sort;
	}
	
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	
	public String getIntro() {
		return intro;
	}
	
	public void setIntro(String intro) {
		this.intro = intro;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public String getRemark() {
		return remark;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public void setDevBoardReports(List<DevBoardReport> devBoardReports){
		this.devBoardReports = devBoardReports;
	}
	
	public List<DevBoardReport> getDevBoardReports() {
		return devBoardReports;
	}
	public void setDevBoardPros(List<DevBoardPro> devBoardPros){
		this.devBoardPros = devBoardPros;
	}
	
	public List<DevBoardPro> getDevBoardPros() {
		return devBoardPros;
	}
	public void setDevBoardApplys(List<DevBoardApply> devBoardApplys){
		this.devBoardApplys = devBoardApplys;
	}
	
	public List<DevBoardApply> getDevBoardApplys() {
		return devBoardApplys;
	}

	public VerifyStatus getStatus() {
		return status;
	}

	public void setStatus(VerifyStatus status) {
		this.status = status;
	}

	public String getVerifierId() {
		return verifierId;
	}

	public void setVerifierId(String verifierId) {
		this.verifierId = verifierId;
	}

	public String getVerifier() {
		return verifier;
	}

	public void setVerifier(String verifier) {
		this.verifier = verifier;
	}

	public Date getVerifyTime() {
		return verifyTime;
	}

	public void setVerifyTime(Date verifyTime) {
		this.verifyTime = verifyTime;
	}

}

