package com.dspsemi.declare.core.pojo.user;

import com.dspsemi.common.jpa.Add2Resource;
import com.dspsemi.common.jpa.Entity;
import com.dspsemi.common.jpa.Id;
import com.dspsemi.common.jpa.Table;
import com.dspsemi.common.lang.dto.AbstractEntity;
import com.dspsemi.declare.core.enums.JobFieldType;
import com.dspsemi.declare.core.enums.JobType;

/**
 * 用户 - 用户登录后台的用户
 * @author XiaoJin Wang
 *
 */
@Entity
@Add2Resource
@Table(name="u_user")
public class User extends AbstractEntity {

	private static final long serialVersionUID = 5454155825314635342L;
	
	/**
	 * 主键
	 */
	@Id
	private String id;
	
	/**
	 * 等级
	 */
	private Integer level;
	
	/**
	 * 积分
	 */
	private Integer point;
	
	/**
	 * 签名
	 */
	private String sign;
	
	/**
	 * QQ
	 */
	private String qq;
	
	/**
	 * 公式名称
	 */
	private String companyName;
	
	/**
	 * 职业
	 */
	private JobType job;
	
	/**
	 * 领域
	 */
	private JobFieldType fields;
	
	private String bbs_userId;
	
	
	public User(){
	
	}

	public User(String id){
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public JobType getJob() {
		return job;
	}

	public void setJob(JobType job) {
		this.job = job;
	}

	public JobFieldType getFields() {
		return fields;
	}

	public void setFields(JobFieldType fields) {
		this.fields = fields;
	}

	public String getBbs_userId() {
		return bbs_userId;
	}

	public void setBbs_userId(String bbs_userId) {
		this.bbs_userId = bbs_userId;
	}
	
}

