(function () {
    var headTag = document.getElementsByTagName('script')[0].parentNode;
    var scriptTag;
    var apiHost = 'https://drm.media.baidubce.com:8888/v1/sdk-capture';
    var sessionTime = Date.now() + '';


    var $ = function (id) {
        return document.getElementById(id);
    };

    function getTime(showMilliseconds) {
        var d = new Date();
        var year = d.getFullYear();
        var month = d.getMonth() + 1;
        var date = d.getDate();
        var hour = d.getHours();
        var minutes = d.getMinutes();
        var seconds = d.getSeconds();
        var milliseconds = d.getMilliseconds();

        month = month < 10 ? '0' + month : month;
        date = date < 10 ? '0' + date : date;
        hour = hour < 10 ? '0' + hour : hour;
        minutes = minutes < 10 ? '0' + minutes : minutes;
        seconds = seconds < 10 ? '0' + seconds : seconds;


        var s = year + '-' + month + '-' + date + ' ' + hour + ':' + minutes + ':' + seconds;

        if (showMilliseconds) {
            s = s + '.' + milliseconds;
        }

        return s;
    }

    function args2search(args) {
        var s = [];

        for(var i in args) {
            if (typeof args[i] === 'object') {
                s.push(i + '=' + encodeURIComponent(JSON.stringify(args[i])));
            }
            else {
                s.push(i + '=' + args[i]);
            }
        }

        return s.join('&');
    }

    function send(args) {
        var action = args.action;

        delete args.action;
        args.sendTime = getTime();
        args = args2search(args);

        if (scriptTag) {
            headTag.removeChild(scriptTag);
        }
        scriptTag = document.createElement('script');
        scriptTag.setAttribute('type', 'text/javascript');

        scriptTag.src = apiHost + action + '?' + args;

        headTag.insertBefore(scriptTag, document.getElementsByTagName('script')[0]);
    }

    var getQuery = function () {
        var query = {};
        var searchInArray = location.search.slice(1).split('&');
        var searchItemInArray;

        for(var i = 0; i < searchInArray.length; i++) {
            searchItemInArray = searchInArray[i].split('=');
            query[searchItemInArray[0]] = decodeURIComponent(searchItemInArray[1]);
        }

        return query;
    };

    var getFormatedTime = function () {
        var date = new Date();
        var h = date.getHours();
        var m = date.getMinutes();
        var s = date.getSeconds();

        return 'hh:mm:ss'.replace('hh', function (){return h >= 10 ? h : '0' + h})
                         .replace('mm', function (){return m >= 10 ? m : '0' + m})
                         .replace('ss', function (){return s >= 10 ? s : '0' + s});
    }

    var formatDuration = function (input) {
        var duration = 0;

        var second = parseInt(input / 1000);
        var minute = 0;
        var hour = 0;

        if (second < 60) {
            second = second < 10 ? '0' + second : second;
            duration = '00:00:' + second;
        } else if (second / 60 < 60) {
            minute = parseInt(second / 60);
            second = second - minute * 60;

            minute = minute < 10 ? '0' + minute : minute;
            second = second < 10 ? '0' + second : second;
            duration = '00:' + minute + ':' + second;
        } else {
            minute = parseInt(second / 60);
            hour = parseInt(hour / 60);
            minute = parseInt((second - hour * 60 * 60) / 60);
            second = second - hour * 60 * 60 - minute * 60;

            hour = hour < 10 ? '0' + hour : hour;
            minute = minute < 10 ? '0' + minute : minute;
            second = second < 10 ? '0' + second : second;
            duration = hour + ':' + minute + ':' + second;
        }

        return duration;
    }

    var disableFormField = function () {
        var fields = document.querySelectorAll('input');

        for(var i = 0; i < fields.length; i++) {
            fields[i].setAttribute('disabled', 'disabled');
        }

        fields = document.querySelectorAll('select');

        for(i = 0; i < fields.length; i++) {
            fields[i].setAttribute('disabled', 'disabled');
        }
    };

    var enableFormField = function () {
        var fields = document.querySelectorAll('input');

        for(var i = 0; i < fields.length; i++) {
            fields[i].removeAttribute('disabled');
        }

        fields = document.querySelectorAll('select');

        for(i = 0; i < fields.length; i++) {
            fields[i].removeAttribute('disabled');
        }
    };

    var swfInstance = $('Capture');
    var publishBtn = $('publish');
    var stopBtn = $('stop');
    var startTime = '';
    var maxBitrate = 0;

    swfInstance.on = Events.on;
    swfInstance.trigger = Events.trigger;

    swfInstance.on('cameras', function (data) {
        var cameras = '';
        for(var i = 0; i < data.length; i++) {
            cameras += '<option value="' + data[i] + '">' + data[i] + '</option>';
        }
        $('camera').innerHTML = cameras;
    });

    swfInstance.on('microphones', function (data) {
        var mics = '';
        for(var i = 0; i < data.length; i++) {
            mics += '<option value="' + data[i] + '">' + data[i] + '</option>';
        }
        $('mic').innerHTML = mics;
    });

    swfInstance.on('error', function (data) {

    });

    swfInstance.on('cameraAccess', function () {
        publishBtn.removeAttribute('disabled');
        stopBtn.style.display = 'block';
        publishBtn.style.display = 'none';
        startTime = Date.now();
        maxBitrate = 0;

        swfInstance.__externalCall('publish', JSON.stringify([{remote: $('remote').value}]));

        // args = {
        //     action: '/user/web/end',
        //     url: $('remote').value,
        //     time: getTime(true)
        // };
        // send(args);
    });

    swfInstance.on('cameraAccessDeny', function () {
        // publishBtn.setAttribute('disabled', 'disabled');
    });

    swfInstance.on('microphoneAccess', function () {

    });

    swfInstance.on('microphoneAccessDeny', function () {
        // publishBtn.setAttribute('disabled', 'disabled');
    });

    swfInstance.on('streamInfo', function (data) {
        var byteCount = data.byteCount;

        if (byteCount > 1024 * 1024) {
            byteCount = (byteCount / 1024 / 1024).toFixed(3) + '(MB)';
        } else if (byteCount > 1024) {
            byteCount = (byteCount / 1024).toFixed(3) + '(KB)';
        } else if (byteCount > 0)  {
            byteCount = byteCount.toFixed(3) + '(byte)';
        } else {
            byteCount = 0;
        }

        var now = Date.now();
        var millisecond = now - startTime;
        var duration = formatDuration(millisecond);
        $('total-duration').innerHTML = duration;

        if (+data.quality.toFixed(2) > +maxBitrate) {
            maxBitrate = data.quality.toFixed(2);
            $('max-bitrate').innerHTML = data.quality.toFixed(2) + '(kbps)';
        }
        $('ava-bitrate').innerHTML = (data.byteCount * 8 / millisecond).toFixed(2) + 'kbps';

//        $('config').value = ''
//            + '褰撳墠甯х巼: ' + data.fps.toFixed(2)
//            + '\n闊抽鐮佺巼: ' + data.audioQuality.toFixed(2) + '(kbps)'
//            + '\n瑙嗛鐮佺巼: ' + data.videoQuality.toFixed(2) + '(kbps)'
//            + '\n褰撳墠鐮佺巼:  ' + data.quality.toFixed(2) + '(kbps)'
//            + '\n鍏抽敭甯ч棿闅�: ' + data.KeyFrameInterval
//            + '\n鍙戦€佸瓧鑺傛暟锛�' + byteCount
//            + '\n闊抽缂栫爜: ' + data.audioCodec
//            + '\n瑙嗛缂栫爜: ' + data.videoCodec
//            + '\n鍘熷瑙嗛瀹藉害: ' + data.width
//            + '\n鍘熷瑙嗛楂樺害: ' + data.height
//            + '\n闊抽璁惧: ' + data.micName
//            + '\n瑙嗛璁惧: ' + data.cameraName;

        var bitCount = data.byteCount * 8;

        if (bitCount > 1024 * 1024) {
            bitCount = (bitCount / 1024 / 1024).toFixed(3) + '(Mb)';
        } else if (bitCount > 1024) {
            bitCount = (bitCount / 1024).toFixed(3) + '(Kb)';
        } else if (bitCount > 0) {
            bitCount = bitCount.toFixed(3) + '(bit)';
        } else {
            bitCount = 0;
        }

        $('total-flow').innerHTML = bitCount;
    });

    
    //日志部分关闭
//    swfInstance.on('log', function (data) {
//        $('log').value += getFormatedTime() + ': ' + data + '\n';
//        $('log').scrollTop = $('log').scrollHeight;
//    });

    publishBtn.onclick = function () {

        if (!/^rtmp/.test($('remote').value)) {
            alert('推流地址地址不正确');
            return;
        }
        if($('camera').selectedIndex==-1){
        	alert("请检查摄像头是否正常连接");
        	return;
        }
        if($('mic').selectedIndex==-1){
        	alert("请检查麦克风是否正常连接");
        	return;
        }
        

        swfInstance.__externalCall('setup', JSON.stringify([{
            camera: {
                index: $('camera').selectedIndex + '',
                width: $('camera-width').value,
                height: $('camera-height').value,
                kbps: $('camera-kbps').value,
                fps: $('camera-fps').value,
                keyframeInterval: $('camera-keyframe').value
            },
            mic: {
                index: $('mic').selectedIndex,
                codec: 'Speex',
                rate: $('mic-rate').value,
                kbps: $('mic-kbps').value / 8,
                gain: $('mic-gain').value
            }
        }]));

        // 缃伆鎵€鏈夎〃鍗曢」
        disableFormField();

        args = {
            action: '/user/web/start',
            url: $('remote').value,
            cameraName: $('camera').value,
            videoWidth: $('camera-width').value, // 瑙嗛鍒嗚鲸鐜囧搴�
            videoHeight: $('camera-height').value, // 瑙嗛鍒嗚鲸鐜囬珮搴�
            bitrate: $('camera-kbps').value, // 瑙嗛鐮佺巼
            fps: $('camera-fps').value, // 瑙嗛甯х巼
            gopLength: $('camera-keyframe').value,    // I甯ф渶澶ч棿闅斻€傚崟浣嶇
            microphoneName: $('mic').value,
            audioBitrate: $('mic-kbps').value / 8, // 闊抽鐮佺巼
            audioSampleRate: $('mic-rate').value, // 闊抽閲囨牱鐜�
            micGain: $('mic-gain').value, // 楹﹀厠椋庨煶閲忓鐩�
            time: getTime(true),
            sessionTime: sessionTime
        };
        send(args);
    };

    stopBtn.onclick = function () {
        swfInstance.__externalCall('stop');
        
        stopBtn.style.display = 'none';
        publishBtn.style.display = 'block';

        setTimeout(function () {
            $('total-duration').innerHTML = '00:00:00';
            $('total-flow').innerHTML = '0';
            $('ava-bitrate').innerHTML = '0kbps';
            $('max-bitrate').innerHTML = '0kbps';
        }, 1000);

        enableFormField();

        args = {
            action: '/user/web/end',
            url: $('remote').value,
            time: getTime(true),
            sessionTime: sessionTime
        };
        send(args);
    };

    var query = getQuery();

    if (query.pushUrl) {
        $('remote').value = query.pushUrl;
    }

})();