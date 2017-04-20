package com.dspsemi.declare.backend.controller.user;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dspsemi.common.enums.entity.status.CloseStatus;
import com.dspsemi.common.error.CodeMsg;
import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.common.security.SecurityUtils;
import com.dspsemi.common.web.BaseController;
import com.dspsemi.declare.core.pojo.user.User;
import com.dspsemi.declare.core.service.user.UserService;
import com.dspsemi.login.ws.UserWsService;
import com.dspsemi.login.ws.bo.UserWsBo;

/**
 * @author XiaoJin Wang
 *
 */
@Controller
public class UserController extends BaseController {
	
	@Resource
	private UserWsService userWsService;
	@Resource
	private UserService userService;

	public DataPage<UserWsBo> list(UserWsBo userWsBo, DataPage<UserWsBo> dataPage) throws Exception {
		return userService.page(userWsBo.getUserNo(), userWsBo.getUsername(), userWsBo.getNickname(), 
				userWsBo.getRealname(), userWsBo.getStatus(), dataPage.getPageNo(), dataPage.getPageSize());
	}
	
	/**
	 * 跳转到新增页面
	 */
	@ResponseBody
	public CodeMsg adding(String sign, UserWsBo userWsBo) throws Exception {
		userService.add(userWsBo);
		return CodeMsg.SUC;
	}
	
	/**
	 * 执行修改密码
	 */
	@ResponseBody
	public CodeMsg updatePwd(String oldPwd, String pwd, HttpServletResponse response) throws Exception {
		int num = userWsService.updatePwd(SecurityUtils.getUserId(), 
				DigestUtils.md5Hex(oldPwd), DigestUtils.md5Hex(pwd));
		return num > 0 ? CodeMsg.SUC : CodeMsg.FAIL;
	}
	
	@ResponseBody
	public Object load(String id) throws Exception {
		User u = userService.load(id);
		UserWsBo ub = userWsService.loadById(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("user", u);
		map.put("userWs", ub);
		return map;
	}

	@ResponseBody
	public CodeMsg updating(String companyId, UserWsBo userWsBo) throws Exception {
		int num = userService.update(userWsBo);
		return gt0(num);
	}
	
	@ResponseBody
	public CodeMsg remove(String[] ids) throws Exception {
		return gt0(userService.remove(ids));
	}
	
	@ResponseBody
	public CodeMsg openClose(String[] ids, CloseStatus status) throws Exception {
		return gt0(userWsService.updateStatus(ids, status));
	}
	
	@ResponseBody
	public boolean existUsername(String username, String excludeId) throws Exception {
		return userWsService.existUsername(username, excludeId);
	}
	
	@ResponseBody
	public boolean existNickname(String nickname, String excludeId) throws Exception {
		return userWsService.existNickname(nickname, excludeId);
	}
	
}
