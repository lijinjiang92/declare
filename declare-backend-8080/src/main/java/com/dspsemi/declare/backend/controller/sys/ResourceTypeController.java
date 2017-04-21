package com.dspsemi.declare.backend.controller.sys;

import static com.dspsemi.common.web.callback.Callbacks.callback;
import static com.dspsemi.common.web.callback.Callbacks.closeDialog;

import java.util.List;

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
import com.dspsemi.declare.core.pojo.sys.ResourceType;
import com.dspsemi.declare.core.service.sys.ResourceTypeService;

/**
 * @author XiaoJin Wang
 * 
 */
@Controller
public class ResourceTypeController extends BaseController {

	@Resource
	private ResourceTypeService resourceTypeService;

	/**
	 * 列表
	 */
	public DataPage<ResourceType> list(ResourceType resourceType,
			DataPage<ResourceType> dataPage) throws Exception {

		return resourceTypeService.page(dataPage.getPageNo(),
				dataPage.getPageSize(), resourceType.getName(),
				resourceType.getStatus());
	}

	/**
	 * 详情
	 */
	public ResourceType load(Integer id) throws Exception {
		Assert.notNull(id, "主键参数不能为空");
		return resourceTypeService.load(id);
	}

	/**
	 * 执行新增
	 */
	public void adding(ResourceType resourceType, HttpServletResponse response)
			throws Exception {
		resourceType.setStatus(CloseStatus.OPEN);
		resourceTypeService.add(resourceType);
		callback(closeDialog(), response);
	}

	/**
	 * 跳转修改页面
	 */
	public ResourceType update(Integer id) throws Exception {
		return load(id);
	}

	/**
	 * 执行修改
	 */
	public void updating(ResourceType resourceType, HttpServletResponse response)
			throws Exception {
		int count = resourceTypeService.update(resourceType);
		if (count > 0)
			callback(closeDialog(), response);
		else
			callback(closeDialog(CodeMsg.FAIL), response);
	}

	/**
	 * 逻辑删除
	 */
	@ResponseBody
	public CodeMsg remove(Integer[] ids) throws Exception {
		Validators.instance(ids).minLength(1, "主键参数不能传空值")
				.notEmptyInside("主键参数不能传空值");
		int count = resourceTypeService.remove(ids);
		return gt0(count);
	}

	/**
	 * 物理删除
	 */
	@ResponseBody
	public CodeMsg removePhy(Integer[] ids) throws Exception {
		Validators.instance(ids).minLength(1, "主键参数不能传空值")
				.notEmptyInside("主键参数不能传空值");
		int count = resourceTypeService.removePhy(ids);
		return gt0(count);
	}
	
	/**
	 * 获取list
	 * @return
	 */
	@ResponseBody
	public CodeMsg resourceType_list(){
		List<ResourceType> list = resourceTypeService.list();
		return CodeMsg.NONE.data(list);
	}

}
