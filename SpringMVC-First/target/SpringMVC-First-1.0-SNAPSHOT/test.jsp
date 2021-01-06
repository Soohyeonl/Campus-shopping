<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="./layui/css/layui.css" rel="stylesheet" media="all">
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>


<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">
            <div class="row-fluid">
                <div class="span12">
                    <ul class="layui-nav">
                        <li class="layui-nav-item">
                            <a href="">控制台<span class="layui-badge">9</span></a>
                        </li>
                        <li class="layui-nav-item">
                            <a href="">个人中心<span class="layui-badge-dot"></span></a>
                        </li>
                        <li class="layui-nav-item" lay-unselect="">
                            <a href="javascript:;"><img src="//t.cn/RCzsdCq" class="layui-nav-img">我</a>
                            <dl class="layui-nav-child">
                                <dd><a href="javascript:;">修改信息</a></dd>
                                <dd><a href="javascript:;">安全管理</a></dd>
                                <dd><a href="javascript:;">退了</a></dd>
                            </dl>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="row-fluid">
                <div class="span2">
                    <ul class="layui-nav layui-nav-tree layui-inline" lay-filter="demo" style="margin-right: 10px;">
                        <li class="layui-nav-item layui-nav-itemed">
                            <a href="javascript:;">默认展开</a>
                            <dl class="layui-nav-child">
                                <dd><a href="javascript:;">选项一</a></dd>
                                <dd><a href="javascript:;">选项二</a></dd>
                                <dd><a href="javascript:;">选项三</a></dd>
                                <dd><a href="">跳转项</a></dd>
                            </dl>
                        </li>
                        <li class="layui-nav-item">
                            <a href="javascript:;">解决方案</a>
                            <dl class="layui-nav-child">
                                <dd><a href="">移动模块</a></dd>
                                <dd><a href="">后台模版</a></dd>
                                <dd><a href="">电商平台</a></dd>
                            </dl>
                        </li>
                        <li class="layui-nav-item"><a href="">云市场</a></li>
                        <li class="layui-nav-item"><a href="">社区</a></li>
                    </ul>

                </div>
                <div class="span10">
                </div>
            </div>
        </div>
    </div>
</div>

<script src="./layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    layui.use('element', function(){
        var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块

        //监听导航点击
        element.on('nav(demo)', function(elem){
            //console.log(elem)
            layer.msg(elem.text());
        });
    });
</script>

</body>
</html>