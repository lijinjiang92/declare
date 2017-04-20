package com.dspsemi.declare.core.service.sys.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dspsemi.common.enums.entity.status.CloseStatus;
import com.dspsemi.common.jdbc.SqlGrammar;
import com.dspsemi.common.lang.StringUtils;
import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.declare.core.pojo.sys.News;
import com.dspsemi.declare.core.service.AbstractService;
import com.dspsemi.declare.core.service.sys.NewsService;
import com.dspsemi.declare.core.util.R;

/**
 * @author XiaoJin Wang
 * 
 */
@Service("newsService")
public class NewsServiceImpl extends AbstractService<News> implements
		NewsService {

	@Override
	public List<News> list() {
		// TODO Auto-generated method stub
		return this.list(SqlGrammar.instance(News.class).eq(R.News.status,
				CloseStatus.OPEN));
	}

	@Override
	public News load(String id) {
		// TODO Auto-generated method stub
		return this.get(SqlGrammar.instance(News.class).eq(R.News.id, id));
	}

	@Override
	@Transactional
	public News add(News news) {
		// TODO Auto-generated method stub
		this.save(news);
		return news;
	}

	@Override
	public int update(News news) {
		// TODO Auto-generated method stub

		return this.update(SqlGrammar.instance(News.class)
				.update(R.News.title, news.getTitle())
				.update(R.News.sort, news.getSort())
				.update(R.News.content, news.getContent())
				.update(R.News.pic, news.getPic())
				.update(R.News.summary, news.getSummary())
				.eq(R.News.id, news.getId()));
	}

	@Override
	public int remove(String[] ids) {
		// TODO Auto-generated method stub
		return this.update(SqlGrammar.instance(News.class)
				.update(R.News.status, CloseStatus.CLOSE).in(R.News.id, ids));
	}

	@Override
	public int removePhy(String[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DataPage<News> page(String title, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return this.page(
				SqlGrammar
						.instance(News.class)
						.column(R.News.id)
						.column(R.News.title)
						.column(R.News.status)
						.column(R.News.pic)
						.column(R.News.sort)
						.column(R.News.browseNum)
						.column(R.News.summary)
						.column(R.News.createTime)
						.eq(R.News.status, CloseStatus.OPEN)
						.like(R.News.title,
								StringUtils.isEmpty(title) ? null : title
										.trim()).limit(pageNo, pageSize),
				News.class);
	}

	@Override
	public List<News> news4Index() {
		return super.list(sql().eq(R.News.status, CloseStatus.OPEN)
				.limitByIndex(4));
	}

	@Override
	public int browseNumUpdateByRawVal(String id) {
		return this.update(sql().updateByRawVal(R.News.browseNum, "#{browseNum}+1").eq(R.News.id, id));
	}

}
