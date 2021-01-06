<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>收货地址填写</title>

    <link rel="stylesheet" href="css/Adressstyle.css">

</head>
<body>


<div id="img2">
    <img src="css/imagines/2.jpg" alt="爱学习" width="600" height="600">
</div>


<div class="adderss_info" style="font-weight: bold;font-size: 20px;
                                 color: lightcoral;float: right;
                                 padding-right: 100px;font-family:Serif;">
    <c:if test="${!empty haveAddress}">
        <p>你的地址为：${haveAddress}，当前修改会覆盖地址</p>
    </c:if>
</div>


<div class="fram">
    <div class="biaoti">
        <h1>收货地址填写</h1>
    </div>
    <div class="father">
        <form action="/newAddress" method="post">
            <div class="selc">
                <span class="xiaoqu">校区：</span>
                <select name="xiaoqu" id="sec1">
                    <%--                    <option value="0">--%>
                    <%--                        <span>请选择</span>--%>
                    <%--                    </option>--%>
                    <option value="余家头">
                        <span>余家头</span>
                    </option>
                    <option value="南湖">
                        <span>南湖</span>
                    </option>
                    <option value="鉴湖">
                        <span>鉴湖</span>
                    </option>
                    <option value="东院">
                        <span>东院</span>
                    </option>
                    <option value="西苑">
                        <span>西苑</span>
                    </option>
                </select>

                <span class="zhusuqu">住宿区：</span>
                <select name="zhusuqu" id="sec2">
                    <%--                    <option value="0">--%>
                    <%--                        <span>请选择</span>--%>
                    <%--                    </option>--%>
                    <option value="海虹">
                        <span>海虹</span>
                    </option>
                    <option value="升升公寓">
                        <span>升升公寓</span>
                    </option>
                    <option value="南湖宿舍楼">
                        <span>南湖宿舍楼</span>
                    </option>
                    <option value="鉴湖宿舍楼">
                        <span>鉴湖宿舍楼</span>
                    </option>
                    <option value="东院宿舍楼">
                        <span>东院宿舍楼</span>
                    </option>
                    <option value="西苑宿舍楼">
                        <span>西苑宿舍楼</span>
                    </option>
                </select>
            </div>
            <br>
            <div class="xiangzhi">
                <span id="s12">详细地址:</span>
                <input class="txt" name="det_address" type="text" placeholder="请输入详细地址" required="required">
            </div>
            <div class="s_btn">
                <input class="btn" id="bt1" type="submit" value="完成">
                <input class="btn" id="bt2" type="reset" value="清空输入">
            </div>
        </form>
    </div>
</div>


</body>
</html>