package com.dspsemi.declare.core.service.user;

import java.util.List;

import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.declare.core.pojo.user.Collect;
import com.dspsemi.declare.core.pojo.user.Contact;

/**
 * @author XiaoJin Wang
 *
 */
public interface ContactService {

	/**
	 * 收藏列表
	 * @return
	 */
	List<Contact> list();
	
	/**
	 * 收藏详情
	 * @param id
	 * @return
	 */
	Contact load(String id);
	
	/**
	 * 新增收藏
	 * @param collect
	 * @return	应该实现返回数据能获取到主键
	 */
	Contact add(Contact contact);
	
	/**
	 * 修改收藏
	 * @param collect
	 * @return
	 */
	int update(Contact contact);
	
	/**
	 * 逻辑删除收藏
	 * @param ids
	 * @return
	 */
	int remove(String[] ids);
	
	/**
	 * 物理删除收藏
	 * @param ids
	 * @return
	 */
	int removePhy(String[] ids);
	
	/**
	 * 收藏分页
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	DataPage<Contact> page(int pageNo, int pageSize, String name);
	
}
