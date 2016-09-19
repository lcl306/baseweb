package com.it.apps.nina._share.tag;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.it.apps.nina._share.bo.MenuDto;
import com.it.apps.nina._share.bo.NinaSystemDto;
import com.it.common.component.log.LogPrint;
import com.it.common.share.GlobalName;


public class NinaMenuTag extends TagSupport {
	
	private static final long serialVersionUID = 6946430167865506635L;
	
	public static final String SESSION_ID_NAME = "sessionId";
	
	public static final String COMPANY_IMAGE_URL ="company_image_url";
	
	public static final String COMPANY_LOGO_NM ="company_logo_nm";

	public int doEndTag() throws JspException {
		HttpServletRequest request = (HttpServletRequest) this.pageContext.getRequest();
		NinaSystemDto so = NinaSystemDto.getInstance(request);
		try {
			if(so!=null){
				this.pageContext.getOut().print(getMenuStr(so));
				this.pageContext.getOut().println("<script language=javascript>activeMenu('" +this.pageContext.getAttribute("bg_land") + "')</script>");
			}
		} catch (IOException e) {
			LogPrint.error(e.getMessage());
			e.printStackTrace();
		}
		return TagSupport.EVAL_PAGE;
	}
	
	public static String getMenuStr(NinaSystemDto so){
		Map<String, MenuDto> menuMap = pathMenus(so);
		StringBuilder builder = new StringBuilder();
		builder.append("    <div class=\"navbar navbar-fixed-top\" role=\"navigation\">");
		builder.append("      <div class=\"container\">");
		builder.append("        <span class=\"navbar-brand\">驰立玖玖生产管理系统</span>");
		builder.append("        <div class=\"navbar-collapse\">");
		builder.append("         <ul class=\"nav navbar-nav\">");
		builder.append("			<li id=\"1.2\" class=\"dropdown\">");
		builder.append("			   <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">采购管理<span class=\"caret\"></span></a>");
		builder.append("			   <ul class=\"dropdown-menu\" role=\"menu\">");
		builder.append("			    <li id=\"1.2.10\" class=\"dropdown-header purchase\">采购管理</li>");
		builder.append(getMenuLi(menuMap, "1.2.10.100", "init.do"));//builder.append("             <li id=\"1.2.10.100\"><a href=\""+menuMap.get("1.2.10.100")+"/nina/purchase/materialPurchasePrint/init.do\">嵌入件采购计划</a></li>");
		builder.append(getMenuLi(menuMap, "1.2.10.200", "init.do"));//builder.append("             <li id=\"1.2.10.200\"><a href=\""+menuMap.get("1.2.10.200")+"/nina/purchase/outsourcingPurchasePrint/init.do\">外购品采购计划</a></li>");
		builder.append(getMenuLi(menuMap, "1.2.10.300", "init.do"));//builder.append("             <li id=\"1.2.10.300\"><a href=\""+menuMap.get("1.2.10.300")+"/nina/purchase/materialPurchase/init.do\">嵌入件采购</a></li>");
		builder.append(getMenuLi(menuMap, "1.2.10.400", "init.do"));//builder.append("             <li id=\"1.2.10.400\"><a href=\""+menuMap.get("1.2.10.400")+"/nina/purchase/outsourcingPurchase/init.do\">外购品采购</a></li>");
		builder.append(getMenuLi(menuMap, "1.2.10.450", "init.do"));
		builder.append(getMenuLi(menuMap, "1.2.10.500", "init.do"));//builder.append("             <li id=\"1.2.10.500\"><a href=\""+menuMap.get("1.2.10.500")+"/nina/purchase/purchaseSettleAccounts/init.do\">嵌入件结算</a></li>");
		builder.append(getMenuLi(menuMap, "1.2.10.600", "init.do"));//builder.append("             <li id=\"1.2.10.600\"><a href=\""+menuMap.get("1.2.10.600")+"/nina/purchase/outsourcingAccounts/init.do\">外购品结算</a></li>");
		builder.append(getMenuLi(menuMap, "1.2.10.700", "init.do"));//builder.append("				<li id=\"1.2.10.700\"><a href=\""+menuMap.get("1.2.10.700")+"/nina/purchase/purchaseMonthDetail/init.do\">采购月明细统计</a></li>");
		builder.append("				<li id=\"1.2.20\" class=\"dropdown-header purchase\">委外加工管理</li>");
		builder.append(getMenuLi(menuMap, "1.2.20.100", "init.do"));//builder.append("             <li id=\"1.2.20.100\"><a href=\""+menuMap.get("1.2.20.100")+"/nina/purchase/outsourcingSettle/init.do\">委外加工结算</a></li>");
		builder.append(getMenuLi(menuMap, "1.2.20.200", "init.do"));//builder.append("				<li id=\"1.2.20.200\"><a href=\""+menuMap.get("1.2.20.200")+"/nina/purchase/outprocessingMonthDetail/init.do\">委外加工月明细统计</a></li>");
		builder.append("			    <li id=\"1.2.30\" class=\"dropdown-header purchase\">采购统计</li>");
		builder.append(getMenuLi(menuMap, "1.2.30.100", "init.do"));//builder.append("				<li  id=\"1.2.30.100\"><a href=\""+menuMap.get("1.2.30.100")+"/nina/purchase/vendorYearStatistics/init.do\">供应商别年间采购金额统计</a></li>");
		builder.append("            </ul>");
		builder.append("			</li>");
		builder.append("         <li id=\"1.3\" class=\"dropdown\">");
		builder.append("			   <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">销售管理<span class=\"caret\"></span></a>");
		builder.append("			   <ul class=\"dropdown-menu\" role=\"menu\">");
		builder.append("			    <li id=\"1.3.10\" class=\"dropdown-header sale\">订单管理</li>");
		builder.append(getMenuLi(menuMap, "1.3.10.100", "init.do"));
		builder.append(getMenuLi(menuMap, "1.3.10.200", "toInit.do"));
		builder.append(getMenuLi(menuMap, "1.3.10.300", "toInit.do"));//builder.append("             <li id=\"1.3.10.300\"><a href=\""+menuMap.get("1.3.10.300")+"/nina/sale/orderSearch/toInit.do\">订单查询</a></li>");
		builder.append(getMenuLi(menuMap, "1.3.10.400", "init.do"));//builder.append("				<li id=\"1.3.10.400\"><a href=\""+menuMap.get("1.3.10.400")+"/nina/sale/billConfirm/init.do\">开票对账确定</a></li>");
		builder.append(getMenuLi(menuMap, "1.3.10.500", "toInit.do"));//builder.append("             <li id=\"1.3.10.500\"><a href=\""+menuMap.get("1.3.10.500")+"/nina/sale/receipt/toInit.do\">开票信息输入</a></li>");
		builder.append(getMenuLi(menuMap, "1.3.10.600", "init.do"));
		builder.append("				<li id=\"1.3.20\" class=\"dropdown-header sale\">销售统计</li>");
		builder.append(getMenuLi(menuMap, "1.3.20.100", "toInit.do"));//builder.append("             <li id=\"1.3.20.100\"><a href=\""+menuMap.get("1.3.20.100")+"/nina/sale/productMonthStatistics/toInit.do\">产品别月间统计</a></li>");
		builder.append(getMenuLi(menuMap, "1.3.20.200", "init.do"));//builder.append("             <li id=\"1.3.20.200\"><a href=\""+menuMap.get("1.3.20.200")+"/nina/sale/productYearStatistics/init.do\">产品别年间统计</a></li>");
		builder.append(getMenuLi(menuMap, "1.3.20.300", "init.do"));//builder.append("             <li id=\"1.3.20.300\"><a href=\""+menuMap.get("1.3.20.300")+"/nina/sale/customerYearStatistics/init.do\">客户别年间统计</a></li>");
		builder.append("            </ul>");
		builder.append("			</li>");
		builder.append("			<li id=\"1.4\" class=\"dropdown\">");
		builder.append("			   <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">生产管理<span class=\"caret\"></span></a>");
		builder.append("			   <ul class=\"dropdown-menu\" role=\"menu\">");
		builder.append("			    <li id=\"1.4.10\" class=\"dropdown-header make\">生产计划</li>");
		builder.append(getMenuLi(menuMap, "1.4.10.100", "init.do"));//builder.append("             <li id=\"1.4.10.100\"><a href=\""+menuMap.get("1.4.10.100")+"/nina/make/planSearch/init.do\">订单计划查询</a></li>");
		builder.append(getMenuLi(menuMap, "1.4.10.200", "init.do"));//builder.append("             <li id=\"1.4.10.200\"><a href=\""+menuMap.get("1.4.10.200")+"/nina/make/makePlan/init.do\" >生产计划制定</a></li>");
		builder.append(getMenuLi(menuMap, "1.4.10.300", "toInit.do"));//builder.append("             <li id=\"1.4.10.300\"><a href=\""+menuMap.get("1.4.10.300")+"/nina/make/planConfirm/toInit.do\">生产计划确定</a></li>");
		builder.append("			    <li id=\"1.4.20\" class=\"dropdown-header make\">生产查询</li>");
		builder.append(getMenuLi(menuMap, "1.4.20.100", "init.do"));//builder.append("             <li id=\"1.4.20.100\"><a href=\""+menuMap.get("1.4.20.100")+"/nina/make/planMaterial/init.do\">领料查询</a></li>");
		builder.append(getMenuLi(menuMap, "1.4.20.200", "init.do"));//builder.append("				<li id=\"1.4.20.200\"><a href=\""+menuMap.get("1.4.20.200")+"/nina/make/dieCastingWeight/init.do\">压铸重量查询</a></li>");
		builder.append(getMenuLi(menuMap, "1.4.20.300", "init.do"));//builder.append("				<li id=\"1.4.20.300\"><a href=\""+menuMap.get("1.4.20.300")+"/nina/make/monthMaterialSearch/init.do\">月用料查询</a></li>");
		builder.append(getMenuLi(menuMap, "1.4.20.400", "init.do"));//builder.append("				<li id=\"1.4.20.400\"><a href=\""+menuMap.get("1.4.20.400")+"/nina/make/productProduce/init.do\">产品生产查询</a></li>");
		builder.append("			    <li id=\"1.4.30\" class=\"dropdown-header make\">模具管理</li>");
		builder.append(getMenuLi(menuMap, "1.4.30.100", "init.do"));//builder.append("             <li id=\"1.4.30.100\"><a href=\""+menuMap.get("1.4.30.100")+"/nina/make/mould/init.do\">模具管理</a></li>");
		builder.append("            </ul>");
		builder.append("			</li>");
		builder.append("			<li id=\"1.8\" class=\"dropdown\">");
		builder.append("			   <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">日报管理<span class=\"caret\"></span></a>");
		builder.append("			   <ul class=\"dropdown-menu\" role=\"menu\">");
		builder.append("			    <li id=\"1.8.10\" class=\"dropdown-header make\">日报管理</li>");
		builder.append(getMenuLi(menuMap, "1.8.10.100", "init.do"));
		builder.append(getMenuLi(menuMap, "1.8.10.200", "init.do"));
		builder.append(getMenuLi(menuMap, "1.8.10.300", "init.do"));
		builder.append(getMenuLi(menuMap, "1.8.10.400", "init.do"));
		builder.append(getMenuLi(menuMap, "1.8.10.500", "init.do"));
		builder.append("			    <li id=\"1.8.20\" class=\"dropdown-header make\">生产统计</li>");
		builder.append(getMenuLi(menuMap, "1.8.20.100", "init.do"));
		builder.append(getMenuLi(menuMap, "1.8.20.150", "init.do"));
		builder.append(getMenuLi(menuMap, "1.8.20.200", "init.do"));
		builder.append(getMenuLi(menuMap, "1.8.20.300", "init.do"));
		builder.append(getMenuLi(menuMap, "1.8.20.400", "init.do"));
		builder.append(getMenuLi(menuMap, "1.8.20.500", "init.do"));
		builder.append(getMenuLi(menuMap, "1.8.20.600", "init.do"));
		builder.append(getMenuLi(menuMap, "1.8.20.700", "init.do"));
		builder.append("			    <li id=\"1.8.30\" class=\"dropdown-header make\">生产进度</li>");
		builder.append(getMenuLi(menuMap, "1.8.30.100", "init.do"));
		builder.append("            </ul>");
		builder.append("			</li>");
		builder.append("			<li id=\"1.5\" class=\"dropdown\">");
		builder.append("			   <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">库存管理<span class=\"caret\"></span></a>");
		builder.append("			   <ul class=\"dropdown-menu\" role=\"menu\">");
		builder.append("			    <li id=\"1.5.10\" class=\"dropdown-header ware\">库存查询</li>");
		builder.append(getMenuLi(menuMap, "1.5.10.100", "init.do"));//builder.append("			    <li id=\"1.5.10.100\"><a href=\""+menuMap.get("1.5.10.100")+"/nina/ware/departmentMonthWareInout/init.do\">部门别月出入库查询</a></li>");
		builder.append(getMenuLi(menuMap, "1.5.10.200", "init.do"));//builder.append("             <li id=\"1.5.10.200\"><a href=\""+menuMap.get("1.5.10.200")+"/nina/ware/materialMonthAccessWarehouse/init.do\">原料月出入库查询</a></li>");
		builder.append(getMenuLi(menuMap, "1.5.10.300", "init.do"));//builder.append("				<li id=\"1.5.10.300\"><a href=\""+menuMap.get("1.5.10.300")+"/nina/ware/materialStoreSearch/init.do\">原料库存查询</a></li>");
		builder.append(getMenuLi(menuMap, "1.5.10.400", "init.do"));//builder.append("				<li id=\"1.5.10.400\"><a href=\""+menuMap.get("1.5.10.400")+"/nina/ware/productStoreSearch/init.do\">产品库存查询</a></li>");
		builder.append(getMenuLi(menuMap, "1.5.10.500", "init.do"));//builder.append("				<li id=\"1.5.10.500\"><a href=\""+menuMap.get("1.5.10.500")+"/nina/ware/rejectsSearch/init.do\">不良品查询</a></li>");
		builder.append(getMenuLi(menuMap, "1.5.10.600", "init.do"));//builder.append("				<li id=\"1.5.10.600\"><a href=\""+menuMap.get("1.5.10.600")+"/nina/ware/rejectsStatistics/init.do\">不良品统计</a></li>");
		builder.append("				<li id=\"1.5.20\" class=\"dropdown-header ware\">盘点管理</li>");
		builder.append(getMenuLi(menuMap, "1.5.20.100", "init.do"));//builder.append("             <li id=\"1.5.20.100\"><a href=\""+menuMap.get("1.5.20.100")+"/nina/ware/takeStockPrint/init.do\">盘点表打印</a></li>");
		builder.append(getMenuLi(menuMap, "1.5.20.200", "init.do"));//builder.append("				<li id=\"1.5.20.200\"><a href=\""+menuMap.get("1.5.20.200")+"/nina/ware/takeStockInsert/init.do\">盘点输入</a></li>");
		builder.append(getMenuLi(menuMap, "1.5.20.300", "init.do"));//builder.append("				<li id=\"1.5.20.300\"><a href=\""+menuMap.get("1.5.20.300")+"/nina/ware/takeStockStatistics/init.do\">盘点统计</a></li>");
		builder.append("            </ul>");
		builder.append("			</li>");
		builder.append("			<li id=\"1.6\" class=\"dropdown\">");
		builder.append("            <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">出入库管理<span class=\"caret\"></span></a>");
		builder.append("            <ul class=\"dropdown-menu\" role=\"menu\">");
		builder.append("             <li id=\"1.6.10\" class=\"dropdown-header wareto\">来料加工</li>");
		builder.append(getMenuLi(menuMap, "1.6.10.100", "init.do"));//builder.append("				<li id=\"1.6.10.100\"><a href=\""+menuMap.get("1.6.10.100")+"/nina/wareto/comeMaterialStockin/init.do\">来料加工入库</a></li>");
		builder.append(getMenuLi(menuMap, "1.6.10.200", "init.do"));//builder.append("             <li id=\"1.6.10.200\"><a href=\""+menuMap.get("1.6.10.200")+"/nina/wareto/suppliedWareto/init.do\">来料加工出库</a></li>");
		builder.append("             <li id=\"1.6.20\" class=\"dropdown-header wareto\">一般产品</li>");
		builder.append(getMenuLi(menuMap, "1.6.20.100", "toInit.do"));//builder.append("             <li id=\"1.6.20.100\"><a href=\""+menuMap.get("1.6.20.100")+"/nina/wareto/orderPurchase/toInit.do\">订单采购入库</a></li>");
		builder.append(getMenuLi(menuMap, "1.6.20.150", "toInit.do"));//builder.append("             <li id=\"1.6.20.150\"><a href=\""+menuMap.get("1.6.20.150")+"/nina/wareto/waretoVirtual/toInit.do\">虚拟入库</a></li>");
		builder.append(getMenuLi(menuMap, "1.6.20.200", "init.do"));//builder.append("             <li id=\"1.6.20.200\"><a href=\""+menuMap.get("1.6.20.200")+"/nina/wareto/materialWaretoPurchase/init.do\">原料采购入库</a></li>");
		builder.append(getMenuLi(menuMap, "1.6.20.300", "toInit.do"));//builder.append("             <li id=\"1.6.20.300\"><a href=\""+menuMap.get("1.6.20.300")+"/nina/wareto/materialStockOut/toInit.do\">原料出库</a></li>");
		builder.append(getMenuLi(menuMap, "1.6.20.400", "toInit.do"));//builder.append("				<li id=\"1.6.20.400\"><a href=\""+menuMap.get("1.6.20.400")+"/nina/wareto/rawMaterialStockin/toInit.do\">毛坯入库</a></li>");
		builder.append(getMenuLi(menuMap, "1.6.20.500", "init.do"));//builder.append("             <li id=\"1.6.20.500\"><a href=\""+menuMap.get("1.6.20.500")+"/nina/wareto/materialWareto/init.do\">毛坯出库</a></li>");
		builder.append(getMenuLi(menuMap, "1.6.20.600", "init.do"));//builder.append("             <li id=\"1.6.20.600\"><a href=\""+menuMap.get("1.6.20.600")+"/nina/wareto/outsourcingWareto/init.do\">外购品出库</a></li>");
		builder.append("             <li id=\"1.6.30\" class=\"dropdown-header wareto\">流转</li>");
		builder.append(getMenuLi(menuMap, "1.6.30.100", "init.do"));//builder.append("             <li id=\"1.6.30.100\"><a href=\""+menuMap.get("1.6.30.100")+"/nina/wareto/processingMove/init.do\">在制品流转</a></li>");
		builder.append(getMenuLi(menuMap, "1.6.30.200", "init.do"));//builder.append("             <li id=\"1.6.30.200\"><a href=\""+menuMap.get("1.6.30.200")+"/nina/wareto/outProcessingDeliver/init.do\">委外加工出库</a></li>");
		builder.append(getMenuLi(menuMap, "1.6.30.300", "init.do"));//builder.append("             <li id=\"1.6.30.300\"><a href=\""+menuMap.get("1.6.30.300")+"/nina/wareto/outProcessingReceive/init.do\">委外加工入库</a></li>");
		builder.append(getMenuLi(menuMap, "1.6.30.400", "init.do"));//builder.append("             <li id=\"1.6.30.400\"><a href=\""+menuMap.get("1.6.30.400")+"/nina/wareto/scrapDelivery/init.do\">废品交割</a></li>");
		builder.append(getMenuLi(menuMap, "1.6.30.500", "init.do"));//builder.append("             <li id=\"1.6.30.500\"><a href=\""+menuMap.get("1.6.30.500")+"/nina/wareto/productStorage/init.do\">成品入库</a></li>");
		builder.append(getMenuLi(menuMap, "1.6.30.600", "init.do"));//builder.append("             <li id=\"1.6.30.600\"><a href=\""+menuMap.get("1.6.30.600")+"/nina/wareto/productReturnTrack/init.do\">成品退回跟踪</a></li>");
		builder.append("            </ul>");
		builder.append("            </li>");
		builder.append("         <li id=\"1.7\" class=\"dropdown\">");
		builder.append("            <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">基础管理<span class=\"caret\"></span></a>");
		builder.append("            <ul class=\"dropdown-menu\" role=\"menu\">");
		builder.append("             <li id=\"1.7.10\" class=\"dropdown-header setting\">外联单位管理</li>");
		builder.append(getMenuLi(menuMap, "1.7.10.100", "init.do"));//builder.append("             <li id=\"1.7.10.100\"><a href=\""+menuMap.get("1.7.10.100")+"/nina/setting/customer/init.do\">客户管理</a></li>");
		builder.append(getMenuLi(menuMap, "1.7.10.200", "init.do"));//builder.append("				<li id=\"1.7.10.200\"><a href=\""+menuMap.get("1.7.10.200")+"/nina/setting/vendor/init.do\">供应商管理</a></li>");
		builder.append(getMenuLi(menuMap, "1.7.10.300", "init.do"));//builder.append("             <li id=\"1.7.10.300\"><a href=\""+menuMap.get("1.7.10.300")+"/nina/setting/outsource/init.do\">委外价格管理</a></li>");
		builder.append("             <!-- <li class=\"divider\"></li>-->");
		builder.append("             <li id=\"1.7.20\" class=\"dropdown-header setting\">原料产品管理</li>");
		builder.append(getMenuLi(menuMap, "1.7.20.100", "init.do"));//builder.append("             <li id=\"1.7.20.100\"><a href=\""+menuMap.get("1.7.20.100")+"/nina/setting/material/init.do\">原料管理</a></li>");
		builder.append(getMenuLi(menuMap, "1.7.20.200", "init.do"));//builder.append("             <li id=\"1.7.20.200\"><a href=\""+menuMap.get("1.7.20.200")+"/nina/setting/product/init.do\">产品管理</a></li>");
		builder.append(getMenuLi(menuMap, "1.7.20.300", "init.do"));//builder.append("             <li id=\"1.7.20.300\"><a href=\""+menuMap.get("1.7.20.300")+"/nina/setting/productPrice/init.do\">产品价格管理</a></li>");
		builder.append("             <li id=\"1.7.30\" class=\"dropdown-header setting\">生产基础信息管理</li>");
		builder.append(getMenuLi(menuMap, "1.7.30.100", "list.do"));//builder.append("             <li id=\"1.7.30.100\"><a href=\""+menuMap.get("1.7.30.100")+"/nina/setting/process/list.do\">基础工序管理</a></li>");
		builder.append(getMenuLi(menuMap, "1.7.30.200", "init.do"));//builder.append("             <li id=\"1.7.30.200\"><a href=\""+menuMap.get("1.7.30.200")+"/nina/setting/productProcess/init.do\">产品工序管理</a></li>");
		builder.append(getMenuLi(menuMap, "1.7.30.300", "init.do"));//builder.append("             <li id=\"1.7.30.300\"><a href=\""+menuMap.get("1.7.30.300")+"/nina/setting/machine/init.do\">设备管理</a></li>");
		builder.append(getMenuLi(menuMap, "1.7.30.400", "toInit.do"));//builder.append("             <li id=\"1.7.30.400\"><a href=\""+menuMap.get("1.7.30.400")+"/nina/setting/badReasons/toInit.do\">不良原因管理</a></li>");
		builder.append(getMenuLi(menuMap, "1.7.30.450", "toInit.do"));//builder.append("             <li id=\"1.7.30.450\"><a href=\""+menuMap.get("1.7.30.450")+"/nina/setting/takeStockPermission/toInit.do\">盘点期限管理</a></li>");
		builder.append(getMenuLi(menuMap, "1.7.30.500", "toInit.do"));//builder.append("             <li id=\"1.7.30.500\"><a href=\""+menuMap.get("1.7.30.500")+"/nina/setting/dict/toInit.do\">名称管理</a></li>");
		builder.append(getMenuLi(menuMap, "1.7.30.600", "init.do"));
		builder.append(getMenuLi(menuMap, "1.7.30.700", "init.do"));
		builder.append("             <li id=\"1.7.40\" class=\"dropdown-header setting\">用户权限管理</li>");
		builder.append(getMenuLi(menuMap, "1.7.40.100", "init.do"));//builder.append("             <li id=\"1.7.40.100\"><a href=\""+menuMap.get("1.7.40.100")+"/nina/setting/user/init.do\">用户管理</a></li>");
		builder.append("             <li id=\"1.7.50\" class=\"dropdown-header setting\">个人信息管理</li>");
		builder.append(getMenuLi(menuMap, "1.7.50.100", "init.do"));
		builder.append("            </ul>");
		builder.append("         </li>");
		builder.append("			<li id=\"logout2\"><a id=\"logout\" href=\""+so.getBaseUrl()+"/logout.do\">退出</a></li>");
		builder.append("       </ul>");
		builder.append("       <span class=\"title\"><image class=\"image\" src=\""+so.getImageUrl()+GlobalName.appResources.getString(COMPANY_IMAGE_URL)+GlobalName.appResources.getString(COMPANY_LOGO_NM)+"\"/></span>");
		builder.append("     </div><!--/.nav-collapse -->");
		builder.append("   </div><!-- container-->");
		builder.append(" </div><!-- navbar -->");
		builder.append("<script>$(function(){");
		builder.append("$('li').hide();$(\"li[id='logout2']\").show();");		
		Set<String> activeMenuPath=so.getActiveMenuPath();
		for (String menuPath : activeMenuPath) {
			builder.append("$(\"li[id='"+menuPath+ "']\").show();");
			builder.append("$(\"li[id='"+parentPath(menuPath)+ "']\").show();");
			builder.append("$(\"li[id='"+parentPath(parentPath(menuPath))+ "']\").show();");
		}
		builder.append("});");
		builder.append("var httpData2post ={}; httpData2post."+SESSION_ID_NAME+" = '"+so.getSessionId()+"';");
		//builder.append("var navf=$(\"<form>\").appendTo(\"body\"); navf.append('<input type=\"hidden\" name=\"sessionId\" value=\""+so.getSessionId() +"\">').attr('method','post');");
		builder.append("function goUrlByNav(url){postHttpData(url, httpData2post);}");
		builder.append("</script>");
		return builder.toString();
	}
	
	private static String getMenuLi(Map<String, MenuDto> menuMap, String menuPath, String firstMethod){
		MenuDto m = menuMap.get(menuPath);
		if(m==null) return "";
		return "<li id=\""+menuPath+ "\"><a href=\"javascript:void(0)\" onclick=\"goUrlByNav('"+m.getAppUrl()+NinaScrHeadTag.PRODUCT_DIR+m.getMenuUrl()+"/"+firstMethod+ "')\">"+m.getMenuNm()+ "</a></li>";
	}
	
	private static Map<String,MenuDto> pathMenus(NinaSystemDto so){
		Map<String, MenuDto> map = new HashMap<String, MenuDto>();
		if(so!=null && so.getMenus()!=null){
			for(MenuDto m : so.getMenus().values()){
				map.put(m.getMenuPath(), m);
			}
		}
		return map;
	}
	
	private static String parentPath(String path){
		if(path==null) return "";
		int index=path.lastIndexOf(".");
		if(index<=0){
			return "";
		}
		return path.substring(0, index);
	}

}
