////////////////////////////////////////popup///////////////////////////////////
$(function(){
	bootbox.setDefaults({   
		locale: "zh_CN",   
	    //show: true, 
	    backdrop: false,   
	    animate: false   
	});
});

function boxConfirm(txt, callback){
	bootbox.confirm(txt, function(result){
		if(result) callback();
	});
}

function boxConfirmPrint(txt, callback1, callback2){
	bootbox.dialog({
        message: txt,
        title: "",
        buttons: {
        	cancel : {
        		label : "取消",
        		className : "btn"
        	},
            ok : {
                label : "确定",
                className : "btn btn-primary",
                callback: callback1
            },
        	ok_print : {
        		label : "确定+印刷",
        		className : "btn btn-primary",
        		callback : callback2
        	}
        }
    });
}

function boxAlert(txt, callback){
	bootbox.alert({  
        buttons: {  
            ok: {  
            	label: 'OK',  
                className: 'btn-default'  
            }  
         },
         message: txt,
         callback: callback
    }).draggable();
}

////////////////////////////////////error div/////////////////////////////////
/**
 * var $errDiv = $("#errDiv").errMsg();
 * $errDiv.printErr("aaa");
 * */
;(function ($){
	$.fn.extend({
		errMsg : function (css){				//創建一個報錯信息區域
			var self = $(this).addClass("error-area");
			self.css(css ? css : {});
			return self;
		},
		printErr : function (errList,append){		//清空並寫入報錯信息,append為true時則追加該信息
			var self = $(this);
			if(errList){
				var err = "";
				if(typeof errList == "string"){
					err = errList;
				}else{
					for(var i=0; i<errList.length; i++){
						err += (errList[i] +"<br/>");
					}
				}
				append = append == undefined ? false : (typeof append == "boolean" ? append : false);
				self.html((append ? self.html() : "") + err);
			}
			return self;
		},
		clearErr : function (){			//清空區域中的信息
			var self = $(this);
			self.html("");
			return self;
		},
		hasErr : function(){			//是否有報錯信息
			var self = $(this);
			if(self.text()=="") return false;
			else return true;
		}
	});
})(jQuery);

function alertErr(errList){
	if(errList){
		var err = "";
		if(typeof errList == "string"){
			err = errList;
		}else{
			for(var i=0; i<errList.length; i++){
				err += (errList[i] +"<br/>");
			}
		}
		var box =bootbox.alert({  
            buttons: {  
                ok: {  
                	label: 'OK',  
                    className: 'btn-default'
                }  
             },
             message: "<font color='red'>"+err+"</font>"
        }).draggable().css({"margin-top":window.screen.height/2-250});
		box.find("button").on("keydown",function(e){
			if(e.keyCode=='13'){
				$(this).click();
			}
		});
		box.find(".btn-default:first").focus();
	}
}

/**==========================================key next =======================================*/
;(function ($){
	$.extend({
		tableFocus : function($table){
			$.each($table.find("input, select"), function(i, el){
				$(el).on("keydown", function(e){
					var name = $(this).attr("name");
					if(e.keyCode==38){
						$(this).parents("tr").prev().find("select[name='" +name +"'], input[name='" +name+"']").focus();
					}else if(e.keyCode==40){
						$(this).parents("tr").next().find("select[name='" +name +"'], input[name='" +name+"']").focus();
					}
				});
			});
		},
		docFocus : function(){
			$("input").on("keydown", function(e){  //jquery version >= 1.9  live-->on 
				toFocus(e,this);
			});
			$("select").on("keydown", function(e){
				toFocus(e,this);
			});
		}
	});
})(jQuery);

function firstFocus(){
	getKeyEle().first().focus();
}

function toFocus(e,el){
	if(e.keyCode==13) nextFocus(el);
	if(e.keyCode==27) preFocus(el);
}

function nextFocus(el){
	var $els = getKeyEle();
	var idx = $els.index(el);
	if(idx < 0){
		return;
	}
	if(idx!=$els.length-1){
		var el = $els[idx+1];
		setTimeout(function (){el.focus(); if(el.select) el.select();},50);
	}
}

function preFocus(el){
	var $els = getKeyEle();
	var idx = $els.index(el);
	if(idx>0){
		var el = $els[idx-1];
		setTimeout(function (){el.focus(); if(el.select) el.select();},50);
	}
}

function getKeyEle(){
	return $("input:visible:enabled:not(:button,[readonly]), select:visible:enabled");
}

/**==========================================calculate swing =======================================*/
;(function ($){
	$.fn.extend({
		calSwingId : "calculate-swing-div",
		calSwingX : 10,
	    calSwingY : 25,
	    _panelCreate : function(value, obj){
	    	var ndiv = "<div id='"+this.calSwingId+"'>" + value + "</div>";
            $("body").append(ndiv);  
            $("#"+this.calSwingId).css({  
                "top" : ($(obj).offset().top + this.calSwingY) + "px",  
                "left" : ($(obj).offset().left + this.calSwingX) + "px"  
            }).show();
	    },
	    _panelRemove : function(){
	    	$("#"+this.calSwingId).remove();
	    },
		_swingCreate : function(isCal){
			var $this = $(this);
			$this.attr("autocomplete", "off");
            $this.bind("input propertychange", function(e) { 
            	$this._panelRemove();
                if(this.value!=""){
                	if(isCal && !isDouble(this.value) || !isCal){
                		$this._panelCreate(this.value, this);
                	}
                	this.divText = this.value;
                }
            });
            $this.bind("blur mouseleave", function(){
            	$this._panelRemove();
            });
		},
		_swingShow : function(isCal){
			$this = $(this);
			$this.bind("focus mouseover", function(){
				$this._panelRemove();
            	if(typeof this.divText!="undefined"){
            		if(isCal && (this.divText!=this.value || !isDouble(this.value)) || !isCal)
            			$this._panelCreate(this.divText, this);
            	}
            });
		},
		_swingMark : function(){
			$this = $(this);
			$this.bind("keydown keyup mouseup", function(){
				var sel = window.getSelection();  // W3C 
				if (sel && this.divText==this.value) {    
					this.focus();
					var pos = this.selectionEnd;
					var txt = $("#"+$this.calSwingId).text().replace("|", "");
					var p = txt.substring(pos-1,pos);
					var a = txt.split('');
					a[pos-1] = p+"<font color='red'>|</font>";
					$("#"+$this.calSwingId).html(a.join(''));
                }
			});
		},
		_swingCal : function(){
			$this = $(this);
			$this.bind("blur", function(){
            	if(this.value!="")this.value = eval(this.value);
            });
		},
		calSwing : function (isCal){
			var $this = $(this);
			var cal = isCal?isCal:true;
			$this._swingCreate(cal);
			$this._swingMark();
			$this._swingShow(cal);
			if(cal){
				$this._swingCal();
			}
			return $this;
		}
	});
})(jQuery);

/******************************************************datepicker*********************************************************/
$(function(){
	$.datepicker.setDefaults({
		regional : "zh-CN",
		dateFormat : "yy-mm-dd",
		showButtonPanel : true,
		closeText : "清除",
		changeMonth: true,
	    changeYear: true,
	    yearRange:"1990:2050"
		/*beforeShow: function (input, inst) { 
			
		}*/
	});

	$(".day").datepicker({
		/* onSelect: function(){
			
		},
		onClose: function(){
			
		} */
		onClear : function(input) {
			input.val("");
			$(this).change();
		}
	}).attr({
		"readonly" : true
	});

	$(".date").datepicker({

		dateFormat: "yy-mm",
		onClear : function(input) {
			input.val("");
		}
	}).attr({
		"readonly" : true
	});
});

/******************************************************popup*********************************************************/
var wOpener = new WindowOpener();
function WindowOpener(){
	this.url;
	this.width;
	this.height;
	this.left;
	this.top;
	this.subname;
	this.doBack;
	this.openWin = function(url, width, height, subname){
		this.url = url;
		this.width = width;
		this.height = height;
		this.subname = subname;
		var w=width?width:1050;
		var h=height?height:600;
		var sub=this.subname?this.subname:"sub";
		w = w+10;
	    h = h+2;
	    var l = this.left?this.left : (window.screen.width - w) / 2 - 5;
	    var t = this.top?this.top : (window.screen.height - h) / 2 - 50;
	    var settings = "left="+l+",top="+t+",width="+w+",height="+h+",scrollbars=yes,toolbar=no,menubar=no,resizable=no,location=no,status=no";
	    var win = window.open(url,sub,settings);
		win.focus();
		return win;
	};
	this.clear = function(){
		this.url = null;
		this.width = null;
		this.height = null;
		this.left = null;
		this.top = null;
		this.subname = null;
		this.doBack = null;
	};
	this.openForm = function(form, url){
		var $form = $(form);
		$form.attr("target", "_blank");
		if(url) $form.attr("action", url);
		$form.submit();
		$form.attr("target", "_self");
	};
}

function closeWin(){
    var winOpener = window.opener.wOpener;																									
    window.close();													
    winOpener.doBack();													
}

function go(url,target){
	target = target ? target : "_self";
	$("head").append('<base target = "'+target+'" />');
	$("<a/>").attr("href",clearCache(url)).appendTo($("body")).get(0).click();
}

/******************************************************dataTables*********************************************************/
var datatableSortInfor = {};
var datatableSortIdx = 0;
function dataTables(selector, noSortTagets,initSortTagets){
	$(selector).dataTable( {
			"bLengthChange": false,//是否显示一个每页长度的选择条（须要分页器支撑）
			"bFilter":false,//是否启用客户端过滤功能
			"bInfo": true,//是否显示表格的一些信息
			"bPaginate": true,//开关，是否显示（应用）分页器
			"oLanguage": {
				"sLengthMenu": "每页 _MENU_ 条记录",
				"sInfo": "_START_－ _END_条  ( 共 _TOTAL_条 )",  
				"sInfoEmpty": "没有数据",  
				"sInfoFiltered": "(从 _MAX_ 条数据中检索)",  
				"oPaginate": {  
					"sFirst" : "首页　",
					"sPrevious": "上页　",  
					"sNext": "下页　",
					"sLast" : "　尾页"
				}
			},	
			"bAutoWidth":false,//是否自动调整表格各列宽度
			"aoColumnDefs": [{ "bSortable": false, "aTargets": noSortTagets }],
			"aaSorting": initSortTagets,
			"fnDrawCallback":dataTableDrawBack,
			"fnInitComplete" : function(oSetting, json){
				$(".sorting").bind("click",function(){
			 		var key = $(this).index();
			 		datatableSortIdx++;
			 		if($(document).find(".sorting_asc").length>0){
			 			datatableSortInfor[key] = "asc_"+datatableSortIdx;
			 		}else if($(document).find(".sorting_desc").length>0){
			 			datatableSortInfor[key] = "desc_"+datatableSortIdx;
			 		}
			    });
			}
	});
}

/******************************************************contentChoose*********************************************************/
/**
 * 返回的json必须以value-label的形式存在，如[{"value":1,"label":"zhangSan"},{"value":2,"label":"lisi"}]
 *      <input type="text" class="addName"/>&nbsp;<span class="showName"></span>
 *      <select class="selectName"/><option>选择</option><option>龙虎</option><option>真鹤</option></select>&nbsp;<span class="sShowName"></span>
 *      $(".addName").each(function(idx, el){
			$(this).contentChooseIN("showName", "nameHidden", function(inputVal){
				return 查询的json数据;
			}).contentChooseSetInputSize(3);
		});
		$(".selectName").contentChooseBox("sShowName", "nameHidden");
		var $addName = $(".addName");
		var $showName = $(".showName");
		$(页面加载时的json数据).each(function(idx){
			$addName.eq(idx).contentChooseSpan($showName.eq(idx),this.label+":"+this.num,this.value+":"+this.num,"nameHidden");
		});
 * */
;(function ($){
	$.fn.extend({
		contentChooseDelEleName : '<a href="javascript:void(0)" class="contentChooseA" style="font-size:20px">×</a>',
		contentChooseInputSpanId : "content-choose-span",
		contentChooseEleFlag : "　",
		contentChooseInputSize : 5,
		contentChooseSource : null,
		contentChooseCallbackExec : function(){
			var arr = new Array();
			if(this.contentChooseSource!=null &&this.contentChooseSource.length>0){
				var idx = 0;
				$(this.contentChooseSource).each(function(){
					arr[idx++]=this.label;
				});
			}
			return arr;
		},
		contentChooseFunc : function(eleClassName,srcClassName,callback,chooseBack){
			this.addClass(srcClassName);
			var self = this;
			this.off();
			if(typeof this.data('ui-autocomplete')!='undefined') this.data('ui-autocomplete',null);
			this.autocomplete({
				source: function( request, response ) {
					self.contentChooseSource = callback(request.term);
					var arr =self.contentChooseCallbackExec();
					if(arr!=null) response(arr);
				},
				select: function(event, ui){
					var val = ui.item.value!=null?ui.item.value:"";
					if(val!="" && eleClassName!=null){
						var idx = $("."+srcClassName).index(self);
						//console.debug("linno="+idx);
						if(chooseBack) chooseBack($("."+eleClassName).eq(idx),val);
					}
				}
			});
			this.on("keydown", function(e){
				if(!e.isDefaultPrevented()) toFocus(e,this);
			});
			return this;
		},
		contentChooseGetValue : function(label){
			var val = "";
			$(this.contentChooseSource).each(function(){
				if(this.label==label){
					val = this.value;
					return true;
				} 
			});
			return val;
		},
		contentChooseSpan : function(showEle,val,hiddenVal,hiddenName,delback){
			console.debug('hidden_value=' +hiddenVal);
			var valSpan = $('<span>'+val+'</span>');
			valSpan.append($('<input type="hidden" name="'+hiddenName+'" value="'+hiddenVal+'" />')).appendTo(showEle);
			$(this.contentChooseDelEleName).on("click",function(){
				$(this).closest("span").remove();
				if(delback) delback(hiddenVal);
			}).appendTo(valSpan);
			$("<span>"+this.contentChooseEleFlag+"</span>").appendTo(valSpan);
			return this;
		},
		contentChooseSetFlag : function(flag){
			this.contentChooseEleFlag = flag;
			return this;
		},
		contentChooseSetInputSize : function(size){
			this.contentChooseInputSize = size;
			return this;
		},
		contentChoose : function(eleClassName,hiddenName,callback,delback,srcClassName){
			var $this = $(this);
			srcClassName = srcClassName?srcClassName:"contentChoose";
			$this.contentChooseFunc(eleClassName,srcClassName,callback,function(showEle,val){
				$this.contentChooseSpan(showEle,val,$this.contentChooseGetValue(val),hiddenName,delback);
				$this.on("autocompleteclose", function( event, ui ){
					$(this).val("").focus();
				});
				//$this.select();
				//window.getSelection().createRange().select();
			});
			return $this;
		},
		contentChooseIN :function(eleClassName,hiddenName,callback,inputback,delback,srcClassName){
			var $this = $(this);
			srcClassName = srcClassName?srcClassName:"contentChooseIN";
			$this.contentChooseFunc(eleClassName,srcClassName,callback,function(showEle,val){
				$this.attr("disabled", true);
				var ndiv = $("<span id="+$this.contentChooseInputSpanId+">" + val +"：</span>").appendTo("body").css({  
	                "top" : ($this.offset().top) + "px",  
	                "left" : ($this.offset().left) + "px"
	            });
				var inp = $('<input type="text" class="'+srcClassName+'Text" size="'+$this.contentChooseInputSize+'"/>').appendTo(ndiv).on("keyup blur", function(e){
					if(e.keyCode==13){
						if(this.value!=""){
							$this.contentChooseSpan(showEle,val+":"+this.value,$this.contentChooseGetValue(val)+":"+this.value,hiddenName,delback);
							$this.attr("disabled", false).val("").focus();
							ndiv.remove();
						}
					}
					if(e.keyCode==46 || e.type=='blur'){
						if(inputback) inputback(this.value);
						$this.attr("disabled", false).val("").focus();
						ndiv.remove();
					}
				});
				$this.on("autocompleteclose", function( event, ui ){
					inp.focus();	
				});
				ndiv.show();
			});
			return $this;
		},
		contentChooseBox : function(eleClassName,hiddenName,delback,srcClassName){
			var $this = $(this);
			srcClassName = srcClassName?srcClassName:"contentChooseBox";
			$this.addClass(srcClassName);
			$this.off();
			$this.on("change", function(){
				if(this.value>=0) $this.contentChooseSpan($("."+eleClassName).eq($("."+srcClassName).index($this)),$this.find(":selected").text(),this.value,hiddenName,delback);
				//$this.val($this.find("option").eq(0).val());
			});
		},
		contentChooseAC : function(hiddenName,callback,srcClassName){
			var $this = $(this);
			srcClassName = srcClassName?srcClassName:"contentChooseAC";
			$this.contentChooseFunc(null,srcClassName,callback);
			$this.on("blur", function(){
				if(typeof $this.data('ui-autocomplete')!='undefined'){
					$this.contentChooseSource = callback(this.value);
				}
				var hiddenEle = $this.next("input[name="+hiddenName +"]").first();
				hiddenEle.val($this.contentChooseGetValue($this.val()));
				console.debug("hidden_value="+hiddenEle.val());
			});
			return $this;
		}
	});
})(jQuery);	
