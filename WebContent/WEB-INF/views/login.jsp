<%@ page language="java" contentType="text/html; utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="<%=request.getContextPath() %>/js/jquery/jquery-1.9.0.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<!-- <input id="name"  type="text" />name
	<input id="pwd"  type="password" />passwd
	<input type="button" value="登录" onclick="login();"/> -->
	<!-- <input type="button" value="随机数" onclick="getramdom(3);"/>
	<div id="testtime" style="color:red;"></div>
	<button onclick="testTime()">抽奖优惠</button> -->
	  <ul>
        <li>姓　名：<input id="name"  type="text" /> </li>
        <li>密　码：<input id="pwd"  type="password" /> </li>
        <li>验证码：<input type="text" id="validateCode" name="validateCode" />&nbsp;&nbsp;<img id="validateCodeImg" src="<%=request.getContextPath()%>/system/user/validateCode.do" />&nbsp;&nbsp;<a href="#" onclick="javascript:reloadValidateCode();">看不清？</a></li>
        <li><input type="button" value="登录" onclick="login();"/> </li>
        <li><input type="button" value="测试" onclick="transaction();"/> </li>
    </ul>
</body>
<script type="text/javascript">
var msg="${msg}";
$(function(){
	if(msg!=null&&msg!=""){
		alert(msg);
		$("#name").val("");
		$("#pwd").val("");
	}
});
	function login(){
		window.location.href="<%=request.getContextPath()%>/system/user/login.do?name="+$("#name").val()+"&pwd="+$("#pwd").val()+"&validateCode="+$("#validateCode").val();
	}
	function transaction(){
		window.location.href="<%=request.getContextPath()%>/system/user/transaction.do";
	}
	function getramdom(min){
        alert(parseInt(Math.random()*(min)));
    }
	 function testTime() {
	        document.getElementById("testtime").innerHTML = "您可以享受" + "" + b + "" + "折";

	    }
	 function reloadValidateCode(){
	        $("#validateCodeImg").attr("src","<%=request.getContextPath()%>/system/user/validateCode.do?data=" + new Date() + Math.floor(Math.random()*24));
	    }
</script>
</html>