<%--
  Created by IntelliJ IDEA.
  User: TSH
  Date: 2020/7/9
  Time: 13:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>dblclick双击事件</title>
    <script src="<%=request.getContextPath()%>/js/jquery.js"></script>
</head>
<body>
<script type="text/javascript">
    $(function () {
       $("#a1").dblclick(function () {
         alert("666");
       });
    });
</script>
<a id="a1" href="javascript:void(0);">双击</a>
</body>
</html>
