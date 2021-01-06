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

    <!--设置标签图标-->
    <link rel="stylesheet" href="style/index.css">

    <style>
        .but_right {
            float: right;
        }
    </style>

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
                        <li style="height: 370px">

                                <img src="${goods.goods_picture}" alt="">
                                <b></v><p>${goods.goods_name}</p></b>
                                <p>${goods.description}</p>
                                <p>当前库存：${goods.stock}</p>
                                <i class="yuan">￥</i><span class="price">${goods.price}</span>
                                <div class="but_right">
                                    <a href="/addToCart?goods_id=${goods.goods_id}&price=${goods.price}">
                                        <button type="button" class="layui-btn">加入购物车</button>
                                    </a>
                                </div>

                        </li>
                    </c:forEach>
                </ul>

            </div>
        </div>
    </div>
</div>

<%@ include file="footer.jsp" %>


</body>
</html>