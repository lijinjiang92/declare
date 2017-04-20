package classes_test;

import static com.dspsemi.common.jdbc.Property.instance;

import com.dspsemi.common.biz.pojo.Entity;
import com.dspsemi.common.jdbc.Property;

public class R {

	public static class Generator {
	
		private static final Class<? extends Entity> entity = com.dspsemi.core.pojo.sys.Generator.class;
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
	
	public static class ShopBo {
	
		public static final String 
			id = "id",
			name = "name",
			status = "status",
			address = "address",
			person = "person";
	
	}
	
	
}
