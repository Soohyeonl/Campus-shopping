<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>欢迎注册</title>
    <link rel="stylesheet" href="layui/css/layui.css">
    <style>
        body {
            background-image: url("images/img_5.jpg");
            margin: 0;
            padding: 0;
            background-color: aliceblue;
        }

        .layui-input {
            width: 450px;
        }

        .main_box {
            display: flex;
            justify-content: space-between;
        }

        .left_box {
            float: left;
            margin-top: 100px;
            margin-left: 50px;
        }

        .right_box {
            width: 600px;
            height: 400px;
            margin-right: 40px;
            margin-top: 100px;
            border: grey solid 1px;
            border-radius: 5px;
            box-shadow: #9F9F9F 3px 3px 3px 3px;
        }

        .layui-form {
            padding-top: 60px;
        }

        .pic_box {
            padding-left: 40px;
            padding-top: 0;
            border-radius: 5px;
            width: 570px;
            height: 400px;
        }

    </style>
</head>
<body>

<%--<%@ include file="header.jsp" %>--%>

<div class="main_box">
    <div class="left_box">
        <div class="pic_box">

        </div>

    </div>

    <div class="right_box">
        <form class="layui-form" action="/register" method="post" name="fir" id="reg_form">
            <div class="layui-form-item">
                <label class="layui-form-label">昵称</label>
                <div class="layui-input-block">
                    <input type="text" name="user_nick_name" required id="user_name" lay-verify="required"
                           placeholder="请输入昵称" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">密码</label>
                <div class="layui-input-block">
                    <input type="password" name="user_pwd" required id="pwd" lay-verify="required" placeholder="请输入密码"
                           autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">确认密码</label>
                <div class="layui-input-block">
                    <input type="password" name="rePassword" required id="rpwd" lay-verify="required"
                           placeholder="请再次输入密码" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">电话号码</label>
                <div class="layui-input-block">
                    <input type="text" name="user_phone" required id="phone" lay-verify="required" placeholder="请输入电话号码"
                           autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" type="button" onclick="Check()">立即提交</button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </div>
        </form>
    </div>
</div>

<%--<%@ include file="footer.jsp" %>--%>
<script src="layui/layui.js"></script>
<script>
    function Check() {
        var sign = false;
        var a = document.getElementById("pwd").value;
        var b = document.getElementById("rpwd").value;
        var u = document.getElementById("user_name").value;
        var t = document.getElementById("phone").value;
        if (a !== b) {
            window.alert("两次密码不相同");
            return false;
        } else if (u === "") {
            window.alert("昵称不能为空");
            return false;
        } else if (t === "") {
            window.alert("电话不能为空");
            return false;
        } else if (a === "") {
            window.alert("密码不能为空")
            return false;
        } else {
            sign = true;
            console.log(2);
        }
        if (sign === true) {
            console.log(1);
            var form = document.getElementById("reg_form");
            form.submit();
            return true;
        } else {
            return false;
        }


    }

    //Demo
    // layui.use('form', function(){
    //
    //     var form = layui.form;
    //
    //     //监听提交
    //     form.on('submit(formDemo)', function(data){
    //         layer.msg(JSON.stringify(data.field));
    //         form.submit();
    //         return false;
    //     });
    // });
</script>
</body>
</html>