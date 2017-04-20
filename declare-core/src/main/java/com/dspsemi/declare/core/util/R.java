package com.dspsemi.declare.core.util;

import com.dspsemi.common.lang.dto.Entity;
import com.dspsemi.common.jdbc.Property;
import static com.dspsemi.common.jdbc.Property.instance;

/**
 * 	如果是Entity类，则需要加上private static final Class<? extends Entity> entity = com.dspsemi.core.pojo.xxx.xxx.class;
 * 且创建的Property属性需要增加。如：public static final Property id = instance("id", entity)。
 * 	如果只是普通的BO对象，则：public static final String id = "id";
 * @author XiaoJin Wang
 *
 */
public class R {

	public static class Activity {
	
		private static final Class<? extends Entity> entity = com.dspsemi.declare.core.pojo.activity.Activity.class;
		public static final Property 
			id = instance("id", entity),
			title = instance("title", entity),
			pic = instance("pic", entity),
			status = instance("status", entity),
			sort = instance("sort", entity),
			browseNum = instance("browseNum", entity),
			joinNum = instance("joinNum", entity),
			beginTime = instance("beginTime", entity),
			endTime = instance("endTime", entity),
			intro = instance("intro", entity),
			detail = instance("detail", entity),
			remark = instance("remark", entity),
			verifierId = instance("verifierId", entity),
			verifier = instance("verifier", entity),
			verifyTime = instance("verifyTime", entity),
			creatorId = instance("creatorId", entity),
			creator = instance("creator", entity),
			createTime = instance("createTime", entity),
			modifierId = instance("modifierId", entity),
			modifier = instance("modifier", entity),
			modifyTime = instance("modifyTime", entity);
	
	}
	
	public static class BbsModerator {
	
		private static final Class<? extends Entity> entity = com.dspsemi.declare.core.pojo.bbs.BbsModerator.class;
		public static final Property 
			userId = instance("userId", entity),
			sectionId = instance("sectionId", entity),
			bbsSection = instance("bbsSection", entity),
			creatorId = instance("creatorId", entity),
			creator = instance("creator", entity),
			createTime = instance("createTime", entity);
	
	}
	
	public static class BbsSection {
	
		private static final Class<? extends Entity> entity = com.dspsemi.declare.core.pojo.bbs.BbsSection.class;
		public static final Property 
			id = instance("id", entity),
			ctgId = instance("ctgId", entity),
			name = instance("name", entity),
			sort = instance("sort", entity),
			status = instance("status", entity),
			topicNum = instance("topicNum", entity),
			concernNum = instance("concernNum", entity),
			describes = instance("describes", entity),
			bbsSectionCtg = instance("bbsSectionCtg", entity),
			bbsTopics = instance("bbsTopics", entity),
			creatorId = instance("creatorId", entity),
			creator = instance("creator", entity),
			createTime = instance("createTime", entity),
			modifierId = instance("modifierId", entity),
			modifier = instance("modifier", entity),
			modifyTime = instance("modifyTime", entity);
	
	}
	
	public static class BbsSectionCtg {
	
		private static final Class<? extends Entity> entity = com.dspsemi.declare.core.pojo.bbs.BbsSectionCtg.class;
		public static final Property 
			id = instance("id", entity),
			name = instance("name", entity),
			sort = instance("sort", entity),
			status = instance("status", entity),
			bbsSections = instance("bbsSections", entity),
			creatorId = instance("creatorId", entity),
			creator = instance("creator", entity),
			createTime = instance("createTime", entity),
			modifierId = instance("modifierId", entity),
			modifier = instance("modifier", entity),
			modifyTime = instance("modifyTime", entity);
	
	}
	
	public static class BbsTopic {
	
		private static final Class<? extends Entity> entity = com.dspsemi.declare.core.pojo.bbs.BbsTopic.class;
		public static final Property 
			id = instance("id", entity),
			ctgId = instance("ctgId", entity),
			sectionId = instance("sectionId", entity),
			title = instance("title", entity),
			sort = instance("sort", entity),
			status = instance("status", entity),
			replyNum = instance("replyNum", entity),
			collectNum = instance("collectNum", entity),
			visitNum = instance("visitNum", entity),
			isReply = instance("isReply", entity),
			isStick = instance("isStick", entity),
			isElite = instance("isElite", entity),
			isHot = instance("isHot", entity),
			content = instance("content", entity),
			bbsTopicCtg = instance("bbsTopicCtg", entity),
			bbsSection = instance("bbsSection", entity),
			bbsTopicReplys = instance("bbsTopicReplys", entity),
			creatorId = instance("creatorId", entity),
			creator = instance("creator", entity),
			createTime = instance("createTime", entity),
			modifierId = instance("modifierId", entity),
			modifier = instance("modifier", entity),
			modifyTime = instance("modifyTime", entity);
	
	}
	
	public static class BbsTopicCtg {
	
		private static final Class<? extends Entity> entity = com.dspsemi.declare.core.pojo.bbs.BbsTopicCtg.class;
		public static final Property 
			id = instance("id", entity),
			name = instance("name", entity),
			sort = instance("sort", entity),
			status = instance("status", entity),
			bbsTopics = instance("bbsTopics", entity),
			creatorId = instance("creatorId", entity),
			creator = instance("creator", entity),
			createTime = instance("createTime", entity),
			modifierId = instance("modifierId", entity),
			modifier = instance("modifier", entity),
			modifyTime = instance("modifyTime", entity);
	
	}
	
	public static class BbsTopicReply {
	
		private static final Class<? extends Entity> entity = com.dspsemi.declare.core.pojo.bbs.BbsTopicReply.class;
		public static final Property 
			id = instance("id", entity),
			topicId = instance("topicId", entity),
			status = instance("status", entity),
			content = instance("content", entity),
			byReplytId = instance("byReplytId", entity),
			byReplierId = instance("byReplierId", entity),
			byReplier = instance("byReplier", entity),
			bbsTopic = instance("bbsTopic", entity),
			creatorId = instance("creatorId", entity),
			creator = instance("creator", entity),
			createTime = instance("createTime", entity),
			modifierId = instance("modifierId", entity),
			modifier = instance("modifier", entity),
			modifyTime = instance("modifyTime", entity);
	
	}
	
	public static class Register {
	
		private static final Class<? extends Entity> entity = com.dspsemi.declare.core.pojo.declare.Register.class;
		public static final Property 
			id = instance("id", entity),
			registeName = instance("registeName", entity),
			registePassword = instance("registePassword", entity),
			creditCode = instance("creditCode", entity),
			telphone = instance("telphone", entity),
			mobile = instance("mobile", entity),
			email = instance("email", entity),
			qq = instance("qq", entity),
			resume = instance("resume", entity),
			hash = instance("hash", entity),
			registeredIp = instance("registeredIp", entity),
			lastLoginIp = instance("lastLoginIp", entity),
			lastLoginTime = instance("lastLoginTime", entity),
			userStatus = instance("userStatus", entity);
	
	}
	
	public static class DevBoardApply {
	
		private static final Class<? extends Entity> entity = com.dspsemi.declare.core.pojo.devboard.DevBoardApply.class;
		public static final Property 
			id = instance("id", entity),
			boardBaseId = instance("boardBaseId", entity),
			boardProId = instance("boardProId", entity),
			deliveryAddrId = instance("deliveryAddrId", entity),
			mobile = instance("mobile", entity),
			relation = instance("relation", entity),
			address = instance("address", entity),
			status = instance("status", entity),
			applyStatus = instance("applyStatus", entity),
			applyPrice = instance("applyPrice", entity),
			applyNum = instance("applyNum", entity),
			applyTotalPrice = instance("applyTotalPrice", entity),
			projectName = instance("projectName", entity),
			applyReason = instance("applyReason", entity),
			projectDesc = instance("projectDesc", entity),
			remark = instance("remark", entity),
			verifierId = instance("verifierId", entity),
			verifier = instance("verifier", entity),
			verifyTime = instance("verifyTime", entity),
			deliveryAddr = instance("deliveryAddr", entity),
			devBoardPro = instance("devBoardPro", entity),
			devBoardBase = instance("devBoardBase", entity),
			name = instance("name", entity),
			manufacturer = instance("manufacturer", entity),
			pic = instance("pic", entity),
			proType = instance("proType", entity),
			creatorId = instance("creatorId", entity),
			creator = instance("creator", entity),
			createTime = instance("createTime", entity),
			modifierId = instance("modifierId", entity),
			modifier = instance("modifier", entity),
			modifyTime = instance("modifyTime", entity);
	
	}
	
	public static class DevBoardBase {
	
		private static final Class<? extends Entity> entity = com.dspsemi.declare.core.pojo.devboard.DevBoardBase.class;
		public static final Property 
			id = instance("id", entity),
			categoryId = instance("categoryId", entity),
			subCategoryId = instance("subCategoryId", entity),
			brandId = instance("brandId", entity),
			name = instance("name", entity),
			manufacturer = instance("manufacturer", entity),
			pic = instance("pic", entity),
			status = instance("status", entity),
			sort = instance("sort", entity),
			intro = instance("intro", entity),
			price = instance("price", entity),
			remark = instance("remark", entity),
			verifierId = instance("verifierId", entity),
			verifier = instance("verifier", entity),
			verifyTime = instance("verifyTime", entity),
			devBoardReports = instance("devBoardReports", entity),
			devBoardPros = instance("devBoardPros", entity),
			devBoardApplys = instance("devBoardApplys", entity),
			creatorId = instance("creatorId", entity),
			creator = instance("creator", entity),
			createTime = instance("createTime", entity),
			modifierId = instance("modifierId", entity),
			modifier = instance("modifier", entity),
			modifyTime = instance("modifyTime", entity);
	
	}
	
	public static class DevBoardPro {
	
		private static final Class<? extends Entity> entity = com.dspsemi.declare.core.pojo.devboard.DevBoardPro.class;
		public static final Property 
			id = instance("id", entity),
			boardBaseId = instance("boardBaseId", entity),
			title = instance("title", entity),
			pic = instance("pic", entity),
			proType = instance("proType", entity),
			status = instance("status", entity),
			sort = instance("sort", entity),
			marketPrice = instance("marketPrice", entity),
			applyPrice = instance("applyPrice", entity),
			totalNum = instance("totalNum", entity),
			maxNumPer = instance("maxNumPer", entity),
			applyNum = instance("applyNum", entity),
			applyManTime = instance("applyManTime", entity),
			beginTime = instance("beginTime", entity),
			endTime = instance("endTime", entity),
			intro = instance("intro", entity),
			description = instance("description", entity),
			remark = instance("remark", entity),
			verifierId = instance("verifierId", entity),
			verifier = instance("verifier", entity),
			verifyTime = instance("verifyTime", entity),
			devBoardBase = instance("devBoardBase", entity),
			devBoardReports = instance("devBoardReports", entity),
			devBoardApplys = instance("devBoardApplys", entity),
			creatorId = instance("creatorId", entity),
			creator = instance("creator", entity),
			createTime = instance("createTime", entity),
			modifierId = instance("modifierId", entity),
			modifier = instance("modifier", entity),
			modifyTime = instance("modifyTime", entity);
	
	}
	
	public static class DevBoardReport {
	
		private static final Class<? extends Entity> entity = com.dspsemi.declare.core.pojo.devboard.DevBoardReport.class;
		public static final Property 
			id = instance("id", entity),
			boardBaseId = instance("boardBaseId", entity),
			boardProId = instance("boardProId", entity),
			status = instance("status", entity),
			sort = instance("sort", entity),
			title = instance("title", entity),
			browseNum = instance("browseNum", entity),
			content = instance("content", entity),
			attachment = instance("attachment", entity),
			remark = instance("remark", entity),
			verifierId = instance("verifierId", entity),
			verifier = instance("verifier", entity),
			verifyTime = instance("verifyTime", entity),
			devBoardPro = instance("devBoardPro", entity),
			devBoardBase = instance("devBoardBase", entity),
			devBoardProIntro = instance("devBoardProIntro", entity),
			pic = instance("pic", entity),
			creatorId = instance("creatorId", entity),
			creator = instance("creator", entity),
			createTime = instance("createTime", entity),
			modifierId = instance("modifierId", entity),
			modifier = instance("modifier", entity),
			modifyTime = instance("modifyTime", entity);
	
	}
	
	public static class Area {
	
		private static final Class<? extends Entity> entity = com.dspsemi.declare.core.pojo.location.Area.class;
		public static final Property 
			id = instance("id", entity),
			status = instance("status", entity),
			districtId = instance("districtId", entity),
			name = instance("name", entity),
			pinyin = instance("pinyin", entity),
			sort = instance("sort", entity),
			district = instance("district", entity),
			creatorId = instance("creatorId", entity),
			creator = instance("creator", entity),
			createTime = instance("createTime", entity),
			modifierId = instance("modifierId", entity),
			modifier = instance("modifier", entity),
			modifyTime = instance("modifyTime", entity);
	
	}
	
	public static class City {
	
		private static final Class<? extends Entity> entity = com.dspsemi.declare.core.pojo.location.City.class;
		public static final Property 
			id = instance("id", entity),
			status = instance("status", entity),
			provinceId = instance("provinceId", entity),
			name = instance("name", entity),
			pinyin = instance("pinyin", entity),
			sort = instance("sort", entity),
			areaCode = instance("areaCode", entity),
			isHot = instance("isHot", entity),
			province = instance("province", entity),
			districts = instance("districts", entity),
			creatorId = instance("creatorId", entity),
			creator = instance("creator", entity),
			createTime = instance("createTime", entity),
			modifierId = instance("modifierId", entity),
			modifier = instance("modifier", entity),
			modifyTime = instance("modifyTime", entity);
	
	}
	
	public static class District {
	
		private static final Class<? extends Entity> entity = com.dspsemi.declare.core.pojo.location.District.class;
		public static final Property 
			id = instance("id", entity),
			status = instance("status", entity),
			cityId = instance("cityId", entity),
			name = instance("name", entity),
			pinyin = instance("pinyin", entity),
			sort = instance("sort", entity),
			city = instance("city", entity),
			areas = instance("areas", entity),
			creatorId = instance("creatorId", entity),
			creator = instance("creator", entity),
			createTime = instance("createTime", entity),
			modifierId = instance("modifierId", entity),
			modifier = instance("modifier", entity),
			modifyTime = instance("modifyTime", entity);
	
	}
	
	public static class Province {
	
		private static final Class<? extends Entity> entity = com.dspsemi.declare.core.pojo.location.Province.class;
		public static final Property 
			id = instance("id", entity),
			status = instance("status", entity),
			regionId = instance("regionId", entity),
			name = instance("name", entity),
			pinyin = instance("pinyin", entity),
			sort = instance("sort", entity),
			parentid = instance("parentid", entity),
			region = instance("region", entity),
			citys = instance("citys", entity),
			creatorId = instance("creatorId", entity),
			creator = instance("creator", entity),
			createTime = instance("createTime", entity),
			modifierId = instance("modifierId", entity),
			modifier = instance("modifier", entity),
			modifyTime = instance("modifyTime", entity);
	
	}
	
	public static class Region {
	
		private static final Class<? extends Entity> entity = com.dspsemi.declare.core.pojo.location.Region.class;
		public static final Property 
			id = instance("id", entity),
			status = instance("status", entity),
			name = instance("name", entity),
			pinyin = instance("pinyin", entity),
			sort = instance("sort", entity),
			provinces = instance("provinces", entity),
			creatorId = instance("creatorId", entity),
			creator = instance("creator", entity),
			createTime = instance("createTime", entity),
			modifierId = instance("modifierId", entity),
			modifier = instance("modifier", entity),
			modifyTime = instance("modifyTime", entity);
	
	}
	
	public static class Case {
	
		private static final Class<? extends Entity> entity = com.dspsemi.declare.core.pojo.sys.Case.class;
		public static final Property 
			id = instance("id", entity),
			title = instance("title", entity),
			status = instance("status", entity),
			pic = instance("pic", entity),
			sort = instance("sort", entity),
			publishTime = instance("publishTime", entity),
			browseNum = instance("browseNum", entity),
			summary = instance("summary", entity),
			content = instance("content", entity),
			creatorId = instance("creatorId", entity),
			creator = instance("creator", entity),
			createTime = instance("createTime", entity),
			modifierId = instance("modifierId", entity),
			modifier = instance("modifier", entity),
			modifyTime = instance("modifyTime", entity);
	
	}
	
	public static class Generator {
	
		private static final Class<? extends Entity> entity = com.dspsemi.declare.core.pojo.sys.Generator.class;
		public static final Property 
			generatorType = instance("generatorType", entity),
			initialVal = instance("initialVal", entity),
			currentVal = instance("currentVal", entity),
			maxVal = instance("maxVal", entity),
			fetchSize = instance("fetchSize", entity),
			increment = instance("increment", entity),
			isCycle = instance("isCycle", entity),
			creatorId = instance("creatorId", entity),
			creator = instance("creator", entity),
			createTime = instance("createTime", entity),
			modifierId = instance("modifierId", entity),
			modifier = instance("modifier", entity),
			modifyTime = instance("modifyTime", entity);
	
	}
	
	public static class Msg {
	
		private static final Class<? extends Entity> entity = com.dspsemi.declare.core.pojo.sys.Msg.class;
		public static final Property 
			id = instance("id", entity),
			msgType = instance("msgType", entity),
			title = instance("title", entity),
			status = instance("status", entity),
			content = instance("content", entity),
			isRead = instance("isRead", entity),
			recipientId = instance("recipientId", entity),
			recipient = instance("recipient", entity),
			creatorId = instance("creatorId", entity),
			creator = instance("creator", entity),
			createTime = instance("createTime", entity),
			modifierId = instance("modifierId", entity),
			modifier = instance("modifier", entity),
			modifyTime = instance("modifyTime", entity);
	
	}
	
	public static class News {
	
		private static final Class<? extends Entity> entity = com.dspsemi.declare.core.pojo.sys.News.class;
		public static final Property 
			id = instance("id", entity),
			title = instance("title", entity),
			status = instance("status", entity),
			pic = instance("pic", entity),
			sort = instance("sort", entity),
			publishTime = instance("publishTime", entity),
			browseNum = instance("browseNum", entity),
			summary = instance("summary", entity),
			content = instance("content", entity),
			creatorId = instance("creatorId", entity),
			creator = instance("creator", entity),
			createTime = instance("createTime", entity),
			modifierId = instance("modifierId", entity),
			modifier = instance("modifier", entity),
			modifyTime = instance("modifyTime", entity);
	
	}
	
	public static class Notice {
	
		private static final Class<? extends Entity> entity = com.dspsemi.declare.core.pojo.sys.Notice.class;
		public static final Property 
			id = instance("id", entity),
			noticeType = instance("noticeType", entity),
			title = instance("title", entity),
			status = instance("status", entity),
			content = instance("content", entity),
			visitNum = instance("visitNum", entity),
			publicTime = instance("publicTime", entity),
			publicTimeStr = instance("publicTimeStr", entity),
			creatorId = instance("creatorId", entity),
			creator = instance("creator", entity),
			createTime = instance("createTime", entity),
			modifierId = instance("modifierId", entity),
			modifier = instance("modifier", entity),
			modifyTime = instance("modifyTime", entity);
	
	}
	
	public static class Resource {
	
		private static final Class<? extends Entity> entity = com.dspsemi.declare.core.pojo.sys.Resource.class;
		public static final Property 
			id = instance("id", entity),
			resourceTypeId = instance("resourceTypeId", entity),
			title = instance("title", entity),
			status = instance("status", entity),
			sort = instance("sort", entity),
			publishTime = instance("publishTime", entity),
			url = instance("url", entity),
			browseNum = instance("browseNum", entity),
			downloadNum = instance("downloadNum", entity),
			description = instance("description", entity),
			pic = instance("pic", entity),
			resourceType = instance("resourceType", entity),
			creatorId = instance("creatorId", entity),
			creator = instance("creator", entity),
			createTime = instance("createTime", entity),
			modifierId = instance("modifierId", entity),
			modifier = instance("modifier", entity),
			modifyTime = instance("modifyTime", entity);
	
	}
	
	public static class ResourceType {
	
		private static final Class<? extends Entity> entity = com.dspsemi.declare.core.pojo.sys.ResourceType.class;
		public static final Property 
			id = instance("id", entity),
			name = instance("name", entity),
			status = instance("status", entity),
			sort = instance("sort", entity),
			resources = instance("resources", entity),
			creatorId = instance("creatorId", entity),
			creator = instance("creator", entity),
			createTime = instance("createTime", entity),
			modifierId = instance("modifierId", entity),
			modifier = instance("modifier", entity),
			modifyTime = instance("modifyTime", entity);
	
	}
	
	public static class UsualIssue {
	
		private static final Class<? extends Entity> entity = com.dspsemi.declare.core.pojo.sys.UsualIssue.class;
		public static final Property 
			id = instance("id", entity),
			issueTypeId = instance("issueTypeId", entity),
			title = instance("title", entity),
			status = instance("status", entity),
			sort = instance("sort", entity),
			publishTime = instance("publishTime", entity),
			browseNum = instance("browseNum", entity),
			content = instance("content", entity),
			typeName = instance("typeName", entity),
			usualIssueType = instance("usualIssueType", entity),
			creatorId = instance("creatorId", entity),
			creator = instance("creator", entity),
			createTime = instance("createTime", entity),
			modifierId = instance("modifierId", entity),
			modifier = instance("modifier", entity),
			modifyTime = instance("modifyTime", entity);
	
	}
	
	public static class UsualIssueType {
	
		private static final Class<? extends Entity> entity = com.dspsemi.declare.core.pojo.sys.UsualIssueType.class;
		public static final Property 
			id = instance("id", entity),
			name = instance("name", entity),
			status = instance("status", entity),
			sort = instance("sort", entity),
			usualIssues = instance("usualIssues", entity),
			creatorId = instance("creatorId", entity),
			creator = instance("creator", entity),
			createTime = instance("createTime", entity),
			modifierId = instance("modifierId", entity),
			modifier = instance("modifier", entity),
			modifyTime = instance("modifyTime", entity);
	
	}
	
	public static class Collect {
	
		private static final Class<? extends Entity> entity = com.dspsemi.declare.core.pojo.user.Collect.class;
		public static final Property 
			id = instance("id", entity),
			objType = instance("objType", entity),
			objId = instance("objId", entity),
			objName = instance("objName", entity),
			user = instance("user", entity),
			creatorId = instance("creatorId", entity),
			creator = instance("creator", entity),
			createTime = instance("createTime", entity);
	
	}
	
	public static class Concern {
	
		private static final Class<? extends Entity> entity = com.dspsemi.declare.core.pojo.user.Concern.class;
		public static final Property 
			id = instance("id", entity),
			objType = instance("objType", entity),
			objId = instance("objId", entity),
			objName = instance("objName", entity),
			user = instance("user", entity),
			creatorId = instance("creatorId", entity),
			creator = instance("creator", entity),
			createTime = instance("createTime", entity);
	
	}
	
	public static class Contact {
	
		private static final Class<? extends Entity> entity = com.dspsemi.declare.core.pojo.user.Contact.class;
		public static final Property 
			id = instance("id", entity),
			name = instance("name", entity),
			phone = instance("phone", entity),
			email = instance("email", entity),
			company = instance("company", entity),
			messages = instance("messages", entity),
			status = instance("status", entity),
			creatorId = instance("creatorId", entity),
			creator = instance("creator", entity),
			createTime = instance("createTime", entity);
	
	}
	
	public static class DeliveryAddr {
	
		private static final Class<? extends Entity> entity = com.dspsemi.declare.core.pojo.user.DeliveryAddr.class;
		public static final Property 
			id = instance("id", entity),
			userId = instance("userId", entity),
			status = instance("status", entity),
			sort = instance("sort", entity),
			mobile = instance("mobile", entity),
			relation = instance("relation", entity),
			isDefault = instance("isDefault", entity),
			provinceId = instance("provinceId", entity),
			province = instance("province", entity),
			cityId = instance("cityId", entity),
			city = instance("city", entity),
			districtId = instance("districtId", entity),
			district = instance("district", entity),
			street = instance("street", entity),
			postCode = instance("postCode", entity),
			user = instance("user", entity),
			creatorId = instance("creatorId", entity),
			creator = instance("creator", entity),
			createTime = instance("createTime", entity),
			modifierId = instance("modifierId", entity),
			modifier = instance("modifier", entity),
			modifyTime = instance("modifyTime", entity);
	
	}
	
	public static class User {
	
		private static final Class<? extends Entity> entity = com.dspsemi.declare.core.pojo.user.User.class;
		public static final Property 
			id = instance("id", entity),
			level = instance("level", entity),
			point = instance("point", entity),
			sign = instance("sign", entity),
			qq = instance("qq", entity),
			companyName = instance("companyName", entity),
			job = instance("job", entity),
			fields = instance("fields", entity),
			bbs_userId = instance("bbs_userId", entity);
	
	}
	
	public static class BbsSectionListBo {
	
		private static final Class<? extends Entity> entity = com.dspsemi.declare.core.bo.BbsSectionListBo.class;
		public static final Property 
			name = instance("name", entity),
			sort = instance("sort", entity),
			bbsSectionCtgName = instance("bbsSectionCtgName", entity),
			topicNum = instance("topicNum", entity),
			concernNum = instance("concernNum", entity),
			status = instance("status", entity),
			id = instance("id", entity),
			creatorId = instance("creatorId", entity),
			creator = instance("creator", entity),
			createTime = instance("createTime", entity),
			modifierId = instance("modifierId", entity),
			modifier = instance("modifier", entity),
			modifyTime = instance("modifyTime", entity);
	
	}
	
	public static class CityBo {
	
		public static final String 
			name = "name",
			id = "id",
			isHot = "isHot",
			pinyin = "pinyin";
	
	}
	
	public static class DynamicBo {
	
		public static final String 
			id = "id",
			title = "title",
			time = "time",
			type = "type";
	
	}
	
	public static class NewsBo {
	
		public static final String 
			id = "id",
			content = "content",
			createDate = "createDate";
	
	}
	
	public static class SectionBo {
	
		public static final String 
			name = "name",
			id = "id",
			describes = "describes";
	
	}
	
	public static class SectionClassifyBo {
	
		public static final String 
			name = "name",
			id = "id",
			sectionBoList = "sectionBoList";
	
	}
	
	public static class SerarchTopResultList {
	
		public static final String 
			createTime = "createTime",
			creator = "creator",
			title = "title",
			userName = "userName",
			replyNum = "replyNum",
			visitNum = "visitNum";
	
	}
	
	public static class TopicReplyBo {
	
		public static final String 
			topic_comment_people_headimage = "topic_comment_people_headimage",
			topic_comment_people_name = "topic_comment_people_name",
			topic_comment_people_topicnum = "topic_comment_people_topicnum",
			topic_comment_people_replynum = "topic_comment_people_replynum",
			topic_comment_content = "topic_comment_content",
			topic_comment_date = "topic_comment_date",
			topic_comment_id = "topic_comment_id",
			be_comment_topicid = "be_comment_topicid",
			be_comment_topiccontent = "be_comment_topiccontent",
			be_comment_topicpeoplename = "be_comment_topicpeoplename";
	
	}
	
	
}
