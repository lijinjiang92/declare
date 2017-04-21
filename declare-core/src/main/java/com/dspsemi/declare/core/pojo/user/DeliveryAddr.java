package com.dspsemi.declare.core.pojo.user;

import com.dspsemi.common.enums.entity.status.DeleteStatus;
import com.dspsemi.common.jpa.Add2Resource;
import com.dspsemi.common.jpa.Entity;
import com.dspsemi.common.jpa.Id;
import com.dspsemi.common.jpa.JoinColumn;
import com.dspsemi.common.jpa.ManyToOne;
import com.dspsemi.common.jpa.Table;
import com.dspsemi.common.lang.dto.AbstractOperateEntity;
import com.dspsemi.declare.core.util.mybatis.GeneratedValue;
import com.dspsemi.declare.core.util.mybatis.GeneratorEnum;

/**
 * 配送地址 - 配送地址
 * @author XiaoJin Wang
 *
 */
@Entity
@Add2Resource
@Table(name="u_delivery_addr")
public class DeliveryAddr extends AbstractOperateEntity {

	private static final long serialVersionUID = 5454155825314635342L;
	
	/**
	 * 主键
	 */
	@Id
	@GeneratedValue(GeneratorEnum.DELIVERY_ADDR_ID)
	private Long id;
	
	/**
	 * 用户ID
	 */
	private String userId;
	
	/**
	 * 状态
	 */
	private DeleteStatus status;
	
	public DeleteStatus getStatus() {
		return status;
	}

	public void setStatus(DeleteStatus status) {
		this.status = status;
	}

	/**
	 * 排序值
	 */
	private Integer sort;
	
	/**
	 * 手机号
	 */
	private String mobile;
	
	/**
	 * 联系人
	 */
	private String relation;
	
	/**
	 * 是否默认
	 */
	private Integer isDefault;
	
	/**
	 * 省ID
	 */
	private Integer provinceId;
	
	/**
	 * 省
	 */
	private String province;
	
	/**
	 * 市ID
	 */
	private Integer cityId;
	
	/**
	 * 市
	 */
	private String city;
	
	/**
	 * 区ID
	 */
	private Integer districtId;
	
	/**
	 * 区
	 */
	private String district;
	
	/**
	 * 街道地址
	 */
	private String street;
	
	/**
	 * 邮政编码
	 */
	private String postCode;
	
	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	@ManyToOne
	@JoinColumn(name="userId") 
	private User user;
	
	public DeliveryAddr(){
	
	}

	public DeliveryAddr(Long id){
		this.id = id;
	}
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
		
	public Integer getSort() {
		return sort;
	}
	
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	
	public String getMobile() {
		return mobile;
	}
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String getRelation() {
		return relation;
	}
	
	public void setRelation(String relation) {
		this.relation = relation;
	}
	
	public Integer getIsDefault() {
		return isDefault;
	}
	
	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
	}
	
	public Integer getProvinceId() {
		return provinceId;
	}
	
	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}
	
	public String getProvince() {
		return province;
	}
	
	public void setProvince(String province) {
		this.province = province;
	}
	
	public Integer getCityId() {
		return cityId;
	}
	
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public Integer getDistrictId() {
		return districtId;
	}
	
	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}
	
	public String getDistrict() {
		return district;
	}
	
	public void setDistrict(String district) {
		this.district = district;
	}
	
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public void setUser(User user){
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}
	
	

}

