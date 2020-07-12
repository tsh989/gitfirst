<%--
  Created by IntelliJ IDEA.
  User: TSH
  Date: 2020/7/10
  Time: 12:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <script src="<%=request.getContextPath()%>/js/jquery.js"></script>
</head>
<body>
<div style="padding-left: 40px"><h2>请输入注册信息</h2></div>
<table>
    <tr><td>用户名：</td><td><input type="text" id="username" name="username"></td></tr>
    <tr><td>密码：</td><td><input type="password" id="password" name="password"></td></tr>
    <tr><td>邮箱：</td><td><input type="email" id="email" name="email"></td></tr>
    <tr><td>手机号：</td><td><input type="number" id="phone" name="phone"></td></tr>
</table>
<div style="padding-left: 100px;padding-top: 10px"><input type="button" value="注册" onclick="subPost()"></div><span id="sp1" ></span>

<script type="text/javascript">
    function subPost()
    {
        $.ajax({
            type: "POST",//请求方式
            url: "<%=request.getContextPath()%>/loginController",//请求到后台的地址
            data: {
                username:$("#username").val(),
                password:$("#password").val(),
                email:$("#email").val(),
                phone:$("#phone").val()
            },//请求到后台的数据
            success: function(data){
                //$("#sp1").html(data);
                if(data==1) {
                    $("#sp1").html("注册失败 用户名已存在");
                }else if(data==2){
                    $("#sp1").html("注册失败 邮箱非法");
                }else if(data==3){
                    $("#sp1").html("注册失败 手机号非法");
                } else {
                    $("#sp1").html("注册成功");
                    window.setTimeout("window.location='<%=request.getContextPath()%>/sign.jsp'",1000);
                    //window.location.href = "<%=request.getContextPath()%>/sign.jsp";
                }
            }
        });
    }
</script>
</body>
</html>
