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
import com.dspsemi.declare.core.pojo.declare.EnterpriseReport;
import com.dspsemi.declare.core.service.declare.EnterpriseReportService;

/**
 * 
 * @author 
 *
 */
@Controller
public class EnterpriseReportController extends BaseController {

	@Resource
	private EnterpriseReportService enterpriseReportService;
	
	/**
	 * 列表页面
	 */
	public DataPage<EnterpriseReport> list(DataPage<EnterpriseReport> dataPage,Model model) throws Exception {
		return enterpriseReportService.page(dataPage.getPageNo(), dataPage.getPageSize());
	}   
	
	/**
	 * 新增
	 */
	public void add(Model model) throws Exception {
		
	}
	
	/**
	 * 执行新增
	 */
	public void adding(EnterpriseReport enterpriseReport, HttpServletResponse response) throws Exception {
		enterpriseReportService.add(enterpriseReport);
		callback(closeDialog(), response);
	}
	
	/**
	 * 跳转修改页面
	 */
	public void update(String id, Model model) throws Exception {		
		model.addAttribute("enterpriseReport", load(id));
	}
	/**
	 * 详情
	 */
	public EnterpriseReport load(String id) throws Exception {
		Assert.notNull(id, "主键参数不能为空");
		return enterpriseReportService.load(id);
	}
	/**
	 * 执行修改
	 */
	public void updating(EnterpriseReport enterpriseReport, HttpServletResponse response) throws Exception {
		int count = enterpriseReportService.update(enterpriseReport);
		if(count > 0)
			callback(closeDialog(), response);
		else
			callback(closeDialog(CodeMsg.FAIL), response);
	}
	
	@ResponseBody
	public CodeMsg remove(String[] ids) throws Exception {
		return gt0(enterpriseReportService.remove(ids));
	}
}
