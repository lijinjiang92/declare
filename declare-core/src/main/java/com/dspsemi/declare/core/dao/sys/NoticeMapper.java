package com.dspsemi.declare.core.dao.sys;

import java.util.List;

import com.dspsemi.declare.core.bo.NewsBo;

/**
 * @author XiaoJin Wang
 * 
 */
public interface NoticeMapper {
	/**
	 * 获取最新公告
	 * @return
	 */
	public List<NewsBo> getIndexNotice();
}
