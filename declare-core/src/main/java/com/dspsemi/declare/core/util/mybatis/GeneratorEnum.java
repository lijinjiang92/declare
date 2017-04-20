package com.dspsemi.declare.core.util.mybatis;

import com.dspsemi.common.enums.DetailEnum;
import com.dspsemi.common.enums.entity.YesNo;
import com.dspsemi.common.generator.AbstractGenerator;
import com.dspsemi.common.generator.GeneratorType;
import com.dspsemi.common.generator.impl.AlphaNumericGenerator;
import com.dspsemi.common.generator.impl.IntegerGenerator;
import com.dspsemi.common.generator.impl.LongGenerator;
import com.dspsemi.common.generator.impl.UUIDGenerator;

/**
 * @author XiaoJin Wang
 * 
 */
public enum GeneratorEnum implements DetailEnum<String>, GeneratorType {
	
	UUID("UUID", "UUID", new UUIDGenerator()) {
		@SuppressWarnings("rawtypes")
		public AbstractGenerator getGenerator() {
			return new UUIDGenerator();
		}
	},
	
	/********************* 业务逻辑 **********************************/
	
	IMG_NAME("img_name", "图片名", new AlphaNumericGenerator()),
	NICKNAME("nickname", "昵称", new AlphaNumericGenerator()),
	KEY("key", "密钥", new AlphaNumericGenerator(49, 500, "a15db6f", "a15db6f", null, YesNo.NO)),
	
	
	
	/********************* 表ID字段 **********************************/
	
	BBS_SECTION_ID("bbs_section_id", "BBS版块表ID字段", new IntegerGenerator()),
	BBS_SECTION_CTG_ID("bbs_section_ctg_id", "BBS版块分类表ID字段", new IntegerGenerator()),
	BBS_TOPIC_ID("bbs_topic_id", "BBS主题表ID字段", new AlphaNumericGenerator()),
	BBS_TOPIC_CTG_ID("bbs_topic_ctg_id", "BBS主题分类表ID字段", new IntegerGenerator()),
	BBS_TOPIC_REPLY_ID("bbs_topic_reply_id", "BBS主题回复表ID字段", new AlphaNumericGenerator()),
	
	MSG_ID("msg_id", "消息表ID字段", new AlphaNumericGenerator()),
	NOTICE_ID("notice_id", "通知表ID字段", new AlphaNumericGenerator()),
	
	CONTACT_ID("CONTACT_id", "联系我们ID字段", new AlphaNumericGenerator()),
	COLLECT_ID("collect_id", "收藏表ID字段", new AlphaNumericGenerator()),
	CONCERN_ID("concern_id", "关注表ID字段", new AlphaNumericGenerator()),
	CASE_ID("case_id", "案例表ID字段", new AlphaNumericGenerator()),
	NEWS_ID("news_id", "新闻表ID字段", new AlphaNumericGenerator()),
	RESOURCE_ID("resource_id", "资源表ID字段", new AlphaNumericGenerator()),
	RESOURCE_TYPE_ID("resource_type_id", "资源类型表ID字段", new IntegerGenerator()),
	USUAL_ISSUE_ID("usual_issue_id", "常见问题表ID字段", new AlphaNumericGenerator()),
	USUAL_ISSUE_TYPE_ID("usual_issue_type_id", "常见问题类型表ID字段", new IntegerGenerator()),
	
	DELIVERY_ADDR_ID("delivery_addr_id", "配送表ID字段", new LongGenerator()),
	
	DEV_BOARD_APPLY_ID("dev_board_apply_id", "开发板申请表ID字段", new AlphaNumericGenerator()),
	DEV_BOARD_BASE_ID("dev_board_base_id", "开发板基础表ID字段", new AlphaNumericGenerator()),
	DEV_BOARD_PRO_ID("dev_board_pro_id", "开发板产品表ID字段", new AlphaNumericGenerator()),
	DEV_BOARD_REPORT_ID("dev_board_report_id", "开发板报告表ID字段", new AlphaNumericGenerator()),
	
	REGION_ID("region_id", "大区域表ID字段", new IntegerGenerator()),
	PROVINCE_ID("province_id", "省表ID字段", new IntegerGenerator()),
	CITY_ID("city_id", "市表ID字段", new IntegerGenerator()),
	DISTRICT_ID("district_id", "区表ID字段", new IntegerGenerator()),
	AREA_ID("area_id", "商圈表ID字段", new IntegerGenerator()),
	
	ACTIVITY_ID("activity_id", "活动表ID字段", new AlphaNumericGenerator()),
	ISSUE_ID("issue_id", "常见问题ID字段", new AlphaNumericGenerator()),
	
	
	
	
	//业务开始的地方
	
	REGISTER_ID("register_id", "注册ID字段", new AlphaNumericGenerator()),
	
	;
	
	private String value;
	private String displayName;
	@SuppressWarnings("rawtypes")
	private AbstractGenerator rawGenerator;
	@SuppressWarnings("rawtypes")
	private volatile AbstractGenerator generator;
   
	@SuppressWarnings("rawtypes")
	private GeneratorEnum(String value, String display, AbstractGenerator rawGenerator) {
        this.value = value;
        this.displayName = display;
        this.rawGenerator = rawGenerator;
    }

	@Override
	public String getDisplayName() {
		return displayName;
	}

	@Override
	public String getValue() {
		return value;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public AbstractGenerator getRawGenerator() {
		return rawGenerator;
	}

	@Override
	public String toString() {
		return "{displayName : '" + displayName + "', value : " + value + "}";
	}
	
	@Override
	public String getClassName() {
		return this.name();
	}

	@Override
	@SuppressWarnings("rawtypes")
	public AbstractGenerator getGenerator() {
		return generator;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public void setGenerator(AbstractGenerator generator) {
		this.generator = generator;
	}
	
}
