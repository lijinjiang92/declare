package com.dspsemi.declare.core.pojo.sys;

import java.util.Date;

import com.dspsemi.common.enums.entity.status.DeleteStatus;
import com.dspsemi.common.jpa.Add2Resource;
import com.dspsemi.common.jpa.Entity;
import com.dspsemi.common.jpa.Id;
import com.dspsemi.common.jpa.Table;
import com.dspsemi.common.jpa.Temporal;
import com.dspsemi.common.jpa.TemporalType;
import com.dspsemi.common.jpa.Transient;
import com.dspsemi.common.lang.dto.AbstractOperateEntity;
import com.dspsemi.declare.core.enums.NoticeType;
import com.dspsemi.declare.core.util.mybatis.GeneratedValue;
import com.dspsemi.declare.core.util.mybatis.GeneratorEnum;

/**
 * 公告 - 公告
 * @author XiaoJin Wang
 *
 */
@Entity
@Add2Resource
@Table(name="sys_notice")
public class Notice extends AbstractOperateEntity {

	private static final long serialVersionUID = 5454155825314635342L;
	
	/**
	 * 主键
	 */
	@Id
	@GeneratedValue(GeneratorEnum.NOTICE_ID)
	private String id;
	
	/**
	 * 类型
	 */
	private NoticeType noticeType;
	
	/**
	 * 标题
	 */
	private String title;
	
	/**
	 * 状态
	 */
	private DeleteStatus status;
	
	/**
	 * 内容
	 */
	private String content;
	
	/**
	 * 访问数
	 */
	private Integer visitNum;
	/**
	 * 发布时间
	 */
	@Temporal(TemporalType.TIMESTAMP)
	private Date publicTime;

	public Date getPublicTime() {
		return publicTime;
	}

	public void setPublicTime(Date publicTime) {
		this.publicTime = publicTime;
	}
	//***************冗余字段	开始******************//
	@Transient
	private String publicTimeStr;
	//***************冗余字段	结束******************//

	public Notice(){
	
	}

	public String getPublicTimeStr() {
		return publicTimeStr;
	}

	public void setPublicTimeStr(String publicTimeStr) {
		this.publicTimeStr = publicTimeStr;
	}

	public Notice(String id){
		this.id = id;
	}
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public NoticeType getNoticeType() {
		return noticeType;
	}
	
	public void setNoticeType(NoticeType noticeType) {
		this.noticeType = noticeType;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public DeleteStatus getStatus() {
		return status;
	}
	
	public void setStatus(DeleteStatus status) {
		this.status = status;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public Integer getVisitNum() {
		return visitNum;
	}
	
	public void setVisitNum(Integer visitNum) {
		this.visitNum = visitNum;
	}
	

}

