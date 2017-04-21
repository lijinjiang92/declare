package com.dspsemi.declare.core.service.sys;

import java.util.List;

import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.declare.core.pojo.sys.News;

/**
 * @author XiaoJin Wang
 *
 */
public interface NewsService {
	
	/**
	 * 添加阅读次数
	 * @param news
	 * @return
	 */
	int browseNumUpdateByRawVal(String id);
	
	/**
	 * 新闻列表
	 * @return
	 */
	List<News> list();
	
	/**
	 * 新闻详情
	 * @param id
	 * @return
	 */
	News load(String id);
	
	/**
	 * 新增新闻
	 * @param news
	 * @return	应该实现返回数据能获取到主键
	 */
	News add(News news);
	
	/**
	 * 修改新闻
	 * @param news
	 * @return
	 */
	int update(News news);
	
	/**
	 * 逻辑删除新闻
	 * @param ids
	 * @return
	 */
	int remove(String[] ids);
	
	/**
	 * 物理删除新闻
	 * @param ids
	 * @return
	 */
	int removePhy(String[] ids);
	
	/**
	 * 新闻分页
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	DataPage<News> page(String title,int pageNo, int pageSize);
	
	/**
	 * 获取首页新闻
	 * @return
	 */
	List<News> news4Index();
}
