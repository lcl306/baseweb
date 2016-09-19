/******************************************************not used*********************************************************/
var optionNames = {
	//moneyType : ["人民币","日元","美元"],
	vendorType : ["供应商","外协单位"],
	//materialType : ["铝合金","锌合金","嵌入件","外购品"],
	//materialType2 : ["铝合金","锌合金","嵌入件"],
	//materialOrigin : ["中国", "日本"],
	//unit : ["个", "kg"],
	//cixing : ["1#","2#","3#","4#"],
	//materialExamine : ["订单采购入库","原料采购入库","原料出库"],
	//productExamine : ["来料加工入库","来料加工出库","毛坯入库","毛坯出库","外购品出库","在制品流转","委外加工出库","委外加工入库","废品交割","成品入库","成品退回跟踪"],
	productType : ["一般产品","来料加工品"],
	//currency : ["人民币", "日元", "美元"],
	//outRemarkType : ["良品备注","返修备注","测试备注","不良备注(胜喜原因)","不良备注(外协原因)"],
	//mouldStatus : ["开发中","制造中","待确认","可用"],
	//machineType : ["取毛边", "机加工", "钝化","阳极氧化"],
	//machineType2: ["350t","500t","CNC","NC"],
	//process : ["压铸", "取毛边", "砂带抛光", "研扫", "整形", "外协", "机加工", "检查捆包"],
	//process2 : ["取毛边", "砂带抛光", "研扫", "整形", "外协", "机加工","检查捆包","成品库"],
	//process6 : ["取毛边", "砂带抛光", "研扫", "整形", "外协", "机加工","检查捆包"],
	//process3 : ["取毛边", "砂带抛光"],
	//process4 : ["外购库","来料加工库","成品库","毛坯库","取毛边","整形","砂带抛光","研扫","机加工","外协","检查捆包","不良品库"],
	//process5 : ["成品库","外购库","来料加工库","毛坯库","取毛边","机加工","外协","整形","砂带抛光","研扫","检查捆包"],
	//process6 : ["取毛边", "砂带抛光", "研扫", "整形", "外协", "机加工","检查捆包"],
	//dieCasting : ["装模","调模","压铸","冲压"],
	//band : ["砂带","砂带+抛光"],
	//shaping : ["整形","打磨","测量","补砂眼"],
	//afterMachining : ["耐压","清洗","打轴套"],
	//bale : ["外观","打磨"],
	//badLType : ["自方", "外方"],
	//badMType : ["压铸", "机加工", "外协", "外购"],
	//badSType : ["外观不良", "尺寸不良", "测量不良", "其它"],
    //badReasons:["划伤","倒角不良","试验品","裂痕","断裂","气泡","砂眼","生锈","空偏","二次加工"],
    //dictType : ["产地", "单位", "结算币种", "加工项目","设备情况", "输入延后天数"],
    //valid : ["使用中","在外协","不使用","确认中", "报废","退还客户","报废退还客户"],
    //batchNo: ["20150001", "20150002", "20150003","20150004","20150009"],
    //userDpt: ["生产管理人员","仓库管理人员","车间文员"],
    //repairMethod: ["返修","选别"],
	//warehouse:["毛坯","外购成品","外购素材"],
    //machineProduceContent:["全部项目","取毛边","铣平面","流水线","铰孔","钝化","阳极氧化"],
    //produceState:["已加工","未加工"],
    //machineInfor:["使用中","报废","外借"],
    //productState:["良品","素材不良","加工不良","试验品","百格品"],
    badDepartment:["胜僖","外协"],
	//takestock:["原料库","成品库","外购库","来料加工库","毛坯库","取毛边","机加工","外协","整形","砂带抛光","研扫","检查捆包","模具","压铸"]
};

function setNameOption(sel, arr){
	$(arr).each(function(){
		$("<option>"+this +"</option>").appendTo($(sel)).addClass($(sel).attr("class"));
	});
}

function setNameOptions(){
	for (attr in optionNames){
		setNameOption($("select[name="+attr+"]"), optionNames[attr]);
	}
}

/*function getMonthEnd(){
var d = new Date();
//d.setMonth(d.getMonth()+1);
return new Date(d.getFullYear(), d.getMonth(), 0).format("yyyy-MM-dd");
}*/

function getMonthFirst() {

	var d = getMonthEnd();
	var s = new Date(d);
	var month = s.getMonth();
	var year = s.getFullYear();
	var day = 1;
	return new Date(year, month, day).format("yyyy-MM-dd");

}
function getNextMonthFirst() {

	var d = getMonthEnd();
	var s = new Date(d);
	var month = s.getMonth();
	var year = s.getFullYear();
	var day = 1;
	return new Date(year, month + 1, day).format("yyyy-MM-dd");

}
function getMonthEnd() {
	var d = new Date();
	var month = d.getMonth();
	var year = d.getFullYear();
	var day = 0;
	/*
	 * if(month==0){ month = 11; year = year -1; day = 20; }
	 */
	d.setMonth(d.getMonth() + 1);

	return new Date(year, d.getMonth(), day).format("yyyy-MM-dd");
}
function getLastMonthEnd() {
	var d = new Date();
	var month = d.getMonth();
	var year = d.getFullYear();
	var day = 0;
	return new Date(year, month, day).format("yyyy-MM-dd");
}

function addToday(el) {
	$(el).val(new Date().format("yyyy-MM-dd"));
}

/******************************************************navigation*********************************************************/
function overMenu(){
	$(".dropdown-menu a").each(function() {
		$(this).bind("mouseover", function() {
			$("a").each(function() {
				$(this).removeClass("menu-bg");
			});
			$(this).addClass("menu-bg");
		});
	});
}

function activeMenu(cls){
  	$(".dropdown-toggle").each(function(){
		$(this).removeClass($(this).attr("class").split(" ")[1]);
	});
	$dropdown = $("."+cls).first().closest(".dropdown");
	$dropdown.children(".dropdown-toggle").addClass($dropdown.find(".dropdown-header").attr("class").split(" ")[1]);
}

$(function(){
	overMenu();
	$(".container:gt(0)").css("overflow-y","auto");
	/*$(".today").each(function(){
		addToday(this);
	});
	$(".monthFirst").val(getMonthFirst()).text(getMonthFirst());
	$(".nextMonthFirst").val(getNextMonthFirst()).text(getNextMonthFirst());
	$(".monthEnd").val(getMonthEnd()).text(getMonthEnd());
	$(".lastMonthEnd").val(getLastMonthEnd()).text(getLastMonthEnd());*/
	//setNameOptions();
	
	/******************************************************css*********************************************************/
	  
	function addAlign(align){
		$("th."+align).each(function(){
			  var $th = $(this);
			  var $table = $th.closest("table");
			  var mc = $th.closest("tr").find("th").length;
			  var mr = $table.find("tr").length;
			  var $tds = $table.find("td");
			  for(var r=0;r<mr;r++){
				  $tds.eq(r*mc+$th.index()).addClass(align);
			  }
		});
	}
	
	function addMust(){
		$(".must").each(function(){
			var pre = "<span style='color:red;'>*&nbsp;</span>";
			var aft ="&nbsp;&nbsp;";
			if($(this).is('th')) aft="";
			$(this).html(pre+$(this).html()+aft);
		});
	}

	function addBackground(){
		$("label,hr").addClass("label-bg");
		$(".list th").addClass("label-bg");
	}
	
	$(".list").trNext();
	
	//$(".list tr:nth-child(odd)").addClass("tr-next");
	addAlign("text-right");
	addAlign("text-center");
	addBackground();
	addMust();
	toEnable();
});

;$.fn.extend({
	trNext : function(){
		var $table = $(this);
		$table.each(function(){
			var rowsCls = $(this).attr("class").match(/\drows/);
			var n = rowsCls?parseFloat(rowsCls[0].charAt(0), 10):1;
			$table.addTrNext(this, n);
		});
	},
	addTrNext : function(tbl, n){
		var trs = $(tbl).find("tr").not($(".inner_table").find("tr"));
		trs.removeClass("tr-next");
		var len = $(tbl).find("thead tr").length;
		for(var i=0; i<trs.length; i++){
			if(i%n==0 && (i+len)%(2*n)>0){
				var start = i+1;
				for(var j=start; j<start+n; j++){
					trs.eq(j).addClass("tr-next");
				}
			}
		}
	}
});

function toDisable(){
	$("input,select").not(".enabled").attr("disabled", true).addClass("disabled");
}

function toEnable(){
	$(".toEnable").bind("click",function(){
		$("input,select").not(".neverEnabled").attr("disabled", false).removeClass("disabled");
	});
}  

/******************************************************copy*********************************************************/
;$.fn.extend({
	toCopy : function(copyContent, cnt, idx,showHidden){
		var $table = idx?$("table").eq(idx):$(this).closest("table");
		var c = cnt?cnt:1;
		var showHiddenRtn=true;
		if(showHidden!=null) showHiddenRtn=showHidden;
		//var $tr = $table.find("tr").eq(1);
		var $tr = $table.find("tr:gt(0):lt("+c+")");
		if(showHiddenRtn && $tr.is(":hidden")){
			$tr.find("input").not(":button").val("");
			$tr.find("span").text("");
			$tr.show();
		}else{
			var $trC;
			if(!copyContent){
				$trC =$tr.clone(true);
				$trC.find("input").not(":button").val("").attr("checked", false);
				$trC.find("span").text("");
				$trC.find("option").removeAttr("selected");
			}else{
				var ci = $(this).closest("tr").index();
				$trC = $table.find("tr:lt("+(ci+c)+"):gt("+(ci-1)+")").clone(true);
				//$trC =$(this).closest("tr").clone(true);
			}
			$radio = $trC.find(":radio");
			$radio.each(function(){
				$radio.attr("name", $radio.attr("name")+"_"+($table.find("tr").length));
			});
			$trC.find(".del,.remove").show();
			$trC.find(".day").removeAttr("id").removeClass("hasDatepicker").datepicker({
				onClear : function(input) {
					input.val("");
				}
			}).attr({
				"readonly" : true
			});
			$trC.find(".today").each(function(){
				addToday(this);
			});
			$table.find("tbody").append($trC);
			$tr = $trC;
		}
		$table.trNext();
		return $tr;
	},
	toDel : function(cnt){
		var c = cnt?cnt:1;
		var ci = $(this).closest("tr").index();
		var $tr = $(this).closest("table").find("tr:lt("+(ci+c)+"):gt("+(ci-1)+")");
		var $table =$(this).closest("table");
		if($tr.first().index()==1){
			$tr.hide();
		}else{
			$tr.remove();
		}
			$table.trNext();
		/*$tr = $(this).closest("tr");
		if($tr.index()==1){
			$tr.hide();
		}else{
			$tr.remove();
		}*/
	}
});

/******************************************************popup*********************************************************/
function delConfirm(callback){
	boxConfirm("<span style='font-size:14px;'>是否删除？</span>", callback);
}

function openProductPop(productCd,css,index,customerCd,valid,doBack,productType,outPurchase){
	wOpener.clear();
	wOpener.doBack=doBack;
	if(index==null||typeof(index) == "undefined") index='0';
	if(customerCd==null||typeof(customerCd) == "undefined") customerCd='';
	if(valid==null||typeof(valid) == "undefined") valid='';
	if(productType==null||typeof(productType) == "undefined") productType='';
	if(outPurchase==null||typeof(outPurchase) == "undefined") outPurchase='';
	wOpener.openWin("../../popup/productPopup/list.do?css="+css+"&index="+index+"&productCd="+encodeURIComponent(productCd)+"&customerCd="+customerCd+"&valid="+valid+"&productType="+productType+"&outPurchase="+outPurchase,null,700,new Date());
	
}

function openCustomerPop(customerCd,css,index,doBack,valid){
	wOpener.clear();
	wOpener.doBack=doBack;
	if(index==null||typeof(index) == "undefined") index='0';
	if(valid==null||typeof(valid) == "undefined") valid='';
	wOpener.openWin("../../popup/customerPopup/list.do?css="+css+"&index="+index+"&customerCd="+customerCd+"&valid="+valid,null,700,new Date());
	
}

function openOutSourcePop(vendorCd,css,index,valid,doBack){
	wOpener.clear();
	wOpener.doBack=doBack;
	if(index==null||typeof(index) == "undefined") index='0';
	if(valid==null||typeof(valid) == "undefined") valid='';
	wOpener.openWin("../../popup/outsourcePopup/list.do?css="+css+"&index="+index+"&valid="+valid+"&vendorCd="+vendorCd,null,700,new Date());
	
}

function openMaterialPop(materialCd,css,index,doBack){
	wOpener.clear();
	wOpener.doBack=doBack;
	wOpener.clear();
	if(index==null||typeof(index) == "undefined") index='0';
	  wOpener.openWin("../../popup/materialPopup/list.do?css="+css+"&index="+index+"&materialCd="+encodeURIComponent(materialCd),null,700,new Date());
}

/*materialType='embed'弹出嵌入件弹框
 * materialType='all'原料弹出框，包含原料，嵌入件信息
 * materialType='alAu'原料弹出框，只包含铝合金信息
 * materialType='znAu'原料弹出框，只包含锌合金信息
 * 其他 原料弹出框，包含锌合金，锌合金信息
 * */
function openMaterialPop2(materialCd,css,index,materialType,valid,doBack,vendorCd){
	
	wOpener.clear();
	wOpener.doBack=doBack;
	wOpener.clear();
	if(index==null||typeof(index) == "undefined") index='0';
	if(valid==null||typeof(valid) == "undefined") valid='';
	if(vendorCd==null||typeof(vendorCd) == "undefined") vendorCd='';
	wOpener.openWin("../../popup/materialPopup/list.do?css="+css+"&index="+index+"&materialCd="+materialCd+"&materialType="+materialType+"&valid="+valid+"&vendorCd="+vendorCd,null,700);
}

function openVendorPop(vendorCd,css,index,doBack,venType){
	wOpener.clear();
	wOpener.doBack=doBack;
	wOpener.clear();
	if(index==null||typeof(index) == "undefined") index='0';
	  wOpener.openWin("../../popup/vendorPopup/venInit.do?css="+css+"&index="+index+"&vendorCd="+vendorCd+"&venType="+venType,null,700,new Date());
}

function openEmbedPop(embedCd,css,index,doBack){
	wOpener.clear();
	wOpener.doBack=doBack;
	wOpener.clear();
	if(index==null||typeof(index) == "undefined") index='0';
	  wOpener.openWin("../../popup/materialPopup/list.do?css="+css+"&index="+index+"&materialCd="+embedCd+"&materialType=embed",null,700,new Date());
}

/*******************************************************************datatable*************************************************************************/
function dataTableDrawBack(){
	trBgResort();
}
function trBgResort(){
	$(".list").trNext();
	/*$(".list tr:nth-child(odd)").removeClass("tr-next");
	$(".list tr:nth-child(even)").addClass("tr-next");*/
}

function datatable(noSortTagets,initSortTagets){
	dataTables('.orderTable',noSortTagets,initSortTagets);
}
