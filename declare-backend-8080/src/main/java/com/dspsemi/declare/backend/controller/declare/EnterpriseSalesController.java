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
import com.dspsemi.declare.core.pojo.declare.EnterpriseSales;
import com.dspsemi.declare.core.service.declare.EnterpriseSalesService;

/**
 * 
 * @author 
 *
 */
@Controller
public class EnterpriseSalesController extends BaseController {

	@Resource
	private EnterpriseSalesService enterpriseSalesService;
	
	/**
	 * 列表页面
	 */
	public DataPage<EnterpriseSales> list(DataPage<EnterpriseSales> dataPage,Model model) throws Exception {
		return enterpriseSalesService.page(dataPage.getPageNo(), dataPage.getPageSize());
	}   
	
	/**
	 * 新增
	 */
	public void add(Model model) throws Exception {
		
	}
	
	/**
	 * 执行新增
	 */
	public void adding(EnterpriseSales enterpriseSales, HttpServletResponse response) throws Exception {
		enterpriseSalesService.add(enterpriseSales);
		callback(closeDialog(), response);
	}
	
	/**
	 * 跳转修改页面
	 */
	public void update(String id, Model model) throws Exception {		
		model.addAttribute("enterpriseSales", load(id));
	}
	/**
	 * 详情
	 */
	public EnterpriseSales load(String id) throws Exception {
		Assert.notNull(id, "主键参数不能为空");
		return enterpriseSalesService.load(id);
	}
	/**
	 * 执行修改
	 */
	public void updating(EnterpriseSales enterpriseSales, HttpServletResponse response) throws Exception {
		int count = enterpriseSalesService.update(enterpriseSales);
		if(count > 0)
			callback(closeDialog(), response);
		else
			callback(closeDialog(CodeMsg.FAIL), response);
	}
	
	@ResponseBody
	public CodeMsg remove(String[] ids) throws Exception {
		return gt0(enterpriseSalesService.remove(ids));
	}
}
