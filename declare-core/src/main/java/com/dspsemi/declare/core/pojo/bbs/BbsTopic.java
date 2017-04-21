package com.dspsemi.declare.core.pojo.bbs;

import java.util.List;

import com.dspsemi.common.enums.entity.YesNo;
import com.dspsemi.common.jpa.Add2Resource;
import com.dspsemi.common.jpa.Entity;
import com.dspsemi.common.jpa.Id;
import com.dspsemi.common.jpa.JoinColumn;
import com.dspsemi.common.jpa.ManyToOne;
import com.dspsemi.common.jpa.OneToMany;
import com.dspsemi.common.jpa.Table;
import com.dspsemi.common.lang.dto.AbstractOperateEntity;
import com.dspsemi.declare.core.enums.TopicStatus;
import com.dspsemi.declare.core.util.mybatis.GeneratedValue;
import com.dspsemi.declare.core.util.mybatis.GeneratorEnum;

/**
 * BBS主题 - BBS主题
 * @author XiaoJin Wang
 *
 */
@Entity
@Add2Resource
@Table(name="bbs_topic")
public class BbsTopic extends AbstractOperateEntity {

	private static final long serialVersionUID = 5454155825314635342L;
	
	/**
	 * 主键
	 */
	@Id
	@GeneratedValue(GeneratorEnum.BBS_TOPIC_ID)
	private String id;
	
	/**
	 * 主题分类ID
	 */
	private Integer ctgId;
	
	/**
	 * 版块ID
	 */
	private Integer sectionId;
	
	/**
	 * 标题
	 */
	private String title;
	
	/**
	 * 排序值
	 */
	private Integer sort;
	
	/**
	 * 状态
	 */
	private TopicStatus status;
	
	/**
	 * 回复数
	 */
	private Integer replyNum;
	
	/**
	 * 收藏数
	 */
	private Integer collectNum;
	
	/**
	 * 访问量
	 */
	private Integer visitNum;
	
	/**
	 * 是否可回复
	 */
	private YesNo isReply;
	
	/**
	 * 是否置顶
	 */
	private YesNo isStick;
	
	/**
	 * 是否精华帖
	 */
	private YesNo isElite;
	
	/**
	 * 是否热帖
	 */
	private YesNo isHot;
	
	/**
	 * 内容
	 */
	private String content;
	

	@ManyToOne
	@JoinColumn(name="ctgId") 
	private BbsTopicCtg bbsTopicCtg;
	
	@ManyToOne
	@JoinColumn(name="sectionId") 
	private BbsSection bbsSection;
	
	@OneToMany(mappedBy="bbsTopic")
	private List<BbsTopicReply> bbsTopicReplys;
	
	public BbsTopic(){
	
	}

	public BbsTopic(String id){
		this.id = id;
	}
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public Integer getCtgId() {
		return ctgId;
	}
	
	public void setCtgId(Integer ctgId) {
		this.ctgId = ctgId;
	}
	
	public Integer getSectionId() {
		return sectionId;
	}
	
	public void setSectionId(Integer sectionId) {
		this.sectionId = sectionId;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Integer getSort() {
		return sort;
	}
	
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	
	public TopicStatus getStatus() {
		return status;
	}
	
	public void setStatus(TopicStatus status) {
		this.status = status;
	}
	
	public Integer getReplyNum() {
		return replyNum;
	}
	
	public void setReplyNum(Integer replyNum) {
		this.replyNum = replyNum;
	}
	
	public Integer getCollectNum() {
		return collectNum;
	}
	
	public void setCollectNum(Integer collectNum) {
		this.collectNum = collectNum;
	}
	
	public Integer getVisitNum() {
		return visitNum;
	}
	
	public void setVisitNum(Integer visitNum) {
		this.visitNum = visitNum;
	}
	
	public YesNo getIsReply() {
		return isReply;
	}
	
	public void setIsReply(YesNo isReply) {
		this.isReply = isReply;
	}
	
	public YesNo getIsStick() {
		return isStick;
	}
	
	public void setIsStick(YesNo isStick) {
		this.isStick = isStick;
	}
	
	public YesNo getIsElite() {
		return isElite;
	}
	
	public void setIsElite(YesNo isElite) {
		this.isElite = isElite;
	}
	
	public YesNo getIsHot() {
		return isHot;
	}
	
	public void setIsHot(YesNo isHot) {
		this.isHot = isHot;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public void setBbsTopicCtg(BbsTopicCtg bbsTopicCtg){
		this.bbsTopicCtg = bbsTopicCtg;
	}
	
	public BbsTopicCtg getBbsTopicCtg() {
		return bbsTopicCtg;
	}
	public void setBbsSection(BbsSection bbsSection){
		this.bbsSection = bbsSection;
	}
	
	public BbsSection getBbsSection() {
		return bbsSection;
	}
	public void setBbsTopicReplys(List<BbsTopicReply> bbsTopicReplys){
		this.bbsTopicReplys = bbsTopicReplys;
	}
	
	public List<BbsTopicReply> getBbsTopicReplys() {
		return bbsTopicReplys;
	}

}

