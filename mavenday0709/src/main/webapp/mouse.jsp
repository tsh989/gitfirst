<%--
  Created by IntelliJ IDEA.
  User: TSH
  Date: 2020/7/9
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>mouse事件</title>
    <script src="<%=request.getContextPath()%>/js/jquery.js"></script>
</head>
<body>
<script type="text/javascript">
    $(function () {
       $("#btn1").mousedown(function () {
           console.log("mousedown");
       });
       $("#btn1").mouseup(function () {
           console.log("mouseup")
       });
       $("a").mouseenter(function () {
           $("a").css("background-color","yellow");
       });
       $("#sp1").hover(function () {
           $("#sp1").css("color","red");
       },function () {
           $("#sp1").css("color","black");
       });
    });
</script>
<input type="button" id="btn1" value="鼠标mouse"><br>
<a>mouse事件</a><br>
<span id="sp1">今天是2020年7月9日</span>
</body>
</html>
