package com.dspsemi.declare.backend.controller.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.dspsemi.common.jackson.Jacksons;
import com.fasterxml.jackson.core.JsonProcessingException;

public class Test {

	public static void main(String[] args) throws JsonProcessingException {
		ScmOrderTempletReqDto sotrd = new ScmOrderTempletReqDto();
		sotrd.setId(UUID.randomUUID());
		sotrd.setStoreId(UUID.randomUUID());
		sotrd.setStatus(0);
		sotrd.setTempCode("1234567");
		sotrd.setTempName("车市");
		sotrd.setTotalQty(1);
		sotrd.setTotalAmt(new BigDecimal(0.0));
		List<ScmOrderTempletDetail> list = new ArrayList<ScmOrderTempletDetail>();
		ScmOrderTempletDetail s1 = new ScmOrderTempletDetail();
		s1.setBillId(sotrd.getId());
		s1.setStoreId(UUID.randomUUID());
		s1.setSeriNo(1234);
		s1.setGoodsId(UUID.randomUUID());
		s1.setGoodsName("物品名称");
		s1.setGoodsQty(new BigDecimal(20));
		s1.setGoodsAmt(new BigDecimal(1));
		s1.setUnitPrice(new BigDecimal(20));
		list.add(s1);
		sotrd.setList(list);
		System.out.println(Jacksons.SIMPLE.toJson(sotrd));
	}

}
