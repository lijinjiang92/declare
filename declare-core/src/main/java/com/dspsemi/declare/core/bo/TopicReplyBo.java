package com.dspsemi.declare.core.bo;

import java.util.Date;

public class TopicReplyBo {
	/**
	 * 2楼以下的回复，我定义为评论comment来表示。
	 */
	
	
	/**
	 * 评论人的头像
	 */
	private String topic_comment_people_headimage;
	/**
	 * 评论人的名称
	 */
	private String topic_comment_people_name;
	/**
	 * 评论人的发帖数
	 */
	private String topic_comment_people_topicnum;
	
	/**
	 * 评论人的回复数
	 */
	private String topic_comment_people_replynum;
	
	/**
	 * 评论人评论的内容
	 */
	private String topic_comment_content;
	
	/**
	 * 评论人评论的日期
	 */
	private Date topic_comment_date;
		
	/**
	 * 该条评论的id
	 */
	private String topic_comment_id;
	
	/**
	 * 被评论的topic的id
	 */
	private String be_comment_topicid;
		
	/**
	 * 被评论的topic的内容
	 */
	private String be_comment_topiccontent;
	
	/**
	 * 被评论的topic的发布人
	 */
	private String be_comment_topicpeoplename;
	
	
	


}
