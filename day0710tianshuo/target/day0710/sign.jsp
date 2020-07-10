<%--
  Created by IntelliJ IDEA.
  User: TSH
  Date: 2020/7/10
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <script src="<%=request.getContextPath()%>/js/jquery.js"></script>
</head>
<body>
<div style="padding-left: 40px"><h2>请输入登录信息</h2></div>
<table>
    <tr><td>用户名：</td><td><input type="text" id="username" name="username"></td></tr>
    <tr><td>密码：</td><td><input type="password" id="password" name="password"></td></tr>
</table>
<div style="padding-left: 100px;padding-top: 10px"><input type="button" value="登录" onclick="subPost()"></div><span id="sp1"></span>
<script type="text/javascript">
    function subPost() {
        $.ajax({
            type: "POST",//请求方式
            url: "<%=request.getContextPath()%>/signController",//请求到后台的地址
            data: {
                username:$("#username").val(),
                password:$("#password").val(),

            },//请求到后台的数据
            success: function(data){
                if(data==0) {
                    $("#sp1").html("用户名或密码不正确 请重新输入");
                }else {
                    $("#sp1").html("登录成功");
                    window.setTimeout("window.location='<%=request.getContextPath()%>/selectController'",1000);
                    //window.location.href = "<%=request.getContextPath()%>/selectController";
                }
            }
        });
    }
</script>
</body>
</html>
