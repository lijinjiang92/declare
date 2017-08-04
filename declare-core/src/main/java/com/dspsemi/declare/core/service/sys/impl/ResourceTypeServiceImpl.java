package com.dspsemi.declare.core.service.sys.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dspsemi.common.enums.entity.status.CloseStatus;
import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.declare.core.pojo.sys.ResourceType;
import com.dspsemi.declare.core.service.AbstractService;
import com.dspsemi.declare.core.service.sys.ResourceTypeService;
import com.dspsemi.declare.core.util.R;

/**
 * @author XiaoJin Wang
 * 
 */
@Service("resourceTypeService")
public class ResourceTypeServiceImpl extends AbstractService<ResourceType>
		implements ResourceTypeService {

	@Override
	public List<ResourceType> list() {
		return super.list(sql().eq(R.ResourceType.status, CloseStatus.OPEN));
	}

	@Override
	public ResourceType load(Integer id) {
		return super.get(sql().eq(R.ResourceType.id, id));
	}

	@Override
	@Transactional
	public ResourceType add(ResourceType resourceType) {
		super.save(resourceType);
		return resourceType;
	}

	@Override
	public int update(ResourceType resourceType) {
		return super.update(sql()
				.update(R.ResourceType.name, resourceType.getName())
				.update(R.ResourceType.sort, resourceType.getSort())
				.eq(R.ResourceType.id, resourceType.getId()));
	}

	@Override
	public int remove(Integer[] ids) {
		return super.updateStatus(ids, CloseStatus.DELETE);
	}

	@Override
	public int removePhy(Integer[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DataPage<ResourceType> page(int pageNo, int pageSize, String name,
			CloseStatus status) {
		return super.page(sql().ne(R.ResourceType.status, CloseStatus.DELETE)
				.like(R.ResourceType.name, name)
				.eq(R.ResourceType.status, status)
				.desc(R.ResourceType.createTime).limit(pageNo, pageSize));
	}

	@Override
	public ResourceType getByTypeName(String name) {
		return super.get(sql().like(R.ResourceType.name, name).ne(R.ResourceType.status, CloseStatus.DELETE));
	}

}
