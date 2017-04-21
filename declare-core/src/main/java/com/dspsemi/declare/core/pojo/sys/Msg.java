package com.dspsemi.declare.core.pojo.sys;

import com.dspsemi.common.enums.entity.YesNo;
import com.dspsemi.common.enums.entity.status.DeleteStatus;
import com.dspsemi.common.jpa.Add2Resource;
import com.dspsemi.common.jpa.Entity;
import com.dspsemi.common.jpa.Id;
import com.dspsemi.common.jpa.Table;
import com.dspsemi.common.lang.dto.AbstractOperateEntity;
import com.dspsemi.declare.core.enums.MsgType;
import com.dspsemi.declare.core.util.mybatis.GeneratedValue;
import com.dspsemi.declare.core.util.mybatis.GeneratorEnum;

/**
 * 消息 - 消息
 * @author XiaoJin Wang
 *
 */
@Entity
@Add2Resource
@Table(name="sys_msg")
public class Msg extends AbstractOperateEntity {

	private static final long serialVersionUID = 5454155825314635342L;
	
	/**
	 * 主键
	 */
	@Id
	@GeneratedValue(GeneratorEnum.MSG_ID)
	private String id;
	
	/**
	 * 类型
	 */
	private MsgType msgType;
	
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
	 * 是否已读
	 */
	private YesNo isRead;
	
	/**
	 * 接收人ID
	 */
	private String recipientId;
	
	/**
	 * 接收人
	 */
	private String recipient;
	

	public Msg(){
	
	}

	public Msg(String id){
		this.id = id;
	}
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public MsgType getMsgType() {
		return msgType;
	}
	
	public void setMsgType(MsgType msgType) {
		this.msgType = msgType;
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
	
	public YesNo getIsRead() {
		return isRead;
	}
	
	public void setIsRead(YesNo isRead) {
		this.isRead = isRead;
	}
	
	public String getRecipientId() {
		return recipientId;
	}
	
	public void setRecipientId(String recipientId) {
		this.recipientId = recipientId;
	}
	
	public String getRecipient() {
		return recipient;
	}
	
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	

}

