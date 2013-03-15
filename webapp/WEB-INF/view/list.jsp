<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>列表</title>
</head>
<body>
	<ul>
		<c:forEach items="${accounts}" var="account" varStatus="idx">
			<li>登录名：${account.passport}</li>
			<li>昵称：${account.nickName}</li>
			<li>邮箱：${account.email}</li>
			<li>手机：${account.mobile}</li>
			<p/>
		</c:forEach>
	</ul>
</body>
</html>