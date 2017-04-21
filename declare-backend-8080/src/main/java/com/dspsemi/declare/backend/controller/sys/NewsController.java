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
import com.dspsemi.declare.core.pojo.sys.News;
import com.dspsemi.declare.core.service.sys.NewsService;

/**
 * @author XiaoJin Wang
 *
 */
@Controller
public class NewsController extends BaseController {
	
	@Resource
	private NewsService newsService;

	/**
	 * 列表
	 */
	public DataPage<News> list(News news, DataPage<News> dataPage) throws Exception {
		
		return newsService.page(news.getTitle(),dataPage.getPageNo(), dataPage.getPageSize());
	}
	
	/**
	 * 详情
	 */
	public News load(String id) throws Exception {
		Assert.notBlank(id, "主键参数不能为空");
		return newsService.load(id);
	}
	
	/**
	 * 执行新增
	 */
	public void adding(News news, HttpServletResponse response) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		news.setPublishTime(sdf.parse(sdf.format(new Date())));
		news.setStatus(CloseStatus.OPEN);
		news.setBrowseNum(0L);
		newsService.add(news);
		callback(closeDialog(), response);
	}
	
	/**
	 * 跳转修改页面
	 */
	public News update(String id) throws Exception {
		return load(id);
	}
	
	/**
	 * 执行修改
	 */
	public void updating(News news, HttpServletResponse response) throws Exception {
		int count = newsService.update(news);
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
		int count = newsService.remove(ids);
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
		int count = newsService.removePhy(ids);
		return gt0(count);
	}
	
}
