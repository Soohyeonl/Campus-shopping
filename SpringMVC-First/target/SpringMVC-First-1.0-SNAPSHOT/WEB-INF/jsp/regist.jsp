<%--
  Created by IntelliJ IDEA.
  User: mktb
  Date: 1/4/2021
  Time: 5:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="../../style/regStyle.css" rel="stylesheet">
<html>
<head>
    <title>注册</title>
</head>
<body>

<%@ include file="header.jsp" %>

<div id="reg_main">
    <div class="main_left">
        <form action="/regist" id="reg_form" method="post">
            <div>
                <label>昵称</label>
                <input id="username"  type="text" placeholder="请输入用户名..." name="username">
            </div>
            <div>
                <label>密码</label>
                <input id="pwd" type="text" placeholder="请输入密码.." name="password">
            </div>
            <div>
                <label>确认密码</label>
                <input id="pwd2" type="text" placeholder="请再次输入密码...">
            </div>
            <div>
                <label>电话</label>
                <input type="text" placeholder="请输入电话..." name="phone">
            </div>
            <div class="submit_button">
                <input type="button" value="立即注册" onclick="checkData()">
            </div>
        </form>
    </div>
</div>

<%@ include file="footer.jsp" %>

</body>
</html>
