<%--
  Created by IntelliJ IDEA.
  User: mozzi
  Date: 2023/03/19
  Time: 10:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시글 작성</title>
</head>
<body>
<h1>게시글 작성하기</h1>

<form action="/stock/text" method="post">
    <input type="text" name="title"><br>
    <input type="text" name="content"><br>

    <button type="submit">등록</button>
</form>

</body>
</html>
