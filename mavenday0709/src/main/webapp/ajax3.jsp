<%--
  Created by IntelliJ IDEA.
  User: TSH
  Date: 2020/7/9
  Time: 19:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jquery发送请求</title>
    <script src="<%=request.getContextPath()%>/js/jquery.js"></script>
</head>
<body>
<input type="text" id="username" name="username"><br>
<input type="password" id="password" name="password"><br>
<input type="button" value="提交" onclick="subGet()"><span id="sp1"></span>
<script type="text/javascript">
    function subGet() {
        var username=$("#username").val();
        var password=$("#password").val();
        $.ajax({
            type: "GET",//请求方式
            url: "<%=request.getContextPath()%>/myServlet2",//请求到后台的地址
            data: {username:username,password:password},//请求到后台的数据
            success: function(data){
                $("#sp1").html(data);
            }
        });
    }
</script>
</body>
</html>
