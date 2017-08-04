package com.dspsemi.declare.core.pojo.sys;

import java.util.List;

import com.dspsemi.common.enums.entity.status.CloseStatus;
import com.dspsemi.common.enums.entity.status.DeleteStatus;
import com.dspsemi.common.jpa.Add2Resource;
import com.dspsemi.common.jpa.Entity;
import com.dspsemi.common.jpa.Id;
import com.dspsemi.common.jpa.OneToMany;
import com.dspsemi.common.jpa.Table;
import com.dspsemi.common.lang.dto.AbstractOperateEntity;
import com.dspsemi.declare.core.util.mybatis.GeneratedValue;
import com.dspsemi.declare.core.util.mybatis.GeneratorEnum;

/**
 * 常见问题类型 - 常见问题类型
 * @author XiaoJin Wang
 *
 */
/**
 * @author Administrator
 *
 */
@Entity
@Add2Resource
@Table(name="sys_usual_issue_type")
public class UsualIssueType extends AbstractOperateEntity {

	private static final long serialVersionUID = 5454155825314635342L;
	
	/**
	 * 主键
	 */
	@Id
	@GeneratedValue(GeneratorEnum.USUAL_ISSUE_TYPE_ID)
	private Integer id;
	
	/**
	 * 类型名
	 */
	private String name;
	
	/**
	 * 状态
	 */
	private DeleteStatus status;
	
	/**
	 * 排序值
	 */
	private Integer sort;
	

	@OneToMany(mappedBy="usualIssueType")
	private List<UsualIssue> usualIssues;
	
	public UsualIssueType(){
	
	}

	public UsualIssueType(Integer id){
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
	
	public DeleteStatus getStatus() {
		return status;
	}

	public void setStatus(DeleteStatus status) {
		this.status = status;
	}

	public Integer getSort() {
		return sort;
	}
	
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	
	public void setUsualIssues(List<UsualIssue> usualIssues){
		this.usualIssues = usualIssues;
	}
	
	public List<UsualIssue> getUsualIssues() {
		return usualIssues;
	}

}

