/**
 * @author XiaoJin Wang
 */
$(function(){
	
	//渲染页面
	window.renderPage = function() {
		
		$("table.ui-table").UI_table();
		
		if(!utils.bindedEvent($(window), 'resize', "frame")) {
			//设置主题结构的宽、高
			var resizeContent = function(){
				
				var $main = $('#main'),
					$header = $("#header"),
					$conent = $("#conent"),
					$menus = $("#menus"),
					$coreDiv = $("#core-div"),
					$control = $(".control"),
					$search = $("ul.search"),
					$paramLi = $search.children(".param-li"),
					$dataDiv = $(".data-div"),
					$page = $(".page"),
					$footer = $("#footer");
				
				$main.height($(window).height() - $header.outerHeight(true));
				$conent.outerWidth(true, $(window).width() - $menus.outerWidth(true));
				
				if($coreDiv.length == 0) return;
				
				$coreDiv.outerWidth(true, $conent.width());
				$control.outerWidth(true, $coreDiv.width());
				
				//计算查询条件的显示/影藏
				var searchWidth = $control.width() - $(".search-btns").outerWidth(true) - $(".handle-btns").outerWidth(true),
					hideParam = false;
				$paramLi.each(function(){
					var hide = true;
					if(searchWidth > 0) {
						searchWidth -= $(this).outerWidth(true);
						hide = searchWidth < 0 ? true : false;
					}
					if(hide) {
						$(this).addClass("param-hidden").attr("param-hidden", "true");
						hideParam = true;
					}else
						$(this).removeClass("param-hidden").removeAttr("param-hidden");
				});
				$search.width("100%");
				if(hideParam) {
					var hiding = true;
					$paramLi.off(".frame").on("mouseenter.frame", function(){
						if(hiding) {
							$(".param-li[param-hidden]").removeClass("param-hidden");
							$(".control .handle-btns").hide();
							$control.addClass("border-bottom");
							hiding = false;
						}
					});
					$control.off(".frame").on({
						"mouseleave.frame": function() {
							if(!hiding) {
								$(".param-li[param-hidden]").addClass("param-hidden");
								$(".control .handle-btns").show();
								$control.removeClass("border-bottom");
								hiding = true;
							}
						}
					}).css("cursor", "pointer");
				}else {
					$control.off(".frame");
				}
				
				var coreDivExtra = $coreDiv.outerHeight(true) - $coreDiv.height(),
					shiftyHeight = ($page.position() || $footer.position()).top - $coreDiv.position().top - coreDivExtra,
					dataHeight = shiftyHeight - ($dataDiv.position() ? $dataDiv.position().top : 0);
				$coreDiv.height(shiftyHeight);
				$dataDiv.outerWidth(true, $coreDiv.width()).outerHeight(true, dataHeight);
				$.UI_table.resize($("table.ui-table"), $coreDiv.width(), dataHeight);
			};
			resizeContent();
			//设置主题结构的宽、高
			$(window).off(".frame").on("resize.frame", utils.debounce(resizeContent));
		}
		
	};
	
	/************  左侧菜单  *****************/
	(function() {
		$('.one').off(".init-page").on("click.init-page", function() {
			var $this = $(this),
				$two = $this.next().children(".two");
			if($two.hasClass('show')) {
				$this.find(".icon").css(
					'background-image',
					'url(/imgs/frame/menu_li_bg.png)');
				$two.removeClass('show').addClass('hidden');
			}else {
				$(".one .icon").css(
						'background-image',
						'url(/imgs/frame/menu_li_bg.png)');
				$this.find(".icon").css(
						'background-image',
						'url(/imgs/frame/menu_li_bg_down.png)');
				$('.two').removeClass('show').addClass('hidden');
				$two.removeClass('hidden').addClass('show');
			}
		});
		$(".menu-bar").hover(
			function() {
				$(this).find("a").addClass("menu-hover");
			},
			function() {
				$(this).find("a").removeClass("menu-hover");
			}
		).click(function(){
			$(".menu-bar").find("a").removeClass("selected");
			$(this).find("a").addClass("selected");
			var menuId = $(this).attr("menu-id"),
				memus = $.cookie(BaseData.menus) ? JSON.parse($.cookie(BaseData.menus)) : {};
			memus[BaseData.path] = menuId;
			$.cookie(BaseData.menus, JSON.stringify(memus), {path: '/'});
		});
		//初始化菜单的显示
		var memus = $.cookie(BaseData.menus) ? JSON.parse($.cookie(BaseData.menus)) : {};
			menuId = memus[BaseData.path],
			$menu_li = $(".menu-bar[menu-id=" + menuId + "]");
		if(menuId && $menu_li.length > 0) {
			$menu_li.closest("dd").prev("dt").click();
			$menu_li.find("a").addClass("selected");
		}
	})();
		
	window.initPage = function(){
		
		//input标签绑定placeholder属性，为了兼容IE
		$('input[placeholder]').placeholder();
		
		//绑定DIV弹出框表单提交后刷新当前表单页面(典型例子：弹出框中带有表单查询)
		$(".refresh-submit").off(".init-page").on("click.init-page", function(){
			var $this = $(this),
				$form = $this.closest("form"),
				isa = $this.is("a") && new RegExp(regex.url).test($this.attr("href"));
			if(isa || $form.length > 0){
				var url = isa ? $this.attr("href") : $form.attr("action"),
					params = isa ? null : $form.serialize();
				$.post(url, params, function(data){
					var dialogObj = window.top.$.dialog.list[$.dialog.manageDialogId],
						setting = (new Function( "return " + $this.attr("setting") ))() || {};
					setting.title = dialogObj ? dialogObj.config.title 
							: setting.title ? setting.title : $this.attr("title") ? 
							$this.attr("title") : $this.text() ? $this.text() : $this.val();
					setting.id = $.dialog.manageDialogId;
					setting.lock = setting.lock === false ? false : true;
					var tmpImit = setting.init;
					setting.init = function(){
						//初始化页面
						initPage();
						tmpImit && tmpImit.call(this);
					};
					setting.content = data;
					if(dialogObj) {
						dialogObj.close();
					}
					window.top.$.dialog(setting);
				});
			}
			return false;
		});
		
		//当前页面提交form表单，并弹出提示信息
		utils.submit.single($(".submit"), true);
		
		//返回历史页面
		$(".back-his").off(".init-page").on("click.init-page", function(){
			window.callback(window.location.pathname, {"action":"flush_his"});
		});
		
		//刷新当前页面
		$(".flush-frame").off(".init-page").on("click.init-page", function(){
			window.location.reload(true);
		});
		//清空form表单的数据,如果想不清空指定的对象，则加上class="not-clear"
		$(".clear-data").off(".init-page").on("click.init-page", function(){
			var $form = $(this).closest("form");
			//清空UI_select的值
			$form.find(".ui-select-value:not(.not-clear)").each(function(){
				$.UI_select.unselect($(this).attr("id"), $(this).val());
			});
			$form.find("input[type=text]:not(.not-clear),input[type=hidden]:not(.not-clear),input[type=file]:not(.not-clear),input[type=password]:not(.not-clear),input[type=file]:not(.not-clear),textarea:not(.not-clear)").val("");
			$form.find("input:checked:not(.not-clear)").prop("checked",false);
			$form.find("select:not(.not-clear)").each(function(){
				this.options.selectedIndex = 0;
			});
			if(utils.browser.ie){
				$form.find("input[type=file]:not(.not-clear)").each(function(){
					var self = $(this);
					self.after(self.clone().val(""));
					self.remove();
				});
			}
			if($.uploadImg) {
				//清除上传图片内容
				$.uploadImg.clear($form);
			}
			return false;
		});
		
		//关闭弹出框的触发按钮
		$(".dialog-cancel").off(".init-page").on("click.init-page", function(){
			$.dialog.focus.close();
			return false;
		});
		//设置页面弹出框默认的ID
		$.dialog.manageDialogId = "manage_dialog_id";
		
		utils.submit.closeDialog = function() {
			var dialog = $.dialog.list[$.dialog.manageDialogId];
			if(dialog)
				dialog.close();
		};
		
		/**
		 * dialog="/web/load.html" dialog显示请求页面
		 * setting.title 标题由setting.title --> 标签的title属性 --> 标签的内容
		 */
		$("[dialog]").off(".init-page").on("click.init-page", function(){
			var dialog_key = "dialog_setting_key",
				$this = $(this),
				setting = $this.data(dialog_key);
			
			if(!setting) {
				setting = (new Function( "return " + $this.attr("setting") ))() || {};
				setting.content = "url:" + $this.attr("dialog");
				setting.title = setting.title ? setting.title : $this.attr("title") ? 
						$this.attr("title") : $this.text() ? $this.text() : $this.val();
				setting.id = $.dialog.manageDialogId;
				setting.lock = setting.lock === false ? false : true;
				var tmpImit = setting.init;
				setting.init = function(){
					//初始化页面
					initPage();
					tmpImit && tmpImit.call(this);
				};
				$this.data(dialog_key, $.extend({}, setting));
			}else
				setting = $.extend({}, setting);
			
			$.dialog(setting);
			return false;
		});
		
		/*********************************** 自定义功能  ***************************************************/
		//绑定表单验证
		if((formValid = $(".form-validate")).length > 0) {
			formValid.bValidator({
				onAfterAllValidations: function(eles, flag) {
					if(!flag) {
						utils.submit.unlock($(eles[0]).closest("form").find(".submiting"))
					}
				}
			});
			BaseData.validateObj = formValid.data('bValidator');
		}
		
	};
	
	//渲染页面
	renderPage();
	//初始化页面
	initPage();
	
});

;(function($){
	
	/*******************************  通用弹框功能  **************************************/
	$.extend({
		/**
		 * 组合格式：
		 * code, msg, fn
		 * msg, fn
		 * msg
		 * code = warn/info/error
		 */
		alert: function(code, msg, fn) {
			if(utils.isFunction(msg)) {
				fn = msg;
				msg = code;
				code = null;
			}
			if(msg == null) {
				msg = code;
				code = null;
			}
			var parent = null;
			for(var key in $.dialog.list) {
				var dialog = $.dialog.list[key];
				if(dialog.config.lock) {
					parent = dialog;
					break;
				}
			}
			$.dialog.alert(code, msg, fn, parent);
		},
		confirm: function(content, yes, no) {
			var parent = null;
			for(var key in $.dialog.list) {
				var dialog = $.dialog.list[key];
				if(dialog.config.lock) {
					parent = dialog;
					break;
				}
			}
			$.dialog.confirm(content, yes, no, parent);
		}
	});
	
	var default_setting = {
			batchClass: "batch",//批处理标识，含有class="batch" 表明此操作是批处理
			targetClass: null,	//操作成功后修改的目标对象,null为当前触发事件的对象。批量操作必须传值
			idsKey: "ids",		//主键参数的key值
			url: null,			//如果change里面包含url参数则首选，否则用此url参数
			change: {
				open: {
					confirmMsg	: "确定启用？",
			 		sucMsg		: null,
			 		failMsg		: "启用失败!",
			 		sucText		: null,
			 		targetText	: null,
			 		targetClass	: "yes",
			 		url			: null,
			 		type		: "POST",
			 		cache 		: false,
			 		data		: {status: "OPEN"}
				},
				close: {
					confirmMsg	: "确定禁用？",
			 		sucMsg		: null,
			 		failMsg		: "禁用失败!",
			 		sucText		: null,
			 		targetText	: null,
			 		targetClass	: "no",
			 		url			: null,
			 		type		: "POST",
			 		cache 		: false,
			 		data		: {status: "CLOSE"}
				}
			}
	};
	
	$.fn.extend({
		//更换对象处理逻辑
		changeHandler : function(settings) {
			settings = $.extend(true, {}, default_setting, settings);
			var self = this,
				obverseClass,
				reverseClass;
			for(var cls in settings.change) {
				if(!obverseClass) {
					obverseClass = cls;
				}else if(!reverseClass) {
					reverseClass = cls;
				}else
					break;
			}
			
			function change(addClass, removeClass) {
				var $addObj = settings.change[addClass],
					$rmObj = settings.change[removeClass];
				if($(this).hasClass(settings.batchClass)
						&& settings.targetClass) {
					var parents = $("input[name=ids]:checked").closest("[trid]"),
						$targets = parents.find("." + settings.targetClass);
						
					if($rmObj.targetText)
						$targets.text($rmObj.targetText);
					if($addObj.targetClass && $rmObj.targetClass) {
						$targets.removeClass($addObj.targetClass).addClass($rmObj.targetClass);
					}
					$targets.removeClass(removeClass).addClass(addClass);
					if($addObj.sucText)
						$targets.html($addObj.sucText);
				}else {
					if($addObj.sucText)
						$(this).html(s.sucText);
					$(this).removeClass(removeClass).addClass(addClass);
					
					var $target = !settings.targetClass ? $(this)
							: $(this).closest("[trid]").find("." + settings.targetClass);
					if($rmObj.targetText)
						$target.text($rmObj.targetText);
					if($addObj.targetClass && $rmObj.targetClass) {
						$target.removeClass($addObj.targetClass).addClass($rmObj.targetClass);
					}
				}
			}
			
			function bindData(s) {
				s.data = s.data || {};
				if(!settings.idsKey) 
					return;
				var vals = [];
				if($(this).hasClass(settings.batchClass)) {
					$("input[name=ids]:checked").each(function(){
						vals.push($(this).val());
					});
				}else {
					var val = $(this).closest("[trid]").attr("trid");
					if(val)
						vals.push(val);
				}
				s.data[settings.idsKey] = vals;
			}
			self.off(".changeHandler").on("click.changeHandler", function(){
				var _this = this;
				if($(_this).hasClass(settings.batchClass)
						&& $("input[name=ids]:checked").length == 0) {
					$.alert("warn", "请先选择您要操作的对象！");
					return;
				}
				if($(_this).hasClass(obverseClass)){
					var s = $.extend({}, settings.change[obverseClass] || {});
					s.url = s.url || settings.url;
					var successTmp = s.success;
					s.success = function(data, textStatus, jqXHR){
						if(!data.code || data.code == BaseData.suc){
							change.call(_this, reverseClass, obverseClass);
						}
						if(successTmp)
							successTmp.call(_this, data, textStatus, jqXHR);
					};
					bindData.call(_this, s);
					if(s.beforeAjax){
						var back = s.beforeAjax.call(_this, s);
						if(back === false)
							return;
					}
					if(s.confirmMsg){
						$.confirm(s.confirmMsg, function(){
							$.ajax(s);
						});
					}else{
						$.ajax(s);
					}
				}else if($(_this).hasClass(reverseClass)){
					var s = $.extend({}, settings.change[reverseClass] || {});
					s.url = s.url || settings.url;
					var successTmp = s.success;
					s.success = function(data, textStatus, jqXHR){
						if(!data.code || data.code == BaseData.suc){
							change.call(_this, obverseClass, reverseClass);
						}
						if(successTmp)
							successTmp.call(_this, data, textStatus, jqXHR);
					};
					bindData.call(_this, s);
					if(s.beforeAjax){
						var back = s.beforeAjax.call(_this, s);
						if(back === false)
							return;
					}
					if(s.confirmMsg){
						$.confirm(s.confirmMsg, function(){
							$.ajax(s);
						});
					}else{
						$.ajax(s);
					}
				}
				return false;
			});
			return this;
		}
	});
	
})(jQuery);

/**
 * 删除
 * _info 	删除确认框的提示信息
 * _sucMsg	删除成功后的提示信息
 * _failMsg 删除失败后的提示信息
 */
function remove(_url, _id, _info, _sucMsg, _failMsg, _sucFun) {
	if(utils.isFunction(_info)){
		_sucFun = _info;
		_info = null;
		_sucMsg = null;
		_failMsg = null;
	}else if(utils.isFunction(_sucMsg)){
		_sucFun = _sucMsg;
		_sucMsg = null;
		_failMsg = null;
	}
	$.confirm(_info || "确定删除？", function(){
		$.ajax({
            type: "post",
            url: _url,
            data: {ids:_id},
            sucMsg: _sucMsg || "删除成功!",
            failMsg: _failMsg || "删除失败!",
            success: function (data, textStatus, jqXHR) {
            	if(!data.code || data.code == BaseData.suc){
    				//删除指定的行
    				$("(li,tr)[trid='"+_id+"']").remove();
    				//显示的总数减1
    				if($(".content").length > 0) {
    					$(".totalCount").text($(".totalCount").text()-1);
    				}
    				//重新排序
    				$.UI_table.resortRowNo();
    			}
    			if(utils.isFunction(_sucFun))
    				_sucFun(data, textStatus, jqXHR);
            }
        });
	});
}

/**
 * 批量删除
 * _info 	删除确认框的提示信息
 * _sucMsg	删除成功后的提示信息
 * _failMsg 删除失败后的提示信息
 * _sucFun  回调函数
 * 只有在_sucFun返回值不等于false ，且ajax请求返回suc 时才会刷新页面
 */
function batchRemove(_url, _info, _sucMsg, _failMsg, _sucFun) {
	if(utils.isFunction(_info)){
		_sucFun = _info;
		_info = null;
		_sucMsg = null;
		_failMsg = null;
	}else if(utils.isFunction(_sucMsg)){
		_sucFun = _sucMsg;
		_sucMsg = null;
		_failMsg = null;
	}
	var idsDom = $("input[name=ids]:checked");
	if(idsDom.length === 0){
		$.alert("warn", "请先选择您要删除的对象！");
		return;
	}
	$.confirm(_info || idsDom.length == 1 ? "确定删除？" : "确定批量删除？", function(){
		$.ajax({
            type: "post",
            url: _url,
            data: $("input[name=ids]:checked"),
            sucMsg: _sucMsg || idsDom.length == 1 ? "删除成功!" : "批量删除成功!", 
            failMsg: _failMsg || idsDom.length == 1 ? "删除失败!" : "批量删除失败!",
            success: function(data, textStatus, jqXHR){
    			var reload = true;
    			if(utils.isFunction(_sucFun))
    				reload = _sucFun(data, textStatus, jqXHR);
    			if(reload !== false && (!data.code || data.code == BaseData.suc))
    				window.callback(window.location.pathname, {"action":"flush_cur"});
    		}
        });
	});
}
