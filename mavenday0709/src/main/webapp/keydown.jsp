<%--
  Created by IntelliJ IDEA.
  User: TSH
  Date: 2020/7/9
  Time: 13:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>keydown键盘按下事件</title>
    <script src="<%=request.getContextPath()%>/js/jquery.js"></script>
</head>
<body>
<script type="text/javascript">
    $(function () {
       $("#btn1").keyup(function () {
           console.log("keydown事件已触发");
           var inputValue = $("#btn1").val();
           console.log(inputValue);
           $("#s1").empty();
           $("#s1").html(inputValue);
       });
    });
</script>
<input type="text" id="btn1" name="username" >
<span id="s1"></span>
</body>
</html>
