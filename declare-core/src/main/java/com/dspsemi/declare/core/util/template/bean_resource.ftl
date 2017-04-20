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

<#list data as bean>
	public static class ${bean.className} {
	
	<#if bean.entity>
		private static final Class<? extends Entity> entity = ${bean.clazz};
		public static final Property 
		<#list bean.properties as prop>
			<#if prop_has_next>
			${prop} = instance("${prop}", entity),
			<#else>
			${prop} = instance("${prop}", entity);
			</#if>
		</#list>
	<#else>
		public static final String 
		<#list bean.properties as prop>
			<#if prop_has_next>
			${prop} = "${prop}",
			<#else>
			${prop} = "${prop}";
			</#if>
		</#list>
	</#if>
	
	}
	
</#list>
	
}
