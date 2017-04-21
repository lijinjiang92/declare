package com.dspsemi.declare.backend.controller.devboard;

import static com.dspsemi.common.web.callback.Callbacks.callback;
import static com.dspsemi.common.web.callback.Callbacks.closeDialog;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dspsemi.common.enums.entity.status.VerifyStatus;
import com.dspsemi.common.error.CodeMsg;
import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.common.validate.Assert;
import com.dspsemi.common.validate.Validators;
import com.dspsemi.common.web.BaseController;
import com.dspsemi.declare.core.pojo.devboard.DevBoardReport;
import com.dspsemi.declare.core.service.devboard.DevBoardReportService;

/**
 * @author XiaoJin Wang
 *
 */
@Controller
public class DevBoardReportController extends BaseController {
	
	@Resource
	private DevBoardReportService devBoardReportService;

	/**
	 * 列表
	 */
	public DataPage<DevBoardReport> list(DevBoardReport devBoardReport, DataPage<DevBoardReport> dataPage,
			@RequestParam(required = false, value = "status")  VerifyStatus status,
			@RequestParam(required = false, value = "title")  String title,Model model) throws Exception {
		model.addAttribute("title",title);
		model.addAttribute("status",status);
		return devBoardReportService.page(dataPage.getPageNo(), dataPage.getPageSize(),title,status);
	}
	
	/**
	 * 详情
	 */
	public DevBoardReport load(String id) throws Exception {
		Assert.notBlank(id, "主键参数不能为空");
		return devBoardReportService.load(id);
	}
	
	/**
	 * 审核
	 */
	@ResponseBody
	public CodeMsg verify(String[] ids) throws Exception {
		Validators.instance(ids)
			.minLength(1, "主键参数不能传空值")
			.notEmptyInside("主键参数不能传空值");
		int count = devBoardReportService.verify(ids);
		return gt0(count);
	}
	
	/**
	 * 执行新增
	 */
	public void adding(DevBoardReport devBoardReport, HttpServletResponse response) throws Exception {
		devBoardReportService.add(devBoardReport);
		callback(closeDialog(), response);
	}
	
	/**
	 * 跳转修改页面
	 */
	public DevBoardReport update(String id) throws Exception {
		return load(id);
	}
	
	/**
	 * 执行修改
	 */
	public void updating(DevBoardReport devBoardReport, HttpServletResponse response) throws Exception {
		int count = devBoardReportService.update(devBoardReport);
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
		int count = devBoardReportService.remove(ids);
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
		int count = devBoardReportService.removePhy(ids);
		return gt0(count);
	}
	
}
