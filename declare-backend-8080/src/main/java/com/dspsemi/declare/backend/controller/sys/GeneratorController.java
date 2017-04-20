package com.dspsemi.declare.backend.controller.sys;

import static com.dspsemi.common.web.callback.Callbacks.callback;
import static com.dspsemi.common.web.callback.Callbacks.closeDialog;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dspsemi.common.enums.entity.YesNo;
import com.dspsemi.common.error.CodeMsg;
import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.common.validate.Assert;
import com.dspsemi.common.validate.Validators;
import com.dspsemi.common.web.BaseController;
import com.dspsemi.declare.core.pojo.sys.Generator;
import com.dspsemi.declare.core.service.sys.GeneratorService;
import com.dspsemi.declare.core.util.mybatis.GeneratorEnum;

/**
 * @author XiaoJin Wang
 *
 */
@Controller
public class GeneratorController extends BaseController {
	
	@Resource
	private GeneratorService generatorService;

	/**
	 * 列表
	 */
	public DataPage<Generator> list(Generator generator, DataPage<Generator> dataPage) throws Exception {
		
		return generatorService.page(generator.getGeneratorType(),
				generator.getIsCycle(), dataPage.getPageNo(), dataPage.getPageSize());
	}
	
	/**
	 * 详情
	 */
	public Generator load(GeneratorEnum generatorType) throws Exception {
		Assert.notNull(generatorType, "主键参数不能为空");
		return generatorService.load(generatorType);
	}
	
	/**
	 * 跳转修改页面
	 */
	public Generator update(GeneratorEnum generatorType) throws Exception {
		return load(generatorType);
	}
	
	/**
	 * 执行修改
	 */
	public void updating(Generator generator, HttpServletResponse response) throws Exception {
		int count = generatorService.update(generator);
		if(count > 0)
			callback(closeDialog(), response);
		else
			callback(closeDialog(CodeMsg.FAIL), response);
	}
	
	@ResponseBody
	public CodeMsg updateIsCycle(GeneratorEnum generatorType, YesNo isCycle) throws Exception {
		Validators.instance(generatorType)
			.notNull("主键参数不能传空值");
		int count = generatorService.updateIsCycle(generatorType, isCycle);
		return gt0None(count);
	}
	
}
