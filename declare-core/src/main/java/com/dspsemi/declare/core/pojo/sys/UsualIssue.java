package com.dspsemi.declare.core.pojo.sys;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.dspsemi.common.enums.entity.status.CloseStatus;
import com.dspsemi.common.jpa.Add2Resource;
import com.dspsemi.common.jpa.Entity;
import com.dspsemi.common.jpa.Id;
import com.dspsemi.common.jpa.JoinColumn;
import com.dspsemi.common.jpa.ManyToOne;
import com.dspsemi.common.jpa.Table;
import com.dspsemi.common.jpa.Transient;
import com.dspsemi.common.lang.dto.AbstractOperateEntity;
import com.dspsemi.declare.core.util.mybatis.GeneratedValue;
import com.dspsemi.declare.core.util.mybatis.GeneratorEnum;

/**
 * 常见问题 - 常见问题
 * @author XiaoJin Wang
 *
 */
@Entity
@Add2Resource
@Table(name="sys_usual_issue")
public class UsualIssue extends AbstractOperateEntity {

	private static final long serialVersionUID = 5454155825314635342L;
	
	/**
	 * 主键
	 */
	@Id
	@GeneratedValue(GeneratorEnum.USUAL_ISSUE_ID)
	private String id;
	
	/**
	 * 问题类型
	 */
	private Integer issueTypeId;
	
	/**
	 * 标题
	 */
	private String title;
	
	/**
	 * 状态
	 */
	private CloseStatus status;
	
	/**
	 * 排序值
	 */
	private Integer sort;
	
	/**
	 * 发布时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date publishTime;
	
	/**
	 * 浏览数
	 */
	private Long browseNum;
	
	/**
	 * 内容
	 */
	private String content;
	
	@Transient
	private String typeName;
	

	@ManyToOne
	@JoinColumn(name="issueTypeId") 
	private UsualIssueType usualIssueType;
	
	public UsualIssue(){
	
	}
	

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}



	public UsualIssue(String id){
		this.id = id;
	}
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public Integer getIssueTypeId() {
		return issueTypeId;
	}
	
	public void setIssueTypeId(Integer issueTypeId) {
		this.issueTypeId = issueTypeId;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
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
	
	public Date getPublishTime() {
		return publishTime;
	}
	
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}
	
	public Long getBrowseNum() {
		return browseNum;
	}
	
	public void setBrowseNum(Long browseNum) {
		this.browseNum = browseNum;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public void setUsualIssueType(UsualIssueType usualIssueType){
		this.usualIssueType = usualIssueType;
	}
	
	public UsualIssueType getUsualIssueType() {
		return usualIssueType;
	}

}

