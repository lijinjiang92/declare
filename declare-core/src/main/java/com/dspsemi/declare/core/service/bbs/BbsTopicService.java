package com.dspsemi.declare.core.service.bbs;

import java.util.List;

import com.dspsemi.common.enums.entity.YesNo;
import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.declare.core.pojo.bbs.BbsTopic;

/**
 * @author XiaoJin Wang
 * 
 */
public interface BbsTopicService {

	/**
	 * BBS主题列表
	 * 
	 * @return
	 */
	List<BbsTopic> list();

	/**
	 * BBS主题详情
	 * 
	 * @param id
	 * @return
	 */
	BbsTopic load(String id);

	/**
	 * 新增BBS主题
	 * 
	 * @param bbsTopic
	 * @return 应该实现返回数据能获取到主键
	 */
	BbsTopic add(BbsTopic bbsTopic);

	/**
	 * 修改BBS主题
	 * 
	 * @param bbsTopic
	 * @return
	 */
	int update(BbsTopic bbsTopic);

	/**
	 * 逻辑删除BBS主题
	 * 
	 * @param ids
	 * @return
	 */
	int remove(String[] ids);

	/**
	 * 物理删除BBS主题
	 * 
	 * @param ids
	 * @return
	 */
	int removePhy(String[] ids);

	/**
	 * BBS主题分页
	 * 
	 * @param topic
	 * @param status
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	DataPage<BbsTopic> page(BbsTopic topic, String status, int pageNo, int pageSize);
	
	/**
	 * 板块内的list
	 * @param topic
	 * @param status
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	DataPage<BbsTopic> pageBySectionId(String sectionId, String status, int pageNo, int pageSize);
	
	

	
	
	int updateTopicStatus(String topicId, YesNo isReply, YesNo isElite,
			YesNo isHot, YesNo isStick, Integer sort);

}
