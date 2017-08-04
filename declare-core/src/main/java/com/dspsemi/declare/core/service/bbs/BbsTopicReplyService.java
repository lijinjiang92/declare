package com.dspsemi.declare.core.service.bbs;

import java.util.List;

import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.declare.core.pojo.bbs.BbsTopicReply;

/**
 * @author XiaoJin Wang
 *
 */
public interface BbsTopicReplyService {

	/**
	 * BBS主题回复列表
	 * @return
	 */
	List<BbsTopicReply> list();
	
	/**
	 * BBS主题回复详情
	 * @param id
	 * @return
	 */
	BbsTopicReply load(String id);
	
	/**
	 * 新增BBS主题回复
	 * @param bbsTopicReply
	 * @return	应该实现返回数据能获取到主键
	 */
	BbsTopicReply add(BbsTopicReply bbsTopicReply);
	
	/**
	 * 修改BBS主题回复
	 * @param bbsTopicReply
	 * @return
	 */
	int update(BbsTopicReply bbsTopicReply);
	
	/**
	 * 逻辑删除BBS主题回复
	 * @param ids
	 * @return
	 */
	int remove(String[] ids);
	
	/**
	 * 物理删除BBS主题回复
	 * @param ids
	 * @return
	 */
	int removePhy(String[] ids);
	
	/**
	 * BBS主题回复分页
	 * @param bbsTopicReply
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	DataPage<BbsTopicReply> page(BbsTopicReply bbsTopicReply, int pageNo, int pageSize);
	
	/**
	 * 查找所有该主题的回复
	 * @param topicId
	 * @return
	 */
	List<BbsTopicReply> loadByTopic(String topicId);
	
}
