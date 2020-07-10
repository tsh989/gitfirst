<%--
  Created by IntelliJ IDEA.
  User: TSH
  Date: 2020/7/9
  Time: 12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>click单击事件</title>
    <script src="<%=request.getContextPath()%>/js/jquery.js"></script>
</head>
<body>
<script type="text/javascript">
    $(function () {
       $("#a1").click(function () {
          console.log("单击事件触发");
          //跳转
           window.location.href="http://www.baidu.com";
       });
       $("#btn1").click(function () {
          $("#btn1").val("加载完毕");
       });
    });
</script>
<a  id="a1" href="javascript:void(0);" style="text-decoration:none">点击事件</a><br><br>
<input type="button" id="btn1" value="加载">
</body>
</html>
