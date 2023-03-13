<%--
  Created by IntelliJ IDEA.
  User: mozzi
  Date: 2023/02/23
  Time: 10:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h1>NUM ${param.num1}</h1>
    <h1>NUM ${param.num2}</h1>
    <h1>SUM ${Integer.parseInt(param.num1) + Integer.parseInt(param.num2)}</h1>

</body>
</html>
