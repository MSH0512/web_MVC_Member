<%--
  Created by IntelliJ IDEA.
  User: 문상현
  Date: 2024-03-11
  Time: 오후 10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>login Page</title>
</head>
<body>
<c:if test="${param.result =='error'}">
    <span><h1>로그인 에러입니다. 다시 시도하세요</h1></span>
</c:if>
<form action="/login" method="post">
    <label>아이디
        <input type="text" name="id">
    </label><br>
    <label>비밀번호
        <input type="password" name="pw">
    </label>
    <button type="submit">LOGIN</button>
</form>

</body>
</html>
