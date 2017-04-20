$(function(){
	window.fun = {
		existname: function(val) {
			var exist = false;
			$.ajax({
				async: false,
				type: "POST",
				url: "/bbsSection/existname.json",
				data: {
					name: val,
					excludeId: $(".form-validate input[name=id]").val()
				},
				suc: function(data) {
					exist = data.data;
				}
			});
			if(exist)
				return "名称已被占用";
			else
				return true;
		}
	};
});
