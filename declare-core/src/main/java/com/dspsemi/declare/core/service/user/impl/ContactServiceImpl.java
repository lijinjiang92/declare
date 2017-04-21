package com.dspsemi.declare.core.service.user.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dspsemi.common.enums.entity.status.CloseStatus;
import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.declare.core.pojo.user.Collect;
import com.dspsemi.declare.core.pojo.user.Contact;
import com.dspsemi.declare.core.service.AbstractService;
import com.dspsemi.declare.core.service.user.CollectService;
import com.dspsemi.declare.core.service.user.ContactService;
import com.dspsemi.declare.core.util.R;

/**
 * @author XiaoJin Wang
 *
 */
@Service("contactService")
public class ContactServiceImpl extends AbstractService<Contact> implements ContactService {

	@Override
	public List<Contact> list() {
		return null;
	}

	@Override
	public Contact load(String id) {
		return super.get(sql().eq(R.Contact.id, id));
	}

	@Override
	@Transactional
	public Contact add(Contact contact) {
		this.save(contact);
		return contact;
	}
	
	@Override
	public int update(Contact contact) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int remove(String[] ids) {
		return this.updateStatus(ids, CloseStatus.DELETE);
	}
	
	@Override
	public int removePhy(String[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DataPage<Contact> page(int pageNo, int pageSize,String name) {
		return this.page(sql().desc(R.Contact.createTime).ne(R.Contact.status, CloseStatus.DELETE).like(R.Contact.name,name).limit(pageNo, pageSize));
	}
	
}
