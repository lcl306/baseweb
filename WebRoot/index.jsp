<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/WEB-INF/nina_screen.tld" prefix="scr" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
String path = request.getContextPath();
%>
<scr:html html5="true">
<scr:head title="驰立玖玖">
	<script type="text/javascript">
		$(function(){
			$("#loginBtn").bind("click",function(){
				$("form").first().attr("action","<%=path%>/loginCheck.do").submit();
				
			});
		});
	</script>
    <style type="text/css">
        body{
        	/*background-color:#eee;*/
        	background-color:rgb(219,237,255);
        }
    	td{
    		height:50px;
    	}
    	.label-bg{
    		/*background-color:rgb(0,136,204);*/
    		background-color:rgb(132,193,255);
    		width:80px;
    		/*color:white;*/
    	}
    	.title{
    		font-size:20px;
    		margin-top: 10%;
    		padding :15px;
    	}
    </style>
</scr:head>
<scr:body errDiv="errDiv">
    <div style="text-align:center">
    <div class="title">驰立玖玖生产管理系统&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
	<form action="" method="post">
		<table width="20%" class="h-center">
         <tbody>
         <tr>
           <td><label class="label-bg">用户名</label></td>
		   <td><input type="text" name="loginNm" value="" maxlength="10" /></td>
         </tr>
		 <tr>
           <td><label class="label-bg">密码</label></td>
		   <td><input type="password" name="password" value="" maxlength="8" /></td>
         </tr>
		 <tr>
           <td colspan="2" align="center"><input type="button" id="loginBtn" class="btn" 
           onclick="" value="登录" /></td>
         </tr>
         <tr style="text-align:right"><td ><div id="errDiv"></div></td></tr>
         </tbody>
        </table>
	</form>
	</div>
	
</scr:body>
</scr:html>