package com.dspsemi.declare.core.pojo.bbs;

import com.dspsemi.common.jpa.Add2Resource;
import com.dspsemi.common.jpa.Entity;
import com.dspsemi.common.jpa.Id;
import com.dspsemi.common.jpa.JoinColumn;
import com.dspsemi.common.jpa.ManyToOne;
import com.dspsemi.common.jpa.Table;
import com.dspsemi.common.lang.dto.AbstractOperateEntity;
import com.dspsemi.declare.core.enums.TopicStatus;
import com.dspsemi.declare.core.util.mybatis.GeneratedValue;
import com.dspsemi.declare.core.util.mybatis.GeneratorEnum;

/**
 * BBS主题回复 - BBS主题回复
 * @author XiaoJin Wang
 *
 */
@Entity
@Add2Resource
@Table(name="bbs_topic_reply")
public class BbsTopicReply extends AbstractOperateEntity {

	private static final long serialVersionUID = 5454155825314635342L;
	
	/**
	 * 主键
	 */
	@Id
	@GeneratedValue(GeneratorEnum.BBS_TOPIC_REPLY_ID)
	private String id;
	
	/**
	 * 主题ID
	 */
	private String topicId;
	
	/**
	 * 状态
	 */
	private TopicStatus status;
	
	/**
	 * 内容
	 */
	private String content;
	
	/**
	 * 被回复帖子ID
	 */
	private String byReplytId;
	
	/**
	 * 被回复人ID
	 */
	private String byReplierId;
	
	/**
	 * 被回复人
	 */
	private String byReplier;
	

	@ManyToOne
	@JoinColumn(name="topicId") 
	private BbsTopic bbsTopic;
	
	public BbsTopicReply(){
	
	}

	public BbsTopicReply(String id){
		this.id = id;
	}
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getTopicId() {
		return topicId;
	}
	
	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}
	
	public TopicStatus getStatus() {
		return status;
	}
	
	public void setStatus(TopicStatus status) {
		this.status = status;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getByReplytId() {
		return byReplytId;
	}
	
	public void setByReplytId(String byReplytId) {
		this.byReplytId = byReplytId;
	}
	
	public String getByReplierId() {
		return byReplierId;
	}
	
	public void setByReplierId(String byReplierId) {
		this.byReplierId = byReplierId;
	}
	
	public String getByReplier() {
		return byReplier;
	}
	
	public void setByReplier(String byReplier) {
		this.byReplier = byReplier;
	}
	
	public void setBbsTopic(BbsTopic bbsTopic){
		this.bbsTopic = bbsTopic;
	}
	
	public BbsTopic getBbsTopic() {
		return bbsTopic;
	}

}

