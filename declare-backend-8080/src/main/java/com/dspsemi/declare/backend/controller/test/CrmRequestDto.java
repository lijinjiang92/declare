package com.dspsemi.declare.backend.controller.test;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * pos端请求参数实体
 * Created by zhengkai on 2017/4/22.
 */
public class CrmRequestDto extends BaseEntity {
    /**
     * 手机号
     */
    private String custMobile;

    /**
     * 会员卡号
     */
    private String cardNo;

    /**
     * 支付方式
     */
    private Integer payType;
    /**
     * 支付金额
     */
    private String payAmount;
    /**
     * 账单id
     */
    private UUID billId;
    /**
     * 订单id
     */
    private UUID orderId;
    /**
     * 支付列表（消费方式、消费金额）
     */
    private List<CrmRequestDto> payList;
    /**
     * 操作人id
     */
    private UUID operationUserId;
    /**
     * 会员名
     */
    private String custName;
    /**
     * 性别
     */
    private Integer custGender;
    /**
     * 生日类型--阴历，阳历
     */
    private Integer birthType;
    /**
     * 生日
     */
    private Date birthDate;
    /**
     * 常用地址
     */
    private String commAddress;
    /**
     * 固定电话
     */
    private String fixedTel;
    /**
     * 邮政编码
     */
    private String zipcode;
    /**
    * 证件类型
     */
    private Integer docuType;
    /**
     * 证件号码
     */
    private String docuCode;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 会员来源
     */
    private Integer custSource;
    /**
     * 会员卡种
     */
    private Object custCardType;
    /**
     * 备注
     */
    private String remarks;
    /**
     * 交易设备
     */
    private UUID tranDevice;
    
    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getCustMobile() {
        return custMobile;
    }

    public void setCustMobile(String custMobile) {
        this.custMobile = custMobile;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(String payAmount) {
        this.payAmount = payAmount;
    }

    public UUID getBillId() {
        return billId;
    }

    public void setBillId(UUID billId) {
        this.billId = billId;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public List<CrmRequestDto> getPayList() {
        return payList;
    }

    public void setPayList(List<CrmRequestDto> payList) {
        this.payList = payList;
    }

    public UUID getOperationUserId() {
        return operationUserId;
    }

    public void setOperationUserId(UUID operationUserId) {
        this.operationUserId = operationUserId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public Integer getCustGender() {
        return custGender;
    }

    public void setCustGender(Integer custGender) {
        this.custGender = custGender;
    }

    public Integer getBirthType() {
        return birthType;
    }

    public void setBirthType(Integer birthType) {
        this.birthType = birthType;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getCommAddress() {
        return commAddress;
    }

    public void setCommAddress(String commAddress) {
        this.commAddress = commAddress;
    }

    public String getFixedTel() {
        return fixedTel;
    }

    public void setFixedTel(String fixedTel) {
        this.fixedTel = fixedTel;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Integer getDocuType() {
        return docuType;
    }

    public void setDocuType(Integer docuType) {
        this.docuType = docuType;
    }

    public String getDocuCode() {
        return docuCode;
    }

    public void setDocuCode(String docuCode) {
        this.docuCode = docuCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getCustSource() {
        return custSource;
    }

    public void setCustSource(Integer custSource) {
        this.custSource = custSource;
    }

    public Object getCustCardType() {
        return custCardType;
    }

    public void setCustCardType(Object custCardType) {
        this.custCardType = custCardType;
    }

	public UUID getTranDevice() {
		return tranDevice;
	}

	public void setTranDevice(UUID tranDevice) {
		this.tranDevice = tranDevice;
	}
    
}
