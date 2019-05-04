<%--
  Created by IntelliJ IDEA.
  User: Semir
  Date: 2019/5/1
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>查询成功</h3>
<c:forEach items="${list}" var="account">
    ${account}
</c:forEach>
</body>
</html>
