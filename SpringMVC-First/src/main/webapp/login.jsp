<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>登录</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="./layui/css/layui.css" rel="stylesheet" media="all">
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <!--设置标签图标-->
    <link rel="stylesheet" href="style/index.css">


    <style>
        *{/*请空所有边距*/
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        .header{/*设置头部高度*/
            height: 88px;
        }
        .header .h_center{/*设置头部中间显示logo*/
            width: 1200px;/*宽度1200像素*/
            height: 88px;/*高度88*/
            margin: 0 auto;/*居中显示*/
        }
        .header .h_center img{
            float: left;/*设置浮动，和下面文件保持在一行*/
            margin-top: 5px;
        }
        .header .h_center p{
            float: left;/*设置浮动和上面图片保持在一行*/
            text-align: center;/*文字居中*/
            width: 880px;/*设置宽度*/
            font-size: 10px;/*设置字体大小*/
            border: 1px solid #ffb4a8;/*设置边框1像素，实线，颜色*/
            padding: 3px;/*设置内边距为3*/
            margin-top: 20px;/*距离顶部3距离*/
            margin-left: 80px;/*距离左侧80*/
            color: #6C6C6C;/*设置文字颜色*/
            background: #fef2f2;/*设置背景颜色*/
        }
        .login_body{
            height: 600px;/*高度600*/
            /*没有设置宽度，默认和窗口的宽度一样*/
            /*设置背景*/
            background-image: url("images/login.png");
            background-position: center center;
        }

        .login_body .login_center{
            width: 1200px;
            height: 600px;
            margin: 0 auto;/*居中*/
            overflow: hidden;/*清除浮动*/
        }
        .login_center .login_bg{
            width: 350px;
            height: 351px;
            background: rgba(255,255,255,0.95);
            margin-left: 850px;
            margin-top: 120px;
            padding: 25px;
        }

        #login div{
            height: 40px;/*高度为40*/
            margin-top: 20px;/*距离顶部20大小*/
        }
        #login span{/*设置用户名和密码的两个小图标*/
            width: 40px;
            height: 40px;
            display: inline-block;/*设置为内联，可以设置大小*/
            background: #ccc;
            float: left;/*设置左浮动，可以和input在一平齐显示*/
            border: 1px #ccc solid;/*设置边框*/
            border-right:none;/*设置右边框没有*/
        }
        #login .username span{/*设置用户名图标居中显示*/
            background-image: url("images/userName_Icon.png");
            background-position: center center;
        }
        #login .password span{/*设置密码图标居中显示*/
            background-image: url("images/password_Icon.png");
            background-position: center center;
        }
        #login input{/*设置输入框*/
            height: 40px;
            float: left;
            border: 1px #ccc solid;
            width: 260px;
        }
        #login .login_btn input{/*设置登录按钮*/
            background: #f40;
            color: white;
            border-radius: 2px;
            width: 300px;
        }

        .forgotPwd{/*设置忘记密码div*/
            margin-top: 60px;
            text-align: right;
        }
        .forgotPwd a{/*设置链接样式*/
            text-decoration:none;
            color: #666;
            font-size: 14px;
        }
        .forgotPwd a:hover{/*鼠标移入样式*/
            color: #ff4400;
        }

        #footer{
            width: 1200px;
            margin: 0 auto;
            margin-top: 20px;

        }
        #footer .link{
            text-align: center;

        }
        #footer a{
            text-decoration: none;
            color: #666;
            margin-left: 5px;
            margin-right: 5px;
        }
        #footer .copyright{
            text-align: center;
            margin-top: 10px;
        }

    </style>

</head>


<body>
<%@ include file="header.jsp" %>

<div class="login">
    <div class="login_body">
        <!--中部-->
        <div class="login_center">
            <!--登录背景-->
            <div class="login_bg">
                <h4>登录</h4>
                <form action="/login"  id="login" method="post">
                    <!--用户名-->
                    <div class="username">
                        <span></span>
                        <input type="text" placeholder="请输入手机号..." name="user_phone" required>
                    </div>
                    <!--密码-->
                    <div class="password">
                        <span></span>
                        <input type="password"  placeholder="请输入密码..." name="user_pwd" required>
                    </div>
                    <div class="login_btn">
                        <input type="submit" class="login_btn" value="登录">
                    </div>
                </form>
                <div class="forgotPwd"><!--忘记密码-->
                    <a href="">忘记密码</a> <a href="">免费注册</a>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>

<!--尾部-->
<%--<div id="footer">--%>
<%--    <!--关于我们-->--%>
<%--    <!--版权-->--%>
<%--    <div class="copyright">--%>
<%--        Copyright&nbsp;&copy;&nbsp;2017-2018&nbsp;&nbsp;人人都是项目经理&nbsp;版权所有--%>
<%--    </div>--%>
<%--</div>--%>


<script src="./layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    layui.use('element', function () {
        var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块

        //监听导航点击
        element.on('nav(demo)', function (elem) {
            //console.log(elem)
            layer.msg(elem.text());
        });
    });
</script>

</body>
</html>
