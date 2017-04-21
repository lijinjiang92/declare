package com.dspsemi.declare.backend.controller.topicCtg;

import static com.dspsemi.common.web.callback.Callbacks.callback;
import static com.dspsemi.common.web.callback.Callbacks.closeDialog;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dspsemi.common.enums.entity.status.CloseStatus;
import com.dspsemi.common.error.CodeMsg;
import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.common.web.BaseController;
import com.dspsemi.declare.core.pojo.bbs.BbsTopicCtg;
import com.dspsemi.declare.core.service.bbs.BbsTopicCtgService;

/**
 * 公告管理
 * 
 * @author caixiang
 * 
 */
@Controller
public class TopicCtgController extends BaseController {

	@Resource
	private BbsTopicCtgService bbsTopicCtgService;

	public DataPage<BbsTopicCtg> list(DataPage<BbsTopicCtg> dataPage)
			throws Exception {
		return bbsTopicCtgService.page(dataPage.getPageNo(),
				dataPage.getPageSize());
	}

	/**
	 * 跳转到新增页面
	 */

	public void add(Model model) throws Exception {
	}

	/**
	 * 执行新增
	 */
	public void adding(BbsTopicCtg bbsTopicCtg, HttpServletResponse response)
			throws Exception {
		bbsTopicCtg.setStatus(CloseStatus.OPEN);
		bbsTopicCtgService.add(bbsTopicCtg);
		callback(closeDialog(), response);
	}
	
	public BbsTopicCtg load(String id){
		return bbsTopicCtgService.load(id);
	}

	/**
	 * 跳转修改页面
	 */
	public Model update(String id, Model model) throws Exception {
		model.addAttribute("topicCtg", this.load(id));
		return model;
	}

	/**
	 * 执行修改
	 */
	public void updating(BbsTopicCtg bbsTopicCtg, HttpServletResponse response)
			throws Exception {
		int count = bbsTopicCtgService.update(bbsTopicCtg);
		if (count > 0)
			callback(closeDialog(), response);
		else
			callback(closeDialog(CodeMsg.FAIL), response);
	}

	@ResponseBody
	public CodeMsg remove(String[] ids) throws Exception {
		return gt0(bbsTopicCtgService.remove(ids));
	}
}
