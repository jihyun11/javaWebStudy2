<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mozzi
  Date: 2023/03/19
  Time: 10:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/stock/textsuccess", method="get">
<ul>
    <c:forEach items="${stockDTO}" var="dto">
        <li>

            <span>${dto.title}</span>
            <span>${dto.content}</span>
        </li>
    </c:forEach>
</ul>
</ul>
</form>
</body>
</html>
