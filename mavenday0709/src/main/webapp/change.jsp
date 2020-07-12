<%--
  Created by IntelliJ IDEA.
  User: TSH
  Date: 2020/7/9
  Time: 12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>change事件</title>
    <script src="<%=request.getContextPath()%>/js/jquery.js"></script>
</head>
<body>
    <script type="text/javascript">
        $(function () {
            $("#city").change(function () {
                var cityValue = $("#city option:selected").val();
                console.log(cityValue);
            });
        });
    </script>
    <select id="city" name=""city>
        <option value="0">北京</option>
        <option value="1">上海</option>
        <option value="2">广州</option>
        <option value="3">深圳</option>
    </select>
</body>
</html>
