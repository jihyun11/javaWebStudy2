<%--
  Created by IntelliJ IDEA.
  User: mozzi
  Date: 2023/03/15
  Time: 5:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>회원 등록</h1>

<form action="userResult.jsp" method="post">
    ID: <input type="text" name="id"><br>
    PW: <input type="password" name="pw"><br>
    성명: <input type="text" name="name"><br>
    전화번호: <input type="text" name="phone"><br>
    주소: <input type="text" name="address"><br>
    <button type="submit">등록</button>
</form>

</body>
</html>
