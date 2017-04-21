package com.dspsemi.declare.backend.controller.sys;

import static com.dspsemi.common.web.callback.Callbacks.callback;
import static com.dspsemi.common.web.callback.Callbacks.closeDialog;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dspsemi.common.enums.entity.status.CloseStatus;
import com.dspsemi.common.error.CodeMsg;
import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.common.validate.Assert;
import com.dspsemi.common.validate.Validators;
import com.dspsemi.common.web.BaseController;
import com.dspsemi.common.web.callback.Callbacks;
import com.dspsemi.declare.core.pojo.sys.Case;
import com.dspsemi.declare.core.service.sys.CaseService;

/**
 * @author XiaoJin Wang
 *
 */
@Controller
public class CaseController extends BaseController {
	
	@Resource
	private CaseService caseService;

	/**
	 * 列表
	 */
	public DataPage<Case> list(Case obj, DataPage<Case> dataPage) throws Exception {
		
		return caseService.page(obj.getTitle(),dataPage.getPageNo(), dataPage.getPageSize());
	}
	
	/**
	 * 详情
	 */
	public Case load(String id) throws Exception {
		Assert.notBlank(id, "主键参数不能为空");
		return caseService.load(id);
	}
	
	/**
	 * 执行新增
	 */
	public void adding(Case obj, HttpServletResponse response) throws Exception {
		if(obj.getPic()==null||obj.getPic().equals("")){
			callback(Callbacks.none(CodeMsg.FAIL.msg("请上传图片")), response);
			return;
		}
		if(this.caseService.isExist(obj.getTitle())){
			callback(Callbacks.none(CodeMsg.FAIL.msg("标题重复")), response);
			return;
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		obj.setPublishTime(sdf.parse(sdf.format(new Date())));
		obj.setStatus(CloseStatus.OPEN);
		obj.setBrowseNum(0L);
		caseService.add(obj);
		callback(closeDialog(), response);
	}
	
	/**
	 * 跳转修改页面
	 */
	public Case update(String id) throws Exception {
		return load(id);
	}
	
	/**
	 * 执行修改
	 */
	public void updating(Case obj, HttpServletResponse response) throws Exception {
		int count = caseService.update(obj);
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
		int count = caseService.remove(ids);
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
		int count = caseService.removePhy(ids);
		return gt0(count);
	}
	
}
