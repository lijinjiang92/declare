package com.dspsemi.declare.core.util;

import com.alibaba.druid.filter.config.ConfigTools;
import com.dspsemi.common.BaseConstants;
import com.dspsemi.common.processor.StaticValue;

/**
 * @author XiaoJin Wang
 * 
 */
public class Constants extends BaseConstants {
	
	//登录失败指定次数就锁住该用户
	@StaticValue("${login_fail}")
	public static Integer loginFail;
	//重置后的新密码
	@StaticValue("${reset_pwd}")
	public static String resetPwd;
	
	/**
	 * 资源服务器地址
	 */
	@StaticValue("${res_url}")
	public static String resUrl;
	
	@StaticValue("${username_key}")
	public static String usernameKey = "username";
	
	/**
	 * BBS版主角色
	 */
	public static String bbsModeratorRole = "BBS版主（IC平台）";
	
	/**
	 * 普通用户
	 */
	public static String icNormalUser = "普通用户（IC平台）";
	
	//系统用户
	public static class SysUser {
		
		public static String userId = "0";
		public static String username = "系统";
		
	}
	
	/******************  支付宝配置 ******************************************/
	@StaticValue("${notify_url}")
	public static String notifyUrl;
	@StaticValue("${dsp_alipay_partner}")
	public static String dspAlipayPartner;
	@StaticValue("${dsp_alipay_key}")
	public static String dspAlipayKey;
	@StaticValue("${use_royalty}")
	public static String useRoyalty;
	@StaticValue("${royalty_percent}")
	public static String royaltyPercent;
	@StaticValue("${royalty_fix_value}")
	public static String royaltyFixValue;
	public static String fixMoney = "固定金额分账";
	public static String fixPercent = "固定金额分账";
	/*********************************************************************/
	
	/******************  微信配置*******************************************/
	@StaticValue("${wx_appId}")
	public static String wxAppid;
	@StaticValue("${wx_appSecret}")
	public static String wxAppsecret;
	@StaticValue("${wx_paySignKey}")
	public static String wxPaysignkey;
	@StaticValue("${wx_partnerId}")
	public static String wxPartnerid;
	@StaticValue("${wx_partnerKey}")
	public static String wxPartnerkey;
	@StaticValue("${wx_signType}")
	public static String wxSigntype;
	@StaticValue("${wx_notify_url}")
	public static String wxNotifyUrl;
	@StaticValue("${pic_get_ip}")
	public static String picGetIp;
	@StaticValue("${pic_upload}")
	public static String picUpload;
	/**
	 * @throws Exception *******************************************************************/
	
	public static void main(String[] args) throws Exception {
		System.out.println(ConfigTools.encrypt("dsp1748"));
	}
	
}
