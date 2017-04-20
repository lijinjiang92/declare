package com.dspsemi.declare.core.service.devboard.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dspsemi.common.enums.entity.status.DeleteStatus;
import com.dspsemi.common.jdbc.JoinType;
import com.dspsemi.common.jdbc.SqlGrammar;
import com.dspsemi.common.lang.StringUtils;
import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.declare.core.enums.DevBoardApplyStatus;
import com.dspsemi.declare.core.pojo.devboard.DevBoardApply;
import com.dspsemi.declare.core.service.AbstractService;
import com.dspsemi.declare.core.service.devboard.DevBoardApplyService;
import com.dspsemi.declare.core.util.R;

/**
 * @author XiaoJin Wang
 *
 */
@Service("devBoardApplyService")
public class DevBoardApplyServiceImpl extends AbstractService<DevBoardApply> implements DevBoardApplyService {

	@Override
	public List<DevBoardApply> list(int count) {
		// TODO Auto-generated method stub
		return this.list(SqlGrammar.instance(DevBoardApply.class)
				    .join(R.DevBoardApply.devBoardBase, "devB", JoinType.INNER_JOIN)
				    .column(R.DevBoardApply.creatorId)
				    .column(R.DevBoardApply.createTime)
				    .column(R.DevBoardBase.name)
				    .limit(1,count));
	}
	
	public List<DevBoardApply> getListByBoardProId(String BoardProId){
		return this.list(sql().eq(R.DevBoardApply.boardProId, BoardProId)
				               .eq(R.DevBoardApply.applyStatus, DevBoardApplyStatus.VERIFYING));
	}

	@Override
	public DevBoardApply load(String id) {
		// TODO Auto-generated method stub
		return this.get(SqlGrammar.instance(DevBoardApply.class)
				    .join(R.DevBoardApply.devBoardBase, "devB", JoinType.INNER_JOIN)
				    .eq(R.DevBoardApply.id, id));
	}

	@Override
	@Transactional
	public int add(DevBoardApply devBoardApply) {
		// TODO Auto-generated method stub
		
		
		return this.save(devBoardApply);
		
	}
	
	@Override
	public int update(DevBoardApply devBoardApply) {
		// TODO Auto-generated method stub
		return this.update(SqlGrammar.instance(DevBoardApply.class)
				    .update(R.DevBoardApply.applyStatus, devBoardApply.getApplyStatus())
				    .update(R.DevBoardApply.remark, devBoardApply.getRemark())
				    .eq(R.DevBoardApply.id, devBoardApply.getId()));
	}

	@Override
	public int remove(String[] ids) {
		// TODO Auto-generated method stub
		return this.update(SqlGrammar.instance(DevBoardApply.class)
				    .update(R.DevBoardApply.status, DeleteStatus.SYS_DELETE)
				    .in(R.DevBoardApply.id, ids));
	}
	
	@Override
	public int removePhy(String[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DataPage<DevBoardApply> page(String name,DevBoardApplyStatus devStatus,int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return this.page(SqlGrammar.instance(DevBoardApply.class)
				    .join(R.DevBoardApply.devBoardBase, "devB", JoinType.INNER_JOIN)
				    .column(R.DevBoardApply.id)
				    .column(R.DevBoardApply.status)
				    .column(R.DevBoardApply.applyStatus)
				    .column(R.DevBoardApply.applyNum)
				    .column(R.DevBoardApply.applyPrice)
				    .column(R.DevBoardApply.applyTotalPrice)
				    .column(R.DevBoardApply.applyReason)
				    .column(R.DevBoardApply.creator)
				    .column(R.DevBoardBase.name)
				    .column(R.DevBoardBase.manufacturer)
				    .like(R.DevBoardBase.name, StringUtils.isEmpty(name)?null:name.trim())
				    .eq(R.DevBoardApply.applyStatus, devStatus)
				    .desc(R.DevBoardApply.createTime)
				    .limit(pageNo, pageSize),DevBoardApply.class);
	}
	public int updateStatusById(DevBoardApplyStatus verifying, String id){
		return this.update(SqlGrammar.instance(DevBoardApply.class)
				    .update(R.DevBoardApply.applyStatus, verifying)
				    .eq(R.DevBoardApply.id, id));
	}

	@Override
	public DataPage<DevBoardApply> forePage(String name, DevBoardApplyStatus devStatus, int pageNo, int pageSize, String createId) {
		
		//List<DevBoardApplyStatus> list = new ArrayList<DevBoardApplyStatus>();
		DevBoardApplyStatus devStatus2 =null;
		if(devStatus!=null){
			if(devStatus.getValue()==1){
				devStatus2 = DevBoardApplyStatus.UNPAY;
			}
			if(devStatus.getValue()==3){
				devStatus2 = DevBoardApplyStatus.DELIVER;
			}
		}
		return this.page(SqlGrammar.instance(DevBoardApply.class)
			    .join(R.DevBoardApply.devBoardBase, "devB", JoinType.INNER_JOIN)
			    .join(R.DevBoardApply.devBoardPro,"devP",JoinType.INNER_JOIN)
			    .column(R.DevBoardApply.id)
			    .column(R.DevBoardApply.boardProId)
			    .column(R.DevBoardApply.boardBaseId)
			    .column(R.DevBoardApply.status)
			    .column(R.DevBoardApply.applyStatus)
			    .column(R.DevBoardPro.proType,R.DevBoardApply.proType)
			    .column(R.DevBoardApply.applyNum)
			    .column(R.DevBoardApply.applyPrice)
			    .column(R.DevBoardApply.applyTotalPrice)
			    .column(R.DevBoardApply.applyReason)
			    .column(R.DevBoardApply.createTime)
			    .column(R.DevBoardApply.creator)
			    .column(R.DevBoardBase.name)
			    .column(R.DevBoardBase.manufacturer)
			    .column(R.DevBoardPro.pic)
			    .column(R.DevBoardApply.applyTotalPrice)
			    .like(R.DevBoardBase.name, StringUtils.isEmpty(name)?null:name.trim())
			    .eq(R.DevBoardApply.creatorId, createId)
			    .ne(R.DevBoardApply.status, DeleteStatus.USER_DELETE)
			    .ne(R.DevBoardApply.status, DeleteStatus.SYS_DELETE)
			    .or(sql().eq(R.DevBoardApply.applyStatus, devStatus).eq(R.DevBoardApply.applyStatus, devStatus2))
			    //.in(R.DevBoardApply.applyStatus, list.toArray())
			    .limit(pageNo, pageSize),DevBoardApply.class);
	}
	
	
}
