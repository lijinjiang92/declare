package com.dspsemi.declare.backend.controller.topicReply;

import static com.dspsemi.common.web.callback.Callbacks.callback;
import static com.dspsemi.common.web.callback.Callbacks.closeDialog;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dspsemi.common.error.CodeMsg;
import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.common.web.BaseController;
import com.dspsemi.declare.core.pojo.bbs.BbsTopic;
import com.dspsemi.declare.core.pojo.bbs.BbsTopicReply;
import com.dspsemi.declare.core.service.bbs.BbsTopicReplyService;
import com.dspsemi.declare.core.service.bbs.BbsTopicService;

/**
 * @author XiaoJin Wang
 * 
 */
@Controller
public class TopicReplyController extends BaseController {

	@Resource
	private BbsTopicReplyService bbsTopicReplyService;

	@Resource
	private BbsTopicService bbsTopicService;

	public DataPage<BbsTopicReply> list(BbsTopicReply bbsTopicReply,
			DataPage<BbsTopicReply> dataPage) throws Exception {
		return bbsTopicReplyService.page(bbsTopicReply, dataPage.getPageNo(),
				dataPage.getPageSize());
	}

	/**
	 * 跳转到新增页面
	 */
	@ResponseBody
	public CodeMsg add(BbsTopicReply bbsTopicReply) throws Exception {

		return CodeMsg.SUC;
	}

	/**
	 * 发布回复
	 * 
	 * @param bbsTopicReply
	 * @return
	 * @throws Exception
	 */
	public CodeMsg addIng(BbsTopicReply bbsTopicReply) throws Exception {
		bbsTopicReplyService.add(bbsTopicReply);
		return CodeMsg.SUC;
	}

	/**
	 * 修改回复
	 * 
	 * @param bbsTopicReply
	 * @return
	 * @throws Exception
	 */
	public void updating(BbsTopicReply bbsTopicReply,
			HttpServletResponse response) throws Exception {
		if (bbsTopicReplyService.update(bbsTopicReply) > 0)
			callback(closeDialog(), response);
		else
			callback(closeDialog(CodeMsg.FAIL), response);
	}

	/**
	 * 逻辑删除回复
	 * 
	 * @param ids
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	public CodeMsg deleting(String ids) throws Exception {
		return bbsTopicReplyService.remove(ids.split(",")) > 0 ? CodeMsg.SUC
				: CodeMsg.FAIL.msg("删除回复失败");
	}

	/**
	 * 回复详情
	 * 
	 * @param id
	 * @return
	 */
	public Model load(String id, Model model) {
		BbsTopicReply tr = bbsTopicReplyService.load(id);
		if (tr != null) {
			BbsTopic bt = bbsTopicService.load(tr.getTopicId());
			if (bt != null) {
				List<BbsTopicReply> bbsTopicReplys = bbsTopicReplyService
						.loadByTopic(tr.getTopicId());
				bt.setBbsTopicReplys(bbsTopicReplys);
				model.addAttribute("bbsTopic", bt);
				model.addAttribute("topicReplyId", id);
				return model;
			}
		}
		return null;
	}
}
