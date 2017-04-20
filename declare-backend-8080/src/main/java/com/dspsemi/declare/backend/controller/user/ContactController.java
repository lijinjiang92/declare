package com.dspsemi.declare.backend.controller.user;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dspsemi.common.error.CodeMsg;
import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.common.validate.Assert;
import com.dspsemi.common.validate.Validators;
import com.dspsemi.common.web.BaseController;
import com.dspsemi.declare.core.pojo.activity.Activity;
import com.dspsemi.declare.core.pojo.user.Contact;
import com.dspsemi.declare.core.service.user.ContactService;
import com.dspsemi.login.ws.bo.UserWsBo;

/**
 * @author XiaoJin Wang
 *
 */
@Controller
public class ContactController extends BaseController {
	@Resource
	private ContactService contactService;

	public DataPage<Contact> list(Contact contact, DataPage<UserWsBo> dataPage,Model model) throws Exception {
		model.addAttribute("name", contact.getName());
		return contactService.page(dataPage.getPageNo(), dataPage.getPageSize(), contact.getName());
	}
	
	/**
	 * 详情
	 */
	public Contact load(String id) throws Exception {
		Assert.notBlank(id, "主键参数不能为空");
		return contactService.load(id);
	}
	
	
	/**
	 * 逻辑删除
	 */
	@ResponseBody
	public CodeMsg remove(String[] ids) throws Exception {
		Validators.instance(ids)
			.minLength(1, "主键参数不能传空值")
			.notEmptyInside("主键参数不能传空值");
		int count = contactService.remove(ids);
		return gt0(count);
	}
	
}
