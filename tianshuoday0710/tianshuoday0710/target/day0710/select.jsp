<%--
  Created by IntelliJ IDEA.
  User: TSH
  Date: 2020/7/10
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java"  %>
<%--<c:if test="${empty sessionScope.user}">
    <c:redirect url="/select.jsp"></c:redirect>&ndash;%&gt;
</c:if>--%>
<html>
<head>
    <title>查询信息</title>
</head>
<body>
<h2>用户个人信息</h2>

<span>用户名：${sessionScope.user.username}</span><br>
<span>密码：${sessionScope.user.password}</span><br>
<span>邮箱：${sessionScope.user.email}</span><br>
<span>手机号：${sessionScope.user.phone}</span><br>
<span>注册时间：${sessionScope.user.register_time}</span><br>
<span>修改时间：${sessionScope.user.modify_time}</span><br>
</body>
</html>
