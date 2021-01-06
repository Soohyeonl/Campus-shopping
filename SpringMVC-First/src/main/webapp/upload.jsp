<%--
  Created by IntelliJ IDEA.
  User: mktb
  Date: 1/5/21
  Time: 11:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>出售商品</title>

    <%--    <link href="./layui/css/layui.css" rel="stylesheet" media="all">--%>

    <script type="text/javascript">
        function upload() {
            var form = document.getElementById("uploadForm");
            form.submit();
            return true;
        }
    </script>


    <style>
        body {
            margin: 0;
            padding: 0;
            background-color: aliceblue;
        }
        .layui-input {
            width: 350px;
        }
        .main_box {
            display: flex;
            justify-content: center;
            padding-top: 190px;
        }
        .btn_box {
            padding-left: 110px;
            width: 400px;
            height: 45px;
            align-items: center;
        }

        .layui-form-label {
            width: 100px;
        }
    </style>

</head>
<body>

<%@ include file="header.jsp" %>


<div class="main_box">
    <form class="layui-form" id="uploadForm" action="/upload" enctype="multipart/form-data" method="post">
        <div class="layui-form-item">
            <label class="layui-form-label" style="width: 100px">商品名称</label>
            <div class="layui-input-block">
                <input type="text" name="goods_name" required  lay-verify="required" placeholder="请输入..." autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label" style="width: 100px">商品描述</label>
            <div class="layui-input-block">
                <input type="text" name="description" required  lay-verify="required" placeholder="请输入..." autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label" style="width: 100px">商品价格</label>
            <div class="layui-input-block">
                <input type="text" name="price" required  lay-verify="required" placeholder="请输入..." autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label" style="width: 100px">商品数量</label>
            <div class="layui-input-block">
                <input type="text" name="stock" required  lay-verify="required" placeholder="请输入..." autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="btn_box">
            <input type="file" class="btn_upload" name="file" id="file"/>
        </div>
        <div><img src="" alt=""></div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" type="button" onclick="upload()">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>

<%--<form id="uploadForm" action="/upload" enctype="multipart/form-data" method="post">--%>


<%--    <div>--%>
<%--        <span class="word4">商品名称</span>--%>
<%--        <input class="in" type="text" name="goods_name" placeholder="请输入..." required/>--%>
<%--    </div>--%>
<%--    <div>--%>
<%--        <span class="word4">商品描述</span>--%>
<%--        <input class="in" type="text" name="description" placeholder="请输入..." required/>--%>
<%--    </div>--%>
<%--    <div>--%>
<%--        <span class="word4">商品价格</span>--%>
<%--        <input class="in" type="text" name="price" placeholder="请输入..." required/>--%>
<%--    </div>--%>

<%--    <div>--%>
<%--        <span class="word4">商品库存</span>--%>
<%--        <input class="in" type="text" name="stock" placeholder="请输入..." required/>--%>
<%--    </div>--%>


<%--    <input type="file" name="file" required>--%>


<%--    <input class="reset" type="reset" value="重置"/>--%>
<%--    <button type="button" onclick="upload()">提交</button>--%>
<%--</form>--%>


<%@ include file="footer.jsp" %>
</body>
</html>
