<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>主页</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="./layui/css/layui.css" rel="stylesheet" media="all">
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <!--设置标签图标-->
    <link rel="stylesheet" href="style/index.css">

</head>
<body>

<%@ include file="header.jsp" %>
<div class="row-fluid">

    <div class="span10">
        <div id="hot_goods">
            <h3 class="hot_goods_title">商品</h3>
            <div class="hot_goods_body">
                <ul>
                    <c:forEach items="${allGoods}" var="goods">
                        <li>
                            <a href="">
                                <img src="${goods.goods_picture}" alt="">
                                <p>${goods.goods_name}</p>
                                <i class="yuan">￥</i><span class="price">599</span>
                            </a>
                        </li>
                    </c:forEach>
                </ul>

            </div>
        </div>
    </div>
</div>


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