<%--
  Created by IntelliJ IDEA.
  User: mktb
  Date: 1/4/2021
  Time: 3:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="style/headerStyle.css" rel="stylesheet" media="all">
<link href="./layui/css/layui.css" rel="stylesheet" media="all">
<style>

    .h_top_right {
        float: right; /*左右显示*/
    }
</style>

<ul class="layui-nav">
    <li class="layui-nav-item">
        <a href="/allGoods">主页</a>
    </li>
    <%--    <li class="layui-nav-item" lay-unselect="">--%>
    <%--        <a href="javascript:;"><img src="//t.cn/RCzsdCq" class="layui-nav-img">我</a>--%>
    <%--        <dl class="layui-nav-child">--%>
    <%--            <dd><a href="javascript:;">修改信息</a></dd>--%>
    <%--            <dd><a href="javascript:;">安全管理</a></dd>--%>
    <%--            <dd><a href="javascript:;">退了</a></dd>--%>
    <%--        </dl>--%>
    <%--    </li>--%>

    <div class="h_top_right">
        <!--有没有用户 session -->
        <c:if test="${empty userStatue }">
            <li class="layui-nav-item">
                <a href="login.jsp">登录</a>
            </li>
            <li class="layui-nav-item">
                <a href="register.jsp">注册</a>
            </li>
        </c:if>

        <c:if test="${!empty userStatue }">
<%--            <li class="layui-nav-item">--%>
<%--                欢迎： ${userStatue.user_nick_name }--%>
<%--            </li>--%>
            <li class="layui-nav-item" lay-unselect="">
                <a href="javascript:;"><img src="${userStatue.user_picture}" class="layui-nav-img">${userStatue.user_nick_name }</a>
                <dl class="layui-nav-child">
                    <dd><a href="/upload.jsp">出售商品</a></dd>
                    <dd><a href="/myGoods">我出售的商品</a></dd>
                    <dd><a href="/myAddress">修改地址</a></dd>
                    <dd><a href="/myCart">我的购物车</a></dd>
                    <dd><a href="/myBills">我的订单</a></dd>
                    <dd><a href="/mySellOrders?seller_id=${userStatue.user_id}">出售订单</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item">
                <a href="/logout">
                    退出
                </a>
            </li>
        </c:if>

    </div>
    <%--    <li class="layui-nav-item">--%>
    <%--        <div class="upright">--%>
    <%--            <a href="">登录<span class="layui-badge-dot"></span></a>--%>
    <%--        </div>--%>

    <%--    </li>--%>
    <%--    <li class="layui-nav-item">--%>
    <%--        <div class="upright">--%>
    <%--            <a href="">注册<span class="layui-badge-dot"></span></a>--%>
    <%--        </div>--%>
    <%--    </li>--%>
</ul>


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