package com.dspsemi.declare.core.pojo.activity;

import java.util.Date;

import com.dspsemi.common.enums.entity.status.VerifyStatus;
import com.dspsemi.common.jpa.Add2Resource;
import com.dspsemi.common.jpa.Entity;
import com.dspsemi.common.jpa.Id;
import com.dspsemi.common.jpa.Table;
import com.dspsemi.common.lang.dto.AbstractOperateEntity;
import com.dspsemi.declare.core.util.mybatis.GeneratedValue;
import com.dspsemi.declare.core.util.mybatis.GeneratorEnum;

/**
 * 活动表 - 活动表
 * @author XiaoJin Wang
 *
 */
@Entity
@Add2Resource
@Table(name="act_activity")
public class Activity extends AbstractOperateEntity {

	private static final long serialVersionUID = 5454155825314635342L;
	
	/**
	 * 主键
	 */
	@Id
	@GeneratedValue(GeneratorEnum.ACTIVITY_ID)
	private String id;
	
	/**
	 * 标题
	 */
	private String title;
	
	/**
	 * 图片
	 */
	private String pic;
	
	/**
	 * 状态
	 */
	private VerifyStatus status;
	
	/**
	 * 排序值
	 */
	private Integer sort;
	
	/**
	 * 浏览数
	 */
	private Long browseNum;
	
	/**
	 * 参与数
	 */
	private Long joinNum;
	
	/**
	 * 开始时间
	 */
	private Date beginTime;
	
	/**
	 * 截止时间
	 */
	private Date endTime;
	
	/**
	 * 简介
	 */
	private String intro;
	
	/**
	 * 详情
	 */
	private String detail;
	
	/**
	 * 备注
	 */
	private String remark;
	
	/**
	 * 审核人ID
	 */
	private String verifierId;
	
	/**
	 * 审核人
	 */
	private String verifier;
	
	/**
	 * 审核时间
	 */
	private Date verifyTime;
	

	public Activity(){
	
	}

	public Activity(String id){
		this.id = id;
	}
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getPic() {
		return pic;
	}
	
	public void setPic(String pic) {
		this.pic = pic;
	}
	
	public VerifyStatus getStatus() {
		return status;
	}
	
	public void setStatus(VerifyStatus status) {
		this.status = status;
	}
	
	public Integer getSort() {
		return sort;
	}
	
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	
	public Long getBrowseNum() {
		return browseNum;
	}
	
	public void setBrowseNum(Long browseNum) {
		this.browseNum = browseNum;
	}
	
	public Long getJoinNum() {
		return joinNum;
	}
	
	public void setJoinNum(Long joinNum) {
		this.joinNum = joinNum;
	}
	
	public Date getBeginTime() {
		return beginTime;
	}
	
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	
	public Date getEndTime() {
		return endTime;
	}
	
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	public String getIntro() {
		return intro;
	}
	
	public void setIntro(String intro) {
		this.intro = intro;
	}
	
	public String getDetail() {
		return detail;
	}
	
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	public String getRemark() {
		return remark;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public String getVerifierId() {
		return verifierId;
	}
	
	public void setVerifierId(String verifierId) {
		this.verifierId = verifierId;
	}
	
	public String getVerifier() {
		return verifier;
	}
	
	public void setVerifier(String verifier) {
		this.verifier = verifier;
	}
	
	public Date getVerifyTime() {
		return verifyTime;
	}
	
	public void setVerifyTime(Date verifyTime) {
		this.verifyTime = verifyTime;
	}
	

}

