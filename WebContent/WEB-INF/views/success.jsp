<%@ page language="java" contentType="text/html; utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="<%=request.getContextPath() %>/js/jquery/jquery-1.9.0.min.js"></script>
</head>
<body>
	success
	
	<input type="button" value="退出" onclick="loginout();"/>
</body>
<script type="text/javascript">
function loginout(){
	window.location.href="<%=request.getContextPath()%>/system/user/logout.do";
}
</script>
</html>