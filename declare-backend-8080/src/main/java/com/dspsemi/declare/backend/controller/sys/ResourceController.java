package com.dspsemi.declare.backend.controller.sys;

import static com.dspsemi.common.web.callback.Callbacks.callback;
import static com.dspsemi.common.web.callback.Callbacks.closeDialog;

import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dspsemi.common.enums.entity.status.CloseStatus;
import com.dspsemi.common.error.CodeMsg;
import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.common.validate.Assert;
import com.dspsemi.common.validate.Validators;
import com.dspsemi.common.web.BaseController;
import com.dspsemi.declare.core.pojo.sys.Resource;
import com.dspsemi.declare.core.service.sys.ResourceService;

/**
 * @author XiaoJin Wang
 * 
 */
@Controller
public class ResourceController extends BaseController {

	@javax.annotation.Resource
	private ResourceService resourceService;

	/**
	 * 列表
	 */
	public DataPage<Resource> list(Resource resource,
			DataPage<Resource> dataPage) throws Exception {
		if (resource.getResourceTypeId() != null && resource.getResourceTypeId() != 0)
			return resourceService.page(dataPage.getPageNo(),
					dataPage.getPageSize(), resource.getTitle(),
					resource.getResourceTypeId());
		else
			return resourceService.page(dataPage.getPageNo(),
					dataPage.getPageSize(), resource.getTitle(), null);
	}

	/**
	 * 详情
	 */
	public Resource load(String id) throws Exception {
		Assert.notBlank(id, "主键参数不能为空");
		return resourceService.load(id);
	}

	/**
	 * 执行新增
	 */
	public void adding(Resource resource, HttpServletResponse response)
			throws Exception {
		resource.setStatus(CloseStatus.OPEN);
		resource.setDownloadNum(0L);
		resource.setBrowseNum(0L);
		resource.setPublishTime(new Date());
		resourceService.add(resource);
		callback(closeDialog(), response);
	}

	/**
	 * 跳转修改页面
	 */
	public Resource update(String id) throws Exception {
		return load(id);
	}

	/**
	 * 执行修改
	 */
	public void updating(Resource resource, HttpServletResponse response)
			throws Exception {
		int count = resourceService.update(resource);
		if (count > 0)
			callback(closeDialog(), response);
		else
			callback(closeDialog(CodeMsg.FAIL), response);
	}

	/**
	 * 逻辑删除
	 */
	@ResponseBody
	public CodeMsg remove(String[] ids) throws Exception {
		Validators.instance(ids).minLength(1, "主键参数不能传空值")
				.notEmptyInside("主键参数不能传空值");
		int count = resourceService.remove(ids);
		return gt0(count);
	}

	/**
	 * 物理删除
	 */
	@ResponseBody
	public CodeMsg removePhy(String[] ids) throws Exception {
		Validators.instance(ids).minLength(1, "主键参数不能传空值")
				.notEmptyInside("主键参数不能传空值");
		int count = resourceService.removePhy(ids);
		return gt0(count);
	}

}
