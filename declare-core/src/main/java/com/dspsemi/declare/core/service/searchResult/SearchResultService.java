package com.dspsemi.declare.core.service.searchResult;

import java.util.List;

import com.dspsemi.common.lang.dto.DataPage;
import com.dspsemi.declare.core.bo.NewsBo;
import com.dspsemi.declare.core.bo.SerarchTopResultList;

public interface SearchResultService {
	DataPage<SerarchTopResultList> getSearchResultByContent(int pageNo, int pageSize,String keyword);


	
}
