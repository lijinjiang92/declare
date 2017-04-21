package com.dspsemi.declare.core.service.sys.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dspsemi.common.enums.entity.status.CloseStatus;
import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.declare.core.pojo.sys.Resource;
import com.dspsemi.declare.core.service.AbstractService;
import com.dspsemi.declare.core.service.sys.ResourceService;
import com.dspsemi.declare.core.util.R;

/**
 * @author XiaoJin Wang
 * 
 */
@Service("resourceService")
public class ResourceServiceImpl extends AbstractService<Resource> implements
		ResourceService {

	@Override
	public List<Resource> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resource load(String id) {
		return super.get(sql().join(R.Resource.resourceType, "t")
				.column(R.ResourceType.name, "resourceType.name")
				.columnAll(Resource.class).eq(R.Resource.id, id));
	}

	@Override
	@Transactional
	public Resource add(Resource resource) {
		super.save(resource);
		return resource;
	}

	@Override
	public int update(Resource resource) {
		return super
				.update(sql()
						.update(R.Resource.title, resource.getTitle())
						.update(R.Resource.sort, resource.getSort())
						.update(R.Resource.resourceTypeId,
								resource.getResourceTypeId())
						.update(R.Resource.url, resource.getUrl())
						.update(R.Resource.pic, resource.getPic())
						.update(R.Resource.description, resource.getDescription())
						.eq(R.Resource.id, resource.getId()));
	}

	@Override
	public int remove(String[] ids) {
		return super.updateStatus(ids, CloseStatus.DELETE);
	}

	@Override
	public int removePhy(String[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DataPage<Resource> page(int pageNo, int pageSize, String title,
			Integer resourceTypeId) {

		return super.page(sql().join(R.Resource.resourceType, "t")
				.column(R.ResourceType.name, "resourceType.name")
				.columnAll(Resource.class)
				.ne(R.Resource.status, CloseStatus.DELETE)
				.ne(R.ResourceType.status, CloseStatus.DELETE)
				.eq(R.ResourceType.id, resourceTypeId)
				.like(R.Resource.title, title).desc(R.Resource.createTime)
				.limit(pageNo, pageSize));
	}

	@Override
	public List<Resource> list(Integer resourceTypeId) {
		return super.list((sql().eq(R.Resource.resourceTypeId, resourceTypeId)));
	}

}
