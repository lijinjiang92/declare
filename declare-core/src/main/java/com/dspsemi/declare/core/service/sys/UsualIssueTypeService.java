package com.dspsemi.declare.core.service.sys;

import java.util.List;

import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.declare.core.pojo.sys.UsualIssueType;

/**
 * @author XiaoJin Wang
 *
 */
public interface UsualIssueTypeService {

	/**
	 * 常见问题类型列表
	 * @return
	 */
	List<UsualIssueType> list();
	
	/**
	 * 常见问题类型详情
	 * @param id
	 * @return
	 */
	UsualIssueType load(Integer id);
	
	/**
	 * 新增常见问题类型
	 * @param usualIssueType
	 * @return	应该实现返回数据能获取到主键
	 */
	UsualIssueType add(UsualIssueType usualIssueType);
	
	/**
	 * 修改常见问题类型
	 * @param usualIssueType
	 * @return
	 */
	int update(UsualIssueType usualIssueType);
	
	/**
	 * 逻辑删除常见问题类型
	 * @param ids
	 * @return
	 */
	int remove(Integer[] ids);
	
	/**
	 * 物理删除常见问题类型
	 * @param ids
	 * @return
	 */
	int removePhy(Integer[] ids);
	
	/**
	 * 常见问题类型分页
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	DataPage<UsualIssueType> page(int pageNo, int pageSize, String titleQuery);
	
}
