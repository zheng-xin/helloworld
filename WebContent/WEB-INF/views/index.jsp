<%@ page language="java" contentType="text/html; utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %> 
<script src="<%=request.getContextPath() %>/js/jquery/jquery-1.9.0.min.js"></script>
</head>
<body>
	<input id="name"  type="text" />姓名
	<input id="pwd"  type="password" />密码
	<shiro:hasPermission name="user:add">  
		<input type="button" value="添加" onclick="adduser();"/>
    </shiro:hasPermission>  
    <input type="button" value="发送" onclick="send();"/>
</body>
<script type="text/javascript">
var msg="${msg}";
$(function(){
	if(msg!=null&&msg!=""){
		alert(msg);	
	}
});
	function adduser(){
		window.location.href="<%=request.getContextPath()%>/system/user/add.do?name="+$("#name").val()+"&pwd="+$("#pwd").val();
	}
	function send(){
		window.location.href="<%=request.getContextPath()%>/system/jms/send.do";
	}
</script>
</html>