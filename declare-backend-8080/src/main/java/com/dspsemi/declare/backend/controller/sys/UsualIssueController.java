package com.dspsemi.declare.backend.controller.sys;

import static com.dspsemi.common.web.callback.Callbacks.callback;
import static com.dspsemi.common.web.callback.Callbacks.closeDialog;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dspsemi.common.error.CodeMsg;
import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.common.validate.Assert;
import com.dspsemi.common.validate.Validators;
import com.dspsemi.common.web.BaseController;
import com.dspsemi.declare.core.pojo.sys.UsualIssue;
import com.dspsemi.declare.core.service.sys.UsualIssueService;
import com.dspsemi.declare.core.service.sys.UsualIssueTypeService;

/**
 * @author XiaoJin Wang
 *
 */
@Controller
public class UsualIssueController extends BaseController {
	
	@Resource
	private UsualIssueService usualIssueService;
	@Resource
	private UsualIssueTypeService usualIssueTypeService;

	/**
	 * 列表
	 */
	public DataPage<UsualIssue> list(UsualIssue usualIssue, DataPage<UsualIssue> dataPage, 
			@RequestParam(required = false, value = "titleQuery")  String titleQuery,
			@RequestParam(required = false, value = "issueTypeId")  Integer issueTypeId,
			Model model) throws Exception {
		model.addAttribute("typeList",usualIssueTypeService.list());
		model.addAttribute("titleQuery",titleQuery);
		model.addAttribute("issueTypeId",issueTypeId);
		return usualIssueService.page(dataPage.getPageNo(), dataPage.getPageSize(),titleQuery,issueTypeId);
	}
	
	/**
	 * 详情
	 */
	public UsualIssue load(String id) throws Exception {
		Assert.notBlank(id, "主键参数不能为空");
		return usualIssueService.load(id);
	}
	
	/**
	 * 执行新增
	 */
	public void adding(UsualIssue usualIssue, HttpServletResponse response,Model model) throws Exception {
		usualIssueService.add(usualIssue);
		callback(closeDialog(), response);
	}
	
	/**
	 * 跳转新增页面
	 */
	public void add(Model model) throws Exception {
		model.addAttribute("typeList",usualIssueTypeService.list());
	}
	
	/**
	 * 跳转修改页面
	 */
	public UsualIssue update(String id,Model model) throws Exception {
		model.addAttribute("typeList",usualIssueTypeService.list());
		return load(id);
	}
	
	/**
	 * 执行修改
	 */
	public void updating(UsualIssue usualIssue, HttpServletResponse response) throws Exception {
		int count = usualIssueService.update(usualIssue);
		if(count > 0)
			callback(closeDialog(), response);
		else
			callback(closeDialog(CodeMsg.FAIL), response);
	}
	
	/**
	 * 逻辑删除
	 */
	@ResponseBody
	public CodeMsg remove(String[] ids) throws Exception {
		Validators.instance(ids)
			.minLength(1, "主键参数不能传空值")
			.notEmptyInside("主键参数不能传空值");
		int count = usualIssueService.remove(ids);
		return gt0(count);
	}
	
	/**
	 * 物理删除
	 */
	@ResponseBody
	public CodeMsg removePhy(String[] ids) throws Exception {
		Validators.instance(ids)
			.minLength(1, "主键参数不能传空值")
			.notEmptyInside("主键参数不能传空值");
		int count = usualIssueService.removePhy(ids);
		return gt0(count);
	}
	
}
