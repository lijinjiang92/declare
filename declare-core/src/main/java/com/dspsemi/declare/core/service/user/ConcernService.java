package com.dspsemi.declare.core.service.user;

import java.util.List;

import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.declare.core.pojo.user.Concern;

/**
 * @author XiaoJin Wang
 *
 */
public interface ConcernService {

	/**
	 * 关注列表
	 * @return
	 */
	List<Concern> list();
	
	/**
	 * 关注详情
	 * @param id
	 * @return
	 */
	Concern load(String id);
	
	/**
	 * 新增关注
	 * @param concern
	 * @return	应该实现返回数据能获取到主键
	 */
	Concern add(Concern concern);
	
	/**
	 * 修改关注
	 * @param concern
	 * @return
	 */
	int update(Concern concern);
	
	/**
	 * 逻辑删除关注
	 * @param ids
	 * @return
	 */
	int remove(String[] ids);
	
	/**
	 * 物理删除关注
	 * @param ids
	 * @return
	 */
	int removePhy(String[] ids);
	
	/**
	 * 关注分页
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	DataPage<Concern> page(int pageNo, int pageSize);
	
}
