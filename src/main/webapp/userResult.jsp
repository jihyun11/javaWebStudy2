<%--
  Created by IntelliJ IDEA.
  User: mozzi
  Date: 2023/03/15
  Time: 6:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>회원정보 등록 확인</h1>

<%
    String idd = request.getParameter("id");
    String pw = request.getParameter("pw");
    String name = request.getParameter("name");
    String phone = request.getParameter("phone");
    String address = request.getParameter("address");


%>

ID: ${param.id}
PW: <%=pw%>
name: <%=name%>
phone: <%=phone%>
address: <%=address%>

<h3>회원 정보가 확인되었습니다.</h3>


</body>
</html>
