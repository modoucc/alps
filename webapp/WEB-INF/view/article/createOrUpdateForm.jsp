<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html lang="cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文章</title>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath%>" />
<script charset="utf-8" src="js/jquery-1.9.1.min.js"></script>
</head>
<body>
	<script charset="utf-8" src="js/kindeditor-4.1.5/kindeditor-min.js"></script>
	<script charset="utf-8" src="js/kindeditor-4.1.5/lang/zh_CN.js"></script>
	<script>
		var editor;
		KindEditor.ready(function(K) {
			editor = K.create('textarea[name="content"]', {
				resizeType : 1,
				allowPreviewEmoticons : false,
				allowImageUpload : false,
			});
		});
	</script>

	<div class="container">

		<h2>
			<c:choose>
				<c:when test="${article['id']==null}">
					<c:out value="新建文章" />
				</c:when>
				<c:otherwise>
					<c:out value="修改文章" />
				</c:otherwise>
			</c:choose>
		</h2>

		<form:form modelAttribute="article" method="post">
			<div class="control-group" id="owner">
				<label class="control-label" id="title">标题 </label>
				<form:input path="title" items="${title}" />
				<form:errors path="title" />
			</div>
			<div class="control-group" id="owner">
				<label class="control-label">作者 </label>
				<form:input path="arthur" items="${arthur}" />
			</div>
			<div class="control-group" id="owner">
				<label class="control-label">来源 </label>
				<form:input path="source" items="${source}" />
			</div>
			<div class="control-group" id="owner">
				<label class="control-label">正文 </label>
				<form:textarea path="content" items="${content}" class="xheditor"
					rows="12" cols="80" style="width: 80%" />
				<form:errors path="content" />
			</div>
			<c:choose>
				<c:when test="${article['id']==null}">
					<button type="submit">创建文章</button>
				</c:when>
				<c:otherwise>
					<button type="submit">修改文章</button>
				</c:otherwise>
			</c:choose>

		</form:form>

	</div>
</body>

</html>
