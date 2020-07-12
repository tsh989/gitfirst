<%--
  Created by IntelliJ IDEA.
  User: TSH
  Date: 2020/7/9
  Time: 13:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>error事件</title>
    <script src="<%=request.getContextPath()%>/js/jquery.js"></script>
</head>
<body>
<script type="text/javascript">
    $(function () {
       $("img").error(function () {
           //attr使用 给标签属性赋值 语法：attr("属性","值") 多个属性赋值attr({属性:"值",属性:"值"})
          $("img").attr("alt","图片已删除");
          /*alert("图片已删除");*/
       });
    });
</script>
<%--<img style="width:100px;height: 100px" src="http://e.hiphotos.baidu.com/zhidao/pic/item/b64543a98226cffc7a951157b8014a90f703ea9c.jpg">--%>
<img style="width:100px;height: 100px" src="http://attach.bbs.miui.com/forum11/201105/17/113554rnu40q7nbgnn3lgq.jpg">
</body>
</html>
