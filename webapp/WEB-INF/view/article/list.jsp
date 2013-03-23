<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>列表</title>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath%>" />
</head>

<body>
	<h2>文章列表</h2>
	<b><a href="article/new">创建文章</a></b>
	<table>
		<thead>
			<tr>
				<th>标题</th>
				<th>作者</th>
				<th>来源</th>
				<th>访问次数</th>
				<th>最后一次更新</th>
				<th>操作</th>
			</tr>
		</thead>
		<c:forEach items="${articles}" var="article" varStatus="idx">
			<tr>
				<td><c:out value="${article.title}" /></td>
				<td><c:out value="${article.arthur}" /></td>
				<td><c:out value="${article.source}" /></td>
				<td><c:out value="${article.visit}" /></td>
				<td><c:out value="${article.updatedTime}"/></td>
				<td><a href="article/${article.id}/edit" >编辑</a>
			</tr>
		</c:forEach>
	</table>
</body>
</html>