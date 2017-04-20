$(function(){
	//启用、禁用 功能
	$(".handler").changeHandler({
		//操作成功后修改的目标对象
		targetClass: "status",
		url: "/bbsSection/openClose.json"
	});
});
	