package com.dspsemi.declare.core.service.index.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dspsemi.declare.core.bo.NewsBo;
import com.dspsemi.declare.core.bo.SectionClassifyBo;
import com.dspsemi.declare.core.dao.bbs.BbsSectionCtgMapper;
import com.dspsemi.declare.core.dao.bbs.BbsTopicMapper;
import com.dspsemi.declare.core.dao.sys.NoticeMapper;
import com.dspsemi.declare.core.service.index.IndexService;

@Service("indexService")
public class IndexServiceImpl implements IndexService {
	@Autowired
	BbsSectionCtgMapper bbsSectionCtgMapper;

	@Autowired
	BbsTopicMapper bbsTopicMapper;

	@Autowired
	NoticeMapper noticeMapper;

	@Override
	public List<SectionClassifyBo> getSectionClassify() {
		List<SectionClassifyBo> sectionClassifyBoList = bbsSectionCtgMapper
				.selectSectionClassifyBo();
		return sectionClassifyBoList;
	}

	@Override
	public List<NewsBo> getIndexTopicByHot() {
		return bbsTopicMapper.getIndexTopicByHot();
	}

	@Override
	public List<NewsBo> getIndexTopicNew() {
		return bbsTopicMapper.getIndexTopicNew();
	}

	@Override
	public List<NewsBo> getIndexNotice() {
		return noticeMapper.getIndexNotice();
	}

}
