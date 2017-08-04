package com.dspsemi.declare.backend.controller.activity;

import static com.dspsemi.common.web.callback.Callbacks.callback;
import static com.dspsemi.common.web.callback.Callbacks.closeDialog;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dspsemi.common.enums.entity.status.VerifyStatus;
import com.dspsemi.common.error.CodeMsg;
import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.common.validate.Assert;
import com.dspsemi.common.validate.Validators;
import com.dspsemi.common.web.BaseController;
import com.dspsemi.declare.core.pojo.activity.Activity;
import com.dspsemi.declare.core.service.activity.ActivityService;

/**
 * @author XiaoJin Wang
 *
 */
@Controller
public class ActivityController extends BaseController {
	
	@Resource
	private ActivityService activityService;
	
	/**
	 * 列表
	 */
	public DataPage<Activity> list(Activity activity, DataPage<Activity> dataPage) throws Exception {
		
		return activityService.page(dataPage.getPageNo(), dataPage.getPageSize(), activity.getTitle());
	}
	
	/**
	 * 详情
	 */
	public Activity load(String id) throws Exception {
		Assert.notBlank(id, "主键参数不能为空");
		return activityService.load(id);
	}
	
	/**
	 * 执行新增
	 */
	@ResponseBody
	public CodeMsg adding(Activity activity, HttpServletResponse response) throws Exception {
		activity.setStatus(VerifyStatus.VERIFIED);
		activity.setSort(0);
		activity.setBrowseNum(0L);
		activity.setJoinNum(0L);
		activityService.add(activity);
		if(activity.getId()!=null)
			return CodeMsg.SUC;
		else
			return CodeMsg.FAIL;
	}
	
	/**
	 * 进入新增页面
	 * @param model
	 * @return
	 */
	public Model add(Model model) {

		return model;
	}
	
	/**
	 * 跳转修改页面
	 */
	@ResponseBody
	public CodeMsg update(String id) throws Exception {
		return CodeMsg.NONE.data(load(id));
	}
	
	/**
	 * 执行修改
	 */
	public void updating(Activity activity, HttpServletResponse response) throws Exception {
		int count = activityService.update(activity);
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
		int count = activityService.remove(ids);
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
		int count = activityService.removePhy(ids);
		return gt0(count);
	}
	
}
