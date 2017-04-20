package com.dspsemi.declare.backend.controller.system;

import static com.dspsemi.common.web.callback.Callbacks.callback;
import static com.dspsemi.common.web.callback.Callbacks.closeDialog;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dspsemi.common.algorithm.Base64UUID;
import com.dspsemi.common.enums.entity.status.CloseStatus;
import com.dspsemi.common.error.CodeMsg;
import com.dspsemi.common.lang.StringUtils;
import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.common.validate.Assert;
import com.dspsemi.common.validate.VerifyCode;
import com.dspsemi.common.web.BaseController;
import com.dspsemi.declare.core.pojo.declare.Register;
import com.dspsemi.declare.core.service.declare.RegisterService;

/**
 * 用户管理
 * @author 
 *
 */
@Controller
public class UserController extends BaseController {

	@Resource
	private RegisterService registerService;
	
	
	public void login(Model model){
		
	}
	
	/**
	 * 登录页面
	 */
	public void add(Model model) throws Exception {
		
	}
	
	/**
	 * 注册页面
	 * @param model
	 * @throws Exception
	 */
	public void reg(Model model) throws Exception {
		
	}
	
	
	
	/**
	 * 执行新增
	 * @return 
	 */
	@ResponseBody
	public CodeMsg adding(Register register, HttpServletResponse response,HttpServletRequest request) throws Exception {
		String salt = getHash();
		register.setHash(salt);
		String pwd = encoderByMd5(register.getRegistePassword(), salt);
		register.setRegistePassword(pwd);
		register.setRegisteredIp(getIp(request));
		register.setUserStatus(CloseStatus.OPEN);
		try {
			registerService.add(register);
			return CodeMsg.SUC;
		} catch (Exception e) {
			e.printStackTrace();
			return CodeMsg.FAIL;
		}
	}
	
	/**
	 * 跳转修改页面
	 */
	public void update(String id, Model model) throws Exception {		
		model.addAttribute("register", load(id));
	}
	/**
	 * 详情
	 */
	public Register load(String id) throws Exception {
		Assert.notNull(id, "主键参数不能为空");
		return registerService.load(id);
	}
	/**
	 * 执行修改
	 */
	public void updating(Register register, HttpServletResponse response) throws Exception {
		int count = registerService.update(register);
		if(count > 0)
			callback(closeDialog(), response);
		else
			callback(closeDialog(CodeMsg.FAIL), response);
	}
	
	@ResponseBody
	public CodeMsg remove(String[] ids) throws Exception {
		return gt0(registerService.remove(ids));
	}
	
	private String getHash(){
		int machineId = 1;//最大支持1-9个集群机器部署
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if(hashCodeV < 0) {//有可能是负数
            hashCodeV = - hashCodeV;
        }
        // 0 代表前面补充0     
        // 4 代表长度为4     
        // d 代表参数为正数型
        return machineId + String.format("%015d", hashCodeV);
	}
	
	/**
	 * 加密密码
	 * @param pwd
	 * @param salt
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	private String encoderByMd5(String pwd,String salt) throws NoSuchAlgorithmException, UnsupportedEncodingException{
        //确定计算方法
		String newStr = pwd+salt;
        MessageDigest md5=MessageDigest.getInstance("MD5");
        
        return Base64.encodeBase64URLSafeString(md5.digest(newStr.getBytes("utf-8")));
    }
	
	public static String getIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if(StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)){
            //多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = ip.indexOf(",");
            if(index != -1){
                return ip.substring(0,index);
            }else{
                return ip;
            }
        }
        ip = request.getHeader("X-Real-IP");
        if(StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)){
            return ip;
        }
        return request.getRemoteAddr();
    }
	
}
