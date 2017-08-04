package com.dspsemi.declare.core.dao.bbs;

import java.util.List;

import com.dspsemi.declare.core.bo.SectionClassifyBo;

/**
 * @author XiaoJin Wang
 *
 */
public interface BbsSectionCtgMapper {
	/**
	 * 获取版块分类及其分类下面的版块
	 * @author yanjy
	 * @return
	 */
	public List<SectionClassifyBo> selectSectionClassifyBo();
}
