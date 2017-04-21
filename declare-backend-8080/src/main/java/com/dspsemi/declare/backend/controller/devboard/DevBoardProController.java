package com.dspsemi.declare.backend.controller.devboard;

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
import com.dspsemi.declare.core.enums.DevBoardProType;
import com.dspsemi.declare.core.pojo.devboard.DevBoardPro;
import com.dspsemi.declare.core.service.devboard.DevBoardBaseService;
import com.dspsemi.declare.core.service.devboard.DevBoardProService;

/**
 * @author XiaoJin Wang
 *
 */
@Controller
public class DevBoardProController extends BaseController {
	
	@Resource
	private DevBoardProService devBoardProService;
	@Resource
	private DevBoardBaseService devBoardBaseService;
	
	

	/**
	 * 列表
	 */
	public DataPage<DevBoardPro> list(DevBoardPro devBoardPro, DataPage<DevBoardPro> dataPage, 
			@RequestParam(required = false, value = "title")  String title,
			@RequestParam(required = false, value = "proType")  DevBoardProType proType,Model model
			) throws Exception {
		model.addAttribute("title", title);
		model.addAttribute("proType", proType);
	
		return devBoardProService.page(dataPage.getPageNo(), dataPage.getPageSize(),title,proType);
	}
	
	/**
	 * 详情
	 */
	public DevBoardPro load(String id) throws Exception {
		Assert.notBlank(id, "主键参数不能为空");
		return devBoardProService.load(id);
	}
	
	/**
	 * 执行新增
	 */
	public void adding(DevBoardPro devBoardPro, HttpServletResponse response) throws Exception {
		devBoardProService.add(devBoardPro);
		callback(closeDialog(), response);
	}
	
	/**
	 * 跳转到添加页面
	 */
	public void add(Model model) throws Exception {
		model.addAttribute("baseList", devBoardBaseService.list());
	}
	/**
	 * 跳转修改页面
	 */
	public DevBoardPro update(String id,Model model) throws Exception {
		model.addAttribute("baseList", devBoardBaseService.list());
		return load(id);
	}
	
	/**
	 * 执行修改
	 */
	public void updating(DevBoardPro devBoardPro, HttpServletResponse response) throws Exception {
		int count = devBoardProService.update(devBoardPro);
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
		int count = devBoardProService.remove(ids);
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
		int count = devBoardProService.removePhy(ids);
		return gt0(count);
	}
	
}
