package com.dspsemi.declare.core.pojo.sys;

import java.util.Date;

import com.dspsemi.common.enums.entity.status.CloseStatus;
import com.dspsemi.common.jpa.Add2Resource;
import com.dspsemi.common.jpa.Entity;
import com.dspsemi.common.jpa.Id;
import com.dspsemi.common.jpa.Table;
import com.dspsemi.common.lang.dto.AbstractOperateEntity;
import com.dspsemi.declare.core.util.mybatis.GeneratedValue;
import com.dspsemi.declare.core.util.mybatis.GeneratorEnum;

/**
 * 新闻 - 新闻
 * @author XiaoJin Wang
 *
 */
@Entity
@Add2Resource
@Table(name="sys_news")
public class News extends AbstractOperateEntity {

	private static final long serialVersionUID = 5454155825314635342L;
	
	/**
	 * 主键
	 */
	@Id
	@GeneratedValue(GeneratorEnum.NEWS_ID)
	private String id;
	
	/**
	 * 标题
	 */
	private String title;
	
	/**
	 * 状态
	 */
	private CloseStatus status;
	
	/**
	 * 图片
	 */
	private String pic;
	
	/**
	 * 排序值
	 */
	private Integer sort;
	
	/**
	 * 发布时间
	 */
	private Date publishTime;
	
	/**
	 * 浏览数
	 */
	private Long browseNum;
	
	/**
	 * 概要
	 */
	private String summary;
	
	/**
	 * 内容
	 */
	private String content;
	

	public News(){
	
	}

	public News(String id){
		this.id = id;
	}
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
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
	
	public String getSummary() {
		return summary;
	}
	
	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	

}

