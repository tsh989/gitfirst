<%--
  Created by IntelliJ IDEA.
  User: TSH
  Date: 2020/7/9
  Time: 12:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>blur失去焦点事件</title>
    <script src="<%=request.getContextPath()%>/js/jquery.js"></script>
</head>
<body>
    <script type="text/javascript">
        $(function () {
            $("#username").blur(function () {//回调函数，当事件触发时需要执行的内容
                var username=$("#username").val();
                if(username==""){
                    console.log("输入内容不能为空！");
                }
            });
        });
    </script>

    <input type="text" id="username" name="username">
</body>
</html>
