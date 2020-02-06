<%--
  Created by IntelliJ IDEA.
  User: yy
  Date: 2020/1/12
  Time: 23:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="cf" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page isELIgnored="false" %>
<html>
<body>
<form action="/fileLoad" method="post" enctype="multipart/form-data">
    <input type="text" name="username" placeholder="请输入用户名"/><br/>
    <input type="text" name="password" placeholder="请输入密码"/><br/>
    <input type="number" name="money" placeholder="请输入要充值的金额,最大值100" max="100"><br/>
    <hr/>
    <label >
        从何处知道我们的系统
        <input type="checkbox" name="from" value="qq"/>
        <input type="checkbox" name="from" value="社区"/>
        <input type="checkbox" name="from" value="微信"/>
    </label>
    <hr/>
    <label>
        点此上传照片
        <input type="file" name="myFile" required="required" />
    </label>

    <button type="submit">提交文件</button>

</form>

<br/><br/><br/><br/><br/>
<a href="${pageContext.request.contextPath}/hello.action">点此action</a>

</body>
</html>

