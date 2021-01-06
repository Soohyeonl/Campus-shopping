<%--
  Created by IntelliJ IDEA.
  User: mktb
  Date: 1/5/21
  Time: 9:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>出售订单</title>

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
        <div class="layui-col-md1">
            商品
        </div>
        <div class="layui-col-md1">
            价格
        </div>
        <div class="layui-col-md1">
            数量
        </div>
        <div class="layui-col-md2">
            地址
        </div>
        <div class="layui-col-md2">
            买家电话
        </div>
        <div class="layui-col-md2">
            付款日期
        </div>
        <div class="layui-col-md2">
            发货日期
        </div>
        <div class="layui-col-md2">
            收货日期
        </div>
        <div class="layui-col-md1">
            订单状态
        </div>
        <div class="layui-col-md1">
            总额
        </div>
        <div class="layui-col-md2">
            操作
        </div>
        <%--        <div class="layui-col-md1">--%>
        <%--            结算--%>
        <%--        </div>--%>

    </div>

    <c:if test="${!empty sellOrder}">
        <c:forEach items="${sellOrder}" var="orders">
            <div class="layui-row">
                <div class="layui-col-md2">
                    <img src="${orders.goods_picture}" alt="" width="100px" height="70px">
                </div>

                <div class="layui-col-md1">
                        ${orders.goods_name}
                </div>

                <div class="layui-col-md1">
                        ${orders.price}
                </div>

                <div class="layui-col-md1">
                        ${orders.quantity}
                </div>

                <div class="layui-col-md2">
                        ${orders.address}
                </div>

                <div class="layui-col-md2">
                        ${orders.user_phone}
                </div>

                <div class="layui-col-md2">
                        ${orders.pay_time}
                </div>

                <div class="layui-col-md2">
                        ${orders.delivery_time}
                </div>

                <div class="layui-col-md2">
                        ${orders.done_time}
                </div>

                <div class="layui-col-md1">
                    <c:if test="${orders.order_state == 0}">
                        待支付
                    </c:if>
                    <c:if test="${orders.order_state == 1}">
                        待发货
                    </c:if>
                    <c:if test="${orders.order_state == 2}">
                        待收货
                    </c:if>
                    <c:if test="${orders.order_state == 3}">
                        已完成
                    </c:if>
                </div>

                <div class="layui-col-md1">
                        ${orders.order_price}
                </div>
                <c:if test="${orders.order_state < 3 }">
                    <div class="layui-col-md1">
                        <c:if test="${orders.order_state < 2 }">
                            <div class="account_button_box">
                                <a href="/delivery?order_id=${orders.order_id}">
                                    <input type="button" value="发货" class="account_button"/>
                                </a>
                            </div>
                        </c:if>
                        <c:if test="${orders.order_state > 1 }">
                            <div class="account_button_box">
                                <input type="button" value="结算" class="account_button"/>
                            </div>
                        </c:if>
                    </div>

                    <div class="layui-col-md1">
                        <div class="del_button_box">
                            <input type="button" value="取消" class="button_del"/>
                        </div>
                    </div>
                </c:if>


                <c:if test="${orders.order_state > 2 }">
                    <div class="layui-col-md2">
                        <div class="del_button_box">
                            <input type="button" value="完成" class="button_del"/>
                        </div>
                    </div>
                </c:if>
            </div>
        </c:forEach>
    </c:if>




</div>

<%@ include file="footer.jsp" %>
</body>
</html>
