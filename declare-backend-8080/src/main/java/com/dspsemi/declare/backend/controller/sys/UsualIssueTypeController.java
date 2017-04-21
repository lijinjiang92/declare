package com.dspsemi.declare.backend.controller.sys;

import static com.dspsemi.common.web.callback.Callbacks.callback;
import static com.dspsemi.common.web.callback.Callbacks.closeDialog;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dspsemi.common.enums.entity.LogLevel;
import com.dspsemi.common.error.CodeMsg;
import com.dspsemi.common.error.ErrorContext;
import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.common.validate.Assert;
import com.dspsemi.common.validate.Validators;
import com.dspsemi.common.web.BaseController;
import com.dspsemi.declare.core.pojo.sys.UsualIssue;
import com.dspsemi.declare.core.pojo.sys.UsualIssueType;
import com.dspsemi.declare.core.service.sys.UsualIssueService;
import com.dspsemi.declare.core.service.sys.UsualIssueTypeService;

/**
 * @author XiaoJin Wang
 *
 */
@Controller
@Scope("prototype") 
public class UsualIssueTypeController extends BaseController {
	
	@Resource
	private UsualIssueTypeService usualIssueTypeService;
	@Resource
	private UsualIssueService usualIssueService;

	/**
	 * 列表
	 */
	public DataPage<UsualIssueType> list(UsualIssueType usualIssueType, DataPage<UsualIssueType> dataPage, @RequestParam(required = false, value = "nameQuery")  String nameQuery,Model model) throws Exception {
		model.addAttribute("nameQuery",nameQuery);
		return usualIssueTypeService.page(dataPage.getPageNo(), dataPage.getPageSize(),nameQuery);
	}
	
	/**
	 * 详情
	 */
	public UsualIssueType load(Integer id) throws Exception {
		Assert.notNull(id, "主键参数不能为空");
		return usualIssueTypeService.load(id);
	}
	
	/**
	 * 执行新增
	 */
	public void adding(UsualIssueType usualIssueType, HttpServletResponse response) throws Exception {
		usualIssueTypeService.add(usualIssueType);
		callback(closeDialog(), response);
	}
	
	/**
	 * 跳转修改页面
	 */
	public UsualIssueType update(Integer id) throws Exception {
		return load(id);
	}
	
	/**
	 * 执行修改
	 */
	public void updating(UsualIssueType usualIssueType, HttpServletResponse response) throws Exception {
		int count = usualIssueTypeService.update(usualIssueType);
		if(count > 0)
			callback(closeDialog(), response);
		else
			callback(closeDialog(CodeMsg.FAIL), response);
	}
	
	/**
	 * 逻辑删除
	 */
	@ResponseBody
	public CodeMsg remove(Integer[] ids) throws Exception {
		Validators.instance(ids)
			.minLength(1, "主键参数不能传空值")
			.notEmptyInside("主键参数不能传空值");
		List<UsualIssue> list = usualIssueService.listByTypeIds(ids);
		if(list!=null&&list.size()>0){
			throw ErrorContext.instance("此类别下关联了开发板，请先删除开发板").logLevel(LogLevel.WARN);
		}
		int count = usualIssueTypeService.remove(ids);
		return gt0(count);
	}
	
	/**
	 * 物理删除
	 */
	@ResponseBody
	public CodeMsg removePhy(Integer[] ids) throws Exception {
		Validators.instance(ids)
			.minLength(1, "主键参数不能传空值")
			.notEmptyInside("主键参数不能传空值");
		int count = usualIssueTypeService.removePhy(ids);
		return gt0(count);
	}
	
}
