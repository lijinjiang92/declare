package com.dspsemi.declare.core.pojo.bbs;

import java.util.List;

import com.dspsemi.common.enums.entity.status.CloseStatus;
import com.dspsemi.common.jpa.Add2Resource;
import com.dspsemi.common.jpa.Entity;
import com.dspsemi.common.jpa.Id;
import com.dspsemi.common.jpa.JoinColumn;
import com.dspsemi.common.jpa.ManyToOne;
import com.dspsemi.common.jpa.OneToMany;
import com.dspsemi.common.jpa.Table;
import com.dspsemi.common.lang.dto.AbstractOperateEntity;
import com.dspsemi.declare.core.util.mybatis.GeneratedValue;
import com.dspsemi.declare.core.util.mybatis.GeneratorEnum;

/**
 * BBS版块 - BBS版块
 * @author XiaoJin Wang
 *
 */
@Entity
@Add2Resource
@Table(name="bbs_section")
public class BbsSection extends AbstractOperateEntity {

	private static final long serialVersionUID = 5454155825314635342L;
	
	/**
	 * 主键
	 */
	@Id
	@GeneratedValue(GeneratorEnum.BBS_SECTION_ID)
	private Integer id;
	
	/**
	 * 版块分类ID
	 */
	private Integer ctgId;
	
	/**
	 * 名称
	 */
	private String name;
	
	/**
	 * 排序值
	 */
	private Integer sort;
	
	/**
	 * 状态
	 */
	private CloseStatus status;
	
	/**
	 * 主题数
	 */
	private Integer topicNum;
	
	/**
	 * 关注数
	 */
	private Integer concernNum;
	/**
	 * 描述
	 */
	private String describes;
	
	public String getDescribes() {
		return describes;
	}

	public void setDescribes(String describes) {
		this.describes = describes;
	}

	@ManyToOne
	@JoinColumn(name="ctgId") 
	private BbsSectionCtg bbsSectionCtg;
	
	@OneToMany(mappedBy="bbsSection")
	private List<BbsTopic> bbsTopics;
	
	public BbsSection(){
	
	}

	public BbsSection(Integer id){
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getCtgId() {
		return ctgId;
	}
	
	public void setCtgId(Integer ctgId) {
		this.ctgId = ctgId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getSort() {
		return sort;
	}
	
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	
	public CloseStatus getStatus() {
		return status;
	}
	
	public void setStatus(CloseStatus status) {
		this.status = status;
	}
	
	public Integer getTopicNum() {
		return topicNum;
	}
	
	public void setTopicNum(Integer topicNum) {
		this.topicNum = topicNum;
	}
	
	public Integer getConcernNum() {
		return concernNum;
	}
	
	public void setConcernNum(Integer concernNum) {
		this.concernNum = concernNum;
	}
	
	public void setBbsSectionCtg(BbsSectionCtg bbsSectionCtg){
		this.bbsSectionCtg = bbsSectionCtg;
	}
	
	public BbsSectionCtg getBbsSectionCtg() {
		return bbsSectionCtg;
	}
	public void setBbsTopics(List<BbsTopic> bbsTopics){
		this.bbsTopics = bbsTopics;
	}
	
	public List<BbsTopic> getBbsTopics() {
		return bbsTopics;
	}

}

