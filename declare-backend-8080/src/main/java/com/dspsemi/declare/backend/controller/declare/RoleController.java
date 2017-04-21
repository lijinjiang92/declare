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
import com.dspsemi.declare.core.pojo.declare.Role;
import com.dspsemi.declare.core.service.declare.RoleService;

/**
 * 
 * @author 
 *
 */
@Controller
public class RoleController extends BaseController {

	@Resource
	private RoleService roleService;
	
	/**
	 * 列表页面
	 */
	public DataPage<Role> list(DataPage<Role> dataPage,Model model) throws Exception {
		return roleService.page(dataPage.getPageNo(), dataPage.getPageSize());
	}   
	
	/**
	 * 新增
	 */
	public void add(Model model) throws Exception {
		
	}
	
	/**
	 * 执行新增
	 */
	public void adding(Role role, HttpServletResponse response) throws Exception {
		roleService.add(role);
		callback(closeDialog(), response);
	}
	
	/**
	 * 跳转修改页面
	 */
	public void update(String id, Model model) throws Exception {		
		model.addAttribute("role", load(id));
	}
	/**
	 * 详情
	 */
	public Role load(String id) throws Exception {
		Assert.notNull(id, "主键参数不能为空");
		return roleService.load(id);
	}
	/**
	 * 执行修改
	 */
	public void updating(Role role, HttpServletResponse response) throws Exception {
		int count = roleService.update(role);
		if(count > 0)
			callback(closeDialog(), response);
		else
			callback(closeDialog(CodeMsg.FAIL), response);
	}
	
	@ResponseBody
	public CodeMsg remove(String[] ids) throws Exception {
		return gt0(roleService.remove(ids));
	}
}
