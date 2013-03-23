<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>列表</title>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
		<c:forEach items="${articles.content}" var="article" varStatus="idx">
			<tr>
				<td><c:out value="${article.title}" /></td>
				<td><c:out value="${article.arthur}" /></td>
				<td><c:out value="${article.source}" /></td>
				<td><c:out value="${article.visit}" /></td>
				<td><c:out value="${article.updatedTime}" /></td>
				<td><a href="article/${article.id}/edit">编辑</a>
			</tr>
		</c:forEach>
	</table>
	<div>
		<pg:pager items="${articles.totalElements}" url="article/list" export="currentPageNumber=pageNumber" maxPageItems="3" maxIndexPages="10">
			<pg:first>
				<a href="${pageUrl}">首页</a>
			</pg:first>
			<pg:prev>
				<a href="${pageUrl}">前页</a>
			</pg:prev>
			<pg:pages>
				<c:choose>
					<c:when test="${pageNumber eq currentPageNumber }">
						<font color="red">${pageNumber }</font>
					</c:when>
					<c:otherwise>
						<a href="${pageUrl}">${pageNumber}</a>
					</c:otherwise>
				</c:choose>
			</pg:pages>
			<pg:next>
				<a href="${pageUrl}">下页</a>
			</pg:next>
			<pg:last>
				<a href="${pageUrl}">尾页</a>
			</pg:last>
		</pg:pager>
	</div>
</body>
</html>