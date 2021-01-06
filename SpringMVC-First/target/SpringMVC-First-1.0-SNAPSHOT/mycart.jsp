<%--
  Created by IntelliJ IDEA.
  User: mktb
  Date: 1/4/21
  Time: 11:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的购物车</title>

    <link rel="stylesheet" href="layui/css/layui.css">
    <script src="js/jquery-3.5.1.js"></script>

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

        .button_buy {
            width: 40px;
            height: 30px;
            border-radius: 4px;
            border: 1px;
        }

        .button_buy:hover {
            background-color: darksalmon;
            box-shadow: red;
        }

        .btn_op {
            border: 0;
            background-color: aliceblue;
            border-radius: 4px;

        }
        .btn_op:hover {
            background-color: darksalmon;
            box-shadow: red;
        }
        .op_num {
            display: flex;
            justify-content: center;
        }
    </style>

    <script>
        $.ajaxSetup({
            contentType: "application/x-www-form-urlencoded; charset=utf-8"
        });

        function up() {
            console.log("111");
            $.post({
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                url:"http://localhost:8080/add",
                data:{"nowNum":$("#num").val()},
                success: function (data) {
                    console.log(data);
                }
            })
        }

    </script>

</head>
<body>

<%@ include file="header.jsp" %>


<div class="layui-container">
    <div class="layui-row">
        <div class="layui-col-md3">
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
            加入时间
        </div>
        <div class="layui-col-md2">
            上架时间
        </div>
        <div class="layui-col-md1">
            总额
        </div>
        <div class="layui-col-md1">
            购买
        </div>

        <div class="layui-col-md1">
            删除
        </div>

    </div>


    <c:forEach items="${myCart}" var="cart">
        <div class="layui-row">
            <div class="layui-col-md3">
                <img src="${cart.goods_picture}" alt="" width="120px" height="60px">
            </div>
            <div class="layui-col-md1">
                ${cart.goods_name}
            </div>
            <div class="layui-col-md1">
                ${cart.price}
            </div>

            <div class="layui-col-md1">
                <div class="op_num">
                    <a href="/down?cart_id=${cart.cart_id}">
                        <button class="btn_op" id="down">
                            &nbsp;&nbsp;- &nbsp;&nbsp;
                        </button>
                    </a>
                    <div id="num">
                        ${cart.goods_stock}
                    </div>
                    <a href="/add?cart_id=${cart.cart_id}">
                        <button class="btn_op" id="up" onclick="up()">
                            &nbsp;&nbsp;+ &nbsp;&nbsp;
                        </button>
                    </a>
                </div>
            </div>

<%--            <div class="layui-col-md1">--%>
<%--                --%>
<%--            </div>--%>
            <div class="layui-col-md2">
                ${cart.input_time}
            </div>
            <div class="layui-col-md2">
                ${cart.on_time}
            </div>
            <div class="layui-col-md1">
                ${cart.total_price}
            </div>

            <div class="layui-col-md1">

                <div class="buy_button_box">
                    <a href="/addToOrders?cart_id=${cart.cart_id}&goods_id=${cart.goods_id}&quantity=${cart.goods_stock}&order_price=${cart.total_price}">
                        <input type="button" value="下单" class="button_buy"/>
                    </a>
                </div>
            </div>
            <div class="layui-col-md1">
                <div class="del_button_box">
                    <a href="/removeCart?goods_id=${cart.goods_id}">
                        <input type="button" value="删除" class="button_del"/>
                    </a>
                </div>
            </div>
        </div>
    </c:forEach>


</div>


<%@ include file="footer.jsp" %>


</body>
</html>
