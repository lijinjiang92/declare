package com.dspsemi.declare.core.service.sys;

import java.util.List;

import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.declare.core.pojo.sys.Msg;

/**
 * @author XiaoJin Wang
 *
 */
public interface MsgService {

	/**
	 * 消息列表
	 * @return
	 */
	List<Msg> list();
	
	/**
	 * 消息详情
	 * @param id
	 * @return
	 */
	Msg load(String id);
	
	/**
	 * 新增消息
	 * @param msg
	 * @return	应该实现返回数据能获取到主键
	 */
	Msg add(Msg msg);
	
	/**
	 * 修改消息
	 * @param msg
	 * @return
	 */
	int update(Msg msg);
	
	/**
	 * 逻辑删除消息
	 * @param ids
	 * @return
	 */
	int remove(String[] ids);
	
	/**
	 * 物理删除消息
	 * @param ids
	 * @return
	 */
	int removePhy(String[] ids);
	
	/**
	 * 消息分页
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	DataPage<Msg> page(int pageNo, int pageSize);
	
}
