<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	<title>ログイン</title>
	</head>
	<body>
		<form action="LoginServlet" method="post">
			<p>name</p>
		    <input type="text" name="name">
		    <p>mail</p>
		    <input type="text" name="mail">
		    <input type="submit" value="ログイン">
		</form>
	
	</body>
</html>