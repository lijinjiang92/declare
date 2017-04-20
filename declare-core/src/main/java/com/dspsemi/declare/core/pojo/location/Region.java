package com.dspsemi.declare.core.pojo.location;

import java.util.List;

import com.dspsemi.common.enums.entity.status.CloseStatus;
import com.dspsemi.common.jpa.Add2Resource;
import com.dspsemi.common.jpa.Entity;
import com.dspsemi.common.jpa.Id;
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
@Table(name="l_region")
public class Region extends AbstractOperateEntity {

	private static final long serialVersionUID = 5454155825314635342L;
	
	@Id
	@GeneratedValue(GeneratorEnum.REGION_ID)
	private Integer id;
	
	private CloseStatus status;
	
	private String name;
	
	private String pinyin;
	
	private Integer sort;
	

	@OneToMany(mappedBy="region")
	private List<Province> provinces;
	
	public Region(){
	
	}

	public Region(Integer id){
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
	
	public void setProvinces(List<Province> province){
		this.provinces = province;
	}
	
	public List<Province> getProvinces() {
		return provinces;
	}

}

