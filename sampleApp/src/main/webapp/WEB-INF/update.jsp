<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更新ページ</title>
</head>
<body>
	<h1>更新ページ</h1>
		<form action="/sampleApp/update?param1=${tweet}" method="post">
		<p>ツイートを更新します</p>
		<!--input type="hidden" name="tweet_id" value="${tweet}" -->
		<input type="text" name="tweet"> 
		<input type="submit" value="投稿する">
	</form>
</body>
</html>