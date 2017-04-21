package com.dspsemi.declare.core.service.sys;

import java.util.List;

import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.declare.core.pojo.sys.Notice;

/**
 * @author XiaoJin Wang
 *
 */
public interface NoticeService {

	/**
	 * 公告列表
	 * @return
	 */
	List<Notice> list();
	
	/**
	 * 公告详情
	 * @param id
	 * @return
	 */
	Notice load(String id);
	
	/**
	 * 新增公告
	 * @param notice
	 * @return	应该实现返回数据能获取到主键
	 */
	Notice add(Notice notice);
	
	/**
	 * 修改公告
	 * @param notice
	 * @return
	 */
	int update(Notice notice);
	
	/**
	 * 逻辑删除公告
	 * @param ids
	 * @return
	 */
	int remove(String[] ids);
	
	/**
	 * 物理删除公告
	 * @param ids
	 * @return
	 */
	int removePhy(String[] ids);
	
	/**
	 * 公告分页
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	DataPage<Notice> page(int pageNo, int pageSize,String titleQuery);
	
}
