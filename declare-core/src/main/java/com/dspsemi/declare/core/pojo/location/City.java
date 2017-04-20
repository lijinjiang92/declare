package com.dspsemi.declare.core.pojo.location;

import java.util.List;

import com.dspsemi.common.enums.entity.YesNo;
import com.dspsemi.common.enums.entity.status.CloseStatus;
import com.dspsemi.common.jpa.Add2Resource;
import com.dspsemi.common.jpa.Entity;
import com.dspsemi.common.jpa.Id;
import com.dspsemi.common.jpa.JoinColumn;
import com.dspsemi.common.jpa.ManyToOne;
import com.dspsemi.common.jpa.OneToMany;
import com.dspsemi.common.jpa.Table;
import com.dspsemi.common.lang.dto.AbstractOperateEntity;
import com.dspsemi.declare.core.util.mybatis.GeneratedValue;
import com.dspsemi.declare.core.util.mybatis.GeneratorEnum;

/**
 * @author XiaoJin Wang
 *
 */
@Entity
@Add2Resource
@Table(name="l_city")
public class City extends AbstractOperateEntity {

	private static final long serialVersionUID = 5454155825314635342L;
	
	@Id
	@GeneratedValue(GeneratorEnum.CITY_ID)
	private Integer id;
	
	private CloseStatus status;
	
	private Integer provinceId;
	
	private String name;
	
	private String pinyin;
	
	private Integer sort;
	
	/**
	 * 电话区号
	 */
	private String areaCode;
	
	private YesNo isHot;
	

	@ManyToOne
	@JoinColumn(name="provinceId") 
	private Province province;
	
	@OneToMany(mappedBy="city")
	private List<District> districts;
	
	public City(){
	
	}

	public City(Integer id){
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public CloseStatus getStatus() {
		return status;
	}
	
	public void setStatus(CloseStatus status) {
		this.status = status;
	}
	
	public Integer getProvinceId() {
		return provinceId;
	}
	
	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPinyin() {
		return pinyin;
	}
	
	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}
	
	public Integer getSort() {
		return sort;
	}
	
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	
	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public void setProvince(Province province){
		this.province = province;
	}
	
	public Province getProvince() {
		return province;
	}
	public void setDistricts(List<District> district){
		this.districts = district;
	}
	
	public List<District> getDistricts() {
		return districts;
	}

	public YesNo getIsHot() {
		return isHot;
	}

	public void setIsHot(YesNo isHot) {
		this.isHot = isHot;
	}

}

