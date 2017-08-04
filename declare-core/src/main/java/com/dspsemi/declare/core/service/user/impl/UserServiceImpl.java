package com.dspsemi.declare.core.service.user.impl;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dspsemi.common.enums.entity.status.CloseStatus;
import com.dspsemi.common.lang.StringUtils;
import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.common.log.slf4j.Logger;
import com.dspsemi.common.log.slf4j.LoggerFactory;
import com.dspsemi.common.validate.Assert;
import com.dspsemi.declare.core.discuzApi.client.Client;
import com.dspsemi.declare.core.discuzApi.util.XMLHelper;
import com.dspsemi.declare.core.pojo.user.User;
import com.dspsemi.declare.core.service.AbstractService;
import com.dspsemi.declare.core.service.user.UserService;
import com.dspsemi.declare.core.util.CodeMsgExt;
import com.dspsemi.declare.core.util.Constants;
import com.dspsemi.declare.core.util.R;
import com.dspsemi.login.ws.UserWsService;
import com.dspsemi.login.ws.bo.UserWsBo;

/**
 * @author XiaoJin Wang
 * 
 */
@Service("userService")
public class UserServiceImpl extends AbstractService<User> implements
		UserService {

	@Resource
	private UserWsService userWsService;
	
	private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public List<User> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User load(String id) {
		return super.get(sql().eq(R.User.id, id));
	}

	@Override
	@Transactional
	public String add(UserWsBo userWsBo) {

		if (StringUtils.isBlank(userWsBo.getId()))
			userWsBo.setId(null);
		if (StringUtils.isBlank(userWsBo.getRealname()))
			userWsBo.setRealname(null);
		if (StringUtils.isBlank(userWsBo.getUserNo()))
			userWsBo.setUserNo(null);
		if (StringUtils.isBlank(userWsBo.getNickname()))
			userWsBo.setNickname(userWsBo.getUsername());
		userWsBo.setPassword(DigestUtils.md5Hex(userWsBo.getPassword()));

		String userId = userWsService.add(userWsBo, Constants.icNormalUser);
		User user = new User();
		user.setId(userId);
		user.setLevel(NumberUtils.INTEGER_ZERO);
		user.setPoint(NumberUtils.INTEGER_ZERO);
		try {
			Client uc = new Client();

			// 生成同步注册bbs的代码
			String $returns = uc.uc_user_register(userWsBo.getUsername(),
					"default", "default@default.com");
			int $uid = Integer.parseInt($returns);
			if ($uid <= 0) {
				if ($uid == -1) {
					LOG.error("用户名不合法");
				} else if ($uid == -2) {
					LOG.error("包含不允许注册的词语");
				} else if ($uid == -3) {
					LOG.error("用户名已经存在");
				} else if ($uid == -4) {
					LOG.error("Email 格式有误");
				} else if ($uid == -5) {
					LOG.error("Email 不允许注册");
				} else if ($uid == -6) {
					LOG.error("该 Email 已经被注册");
				} else {
					LOG.error("未定义错误");
				}
			} else {
				LOG.debug("OK:" + $returns);
				user.setBbs_userId($uid + "");
			}
		} catch (Exception e) {
			LOG.error("add bbs user error. " + e.fillInStackTrace());
		}
		try {
			super.save(user);
		} catch (RuntimeException e) {
			userWsService.remove(new String[] { user.getId() });
			throw e;
		}
		return userId;
	}

	@Override
	public int update(UserWsBo userWsBo) {

		return userWsService.update(userWsBo);
	}

	@Override
	public int remove(String[] ids) {
		Assert.notEmpty(ids, CodeMsgExt.PARAM_BLANK, "主键");
		super.delete(sql().in(R.User.id, ids));
		return userWsService.remove(ids);
	}

	@Override
	public int removePhy(String[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DataPage<UserWsBo> page(String userNo, String username,
			String nickname, String realname, CloseStatus status, int pageNo,
			int pageSize) {
		List<String> userIds = super
				.list(sql().column(R.User.id), String.class);

		if (userIds.size() == 0)
			return new DataPage<UserWsBo>();
		DataPage<UserWsBo> userWs = userWsService.page(null, userNo, username,
				nickname, realname, status, null, null,
				userIds.toArray(new String[] {}), pageNo, pageSize);
		return userWs;
	}

	@Override
	public int updateInfo(User user) {
		return super.update(sql()
				.update(R.User.companyName, user.getCompanyName())
				.update(R.User.fields, user.getFields())
				.update(R.User.job, user.getJob())
				.update(R.User.sign, user.getSign())
				.update(R.User.qq, user.getQq())
				.update(R.User.bbs_userId, user.getBbs_userId())
				.eq(R.User.id, user.getId()));
	}

	@Override
	public String add(User user) {
		super.save(user);
		return user.getId();
	}

	@Override
	public String bbs_login(String username, HttpServletResponse response) {
		try {
			Client e = new Client();
			String result = e.uc_user_login(username, "default");

			LinkedList<String> rs = XMLHelper.uc_unserialize(result);
			if (rs.size() > 0) {
				int $uid = Integer.parseInt(rs.get(0));
				if ($uid > 0) {

					String $ucsynlogin = e.uc_user_synlogin($uid);
					System.out.println("登录成功" + $ucsynlogin);
					return $ucsynlogin;

				} else {
					// 生成同步注册bbs的代码
					String $returns = e.uc_user_register(username,
							"default", "default@default.com");
					int $uid1 = Integer.parseInt($returns);
					if ($uid1 <= 0) {
						if ($uid1 == -1) {
							LOG.error("用户名不合法");
						} else if ($uid1 == -2) {
							LOG.error("包含不允许注册的词语");
						} else if ($uid1 == -3) {
							LOG.error("用户名已经存在");
						} else if ($uid1 == -4) {
							LOG.error("Email 格式有误");
						} else if ($uid1 == -5) {
							LOG.error("Email 不允许注册");
						} else if ($uid1 == -6) {
							LOG.error("该 Email 已经被注册");
						} else {
							LOG.error("未定义错误");
						}
					} else {
						result = e.uc_user_login(username, "default");

						rs = XMLHelper.uc_unserialize(result);
						if (rs.size() > 0) {
							$uid = Integer.parseInt(rs.get(0));
							if ($uid > 0) {

								String $ucsynlogin = e.uc_user_synlogin($uid);
								System.out.println("登录成功" + $ucsynlogin);
								return $ucsynlogin;
							}
						}
					}
				}
			} else {
				System.out.println("Login failed");
				System.out.println(result);
			}
		} catch (Exception e) {
			LOG.error("login bbs error. " + e.fillInStackTrace());
		}
		return null;
	}

	@Override
	public String bbs_loginout(HttpServletResponse response) {
		Client uc = new Client();
		//生成同步退出的代码
		String $ucsynlogout = uc.uc_user_synlogout();
		return $ucsynlogout;
	}

}
