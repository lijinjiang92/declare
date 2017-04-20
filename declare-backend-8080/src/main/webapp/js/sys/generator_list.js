$(function(){
	
	//启用、禁用 功能
	$(".handler").changeHandler({
		//操作成功后修改的目标对象
		targetClass: "isCycle",
		idsKey: "generatorType",
		url: "/generator/updateIsCycle.json",
		change: {
			open: {
				confirmMsg	: "启用循环？",
		 		failMsg		: "启用循环失败!",
		 		data: {isCycle: "YES"}
			},
			close: {
				confirmMsg	: "禁用循环？",
		 		failMsg		: "禁用循环失败!",
		 		data: {isCycle: "NO"}
			}
		}
	});
	
});