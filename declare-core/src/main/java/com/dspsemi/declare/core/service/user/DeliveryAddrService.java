package com.dspsemi.declare.core.service.user;

import java.util.List;

import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.declare.core.pojo.user.DeliveryAddr;

/**
 * @author XiaoJin Wang
 *
 */
public interface DeliveryAddrService {

	/**
	 * 配送地址列表
	 * @return
	 */
	List<DeliveryAddr> list(String userId);
	
	/**
	 * 配送地址详情
	 * @param id
	 * @return
	 */
	DeliveryAddr load(Long id);
	
	/**
	 * 新增配送地址
	 * @param deliveryAddr
	 * @return	应该实现返回数据能获取到主键
	 */
	DeliveryAddr add(DeliveryAddr deliveryAddr);
	
	/**
	 * 修改配送地址
	 * @param deliveryAddr
	 * @return
	 */
	int update(DeliveryAddr deliveryAddr);
	/**
	 * 修改配送地址为默认地址
	 * @param deliveryAddr
	 * @return
	 */
	int defaultAddress(Long id,String userId);
	
	/**
	 * 逻辑删除配送地址(用户)
	 * @param ids
	 * @return
	 */
	int remove(Long id);
	
	/**
	 * 逻辑删除配送地址
	 * @param ids
	 * @return
	 */
	int remove(Long[] ids);
	
	/**
	 * 物理删除配送地址
	 * @param ids
	 * @return
	 */
	int removePhy(Long[] ids);
	
	/**
	 * 配送地址分页
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	DataPage<DeliveryAddr> page(int pageNo, int pageSize);
	
}
