$(function(){
	
	//启用、禁用 功能
	$(".handler").changeHandler({
		//操作成功后修改的目标对象
		targetClass: "status",
		url: "/register/openClose.json"
	});
	
	window.cfgRoles = function(userId) {
		$.ajax({
			type: "POST",
			url: "/role/listByUserId.json",
			data: {
				userId: userId
			},
			suc: function(data) {
				data = data.data;
				var html = '<div id="cfgRolesDiv">',
					templete = '<div style="float:left;margin-left:10px;"><input type="checkbox" id="{0}" name="roleIds" value="{1}" {2} {3} /> <label for="{0}">{4}</label></div>',
					time = new Date().getTime().toString();
				for(var i = 0; i < data.length; i++) {
					html += templete.placeholder(time + i, data[i].id, 
								data[i].isOwn && data[i].isOwn.className == "YES" ? 'checked="checked"' : '',
								data[i].isGroupOwn && data[i].isGroupOwn.className == "YES" ? 'disabled="disabled"' : '',
								data[i].name);
				}
				html += '</div>';
				$.dialog({
					id: "cfgRoles",
					lock: true,
					title: "配置角色",
					content: html,
					width: 300,
					height: 150,
					ok: function () {
						$.ajax({
							url: "/role/cfgByUserId.json",
							data: "userId=" + userId + "&" + $.param($("#cfgRolesDiv input:checked"))
						});
					},    
					cancel: true
				});
			}
		});
	};
	
});