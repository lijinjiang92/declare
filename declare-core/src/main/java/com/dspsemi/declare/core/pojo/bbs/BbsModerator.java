package com.dspsemi.declare.core.pojo.bbs;

import com.dspsemi.common.jpa.Add2Resource;
import com.dspsemi.common.jpa.Entity;
import com.dspsemi.common.jpa.Id;
import com.dspsemi.common.jpa.JoinColumn;
import com.dspsemi.common.jpa.ManyToOne;
import com.dspsemi.common.jpa.Table;
import com.dspsemi.common.lang.dto.AbstractCreateEntity;

/**
 * BBS版主 - BBS版主
 * @author XiaoJin Wang
 *
 */
@Entity
@Add2Resource
@Table(name="bbs_moderator")
public class BbsModerator extends AbstractCreateEntity {

	private static final long serialVersionUID = 5454155825314635342L;
	
	/**
	 * 用户ID
	 */
	@Id
	private String userId;
	
	/**
	 * 版块ID
	 */
	@Id
	private Integer sectionId;
	

	@ManyToOne
	@JoinColumn(name="sectionId") 
	private BbsSection bbsSection;
	
	public BbsModerator(){
	
	}

	public BbsModerator(String userId){
		this.userId = userId;
	}
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public Integer getSectionId() {
		return sectionId;
	}
	
	public void setSectionId(Integer sectionId) {
		this.sectionId = sectionId;
	}
	
	public void setBbsSection(BbsSection bbsSection){
		this.bbsSection = bbsSection;
	}
	
	public BbsSection getBbsSection() {
		return bbsSection;
	}

}

