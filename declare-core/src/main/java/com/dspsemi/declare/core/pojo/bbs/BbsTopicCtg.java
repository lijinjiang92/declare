package com.dspsemi.declare.core.pojo.bbs;

import java.util.List;

import com.dspsemi.common.enums.entity.status.CloseStatus;
import com.dspsemi.common.jpa.Add2Resource;
import com.dspsemi.common.jpa.Entity;
import com.dspsemi.common.jpa.Id;
import com.dspsemi.common.jpa.OneToMany;
import com.dspsemi.common.jpa.Table;
import com.dspsemi.common.lang.dto.AbstractOperateEntity;
import com.dspsemi.declare.core.util.mybatis.GeneratedValue;
import com.dspsemi.declare.core.util.mybatis.GeneratorEnum;

/**
 * BBS主题分类 - BBS主题分类
 * @author XiaoJin Wang
 *
 */
@Entity
@Add2Resource
@Table(name="bbs_topic_ctg")
public class BbsTopicCtg extends AbstractOperateEntity {

	private static final long serialVersionUID = 5454155825314635342L;
	
	/**
	 * 主键
	 */
	@Id
	@GeneratedValue(GeneratorEnum.BBS_TOPIC_CTG_ID)
	private Integer id;
	
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
	

	@OneToMany(mappedBy="bbsTopicCtg")
	private List<BbsTopic> bbsTopics;
	
	public BbsTopicCtg(){
	
	}

	public BbsTopicCtg(Integer id){
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
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
	
	public void setBbsTopics(List<BbsTopic> bbsTopics){
		this.bbsTopics = bbsTopics;
	}
	
	public List<BbsTopic> getBbsTopics() {
		return bbsTopics;
	}

}

