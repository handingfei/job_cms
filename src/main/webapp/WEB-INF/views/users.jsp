<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resource/css/bootstrap.min.css">
<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script>
</script>
</head>
<body>
<div class="container">
	<a href="/add">录入</a>
	<table class="table table-striped">
		<tr>
			<td>序号</td>
			<td>姓名</td>
			<td>性别</td>
			<td>生日</td>
			<td>平均分</td>
			<td>操作</td>
		</tr>
		
		<c:forEach items="${info }" var="e" varStatus="count">
			<tr>
				<td>${count.index+1 }</td>
				<td>${e.name }</td>
				<td>${e.sex}</td>
				<td>${e.birthday}</td>
				<td>${e.avgScore }</td>
				<td>
					<a href="/select?id=${e.id }">详情</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	${page }
</div>
</body>
</html>