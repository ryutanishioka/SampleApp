<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>create</title>
</head>
<body>
	<h1>新規投稿画面</h1>
	<form action="/sampleApp/create" method="post">
		<p>投稿してみよう</p>
		<input type="text" name="tweet"> 
		<input type="submit" value="投稿する">
	</form>
</body>
</html>