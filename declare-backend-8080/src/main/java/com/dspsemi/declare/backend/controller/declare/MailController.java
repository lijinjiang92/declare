package com.dspsemi.declare.backend.controller.declare;

import static com.dspsemi.common.web.callback.Callbacks.callback;
import static com.dspsemi.common.web.callback.Callbacks.closeDialog;

import java.text.SimpleDateFormat;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dspsemi.common.error.CodeMsg;
import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.common.validate.Assert;
import com.dspsemi.common.web.BaseController;
import com.dspsemi.declare.core.pojo.declare.Mail;
import com.dspsemi.declare.core.service.declare.MailService;

/**
 * 
 * @author 
 *
 */
@Controller
public class MailController extends BaseController {

	@Resource
	private MailService mailService;
	
	/**
	 * 列表页面
	 */
	public DataPage<Mail> list(DataPage<Mail> dataPage,Model model) throws Exception {
		return mailService.page(dataPage.getPageNo(), dataPage.getPageSize());
	}   
	
	/**
	 * 新增
	 */
	public void add(Model model) throws Exception {
		
	}
	
	/**
	 * 执行新增
	 */
	public void adding(Mail mail, HttpServletResponse response) throws Exception {
		mailService.add(mail);
		callback(closeDialog(), response);
	}
	
	/**
	 * 跳转修改页面
	 */
	public void update(String id, Model model) throws Exception {		
		model.addAttribute("mail", load(id));
	}
	/**
	 * 详情
	 */
	public Mail load(String id) throws Exception {
		Assert.notNull(id, "主键参数不能为空");
		return mailService.load(id);
	}
	/**
	 * 执行修改
	 */
	public void updating(Mail mail, HttpServletResponse response) throws Exception {
		int count = mailService.update(mail);
		if(count > 0)
			callback(closeDialog(), response);
		else
			callback(closeDialog(CodeMsg.FAIL), response);
	}
	
	@ResponseBody
	public CodeMsg remove(String[] ids) throws Exception {
		return gt0(mailService.remove(ids));
	}
}
