
/**===================================post and ajax================================*/
var code = "UTF-8";
var date_flag = "-";
var day_format = "date";
var mobiles = ["Android", "android", "iPhone", "iPad", "Windows Phone", "windows phone", "Fennec"];

function isMobile(){
	var ua = window.navigator.userAgent;
	for(var i=0; i<mobiles.length; i++){
		if(ua.indexOf(mobiles[i])!=-1){
			return true;
		}
	}
	return false;
}

function clearCache(url){
	var uid = new Date().getTime();
	var connector = /.+?.+=.+/g.exec(url) == null ? "?" : "&";
	return url += (connector + uid + "=" + uid);
}

function submit(f, action){
	$ds = $(":disabled");
	$ds.attr("disabled", false);
	f.attr("action", action).submit();
	$ds.attr("disabled", true);
}

function postJson(url, data, callback, async){
	var asyn = typeof async == "undefined"?true:async;
	$.ajax( {   
     	type : "POST",   
     	contentType : "application/json; charset=" +code,
     	async : asyn,
     	url : url,   
     	data : $.toJSON(data),
     	dataType : "json",   
     	success : callback,
     	error   : function(xmlhttp, textStatus, errorThrown) {
     		//alert(textStatus);
     		var txt = xmlhttp.responseText;
     		if(txt!=null && txt.length<20){
     			window.location = xmlhttp.responseText;
     		}
        }
    });
}

function postForm(url, params, callback, async){
	//$.post(url,$("#" +formId).serialize(), callback,"json");
	var asyn = typeof async == "undefined" ? true : async;
	$.ajax( {   
     	type : "POST", 
     	async : asyn,
     	url : url,   
     	data : params,
     	dataType : "json",   
     	success  : callback,
     	error    : function(xmlhttp, textStatus, errorThrown) {
     		//alert(textStatus);
     		var txt = xmlhttp.responseText;
     		if(txt!=null && txt.length<20){
     			window.location = xmlhttp.responseText;
     		}
        }
    });
}

function goUrl(url, callback, async){
	postForm(url, null, callback, async);
}

function postHttpData(url, data){
	var f=$('<form>').appendTo('body');
	for (key in data){
		f.append('<input type="hidden" name="'+key+'" value="'+data[key]+'">');
	}
	f.attr('method', 'post').attr('action', url).submit();
	$('body').remove(f);
}

function projectName(){
	var pathname = window.location.pathname;
	if(pathname.charAt(0)!="/") pathname = "/" +pathname;
	var pos = pathname.indexOf("/", 2);
	return pathname.substring(0, pos+1);
}

function spanToParam(spanId){
	$.each($(spanId), function(i, el){
		el.name = spanId.substring(1);
		el.value = el.innerHTML;
	});
	return $.param($(spanId));
}

(function(){
	if (typeof(Worker) == "undefined") {
		var e="abbr,article,aside,audio,canvas,datalist,details,figure,footer,header,hgroup,mark,menu,meter,nav,output,progress,section,time,video".split(','),i=e.length;
		while(i--){
			document.createElement(e[i]);
		}
	}
}());

/**===================================format================================*/
Date.prototype.format = function(formatStr){   
	var str = formatStr;  
	str=str.replace(/yyyy|YYYY/,this.getFullYear());   
	str=str.replace(/yy|YY/,(this.getYear() % 100)>9?(this.getYear() % 100).toString():'0' + (this.getYear() % 100));   
	
	var month = this.getMonth()+1;
	str=str.replace(/MM/,month>9?month.toString():'0' + month);   
	str=str.replace(/M/g,month); 

	str=str.replace(/dd|DD/,this.getDate()>9?this.getDate().toString():'0' + this.getDate());   
	str=str.replace(/d|D/g,this.getDate());   

	str=str.replace(/hh|HH/,this.getHours()>9?this.getHours().toString():'0' + this.getHours());   
	str=str.replace(/h|H/g,this.getHours());   
	str=str.replace(/mm/,this.getMinutes()>9?this.getMinutes().toString():'0' + this.getMinutes());   
	str=str.replace(/m/g,this.getMinutes());   

	str=str.replace(/ss|SS/,this.getSeconds()>9?this.getSeconds().toString():'0' + this.getSeconds());   
	str=str.replace(/s|S/g,this.getSeconds());   

	return str;   
};

function fmRange(area){
	if(area && area[0]){
		area = $(area);
	}
	area = area && area[0] ? $(area) : document;
	$(":text[name$='From'],:text[name$='To']",area).each(function (){
		var char = this.name.indexOf("From") != -1 ? "0" : "9";
		if(jQuery.trim(this.value).length == 0){
			$(this).val(getFilling(char,isDate(this)?this.maxLength-2:this.maxLength)).blur();
		}
	});
}

function isDate(ele){
	var cls = $(ele).attr("class");
	cls = typeof cls!="undefined" ? cls : " ";
	return ele.id.indexOf(day_format)!=-1 || cls.indexOf(day_format)!=-1;
}

function getFilling(char,len){
	var str = "";
	if(!len)
		return str;
	while(str.length < len){
		str += char;
	}
	return str;
}

function fmCodeRange(objS, objE, len){
    if (objS) objS.value = fmCode(objS.value, "0", len);
    if (objE) objE.value = fmCode(objE.value, "9", len);
}

function fmDateRange(objS, objE){
	if (objS) objS.value = fmDateVal(fmCode(objS.value, "0", 8));
    if (objE) objE.value = fmDateVal(fmCode(objE.value, "9", 8));
}

function execTag(val){
	 var  a = /((?:<[^>]*>)*)([^<]*)((?:<\/[^>]*>)*)/.exec(val);
	 return a;
}

function fmDateVal(val){
	var a = execTag(val);
	if(a != null){
		val = a[1] + fmDate(a[2]) +a[3];
	}else{
		val = fmDate(val);
	}
	return val;
}

function fmDate(val){
	if(val!=null && val.length==8 && val.indexOf(date_flag)==-1){
		val = val.substring(0, 4) +date_flag +val.substring(4, 6) +date_flag +val.substring(6);
	}else if(val!=null && val.length==6 && val.indexOf(date_flag)==-1){
		val = val.substring(0, 2) +date_flag +val.substring(2, 4) +date_flag +val.substring(4);
	}
	return val;
}

function fmNumVal(val, figsu, dotType){	
	var a = execTag(val);
	if(a != null){
		val = a[1] + fmNum(a[2], figsu, dotType) +a[3];
	}else{
		val = fmNum(num, figsu, dotType);
	}
	return val;
}	

function fmNum(num, figsu, dotType){
	var numStr = num+'';	
	var rtn = '';
	if(numStr.length>0 && numStr!="&nbsp;"){	
		if(dotType=="half_up"&&figsu>0){
			numStr=num.toFixed(figsu)+"";
		}
		var pos = numStr.indexOf('.');						
		var intNum = '';						
		if(pos!=-1){						
			intNum = numStr.substring(0, pos);					
		}else{						
			intNum = numStr;					
		}						
		var dou = '';						
		var intRtn = '';						
		var douCount = 0;						
		for(var i=intNum.length-1; i>=0; i--){						
			douCount++;					
			if(douCount==3 && i!=0){					
				dou = ',';				
				douCount = 0;				
			}else{					
				dou = '';				
			}					
			intRtn = dou +intNum.charAt(i) +intRtn;					
		}				
		if(figsu>0){						
			var dotRtn = '0';					
			for(var i=2; i<=figsu; i++){					
				dotRtn += '0';				
			}					
			if(pos!=-1){					
				var dotNum = numStr.substring(pos+1);				
				dotRtn = dotNum + dotRtn;		
				var f = parseFloat(figsu);
				var dotRtnTemp = dotRtn.substring(0, f-1);
				var l = dotRtn.substring(f-1, f);
				if(dotType!="floor" && dotRtn.length-1>figsu){
					var ll = parseFloat(dotRtn.substring(f, f+1));
					var c = 1;
					if(dotType=="half_up") c = 5;
					if(ll>=c) l = (parseFloat(l) +1)+"";
				}
				dotRtnTemp += l;
				dotRtn = dotRtnTemp;
			}					
			rtn = intRtn + '.' + dotRtn;					
		}else{						
			rtn = intRtn;					
		}											
	}							
	return rtn;		
}

function fmCode(val, pre, len){
	var a = execTag(val);
	if(a != null){
		val = a[1] + preCode(a[2], pre, len) +a[3];
	}else{
		val = preCode(val, pre, len);
	}
	return val;
}

function preCode(val, pre, len){
	var tmp = val;
	if(val!=null) val = $.trim(val);
    if(len!=0 && val!=null && val.length!=0) {
        var format = fmStr(pre, len);
        tmp = format + val;
        tmp = tmp.substring(tmp.length-format.length);
    }
    return tmp;
}

function fmStr(sig, len){
    var format = "";
    for(var i=0;i<len;i++){
      format = format + sig;
    }
    return format;
}

function doFormat(val, format, flag){
	if(val.indexOf(flag)==-1){
		var parts = format.split(flag);
		var len = 0;
		$.each(parts, function(i, part){
			len += parseFloat(part.length);
			if(i>0) len += 1;
			if(val.length>len){
				val = val.substring(0, len) +flag + val.substring(len);
			}
		});
	}
	return val;
}

function doFormat(val, format){
	var a = execTag(val);
	if(a != null){
		val = a[1] + doFm(a[2], format) +a[3];
	}else{
		val = doFm(val, format);
	}
	return val;
}

function doFm(val, format){
	if(format && format.length>0){
		var flag = format.replace(/\d*/g, "");
		var fLen = format.length - flag.length;
		if(flag.length>0){
			flag = flag.substring(0,1);
			if(val && $.trim(val).length==fLen && val.indexOf(flag)==-1){
				var parts = format.split(flag);
				var len = 0;
				$.each(parts, function(i, part){
					len += parseFloat(part.length);
					if(i>0) len += 1;
					if(val.length>len){
						val = val.substring(0, len) +flag + val.substring(len);
					}
				});
			}
		}
	}
	return val;
}

/**========================================calculator==================================*/
function isInteger(str){								
	if(str==parseInt(str, 10)){							
		return true;						
	}else{							
		return false;						
	}							
}								
						
function isDouble(str){								
	if((str!=null && str.length>1 && str.substring(0,1)=='.') ||
		(str!=null && str.length>2 && (str.substring(0,2)=='-.' || str.substring(str.length-1)=='.'))){							
		return false;						
	}							
	if(str==parseFloat(str)){							
		return true;						
	}else{							
		return false;						
	}	
}

function parseNum(val){
	val = val.replace(/\,/g,"");
	return val;
}

/**========================================json==================================*/

function stringToJson(str){
	return eval("(" + str + ")");

}

function jsonToString(json){
	return $.toJSON(json);
}
/**========================================browser==================================*/
function uaMatch(ua) {  
	var rMsie = /(msie\s|trident.*rv:)([\w.]+)/,   
	rFirefox = /(firefox)\/([\w.]+)/,   
	rOpera = /(opera).+version\/([\w.]+)/,   
	rChrome = /(chrome)\/([\w.]+)/,   
	rSafari = /version\/([\w.]+).*(safari)/;
    var match = rMsie.exec(ua);  
    if (match != null) {  
        return { browser : "IE", version : match[2] || "0" };  
    }  
    var match = rFirefox.exec(ua);  
    if (match != null) {  
        return { browser : match[1] || "", version : match[2] || "0" };  
    }  
    var match = rOpera.exec(ua);  
    if (match != null) {  
        return { browser : match[1] || "", version : match[2] || "0" };  
    }  
    var match = rChrome.exec(ua);  
    if (match != null) {  
        return { browser : match[1] || "", version : match[2] || "0" };  
    }  
    var match = rSafari.exec(ua);  
    if (match != null) {  
        return { browser : match[2] || "", version : match[1] || "0" };  
    }  
    if (match != null) {  
        return { browser : "", version : "0" };  
    }  
}  
var browserMatch = uaMatch(navigator.userAgent.toLowerCase());  

function supportCss3(style) {  
    var prefix = ['webkit', 'Moz', 'ms', 'o'],  
    i,  
    humpString = [],  
    htmlStyle = document.documentElement.style,  
    _toHumb = function (string) {  
	    return string.replace(/-(\w)/g, function ($0, $1) {  
	    	return $1.toUpperCase();  
	    });  
    };  
       
    for (i in prefix)  
    humpString.push(_toHumb(prefix[i] + '-' + style));  
    humpString.push(_toHumb(style));  
    for (i in humpString)  
    	if (humpString[i] in htmlStyle) return true;  
    return false;  
}

function getContentHeight(head, tail){
	return document.body.clientHeight - head - tail;
}

/**========================================progress bar==================================*/
var inter;
function displayBar(url,screenCd){
	if(browserMatch.browser!='chrome'){
		initProgeressbar();
		inter=setInterval(function(){getProgressbarPercent(url,screenCd);},150);
	}
}

function getProgressbarPercent(url,screenCd){
	var myDate = new Date();
    var ti=myDate.getTime();
    url  = url+ '&time='+ti+'&screenCd='+screenCd;
    $.ajax({
    	 type:'POST',
         url: url,
         dataType:"html",
         success: setProgressbarValue
    });
}
function initProgeressbar(){
	$("#progressbar").css("display","block");
	$("#progressbar").progressbar({value:0,max:100});
}
function setProgressbarValue(val){
	var v=parseInt(val);
	$("#progressbar").progressbar({value:v});
	if(v==100){
		clearInterval(inter);
	}
} 
