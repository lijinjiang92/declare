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
import com.dspsemi.declare.core.pojo.devboard.DevBoardBase;
import com.dspsemi.declare.core.service.devboard.DevBoardBaseService;

/**
 * @author XiaoJin Wang
 *
 */
@Controller
public class DevBoardBaseController extends BaseController {
	
	@Resource
	private DevBoardBaseService devBoardBaseService;

	/**
	 * 列表
	 */
	public DataPage<DevBoardBase> list(DevBoardBase devBoardBase, DataPage<DevBoardBase> dataPage,
			@RequestParam(required = false, value = "name")  String name,
			@RequestParam(required = false, value = "manufacturer")  String manufacturer,Model model
			) throws Exception {
		model.addAttribute("name",name);
		model.addAttribute("manufacturer",manufacturer);
		return devBoardBaseService.page(dataPage.getPageNo(), dataPage.getPageSize(), name, manufacturer);
	}
	
	/**
	 * 审核
	 */
	@ResponseBody
	public CodeMsg verify(String[] ids) throws Exception {
		Validators.instance(ids)
			.minLength(1, "主键参数不能传空值")
			.notEmptyInside("主键参数不能传空值");
		int count = devBoardBaseService.verify(ids);
		return gt0(count);
	}
	
	
	/**
	 * 详情
	 */
	public DevBoardBase load(String id) throws Exception {
		Assert.notBlank(id, "主键参数不能为空");
		return devBoardBaseService.load(id);
	}
	
	/**
	 * 执行新增
	 */
	public void adding(DevBoardBase devBoardBase, HttpServletResponse response) throws Exception {
		devBoardBaseService.add(devBoardBase);
		callback(closeDialog(), response);
	}
	
	/**
	 * 跳转修改页面
	 */
	public DevBoardBase update(String id) throws Exception {
		return load(id);
	}
	
	/**
	 * 执行修改
	 */
	public void updating(DevBoardBase devBoardBase, HttpServletResponse response) throws Exception {
		int count = devBoardBaseService.update(devBoardBase);
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
		int count = devBoardBaseService.remove(ids);
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
		int count = devBoardBaseService.removePhy(ids);
		return gt0(count);
	}
	
}
