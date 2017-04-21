package com.dspsemi.declare.core.service.user.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dspsemi.common.enums.entity.status.CloseStatus;
import com.dspsemi.common.enums.entity.status.DeleteStatus;
import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.declare.core.pojo.user.DeliveryAddr;
import com.dspsemi.declare.core.service.AbstractService;
import com.dspsemi.declare.core.service.user.DeliveryAddrService;
import com.dspsemi.declare.core.util.R;

/**
 * @author XiaoJin Wang
 *
 */
@Service("deliveryAddrService")
public class DeliveryAddrServiceImpl extends AbstractService<DeliveryAddr> implements DeliveryAddrService {

	@Override
	public List<DeliveryAddr> list(String userId) {
		// TODO Auto-generated method stub
		return this.list(sql().eq(R.DeliveryAddr.status, DeleteStatus.NEW)
				.eq(R.DeliveryAddr.userId, userId)
				.asc(R.DeliveryAddr.isDefault));
	}

	@Override
	public DeliveryAddr load(Long id) {
		return super.get(sql()
				.eq(R.DeliveryAddr.id, id)
				.eq(R.DeliveryAddr.status, DeleteStatus.NEW));
	}

	@Override
	@Transactional
	public DeliveryAddr add(DeliveryAddr deliveryAddr) {
		deliveryAddr.setStatus(DeleteStatus.NEW);
		if(deliveryAddr.getIsDefault()==0){
			this.update(sql().update(R.DeliveryAddr.isDefault, 1).eq(R.DeliveryAddr.status, DeleteStatus.NEW).eq(R.DeliveryAddr.userId, deliveryAddr.getUserId()));
		}
		
		super.save(deliveryAddr);
		return deliveryAddr;
	}
	
	@Override
	@Transactional
	public int update(DeliveryAddr deliveryAddr) {
		if(deliveryAddr.getIsDefault()==0){
			this.update(sql().update(R.DeliveryAddr.isDefault, 1).eq(R.DeliveryAddr.status, DeleteStatus.NEW).eq(R.DeliveryAddr.userId, deliveryAddr.getUserId()));
		}
		return this.update(sql()
				.update(R.DeliveryAddr.province, deliveryAddr.getProvince())
				.update(R.DeliveryAddr.provinceId, deliveryAddr.getProvinceId())
				.update(R.DeliveryAddr.city, deliveryAddr.getCity())
				.update(R.DeliveryAddr.cityId, deliveryAddr.getCityId())
				.update(R.DeliveryAddr.district, deliveryAddr.getDistrict())
				.update(R.DeliveryAddr.districtId, deliveryAddr.getDistrictId())
				.update(R.DeliveryAddr.street, deliveryAddr.getStreet())
				.update(R.DeliveryAddr.relation, deliveryAddr.getRelation())
				.update(R.DeliveryAddr.postCode, deliveryAddr.getPostCode())
				.update(R.DeliveryAddr.mobile, deliveryAddr.getMobile())
				.update(R.DeliveryAddr.isDefault, deliveryAddr.getIsDefault())
				.eq(R.DeliveryAddr.id, deliveryAddr.getId())
				);
	}

	@Override
	public int remove(Long id) {
		return this.update(sql().update(R.DeliveryAddr.status, DeleteStatus.USER_DELETE).eq(R.DeliveryAddr.id, id));
	}
	@Override
	public int remove(Long[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int removePhy(Long[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DataPage<DeliveryAddr> page(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public int defaultAddress(Long id,String userId) {
		this.update(sql().update(R.DeliveryAddr.isDefault, 1).eq(R.DeliveryAddr.status, DeleteStatus.NEW).eq(R.DeliveryAddr.userId, userId));
		return this.update(sql()
				.update(R.DeliveryAddr.isDefault, 0)
				.eq(R.DeliveryAddr.id, id));
	}
	
}
