<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resource/css/bootstrap.min.css">
<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script>
</head>
<body>
<div class="container">
	<h1>录入应聘者成绩</h1>
	<hr>
	<form:form action="/add" id="form1" modelAttribute="user"
		enctype="multipart/form-data" method="post">
		<table id="mtb">
			<tr>
				<td>姓名: <form:input path="name"/>
					<form:errors path="name" cssStyle="color:pink"/>
				</td>
			</tr>
			<tr>
				<td>生日: <form:input path="birthday"/>
					<form:errors path="birthday" cssStyle="color:pink"/>
				</td>
			</tr>
			<tr>
				<td>性别: <form:radiobutton path="sex" value="男" checked="true"/>男
					<form:radiobutton path="sex" value="女"/>女
				</td>
			</tr>
			<tr>
				<td>应聘者照片: <input type="file"  name="file"></td>
			</tr>
			<tr id="mtr">
				<td>职位: <select name="pids" id="pp"/> </td>
				<td>成绩: <input type="text" name="scores"></td>
			</tr>
		</table>
	
		<div class="row form-group">
			<button class="btn btn-info" onclick="addRow()" type="button">增加职位</button>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<button class="btn btn-info" type="submit">保存</button>
		</div>
	
	</form:form>
	
</div>
<script type="text/javascript">
	
	function addRow() {
		var $mtr = $("#mtr").clone();
		$("#mtb").append($mtr);
	}
	
	$(function () {
		$.get("/selectsPosition",function(arr){
			for ( var i in arr) {
				$("#pp").append("<option value='"+arr[i].id+"'>"+arr[i].name+"</option>");
			}
		})
	})
</script>
</body>
</html>