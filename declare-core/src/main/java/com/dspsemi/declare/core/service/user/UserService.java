package com.dspsemi.declare.core.service.user;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.dspsemi.common.enums.entity.status.CloseStatus;
import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.declare.core.pojo.user.User;
import com.dspsemi.login.ws.bo.UserWsBo;

/**
 * @author XiaoJin Wang
 *
 */
public interface UserService {

	/**
	 * 用户列表
	 * @return
	 */
	List<User> list();
	
	/**
	 * 用户详情
	 * @param id
	 * @return
	 */
	User load(String id);
	
	/**
	 * 新增auth和Ic用户
	 * @param user
	 * @return	应该实现返回数据能获取到主键
	 */
	String add(UserWsBo userWsBo);
	
	
	/**
	 * 新增IC平台用户
	 * @param user
	 * @return
	 */
	String add(User user);
	
	/**
	 * 修改用户
	 * @param user
	 * @return
	 */
	int update(UserWsBo userWsBo);
	
	/**
	 * 逻辑删除用户
	 * @param ids
	 * @return
	 */
	int remove(String[] ids);
	
	/**
	 * 物理删除用户
	 * @param ids
	 * @return
	 */
	int removePhy(String[] ids);
	
	/**
	 * 用户分页
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	DataPage<UserWsBo> page(String userNo, String username, String nickname, 
			String realname, CloseStatus status, int pageNo, int pageSize);
	
	/**
	 * 修改用户
	 * @param user
	 * @return
	 */
	int updateInfo(User user);
	
	/**
	 * 同步登陆bbs
	 * @param username
	 * @param response
	 * @return
	 */
	String bbs_login(String username, HttpServletResponse response);
	
	/**
	 * 登出bbs
	 * @param response
	 * @return
	 */
	String bbs_loginout(HttpServletResponse response);
}
