package com.dspsemi.declare.core.service.sys;

import java.util.List;

import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.declare.core.pojo.sys.UsualIssue;

/**
 * @author XiaoJin Wang
 *
 */
public interface UsualIssueService {

	/**
	 * 常见问题列表
	 * @return
	 */
	List<UsualIssue> list();
	
	/**
	 * 常见问题详情
	 * @param id
	 * @return
	 */
	UsualIssue load(String id);
	
	/**
	 * 新增常见问题
	 * @param usualIssue
	 * @return	应该实现返回数据能获取到主键
	 */
	UsualIssue add(UsualIssue usualIssue);
	
	/**
	 * 修改常见问题
	 * @param usualIssue
	 * @return
	 */
	int update(UsualIssue usualIssue);
	
	/**
	 * 逻辑删除常见问题
	 * @param ids
	 * @return
	 */
	int remove(String[] ids);
	
	/**
	 * 物理删除常见问题
	 * @param ids
	 * @return
	 */
	int removePhy(String[] ids);
	
	/**
	 * 常见问题分页
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	DataPage<UsualIssue> page(int pageNo, int pageSize, String titleQuery, Integer issueTypeId);
	
	/**
	 * 常见问题列表
	 * @return
	 */
	List<UsualIssue> listByTypeIds(Integer[] ids);
	
}
