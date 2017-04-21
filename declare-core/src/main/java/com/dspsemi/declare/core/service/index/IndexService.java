package com.dspsemi.declare.core.service.index;

import java.util.List;

import com.dspsemi.declare.core.bo.NewsBo;
import com.dspsemi.declare.core.bo.SectionClassifyBo;

public interface IndexService {
	/**
	 * 获取企业版块类型,及企业版块类型所关系 的版块
	 * @return
	 */
	public List<SectionClassifyBo> getSectionClassify();
	
	/**
	 * 最热的帖子
	 * @return
	 */
	List<NewsBo> getIndexTopicByHot();
	/**
	 * 最新的帖子
	 * @return
	 */
	List<NewsBo> getIndexTopicNew();
	
	/**
	 * 获取主页公告
	 * @return
	 */
	List<NewsBo> getIndexNotice();
}
