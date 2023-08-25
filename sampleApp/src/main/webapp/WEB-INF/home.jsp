<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ホーム画面</title>
</head>
<body>
	<h1>hello world</h1>
	<a href="/sampleApp/create" class="button">新規投稿</a>
	<a href="/sampleApp/logout" class="button">ログアウト</a>
	<c:forEach var="tweet" items="${tweets}">
		<div style="border: 1px solid black; margin: 10px;">
			<p>${tweet.tweet}</p>
			<p>${tweet.name}</p>
			<!-- セッションのユーザーidと${tweet.user_id}が一緒なら削除ボタンを表示させる -->
			<%-- Expression Language (EL)とJSTLのc:ifタグを使用 --%>
			<c:if test="${sessionScope.userId == tweet.user_id}">
				<a href="/sampleApp/delete?param1=${tweet.tweet_id}" class="button">削除</a>
				<a href="/sampleApp/update?param1=${tweet.tweet_id}" class="button">更新</a>
			</c:if>
		</div>
	</c:forEach>
</body>
</html>