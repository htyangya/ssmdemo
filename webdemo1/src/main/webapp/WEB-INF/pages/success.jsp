<%--
  Created by IntelliJ IDEA.
  User: yy
  Date: 2020/1/12
  Time: 23:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>success</title>
</head>
<body>
<h3>成功进入到入门页面！并且打印出helloword</h3>
${allAccount}<hr/>
${pageContext.request.contextPath}
<table>
    <thead>
    <tr>
        <td>账户id</td>
        <td>账户名称</td>
        <td>账户金额</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${allAccount.list}" var="account">
        <tr>
            <td>${account.id}</td>
            <td>${account.name}</td>
            <td>${account.money}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
