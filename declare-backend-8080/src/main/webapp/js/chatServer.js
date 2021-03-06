var appId = 'kMKMl2skz9YhgmXVtWtaRN8e-gzGzoHsz';

//房间的 conversation id（这是服务器端生成的）
//var roomId = '58a14e6161ff4b0058e69815';
var roomId = '';

var roomName = "";

//每个客户端自定义的 id
var clientId = 'LeanCloud';

var realtime;
var client;
var messageIterator;

//用来存储创建好的 roomObject
var room;

//监听是否服务器连接成功
var firstFlag = true;

//用来标记历史消息获取状态
var logFlag = false;

var openBtn = document.getElementById('open-btn');
var sendBtnAsFile = document.getElementById('send-btn-as-file');
var sendBtn = document.getElementById('send-btn');
var inputName = document.getElementById('input-name');
var inputSend = document.getElementById('input-send');
var printWall = document.getElementById('print-wall');

//拉取历史相关
//最早一条消息的时间戳
var msgTime;

bindEvent(sendBtn, 'click', sendMsg);

bindEvent(document.body, 'keydown', function(e) {
	if (e.keyCode === 13) {
		if (firstFlag) {
			main();
		} else {
			sendMsg();
	    }
	}
});

//进入页面
function main(c_,rm_,r_,id) {
	if(c_){
		clientId = c_;
	}
	if(rm_){
		roomName = rm_;
	}
	if(r_){
		roomId = r_;
	}
	
	console.log('正在连接服务器，请等待。。。');
	showMsg(formatTime(new Date()),'系统','正在连接服务器，请等待。。。');
	if (!firstFlag) {
		client.close();
	}
	
	realtime = new AV.Realtime({
		  appId: appId,
		  region: 'cn', //美国节点为 "us"
	});
	// 注册文件类型消息  
	realtime.register(AV.FileMessage);
	// 创建聊天客户端  
	realtime.createIMClient(clientId).then(function(c){
		showMsg(formatTime(new Date()),'系统','服务器连接成功！');
		console.log('服务器连接成功！');
		firstFlag = false;
	    client = c;
	    
	    c.on('disconnect', function() {
	    	showMsg(formatTime(new Date()),'系统','服务器正在重连，请耐心等待。。。');
	    	console.log('服务器正在重连，请耐心等待。。。');
	    });
	    
	    // 获取对话
	    return c.getConversation(roomId);
	}).then(function(conversation){
		if(conversation){
			return conversation;
		}else{
			// 如果服务器端不存在这个 conversation
			return client.createConversation({
				name: roomName,
				transient: true,
			}).then(function(conversation) {
				console.log('创建聊天室成功。id: ' + conversation.id);
				roomId = conversation.id;
				
				$.ajax({
					url : '/live/saveRoomId.do',
					data : 'roomId='+roomId+"&id="+id,
					type : 'post',
					success : function(data) {
						console.log('保存聊天室ID成功。id: ' + conversation.id);
					}
				});
				
				
				return conversation;
			});
		}
	}).then(function(conversation){
		console.log('当前 Conversation 的成员列表：', conversation.members);
		
		if (conversation.members.length > 490) {
			return conversation.remove(conversation.members[30]).then(function(conversation) {
				console.log('人数过多，踢掉： '+ conversation.members[30]);
		        return conversation;
			});
		}
		return conversation;
	}).then(function(conversation){
		return conversation.join();
	}).then(function(conversation){
		// 获取聊天历史
	    room = conversation;
	    messageIterator = conversation.createMessagesIterator();
	    getLog(function() {
	    	//printWall.scrollTop = printWall.scrollHeight;
	    	console.log('已经加入，可以开始聊天。');
	    	showMsg(formatTime(new Date()),'系统','已经加入，可以开始聊天。');
	    });
	    
	    // 房间接受消息
	    conversation.on('message', function(message) {
	    	if (!msgTime) {
	    		// 存储下最早的一个消息时间戳
	    		msgTime = message.timestamp;
	    	}
	    	var reMsg = '（'+formatTime(message.timestamp.toString())+'）'+"  "+message.from+":  "+message.text;
	    	showMsg(formatTime(message.timestamp.toString()),message.from,encodeHTML(message.text));
	    	console.log('（'+formatTime(message.timestamp.toString())+'）'+"  "+message.from+":  "+message.text);
	    	console.log(message.text);
	    	console.log(message.from);
	    	console.log(formatTime(message.timestamp.toString()));
	    });
	});
}


function sendMsg() {
	var val = inputSend.value;
	// 不让发送空字符
	if (!String(val).replace(/^\s+/, '').replace(/\s+$/, '')) {
		alert('请输入点文字！');
		return ;
	}
	// 向这个房间发送消息，这段代码是兼容多终端格式的，包括 iOS、Android、Window Phone
	room.send(new AV.TextMessage(val)).then(function(message) {
		// 发送成功之后的回调
		inputSend.value = '';
		showMsg(formatTime(message.timestamp),'自己',encodeHTML(message.text));
		console.log('（' + formatTime(message.timestamp) + '）  自己： ', encodeHTML(message.text));
		//printWall.scrollTop = printWall.scrollHeight;
  });

}


// 获取消息历史
function getLog(callback) {
//	var height = printWall.scrollHeight;
//	if (logFlag) {
//		return;
//	} else {
//		// 标记正在拉取
//		logFlag = true;
//	}
//	messageIterator.next().then(function(result) {
//	    var data = result.value;
//	    logFlag = false;
//	    // 存储下最早一条的消息时间戳
//	    var l = data.length;
//	    if (l) {
//	    	msgTime = data[0].timestamp;
//	    }
//	    for (var i = l - 1; i >= 0; i--) {
//	    	console.log(data[i], true);
//	    }
//	    if (l) {
//	    	printWall.scrollTop = printWall.scrollHeight - height;
//	    }
//	    if (callback) {
//	    	callback();
//	    }
//	});
	if (callback) {
    	callback();
    }
}


function encodeHTML(source) {
	return String(source)
    .replace(/&/g, '&amp;')
    .replace(/</g, '&lt;')
    .replace(/>/g, '&gt;')
    .replace(/\\/g,'&#92;')
    .replace(/"/g,'&quot;')
    .replace(/'/g,'&#39;');
}

function formatTime(time) {
	var date = new Date(time);
	var month = date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1;
	var currentDate = date.getDate() < 10 ? '0' + date.getDate() : date.getDate();
	var hh = date.getHours() < 10 ? '0' + date.getHours() : date.getHours();
	var mm = date.getMinutes() < 10 ? '0' + date.getMinutes() : date.getMinutes();
	var ss = date.getSeconds() < 10 ? '0' + date.getSeconds() : date.getSeconds();
	return date.getFullYear() + '-' + month + '-' + currentDate + ' ' + hh + ':' + mm + ':' + ss;
}

function createLink(url) {
	return '<a target="_blank" href="' + encodeHTML(url) + '">' + encodeHTML(url) + '</a>';
}

function bindEvent(dom, eventName, fun) {
	if (window.addEventListener) {
		dom.addEventListener(eventName, fun);
	} else {
		dom.attachEvent('on' + eventName, fun);
	}
}

function showMsg(time,name,msg){
	var html = '<li><div class="tab_time">'+time+'</div><div class="tab_info">'+name+'<span>：</span></div><div class="tab_txt">'+msg+'</div></li>';
	$("#tab1").append(html);
//	$('#tab1').animate({
//	     scrolltop: $('#tab1')[0].scrollHeight
//	}, 'slow');
	
	
	$("#tab1")[0].scrollTop = $("#tab1")[0].scrollHeight;
//	var p = document.createElement('p');
//	p.innerHTML = msg;
//	if (isBefore) {
//		printWall.insertBefore(p, printWall.childNodes[0]);
//	} else {
//	    printWall.appendChild(p);
//	}
}

function getRoomId(){
	return roomId;
}
