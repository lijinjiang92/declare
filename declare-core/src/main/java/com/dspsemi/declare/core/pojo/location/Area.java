package com.dspsemi.declare.core.pojo.location;

import com.dspsemi.common.enums.entity.status.CloseStatus;
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
 * @author XiaoJin Wang
 *
 */
@Entity
@Add2Resource
@Table(name="l_area")
public class Area extends AbstractOperateEntity {

	private static final long serialVersionUID = 5454155825314635342L;
	
	@Id
	@GeneratedValue(GeneratorEnum.AREA_ID)
	private Integer id;
	
	private CloseStatus status;
	
	private Integer districtId;
	
	private String name;
	
	private String pinyin;
	
	private Integer sort;
	

	@ManyToOne
	@JoinColumn(name="districtId") 
	private District district;
	
	public Area(){
	
	}

	public Area(Integer id){
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
	
	public Integer getDistrictId() {
		return districtId;
	}
	
	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
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
	
	public void setDistrict(District district){
		this.district = district;
	}
	
	public District getDistrict() {
		return district;
	}

}

