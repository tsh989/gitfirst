<%--
  Created by IntelliJ IDEA.
  User: TSH
  Date: 2020/7/9
  Time: 13:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>focus获取焦点事件</title>
    <script src="<%=request.getContextPath()%>/js/jquery.js"></script>
</head>
<body>
<script type="text/javascript">
    $(function () {
        $("#username").focus(function () {
            $("#username").attr("placeholder", "请输入8位以上内容");

        });
        $("#username").blur(function () {
            var username = $("#username").val();
            if (username.length < 8) {
                console.log("请重新输入")
            }
        });
    });
</script>
<input type="text" id="username" name="username">
</body>
</html>
