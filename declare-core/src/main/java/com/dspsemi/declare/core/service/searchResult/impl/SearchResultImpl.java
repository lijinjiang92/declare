package com.dspsemi.declare.core.service.searchResult.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.declare.core.bo.SerarchTopResultList;
import com.dspsemi.declare.core.dao.bbs.BbsTopicMapper;
import com.dspsemi.declare.core.service.searchResult.SearchResultService;

@Service("searchResultService")
public class SearchResultImpl implements SearchResultService {

	@Resource
	private BbsTopicMapper bbsTopicMapper;
	
	@Override
	public DataPage<SerarchTopResultList> getSearchResultByContent(int pageNo, int pageSize,String keyword) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startRow", (pageNo-1)*pageSize);
		map.put("pageSize", pageSize);
		map.put("keyword", keyword);
		DataPage<SerarchTopResultList> datas = new DataPage<SerarchTopResultList>();
		datas.setData(bbsTopicMapper.pageSearchTopByKeyword(map));
		datas.setTotalCount(bbsTopicMapper.pageSearchTopByKeywordCount(map));
		datas.setPageNo(pageNo);
		datas.setPageSize(pageSize);
		return datas;
	}
}
