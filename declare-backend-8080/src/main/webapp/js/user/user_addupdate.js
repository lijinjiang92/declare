$(function(){
	
	var $tree, setting = {
		view: {
			selectedMulti: false
		},
		data: {
			simpleData: {
				enable: true
			}
		},
		callback: {
			onClick: function onClick(e, treeId, treeNode) {
				e.stopPropagation();
				var zTree = $.fn.zTree.getZTreeObj(treeId),
					nodes = zTree.getSelectedNodes(),
					$groupName = $("#groupName"),
					$groupId = $("#groupId");
				if(nodes[0].id == "-1") {
					$groupId.val("");
					$groupName.val("");
				}else {
					$groupId.val(nodes[0].id);
					$groupName.val(nodes[0].name);
				}
				$("#menuContent").hide();
			}
		}
	};
	
	window.fun = {
		existUsername: function(val) {
			var exist = false;
			$.ajax({
				async: false,
				type: "POST",
				url: "/user/existUsername.json",
				data: {
					username: val,
					excludeId: $(".form-validate input[name=id]").val()
				},
				suc: function(data) {
					exist = data.data;
				}
			});
			if(exist)
				return "用户名已被占用";
			else
				return true;
		},
		existNickname: function(val) {
			var exist = false;
			$.ajax({
				async: false,
				type: "POST",
				url: "/user/existNickname.json",
				data: {
					nickname: val,
					excludeId: $(".form-validate input[name=id]").val()
				},
				suc: function(data) {
					exist = data.data;
				}
			});
			if(exist)
				return "昵称已被占用";
			else
				return true;
		},
		initTree: function() {
			$.ajax({
				type: "POST",
				dataType: "json", 
				url: "/group/listAll.json",
				suc: function(data) {
					$tree = $.fn.zTree.init($("#treeUl"), setting, data);
				}
			});
		}
			
	};
	
	fun.initTree();
	
	$("#groupName,#menuContent").click(function(){
		if($tree && $tree.getNodes().length > 0 && $("#menuContent").is(":hidden")) {
			$("#menuContent").show();
			$("body").one("click", function(){
				$("#menuContent").hide();
			});
		}
		return false;
	});
	
	
});
