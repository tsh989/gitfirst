<%--
  Created by IntelliJ IDEA.
  User: TSH
  Date: 2020/7/9
  Time: 18:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>js发送ajax请求</title>
</head>
<body>
<input type="text" id="username" name="username"><span id="sp1"></span><br>
<input type="button" id="btn1" value="发送" onclick="sendPOST()">
<script type="text/javascript">
    function sendPOST() {
        var username = document.getElementById("username").value;
        //创建js ajax发送步骤
        //1.创建发送对象
        var xmlHttp=new XMLHttpRequest();
        xmlHttp.onreadystatechange=function () {
            //判断状态改变时处理的事情
            if(xmlHttp.readyState==4&&xmlHttp.status==200){
                var data=xmlHttp.responseText;
                document.getElementById("sp1").innerHTML=data;
            }
        }
        //请求发送绑定服务器地址
        var url="<%=request.getContextPath()%>/myServlet";
        xmlHttp.open("POST", url, true);
        xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        //发送请求
        xmlHttp.send("username="+username);
    };
    /*
    * readyState:
    *   0:初始化
    *   1：服务器连接已建立
    *   2：请求已接收
    *   3：请求处理中
    *   4：请求完成，响应就绪
    *  status：
    *   200 请求ok
    *   404：路径访问不到
    * */
</script>
</body>
</html>
