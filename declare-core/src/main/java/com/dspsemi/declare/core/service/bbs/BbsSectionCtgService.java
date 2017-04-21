package com.dspsemi.declare.core.service.bbs;

import java.util.List;

import com.dspsemi.common.enums.entity.status.CloseStatus;
import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.declare.core.pojo.bbs.BbsSection;
import com.dspsemi.declare.core.pojo.bbs.BbsSectionCtg;

/**
 * @author XiaoJin Wang
 *
 */
public interface BbsSectionCtgService {

	/**
	 * BBS版块分类列表
	 * @return
	 */
	List<BbsSectionCtg> list(String name, CloseStatus status);
	
	/**
	 * BBS版块分类详情
	 * @param id
	 * @return
	 */
	BbsSectionCtg load(Integer id);
	
	/**
	 * 新增BBS版块分类
	 * @param bbsSectionCtg
	 * @return	应该实现返回数据能获取到主键
	 */
	BbsSectionCtg add(BbsSectionCtg bbsSectionCtg);
	
	/**
	 * 修改BBS版块分类
	 * @param bbsSectionCtg
	 * @return
	 */
	int update(BbsSectionCtg bbsSectionCtg);
	
	/**
	 * 逻辑删除BBS版块分类
	 * @param ids
	 * @return
	 */
	int remove(Integer[] ids);
	
	/**
	 * 物理删除BBS版块分类
	 * @param ids
	 * @return
	 */
	int removePhy(Integer[] ids);
	
	/**
	 * BBS版块分类分页
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	DataPage<BbsSectionCtg> page(int pageNo, int pageSize,String titleQuery);
	boolean existname(String name, String excludeId);
	/**
	 * 开启、关闭用户
	 * @param ids
	 * @param status
	 * @return
	 */
	int openClose(String[] ids, CloseStatus status);
}
