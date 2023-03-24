<%--
  Created by IntelliJ IDEA.
  User: mozzi
  Date: 2023/03/24
  Time: 2:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>StockText Modify</title>
</head>
<body>
<form id="form1" action="/stock/modify", method="post">
    <div>
        <input type="text" name="title" value="${dto.title}">
    </div>
    <div>
        <input type="text" name="content" value="${dto.content}">
    </div>
    <div>
        <button type="submit">Modify</button>
    </div>
</form>

</body>
</html>
