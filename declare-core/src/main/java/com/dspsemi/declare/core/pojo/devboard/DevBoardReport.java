package com.dspsemi.declare.core.pojo.devboard;

import java.util.Date;

import com.dspsemi.common.enums.entity.status.VerifyStatus;
import com.dspsemi.common.jpa.Add2Resource;
import com.dspsemi.common.jpa.Entity;
import com.dspsemi.common.jpa.Id;
import com.dspsemi.common.jpa.JoinColumn;
import com.dspsemi.common.jpa.ManyToOne;
import com.dspsemi.common.jpa.Table;
import com.dspsemi.common.jpa.Temporal;
import com.dspsemi.common.jpa.TemporalType;
import com.dspsemi.common.jpa.Transient;
import com.dspsemi.common.lang.dto.AbstractOperateEntity;
import com.dspsemi.declare.core.util.mybatis.GeneratedValue;
import com.dspsemi.declare.core.util.mybatis.GeneratorEnum;

/**
 * 开发板报告表 - 申请的开发板产品报告
 * @author XiaoJin Wang
 *
 */
@Entity
@Add2Resource
@Table(name="db_dev_board_report")
public class DevBoardReport extends AbstractOperateEntity {

	private static final long serialVersionUID = 5454155825314635342L;
	
	/**
	 * 主键 - 主
	 */
	@Id
	@GeneratedValue(GeneratorEnum.DEV_BOARD_REPORT_ID)
	private String id;
	
	/**
	 * 开发板基础表ID
	 */
	private String boardBaseId;
	
	/**
	 * 开发板产品表ID
	 */
	private String boardProId;
	
	/**
	 * 状态
	 */
	private VerifyStatus status;
	
	/**
	 * 排序值
	 */
	private Integer sort;
	
	/**
	 * 标题
	 */
	private String title;
	
	/**
	 * 浏览数
	 */
	private Long browseNum;
	
	/**
	 * 内容
	 */
	private String content;
	
	/**
	 * 附件URL
	 */
	private String attachment;
	
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
	@Temporal(TemporalType.TIMESTAMP)
	private Date verifyTime;

	@ManyToOne
	@JoinColumn(name="boardProId") 
	private DevBoardPro devBoardPro;
	
	@ManyToOne
	@JoinColumn(name="boardBaseId") 
	private DevBoardBase devBoardBase;
	@Transient
	private String devBoardProIntro;
	
	/**
	 * 头像
	 */
	@Transient
	private String pic;
	
	public DevBoardReport(){
	
	}

	public String getDevBoardProIntro() {
		return devBoardProIntro;
	}

	public void setDevBoardProIntro(String devBoardProIntro) {
		this.devBoardProIntro = devBoardProIntro;
	}







	public DevBoardReport(String id){
		this.id = id;
	}
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getBoardBaseId() {
		return boardBaseId;
	}
	
	public void setBoardBaseId(String boardBaseId) {
		this.boardBaseId = boardBaseId;
	}
	
	public String getBoardProId() {
		return boardProId;
	}
	
	public void setBoardProId(String boardProId) {
		this.boardProId = boardProId;
	}
	
	public Integer getSort() {
		return sort;
	}
	
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Long getBrowseNum() {
		return browseNum;
	}
	
	public void setBrowseNum(Long browseNum) {
		this.browseNum = browseNum;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getAttachment() {
		return attachment;
	}
	
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	
	public String getRemark() {
		return remark;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public void setDevBoardPro(DevBoardPro devBoardPro){
		this.devBoardPro = devBoardPro;
	}
	
	public DevBoardPro getDevBoardPro() {
		return devBoardPro;
	}
	public void setDevBoardBase(DevBoardBase devBoardBase){
		this.devBoardBase = devBoardBase;
	}
	
	public DevBoardBase getDevBoardBase() {
		return devBoardBase;
	}

	public VerifyStatus getStatus() {
		return status;
	}

	public void setStatus(VerifyStatus status) {
		this.status = status;
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

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

}

