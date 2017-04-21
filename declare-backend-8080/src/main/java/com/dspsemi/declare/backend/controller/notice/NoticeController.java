package com.dspsemi.declare.backend.controller.notice;

import static com.dspsemi.common.web.callback.Callbacks.callback;
import static com.dspsemi.common.web.callback.Callbacks.closeDialog;

import java.text.SimpleDateFormat;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dspsemi.common.error.CodeMsg;
import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.common.validate.Assert;
import com.dspsemi.common.web.BaseController;
import com.dspsemi.declare.core.pojo.sys.Notice;
import com.dspsemi.declare.core.service.sys.NoticeService;

/**
 * 公告管理
 * @author yanjy
 *
 */
@Controller
public class NoticeController extends BaseController {

	@Resource
	private NoticeService noticeService;
	
	public DataPage<Notice> list(DataPage<Notice> dataPage,@RequestParam(required = false, value = "titleQuery")  String titleQuery,Model model) throws Exception {
		model.addAttribute("titleQuery",titleQuery);
		return noticeService.page(dataPage.getPageNo(), dataPage.getPageSize(),titleQuery);
	}   
	
	/**
	 * 跳转到新增页面
	 */

	public void add(Model model) throws Exception {
	}
	
	/**
	 * 执行新增
	 */
	public void adding(Notice notice, HttpServletResponse response) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (!notice.getPublicTimeStr().equals("")) {
			String publicTimeStr = notice.getPublicTimeStr() + " 00:00:00";
			notice.setPublicTime(sdf.parse(publicTimeStr));
		}
		noticeService.add(notice);
		callback(closeDialog(), response);
	}
	
	/**
	 * 跳转修改页面
	 */
	public void update(String id, Model model) throws Exception {
		add(model);
		model.addAttribute("notice", load(id));
	}
	/**
	 * 详情
	 */
	public Notice load(String id) throws Exception {
		Assert.notNull(id, "主键参数不能为空");
		return noticeService.load(id);
	}
	/**
	 * 执行修改
	 */
	public void updating(Notice notice, HttpServletResponse response) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (!notice.getPublicTimeStr().equals("")) {
			String publicTimeStr = notice.getPublicTimeStr() + " 00:00:00";
			notice.setPublicTime(sdf.parse(publicTimeStr));
		}
		int count = noticeService.update(notice);
		if(count > 0)
			callback(closeDialog(), response);
		else
			callback(closeDialog(CodeMsg.FAIL), response);
	}
	
	@ResponseBody
	public CodeMsg remove(String[] ids) throws Exception {
		return gt0(noticeService.remove(ids));
	}
	
//	@ResponseBody
//	public CodeMsg openClose(String[] ids, CloseStatus status) throws Exception {
//		return gt0(noticeService.updateStatus(ids, status));
//	}
//	
//	@ResponseBody
//	public boolean existUsername(String username, String excludeId) throws Exception {
//		return noticeService.existUsername(username, excludeId);
//	}
//	
//	@ResponseBody
//	public boolean existNickname(String nickname, String excludeId) throws Exception {
//		return noticeService.existNickname(nickname, excludeId);
//	}
}
