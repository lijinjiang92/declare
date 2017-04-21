package com.dspsemi.declare.core.pojo.user;

import com.dspsemi.common.enums.entity.status.CloseStatus;
import com.dspsemi.common.jpa.Add2Resource;
import com.dspsemi.common.jpa.Entity;
import com.dspsemi.common.jpa.Id;
import com.dspsemi.common.jpa.JoinColumn;
import com.dspsemi.common.jpa.ManyToOne;
import com.dspsemi.common.jpa.Table;
import com.dspsemi.common.lang.dto.AbstractCreateEntity;
import com.dspsemi.declare.core.enums.ObjType;
import com.dspsemi.declare.core.util.mybatis.GeneratedValue;
import com.dspsemi.declare.core.util.mybatis.GeneratorEnum;

/**
 * 联系我们
 * @author XiaoJin Wang
 *
 */
@Entity
@Add2Resource
@Table(name="u_contact")
public class Contact extends AbstractCreateEntity {

	private static final long serialVersionUID = 5454155825314635342L;
	
	/**
	 * 主键
	 */
	@Id
	@GeneratedValue(GeneratorEnum.CONTACT_ID)
	private String id;
	
	private String name;
	
	private String phone;
	
	private String email;
	
	private String company;
	
	private String messages;
	
	private CloseStatus status;
	
	public Contact(){
	}

	public Contact(String id){
		this.id = id;
	}
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getMessages() {
		return messages;
	}

	public void setMessages(String messages) {
		this.messages = messages;
	}

	public CloseStatus getStatus() {
		return status;
	}

	public void setStatus(CloseStatus status) {
		this.status = status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	
}

