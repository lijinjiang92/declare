package com.dspsemi.declare.backend.controller.bbs;

import static com.dspsemi.common.web.callback.Callbacks.callback;
import static com.dspsemi.common.web.callback.Callbacks.closeDialog;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dspsemi.common.enums.entity.status.CloseStatus;
import com.dspsemi.common.error.CodeMsg;
import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.common.validate.Assert;
import com.dspsemi.common.validate.Validators;
import com.dspsemi.common.web.BaseController;
import com.dspsemi.declare.core.pojo.bbs.BbsSectionCtg;
import com.dspsemi.declare.core.service.bbs.BbsSectionCtgService;
import com.dspsemi.declare.core.util.CodeMsgExt;

/**
 * BBS版块管理
 * @author yanjy
 *
 */
@Controller
public class BbsSectionCtgController extends BaseController {

	@Resource
	private BbsSectionCtgService bbsSectionCtgService;
	
	public DataPage<BbsSectionCtg> list(DataPage<BbsSectionCtg> dataPage,@RequestParam(required = false, value = "titleQuery")  String titleQuery,Model model) throws Exception {
		model.addAttribute("titleQuery",titleQuery);
		return bbsSectionCtgService.page(dataPage.getPageNo(), dataPage.getPageSize(),titleQuery);
	}   
	
	/**
	 * 跳转到新增页面
	 */

	public void add(Model model) throws Exception {
	}
	
	/**
	 * 执行新增
	 */
	public void adding(BbsSectionCtg bbsSectionCtg, HttpServletResponse response) throws Exception {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		if (!notice.getPublicTimeStr().equals("")) {
//			String publicTimeStr = notice.getPublicTimeStr() + " 00:00:00";
//			notice.setPublicTime(sdf.parse(publicTimeStr));
//		}
		bbsSectionCtgService.add(bbsSectionCtg);
		callback(closeDialog(), response);
	}
	
	/**
	 * 跳转修改页面
	 */
	public void update(Integer id, Model model) throws Exception {
		add(model);
		model.addAttribute("bbsSectionCtg", load(id));
	}
	/**
	 * 详情
	 */
	public BbsSectionCtg load(Integer id) throws Exception {
		Assert.notNull(id, "主键参数不能为空");
		return bbsSectionCtgService.load(id);
	}
	/**
	 * 执行修改
	 */
	public void updating(BbsSectionCtg bbsSectionCtg, HttpServletResponse response) throws Exception {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		if (!notice.getPublicTimeStr().equals("")) {
//			String publicTimeStr = notice.getPublicTimeStr() + " 00:00:00";
//			notice.setPublicTime(sdf.parse(publicTimeStr));
//		}
		int count = bbsSectionCtgService.update(bbsSectionCtg);
		if(count > 0)
			callback(closeDialog(), response);
		else
			callback(closeDialog(CodeMsg.FAIL), response);
	}
	
	@ResponseBody
	public CodeMsg remove(Integer[] ids) throws Exception {
		return gt0(bbsSectionCtgService.remove(ids));
	}
	/**
	 * 检查名称是否存在
	 */
	@ResponseBody
	public CodeMsg existname(String name, String excludeId) throws Exception {
		Assert.notBlank(name, CodeMsgExt.PARAM_BLANK.fillArgs("名称"));
		boolean exist = bbsSectionCtgService.existname(name, excludeId);
		return noneErr().data(exist);
	}
	

	@ResponseBody
	public CodeMsg openClose(String[] ids, CloseStatus status) throws Exception {
		Validators.instance(ids)
			.minLength(1, "主键参数不能传空值")
			.notEmptyInside("主键参数不能传空值");
		int count = bbsSectionCtgService.openClose(ids, status);
		return gt0None(count);
	}
	
}
