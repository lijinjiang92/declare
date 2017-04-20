package com.dspsemi.declare.core.pojo.user;

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
 * 关注 - 关注
 * @author XiaoJin Wang
 *
 */
@Entity
@Add2Resource
@Table(name="u_concern")
public class Concern extends AbstractCreateEntity {

	private static final long serialVersionUID = 5454155825314635342L;
	
	/**
	 * 主键
	 */
	@Id
	@GeneratedValue(GeneratorEnum.CONCERN_ID)
	private String id;
	
	/**
	 * 类型 - 被关注对象的类型
	 */
	private ObjType objType;
	
	/**
	 * 对象ID - 被关注对象ID
	 */
	private String objId;
	
	/**
	 * 对象名 - 被关注对象名
	 */
	private String objName;
	

	@ManyToOne
	@JoinColumn(name="creatorId") 
	private User user;
	
	public Concern(){
	
	}

	public Concern(String id){
		this.id = id;
	}
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public ObjType getObjType() {
		return objType;
	}
	
	public void setObjType(ObjType objType) {
		this.objType = objType;
	}
	
	public String getObjId() {
		return objId;
	}
	
	public void setObjId(String objId) {
		this.objId = objId;
	}
	
	public String getObjName() {
		return objName;
	}
	
	public void setObjName(String objName) {
		this.objName = objName;
	}
	
	public void setUser(User user){
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}

}

