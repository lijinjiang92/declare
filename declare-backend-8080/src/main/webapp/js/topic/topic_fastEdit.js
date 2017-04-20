$(function(){
	$("#editTable tr:even").css("background-color", "#eeeeee");
	$('.edit').click(function(){
		var closeClass = "close yes edit";
		var openClass = "open no edit";
		var $this = $(this);
		var $name = $this.attr("name");
		var $reverseVal = $this.attr("reverseVal");
		var $class = $reverseVal == "1" ? closeClass: openClass;
		var $val = $reverseVal=="1" ? "0": "1";
		var isOrNot = $reverseVal=="1" ? "是" : "否";
		$.ajax({
			type : "post",
			url : "/topic/fastEditing.do",
			data : {
				"YesNo":parseInt($reverseVal,10),
				"name":$name,
				"topicId":$('#topicId').val()
			},
			success : function(data) {
				$this.attr("class",$class).attr("reverseVal",$val);
				$('#' + $name + "Font").html(isOrNot);
			}
		});
	}); 
	
	var re = new RegExp("^[\\+-]?\\d+$");
	var flag = false;
	$('#clickTd').click(function(){
		if(flag) return;
		var $_this = $(this);
		var $val = $_this.html();
		$_this.html("<input type='text' value='"+$val+"' id='sortInput' style='width:50px;text-align:center;' title='按tab可快速提交' maxlength='4'/>");
		flag = true;
		$('#sortInput').blur(function(){
			var $$val = $(this).val();
			if(!$$val.match(re)) {
				alert("请输入数字");
				return;
			}
			if($$val == $('#sortFont').html()){
				$_this.html($$val);
				flag = false;
				return;
			}
			var $data = {'topicId':$('#topicId').val(),'sort':$$val};
			$.ajax({
				type : "post",
				url : "/topic/fastEditing.do",
				data : $data,
				success : function(data) {
					$_this.html($$val);
					flag = false;
					$('#sortFont').html($$val);
				}
			});
		});
	}).mouseover(function(){
		$(this).css("cursor","pointer");
	});
	
});