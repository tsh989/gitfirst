<%--
  Created by IntelliJ IDEA.
  User: TSH
  Date: 2020/7/9
  Time: 18:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>postion</title>
    <script src="<%=request.getContextPath()%>/js/jquery.js"></script>
</head>
<body>
<script type="text/javascript">
    $(function () {
        var p = $("p:first");
        var position = p.position();
        //$("p:last").html( "left: " + position.left + ", top: " + position.top );
        $("#p2").html("p2");
        $("#p1").html("p1");
    });
</script>
<p id="p1">Hello</p>
<p id="p2">2nd Paragraph</p>
</body>
</html>
