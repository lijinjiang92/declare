package com.dspsemi.declare.core.pojo.sys;

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
 * 资源类型 - 资源类型
 * @author XiaoJin Wang
 *
 */
@Entity
@Add2Resource
@Table(name="sys_resource_type")
public class ResourceType extends AbstractOperateEntity {

	private static final long serialVersionUID = 5454155825314635342L;
	
	/**
	 * 主键
	 */
	@Id
	@GeneratedValue(GeneratorEnum.RESOURCE_TYPE_ID)
	private Integer id;
	
	/**
	 * 类型名
	 */
	private String name;
	
	/**
	 * 状态
	 */
	private CloseStatus status;
	
	/**
	 * 排序值
	 */
	private Integer sort;
	

	@OneToMany(mappedBy="resourceType")
	private List<Resource> resources;
	
	public ResourceType(){
	
	}

	public ResourceType(Integer id){
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public CloseStatus getStatus() {
		return status;
	}
	
	public void setStatus(CloseStatus status) {
		this.status = status;
	}
	
	public Integer getSort() {
		return sort;
	}
	
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	
	public void setResources(List<Resource> resources){
		this.resources = resources;
	}
	
	public List<Resource> getResources() {
		return resources;
	}

}

