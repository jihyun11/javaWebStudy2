<%--
  Created by IntelliJ IDEA.
  User: mozzi
  Date: 2023/03/21
  Time: 7:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${param.result == 'error'}">
    <h1>로그인 에러</h1>
</c:if>
<form action="/stocklogin" method="post">
    <input type="text" name="sid">
    <input type="password" name="spw">
    <input type="checkbox" name="auto">
    <button type="submit">로그인</button>
</form>

</form>

</body>
</html>
