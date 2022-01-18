<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/springlegacy/static/bootstrap-5.1.3-dist/css/bootstrap.css" />
<script src="/springlegacy/resources/jquery/jquery-3.6.0.js"></script>
</head>
<body>
<div class="container">
	<h2>Form값 받기</h2>
	
	<h3>@RequestParam 어노테이션으로 파라미터 받기</h3>
	
	<ul>
		<li>이름: ${memberDTO.name }</li>
		<li>이름: ${memberDTO.id }</li>
		<li>이름: ${memberDTO.pw }</li>
		<li>이름: ${memberDTO.email }</li>
	</ul>
</div>
</body>
</html>