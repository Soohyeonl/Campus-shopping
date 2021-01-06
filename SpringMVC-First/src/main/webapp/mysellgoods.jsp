<%--
  Created by IntelliJ IDEA.
  User: mktb
  Date: 1/5/2021
  Time: 3:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>我出售的商品</title>

    <link rel="stylesheet" href="layui/css/layui.css">
    <style>
        body {
            margin: 0;
            padding: 0;
            background-color: aliceblue;
        }

        .layui-row {
            font-size: 18px;
            padding: 15px;
            text-align: center;
            border-bottom: grey solid 1px;
            display: flex;
            align-items: center;
        }

        .button_del {
            width: 40px;
            height: 30px;
            border-radius: 4px;
            border: 1px;
        }

        .button_del:hover {
            background-color: darksalmon;
            box-shadow: red;
        }

        .account_button {
            width: 40px;
            height: 30px;
            border-radius: 4px;
            border: 1px;
        }

        .account_button:hover {
            background-color: darksalmon;
            box-shadow: red;
        }
    </style>


</head>
<body>

<%@ include file="header.jsp" %>

<div class="layui-container">
    <div class="layui-row">
        <div class="layui-col-md2">
            图片
        </div>
        <div class="layui-col-md2">
            商品id
        </div>
        <div class="layui-col-md1">
            商品名称
        </div>
        <div class="layui-col-md2">
            商品描述
        </div>
        <div class="layui-col-md1">
            价格
        </div>
        <div class="layui-col-md1">
            数量
        </div>
        <div class="layui-col-md2">
            上架时间
        </div>
        <%--        <div class="layui-col-md1">--%>
        <%--            结算--%>
        <%--        </div>--%>

    </div>

    <c:if test="${!empty mySellGoods}">
        <c:forEach items="${mySellGoods}" var="orders">
            <div class="layui-row">
                <div class="layui-col-md2">
                    <img src="${orders.goods_picture}" alt="" width="100px" height="70px">
                </div>

                <div class="layui-col-md2">
                        ${orders.goods_id}
                </div>

                <div class="layui-col-md1">
                        ${orders.goods_name}
                </div>

                <div class="layui-col-md2">
                        ${orders.description}
                </div>


                <div class="layui-col-md1">
                        ${orders.price}
                </div>

                <div class="layui-col-md1">
                        ${orders.stock }
                </div>

                <div class="layui-col-md2">
                        ${orders.on_time}
                </div>

            </div>
        </c:forEach>
    </c:if>




</div>

<%@ include file="footer.jsp" %>


</body>
</html>
