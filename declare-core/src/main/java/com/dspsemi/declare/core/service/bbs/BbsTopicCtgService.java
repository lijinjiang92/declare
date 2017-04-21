package com.dspsemi.declare.core.service.bbs;

import java.util.List;

import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.declare.core.pojo.bbs.BbsTopicCtg;

/**
 * @author XiaoJin Wang
 *
 */
public interface BbsTopicCtgService {

	/**
	 * BBS主题分类列表
	 * @return
	 */
	List<BbsTopicCtg> list();
	
	/**
	 * BBS主题分类详情
	 * @param id
	 * @return
	 */
	BbsTopicCtg load(String id);
	
	/**
	 * 新增BBS主题分类
	 * @param bbsTopicCtg
	 * @return	应该实现返回数据能获取到主键
	 */
	BbsTopicCtg add(BbsTopicCtg bbsTopicCtg);
	
	/**
	 * 修改BBS主题分类
	 * @param bbsTopicCtg
	 * @return
	 */
	int update(BbsTopicCtg bbsTopicCtg);
	
	/**
	 * 逻辑删除BBS主题分类
	 * @param ids
	 * @return
	 */
	int remove(String[] ids);
	
	/**
	 * 物理删除BBS主题分类
	 * @param ids
	 * @return
	 */
	int removePhy(String[] ids);
	
	/**
	 * BBS主题分类分页
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	DataPage<BbsTopicCtg> page(int pageNo, int pageSize);
	
}
