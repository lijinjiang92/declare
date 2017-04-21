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
import com.dspsemi.declare.core.pojo.declare.EnterpriseInfo;
import com.dspsemi.declare.core.service.declare.EnterpriseInfoService;

/**
 * 
 * @author 
 *
 */
@Controller
public class EnterpriseInfoController extends BaseController {

	@Resource
	private EnterpriseInfoService enterpriseInfoService;
	
	/**
	 * 列表页面
	 */
	public DataPage<EnterpriseInfo> list(DataPage<EnterpriseInfo> dataPage,Model model) throws Exception {
		return enterpriseInfoService.page(dataPage.getPageNo(), dataPage.getPageSize());
	}   
	
	/**
	 * 新增
	 */
	public void add(Model model) throws Exception {
		
	}
	
	/**
	 * 执行新增
	 */
	public void adding(EnterpriseInfo enterpriseInfo, HttpServletResponse response) throws Exception {
		enterpriseInfoService.add(enterpriseInfo);
		callback(closeDialog(), response);
	}
	
	/**
	 * 跳转修改页面
	 */
	public void update(String id, Model model) throws Exception {		
		model.addAttribute("enterpriseInfo", load(id));
	}
	/**
	 * 详情
	 */
	public EnterpriseInfo load(String id) throws Exception {
		Assert.notNull(id, "主键参数不能为空");
		return enterpriseInfoService.load(id);
	}
	/**
	 * 执行修改
	 */
	public void updating(EnterpriseInfo enterpriseInfo, HttpServletResponse response) throws Exception {
		int count = enterpriseInfoService.update(enterpriseInfo);
		if(count > 0)
			callback(closeDialog(), response);
		else
			callback(closeDialog(CodeMsg.FAIL), response);
	}
	
	@ResponseBody
	public CodeMsg remove(String[] ids) throws Exception {
		return gt0(enterpriseInfoService.remove(ids));
	}
}
