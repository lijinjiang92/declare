package com.dspsemi.declare.backend.controller.topic;

import static com.dspsemi.common.web.callback.Callbacks.callback;
import static com.dspsemi.common.web.callback.Callbacks.closeDialog;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dspsemi.common.enums.entity.YesNo;
import com.dspsemi.common.error.CodeMsg;
import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.common.web.BaseController;
import com.dspsemi.declare.core.pojo.bbs.BbsTopic;
import com.dspsemi.declare.core.service.bbs.BbsTopicService;

/**
 * @author XiaoJin Wang
 * 
 */
@Controller
public class TopicController extends BaseController {

	@Resource
	private BbsTopicService bbsTopicService;

	/**
	 * 管理后台列表页面
	 * @param dataPage
	 * @return
	 * @throws Exception
	 */
	public DataPage<BbsTopic> list4Backend(BbsTopic topic, DataPage<BbsTopic> dataPage) throws Exception {
		return bbsTopicService.page(topic, null,dataPage.getPageNo(),
				dataPage.getPageSize());
	}

	/**
	 * 跳转到新增页面
	 */
	@ResponseBody
	public CodeMsg add(BbsTopic bbsTopic) throws Exception {

		return CodeMsg.SUC;
	}

	/**
	 * 发布帖子
	 * 
	 * @param bbsTopic
	 * @return
	 * @throws Exception
	 */
	public CodeMsg addIng(BbsTopic bbsTopic) throws Exception {
		bbsTopicService.add(bbsTopic);
		return CodeMsg.SUC;
	}

	/**
	 * 修改帖子
	 * 
	 * @param bbsTopic
	 * @return
	 * @throws Exception
	 */
	public void updating(BbsTopic bbsTopic, HttpServletResponse response)
			throws Exception {
		if (bbsTopicService.update(bbsTopic) > 0)
			callback(closeDialog(), response);
		else
			callback(closeDialog(CodeMsg.FAIL), response);
	}

	/**
	 * 逻辑删除帖子
	 * 
	 * @param ids
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	public CodeMsg delete(String ids) throws Exception {
		return bbsTopicService.remove(ids.split(",")) > 0 ? CodeMsg.SUC
				: CodeMsg.FAIL.msg("删除帖子失败");
	}

	/**
	 * 帖子详情
	 * 
	 * @param id
	 * @return
	 */
	public BbsTopic load(String id) {
		return bbsTopicService.load(id);
	}

	/**
	 * 帖子操作
	 * 
	 * @param id
	 * @return
	 */
	public BbsTopic fastEdit(String id) {
		return bbsTopicService.load(id);
	}

	/**
	 * 修改帖子状态
	 * 
	 * @param topicId
	 * @param isOrNot
	 * @param name
	 * @param sort
	 */
	@ResponseBody
	public void fastEditing(
			@RequestParam(value = "topicId", required = true) String topicId,
			@RequestParam(value = "YesNo", required = false) YesNo isOrNot,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "sort", required = false) Integer sort) {

		this.bbsTopicService.updateTopicStatus(topicId,
				"isReply".equalsIgnoreCase(name) ? isOrNot : null,
				"isElite".equalsIgnoreCase(name) ? isOrNot : null,
				"isHot".equalsIgnoreCase(name) ? isOrNot : null,
				"isStick".equalsIgnoreCase(name) ? isOrNot : null, sort);
	}
}
