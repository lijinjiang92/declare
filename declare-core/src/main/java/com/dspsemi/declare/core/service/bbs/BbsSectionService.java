package com.dspsemi.declare.core.service.bbs;

import java.util.List;

import com.dspsemi.common.enums.entity.status.CloseStatus;
import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.declare.core.bo.BbsSectionListBo;
import com.dspsemi.declare.core.pojo.bbs.BbsSection;

/**
 * @author XiaoJin Wang
 *
 */
public interface BbsSectionService {

	/**
	 * BBS版块列表
	 * @return
	 */
	List<BbsSection> list(String name, CloseStatus status);
	
	/**
	 * BBS版块详情
	 * @param id
	 * @return
	 */
	BbsSection load(Integer id);
	
	/**
	 * 新增BBS版块
	 * @param bbsSection
	 * @return	应该实现返回数据能获取到主键
	 */
	BbsSection add(BbsSection bbsSection);
	
	/**
	 * 修改BBS版块
	 * @param bbsSection
	 * @return
	 */
	int update(BbsSection bbsSection);
	
	/**
	 * 逻辑删除BBS版块
	 * @param ids
	 * @return
	 */
	int remove(Integer[] ids);
	
	/**
	 * 物理删除BBS版块
	 * @param ids
	 * @return
	 */
	int removePhy(Integer[] ids);
	
	/**
	 * BBS版块分页
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	DataPage<BbsSectionListBo> page(int pageNo, int pageSize,String titleQuery);
	boolean existname(String name, String excludeId);
	/**
	 * 开启、关闭用户
	 * @param ids
	 * @param status
	 * @return
	 */
	int openClose(String[] ids, CloseStatus status);
	
}
