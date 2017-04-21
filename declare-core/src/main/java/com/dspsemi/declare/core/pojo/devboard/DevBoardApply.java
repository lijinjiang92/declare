package com.dspsemi.declare.core.pojo.devboard;

import java.math.BigDecimal;
import java.util.Date;

import com.dspsemi.common.enums.entity.status.DeleteStatus;
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
import com.dspsemi.declare.core.enums.DevBoardApplyStatus;
import com.dspsemi.declare.core.enums.DevBoardProType;
import com.dspsemi.declare.core.pojo.user.DeliveryAddr;
import com.dspsemi.declare.core.util.mybatis.GeneratedValue;
import com.dspsemi.declare.core.util.mybatis.GeneratorEnum;

/**
 * 开发板申请表 - 申请的开发板产品记录
 * @author XiaoJin Wang
 *
 */
@Entity
@Add2Resource
@Table(name="db_dev_board_apply")
public class DevBoardApply extends AbstractOperateEntity {

	private static final long serialVersionUID = 5454155825314635342L;
	
	/**
	 * 主键 - 主
	 */
	@Id
	@GeneratedValue(GeneratorEnum.DEV_BOARD_APPLY_ID)
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
	 * 配送地址ID
	 */
	private Long deliveryAddrId;
	
	/**
	 * 手机号
	 */
	private String mobile;
	
	/**
	 * 联系人
	 */
	private String relation;
	
	/**
	 * 配送地址
	 */
	private String address;
	
	/**
	 * 状态
	 */
	private DeleteStatus status;
	
	/**
	 * 申请状态
	 */
	private DevBoardApplyStatus applyStatus;
	
	/**
	 * 申请单价
	 */
	private BigDecimal applyPrice;
	
	/**
	 * 申请数
	 */
	private Long applyNum;
	
	/**
	 * 申请总价
	 */
	private BigDecimal applyTotalPrice;
	
	/**
	 * 项目名
	 */
	private String projectName;
	
	/**
	 * 申请理由
	 */
	private String applyReason;
	
	/**
	 * 项目描述
	 */
	private String projectDesc;
	
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
	@JoinColumn(name="deliveryAddrId") 
	private DeliveryAddr deliveryAddr;
	
	@ManyToOne
	@JoinColumn(name="boardProId") 
	private DevBoardPro devBoardPro;
	
	@ManyToOne
	@JoinColumn(name="boardBaseId") 
	private DevBoardBase devBoardBase;
	
	@Transient
	private String name;
	@Transient
	private String manufacturer;//生产厂商
	@Transient
	private String pic;//产品图片
	@Transient
	private DevBoardProType proType;
	
	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DevBoardApply(){
	
	}

	public DevBoardApply(String id){
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
	
	public Long getDeliveryAddrId() {
		return deliveryAddrId;
	}
	
	public void setDeliveryAddrId(Long deliveryAddrId) {
		this.deliveryAddrId = deliveryAddrId;
	}
	
	public DeleteStatus getStatus() {
		return status;
	}

	public void setStatus(DeleteStatus status) {
		this.status = status;
	}

	public DevBoardApplyStatus getApplyStatus() {
		return applyStatus;
	}

	public void setApplyStatus(DevBoardApplyStatus applyStatus) {
		this.applyStatus = applyStatus;
	}

	public BigDecimal getApplyPrice() {
		return applyPrice;
	}
	
	public void setApplyPrice(BigDecimal applyPrice) {
		this.applyPrice = applyPrice;
	}
	
	public Long getApplyNum() {
		return applyNum;
	}
	
	public void setApplyNum(Long applyNum) {
		this.applyNum = applyNum;
	}
	
	public BigDecimal getApplyTotalPrice() {
		return applyTotalPrice;
	}
	
	public void setApplyTotalPrice(BigDecimal applyTotalPrice) {
		this.applyTotalPrice = applyTotalPrice;
	}
	
	public String getProjectName() {
		return projectName;
	}
	
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	public String getApplyReason() {
		return applyReason;
	}
	
	public void setApplyReason(String applyReason) {
		this.applyReason = applyReason;
	}
	
	public String getProjectDesc() {
		return projectDesc;
	}
	
	public void setProjectDesc(String projectDesc) {
		this.projectDesc = projectDesc;
	}
	
	public String getRemark() {
		return remark;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public void setDeliveryAddr(DeliveryAddr deliveryAddr){
		this.deliveryAddr = deliveryAddr;
	}
	
	public DeliveryAddr getDeliveryAddr() {
		return deliveryAddr;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public DevBoardProType getProType() {
		return proType;
	}

	public void setProType(DevBoardProType proType) {
		this.proType = proType;
	}
	

}

