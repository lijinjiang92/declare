package com.dspsemi.declare.core.pojo.devboard;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.dspsemi.common.enums.entity.status.VerifyStatus;
import com.dspsemi.common.jpa.Add2Resource;
import com.dspsemi.common.jpa.Entity;
import com.dspsemi.common.jpa.Id;
import com.dspsemi.common.jpa.JoinColumn;
import com.dspsemi.common.jpa.ManyToOne;
import com.dspsemi.common.jpa.OneToMany;
import com.dspsemi.common.jpa.Table;
import com.dspsemi.common.jpa.Temporal;
import com.dspsemi.common.jpa.TemporalType;
import com.dspsemi.common.lang.dto.AbstractOperateEntity;
import com.dspsemi.declare.core.enums.DevBoardProType;
import com.dspsemi.declare.core.util.mybatis.GeneratedValue;
import com.dspsemi.declare.core.util.mybatis.GeneratorEnum;

/**
 * 开发板产品表 - 可申请使用的开发板
 * @author XiaoJin Wang
 *
 */
@Entity
@Add2Resource
@Table(name="db_dev_board_pro")
public class DevBoardPro extends AbstractOperateEntity {

	private static final long serialVersionUID = 5454155825314635342L;
	
	/**
	 * 主键 - 主
	 */
	@Id
	@GeneratedValue(GeneratorEnum.DEV_BOARD_PRO_ID)
	private String id;
	
	/**
	 * 开发板基础表ID
	 */
	private String boardBaseId;
	
	/**
	 * 标题
	 */
	private String title;
	
	/**
	 * 图片
	 */
	private String pic;
	
	/**
	 * 产品类型 - 0：免费申请 1：有偿申请
	 */
	private DevBoardProType proType;
	
	/**
	 * 状态
	 */
	private VerifyStatus status;
	
	/**
	 * 排序值
	 */
	private Integer sort;
	
	/**
	 * 市场价
	 */
	private BigDecimal marketPrice;
	
	/**
	 * 申请价
	 */
	private BigDecimal applyPrice;
	
	/**
	 * 可申请总数 - -1：表示不受限制
	 */
	private Long totalNum;
	
	/**
	 * 每人最多申请数 - -1：表示不受限制
	 */
	private Long maxNumPer;
	
	/**
	 * 已申请数
	 */
	private Long applyNum;
	
	/**
	 * 已申请人次
	 */
	private Long applyManTime;
	
	/**
	 * 开始时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date beginTime;
	
	/**
	 * 截止时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date endTime;
	
	/**
	 * 简介
	 */
	private String intro;
	
	/**
	 * 描述
	 */
	private String description;
	
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
	@JoinColumn(name="boardBaseId") 
	private DevBoardBase devBoardBase;
	
	@OneToMany(mappedBy="devBoardPro")
	private List<DevBoardReport> devBoardReports;
	
	@OneToMany(mappedBy="devBoardPro")
	private List<DevBoardApply> devBoardApplys;
	
	public DevBoardPro(){
	
	}

	public DevBoardPro(String id){
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
	
	public DevBoardProType getProType() {
		return proType;
	}

	public void setProType(DevBoardProType proType) {
		this.proType = proType;
	}

	public Integer getSort() {
		return sort;
	}
	
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	
	public BigDecimal getMarketPrice() {
		return marketPrice;
	}
	
	public void setMarketPrice(BigDecimal marketPrice) {
		this.marketPrice = marketPrice;
	}
	
	public BigDecimal getApplyPrice() {
		return applyPrice;
	}
	
	public void setApplyPrice(BigDecimal applyPrice) {
		this.applyPrice = applyPrice;
	}
	
	public Long getTotalNum() {
		return totalNum;
	}
	
	public void setTotalNum(Long totalNum) {
		this.totalNum = totalNum;
	}
	
	public Long getMaxNumPer() {
		return maxNumPer;
	}
	
	public void setMaxNumPer(Long maxNumPer) {
		this.maxNumPer = maxNumPer;
	}
	
	public Long getApplyNum() {
		return applyNum;
	}
	
	public void setApplyNum(Long applyNum) {
		this.applyNum = applyNum;
	}
	
	public Long getApplyManTime() {
		return applyManTime;
	}
	
	public void setApplyManTime(Long applyManTime) {
		this.applyManTime = applyManTime;
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
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getRemark() {
		return remark;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public void setDevBoardBase(DevBoardBase devBoardBase){
		this.devBoardBase = devBoardBase;
	}
	
	public DevBoardBase getDevBoardBase() {
		return devBoardBase;
	}
	public void setDevBoardReports(List<DevBoardReport> devBoardReports){
		this.devBoardReports = devBoardReports;
	}
	
	public List<DevBoardReport> getDevBoardReports() {
		return devBoardReports;
	}
	public void setDevBoardApplys(List<DevBoardApply> devBoardApplys){
		this.devBoardApplys = devBoardApplys;
	}
	
	public List<DevBoardApply> getDevBoardApplys() {
		return devBoardApplys;
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

}

