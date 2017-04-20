$(function(){
	
	window.fun = {
			initialVal: function(initVal){
				var curVal = $(".form-validate input[name=currentVal]").val();
				if(!curVal)
					return "请先填写当前值";
				if(initVal.length > curVal.length ||
						(initVal.length == curVal.length && initVal > curVal))
					return "初始值不能大于当前值";
				return true;
			},
			curVal: function(curVal) {
				var initVal = $(".form-validate input[name=initialVal]").val(),
					oldCurVal = $("#oldCurVal").val(),
					maxVal = $(".form-validate input[name=maxVal]").val();
				if(!initVal)
					return "请先填写初始值";
				if(curVal.length < initVal.length ||
						(curVal.length == initVal.length && curVal < initVal))
					return "当前值不能小于初始值";
				if(curVal.length < oldCurVal.length ||
						(curVal.length == oldCurVal.length && curVal < oldCurVal))
					return "当前值不能小于" + oldCurVal;
				if(maxVal && (curVal.length > maxVal.length ||
						(curVal.length == maxVal.length && curVal > maxVal)))
					return "当前值不能大于最大值";
				return true;
			},
			maxVal: function(maxVal) {
				var curVal = $(".form-validate input[name=currentVal]").val();
				if(!curVal)
					return "请先填写当前值";
				if(maxVal.length < curVal.length ||
						(maxVal.length == curVal.length && maxVal < curVal))
					return "最大值不能小于当前值";
				return true;
			}
	};
	
});