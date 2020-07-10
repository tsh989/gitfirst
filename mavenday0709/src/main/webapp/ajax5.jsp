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
    <input type="text" id="username" name="username"><span id="sp2"></span><br>
    <input type="password" id="password" name="password"><span id="sp3"></span><br>
    <input type="button" value="提交" onclick="subGet()"><span id="sp1"></span>
    <script type="text/javascript">
        function subGet() {
            $.ajax({
                type: "GET",//请求方式
                url: "<%=request.getContextPath()%>/myServlet4",//请求到后台的地址
                data: {
                    username:$("#username").val(),
                    password:$("#password").val()
                },//请求到后台的数据
                success: function(data){
                    $("#sp1").html(data);
                }
            });
        }
        $(function () {
            $("#username").blur(function () {
                var username=$("#username").val();
                $.ajax({
                    type: "POST",//请求方式
                    url: "<%=request.getContextPath()%>/myServlet4",//请求到后台的地址
                    data: {
                        username:username
                    },//请求到后台的数据
                    success: function(data){
                        $("#sp2").html(data);
                    }
                });
            });
            /*$("#password").blur(function () {
                var url="<%=request.getContextPath()%>/myServlet4";
                var data={
                    username:$("#username").val(),
                    password:$("#password").val()
                };
                $.get(url,data,function (data) {
                    $("#sp3").html(data);
                });
            });*/
        });
    </script>
</body>
</html>
