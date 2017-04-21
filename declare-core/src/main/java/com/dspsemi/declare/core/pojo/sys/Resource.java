package com.dspsemi.declare.core.pojo.sys;

import java.util.Date;

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
 * 资源 - 可下载资源
 * @author XiaoJin Wang
 *
 */
@Entity
@Add2Resource
@Table(name="sys_resource")
public class Resource extends AbstractOperateEntity {

	private static final long serialVersionUID = 5454155825314635342L;
	
	/**
	 * 主键
	 */
	@Id
	@GeneratedValue(GeneratorEnum.RESOURCE_ID)
	private String id;
	
	/**
	 * 资源类型
	 */
	private Integer resourceTypeId;
	
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
	private Date publishTime;
	
	/**
	 * 下载地址
	 */
	private String url;
	
	/**
	 * 浏览数
	 */
	private Long browseNum;
	
	/**
	 * 下载数
	 */
	private Long downloadNum;
	
	/**
	 * 描述
	 */
	private String description;
	
	/**
	 * 上传图片地址
	 */
	private String pic;
	

	@ManyToOne
	@JoinColumn(name="resourceTypeId") 
	private ResourceType resourceType;
	
	public Resource(){
	
	}

	public Resource(String id){
		this.id = id;
	}
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public Integer getResourceTypeId() {
		return resourceTypeId;
	}
	
	public void setResourceTypeId(Integer resourceTypeId) {
		this.resourceTypeId = resourceTypeId;
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
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public Long getBrowseNum() {
		return browseNum;
	}
	
	public void setBrowseNum(Long browseNum) {
		this.browseNum = browseNum;
	}
	
	public Long getDownloadNum() {
		return downloadNum;
	}
	
	public void setDownloadNum(Long downloadNum) {
		this.downloadNum = downloadNum;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setResourceType(ResourceType resourceType){
		this.resourceType = resourceType;
	}
	
	public ResourceType getResourceType() {
		return resourceType;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	
}

