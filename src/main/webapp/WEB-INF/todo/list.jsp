<%--
  Created by IntelliJ IDEA.
  User: mozzi
  Date: 2023/03/01
  Time: 3:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Todo List</title>
</head>
<body>
<h1>Todo List</h1>

<h2>${appName}</h2>
<h2>${loginInfo}</h2>
<h3>${loginInfo.mname}</h3>

<h2>${loginInfo}</h2>
<h3>${loginInfo.mname}</h3>

<ul>
    <c:forEach items="${dtoList}" var="dto">
        <li>
            <span><a href="/todo/read?tno=${dto.tno}">${dto.tno}</a> </span>
            <span>${dto.title}</span>
            <span>${dto.dueDate}</span>
            <span>${dto.finished? "DONE": "NOT YET"}</span>
            <form action="/todo/remove" method="post">
                <input type="hidden" name="tno" value="${dto.tno}"/>
                <button>Delete</button>

            </form>
        </li>
    </c:forEach>
</ul>

<form action="/logout" method="post">
    <button>LOGOUT</button>
</form>

</body>
</html>
