package com.dspsemi.declare.core.dao.bbs;

import java.util.List;
import java.util.Map;

import com.dspsemi.declare.core.bo.NewsBo;
import com.dspsemi.declare.core.bo.SerarchTopResultList;
import com.dspsemi.declare.core.pojo.bbs.BbsTopic;

/**
 * @author XiaoJin Wang
 *
 */
public interface BbsTopicMapper {

	/**
	 * 分页获取帖子
	 * @param map
	 * @return
	 */
	List<BbsTopic> pageTopic(Map<String, Object> map);
	
	/**
	 * 分页获取帖子
	 * @param map
	 * @return
	 */
	List<BbsTopic> pageTopicBySectionId(Map<String, Object> map);
	
	/**
	 * 获取帖子总条数
	 * @param map
	 * @return
	 */
	int pageTopicCount(Map<String, Object> map);
	
	
	/**
	 * 获取帖子总条数
	 * @param map
	 * @return
	 */
	int pageTopicCountBySectionId(Map<String, Object> map);
	
	

	/**
	 * 根据关键字，分页获取帖子
	 * @param map
	 * 	keyword  关键字
	 * @return
	 */
	List<SerarchTopResultList> pageSearchTopByKeyword(Map<String, Object> map);
	


	/**
	 * 根据关键字，分页获取帖子数目
	 * @param map
	 * 	keyword  关键字
	 * @return
	 */
	int pageSearchTopByKeywordCount(Map<String, Object> map);
	
	
	List<NewsBo> getIndexTopicNew();
	

	List<NewsBo> getIndexTopicByHot();



}
