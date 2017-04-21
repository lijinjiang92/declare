package com.dspsemi.declare.backend.controller.declare;

import static com.dspsemi.common.web.callback.Callbacks.callback;
import static com.dspsemi.common.web.callback.Callbacks.closeDialog;
import static com.dspsemi.common.web.callback.Callbacks.closeDialogQuiet;
import static com.dspsemi.common.web.callback.Callbacks.none;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dspsemi.common.enums.entity.status.CloseStatus;
import com.dspsemi.common.error.CodeMsg;
import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.common.security.SecurityUtils;
import com.dspsemi.common.validate.Assert;
import com.dspsemi.common.validate.Validators;
import com.dspsemi.common.web.BaseController;
import com.dspsemi.declare.core.pojo.declare.Register;
import com.dspsemi.declare.core.service.declare.RegisterService;

/**
 * 用户管理
 * @author 
 *
 */
@Controller
public class RegisterController extends BaseController {

	@Resource
	private RegisterService registerService;
	
	
	
	
	/**
	 * 列表页面
	 */
	public DataPage<Register> list(Register register,DataPage<Register> dataPage,Model model) throws Exception {
		model.addAttribute("register", register);
		return registerService.page(dataPage.getPageNo(), dataPage.getPageSize(),register);
	}   
	
	/**
	 * 新增
	 */
	public void add(Model model) throws Exception {
		
	}
	
	/**
	 * 执行新增
	 */
	public void adding(Register register, HttpServletResponse response) throws Exception {
		registerService.add(register);
		callback(closeDialog(), response);
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
	
	
	/**
	 * 执行修改密码page
	 */
	public void updatePwd(Model model) throws Exception {
	}
	
	/**
	 * 执行修改密码
	 */
	public void updatingPwd(String oldPwd, String pwd, HttpServletResponse response) throws Exception {
		
		
		
		String id = "a15b7";
		int num = registerService.updatePwd(id, oldPwd, pwd);

		if(num > 0)
			callback(closeDialogQuiet(), response);
		else
			callback(none(CodeMsg.FAIL.msg("修改失败")), response);
		
//		if(tmpPwd == null) {
//			callback(closeDialogQuiet(CodeMsgExt.FAIL.msg("不能修改此用户的密码")), response);
//		}else if(!tmpPwd.equals(oldPwd))
//			callback(none(CodeMsgExt.FAIL.msg("原密码输入错误")), response);
//		else {
//			int num = userService.updatePwd(DigestUtils.md5Hex(pwd), SecurityUtils.getUserId());
//			if(num > 0)
//				callback(closeDialogQuiet(), response);
//			else
//				callback(closeDialogQuiet(CodeMsgExt.FAIL_MSG), response);
//		}
	}
	
	
	@ResponseBody
	public CodeMsg remove(String[] ids) throws Exception {
		return gt0(registerService.remove(ids));
	}
	
	
	@ResponseBody
	public CodeMsg openClose(String[] ids, CloseStatus status) throws Exception {
		Validators.instance(ids)
			.minLength(1, "主键参数不能传空值")
			.notEmptyInside("主键参数不能传空值");
		int count = registerService.openClose(ids, status);
		return gt0None(count);
	}
	
}
