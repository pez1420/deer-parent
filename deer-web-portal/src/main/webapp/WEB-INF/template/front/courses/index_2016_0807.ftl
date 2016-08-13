<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>DeerMe课程体系</title>
    <link rel="stylesheet" href="${base}/resources/front/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="${base}/resources/front/css/courses.css" type="text/css">
    <link rel="stylesheet" href="${base}/resources/front/css/navfixed.css" type="text/css">
</head>

<body>
<div class="top-tip">
    <div class="top-tip-container">
        <div class="top-tip-rl" style="margin-top:-2px;margin-right:10px">
            <a class="btn btn-default btn-sm header-login" href="login.jhtml">登录</a>&nbsp;&nbsp;&nbsp;&nbsp;
            <a class="btn btn-default btn-sm header-register" href="register.jhtml">注册</a>
            <a class="btn btn-default btn-sm header-username" href="#"></a>
            <a class="btn btn-default btn-sm header-logout" href="logout.jhtml">[退出]</a>
        </div>
    </div>
</div>


<!-- 模态框（Modal） -->
<div class="modal fade bs-example-modal-sm" id="loginModal" tabindex="-1" role="dialog"
     aria-labelledby="myModalLabel" aria-hidden="true" >
    <div class="modal-dialog modal-sm" style="width:500px;margin-top:200px">
        <div class="modal-content" >
            <div class="modal-header">
                <button type="button" class="close"
                        data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h5 class="modal-title" id="myModalLabel">
                    <b>登录DeerMe</b>
                </h5>
            </div><br><br>
            <div class="input-group" style="width:100%;padding-left:20px;padding-right:20px">
                <span class="input-group-addon" id="basic-addon1" style="width:15%"><span class="glyphicon glyphicon-phone"></span></span>
                <input type="text" name="u_name" class="form-control" placeholder="请输入您的手机号码" aria-describedby="basic-addon1">
            </div><br><br>
            <div class="input-group" style="width:100%;padding-left:20px;padding-right:20px">
                <span class="input-group-addon" id="basic-addon1" style="width:15%"><span class="glyphicon glyphicon-lock"></span></span>
                <input type="password" name="u_password" class="form-control" placeholder="请输入您的登录密码" aria-describedby="basic-addon1">
            </div><br>
            <div class="checkbox" style="width:100%;padding-left:20px;padding-right:20px">
                <label>
                    <input type="checkbox">下次自动登录
                </label>
                <label>
                    <a style="margin-left:50px">忘记密码？</a>
                </label>
            </div><br>
            <div style="width:100%;padding-left:20px;padding-right:20px;padding-bottom:20px">
                <button type="submit" class="btn btn-danger" style="width:100%">登录</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<div class="header">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="#"><img src="${base}/resources/front/img/logo.png"></a>
        </div>
        <div class="collapse navbar-collapse navbar-responsive-collapse navbar-right nav-right">
            <ul class="nav navbar-nav" id="navbar">
                <li><a href="index.jhtml">首页</a></li>
                <li><a href="#">公开课</a></li>
                <li><a class="active" href="#">课程体系</a></li>
                <li><a href="${base}/recruit.html">人才招聘</a></li>
            </ul>
        </div>
    </div>
</div>

<!--头部大图courses_top-->
<div style="height:500px;background:url(${base}/resources/front/img/courses_top_img.png);background-size:100% 100%;background-color:#ffffff;">
</div>
<!--头部大图-->

<!--课程特色coursefeatures-->
<div id="advantage-unit" style="height:420px;background-color:#ffffff;">
    <div class="unit-header">
        <br><h2>课程特色</h2>
    </div>
    <div>
        <ul style="width:1130px;margin:0 auto;">
            <li class="advantage-li" style="float:left;width:263px;height:300px;list-style:none;text-align:center">
                <img src="${base}/resources/front/img/coursefeatures1.png" class="img-rounded" style="padding:10px;">
                <h4 style="margin-left:20px">美国小学教学标准</h4>
                <p style="padding:10px">DeerMe所有课程设计，皆参考美国中小学共同核心课程标准（Common Core State Standaerds for K12,简称CCSS）</p>
            </li>
            <li class="advantage-li" style="float:left;width:263px;height:300px;list-style:none;text-align:center">
                <img src="${base}/resources/front/img/coursefeatures2.png" class="img-rounded" style="padding:10px">
                <h4 style="margin-left:20px">语言和内容整合教学法</h4>
                <p style="padding:10px">语言学些和学科知识相结合，即学会英语语言本身，也学会用英语了解数学、科学和艺术等学科知识</p>
            </li>
            <li class="advantage-li" style="float:left;width:263px;height:300px;list-style:none;text-align:center">
                <img src="${base}/resources/front/img/coursefeatures3.png" class="img-rounded" style="padding:10px">
                <h4 style="margin-left:20px">线上课程+线下动手实践</h4>
                <p style="padding:10px">线上互动课程帮助孩子学习知识，课后趣味实践活动引导孩子学以致用，动手实践，发现问题，解决问题</p>
            </li>
            <li class="advantage-li" style="float:left;width:263px;height:300px;list-style:none;text-align:center">
                <img src="${base}/resources/front/img/coursefeatures4.png" class="img-rounded" style="padding:10px">
                <h4 style="margin-left:20px">项目协作式学习</h4>
                <p style="padding:10px">设置各种项目研究专题，鼓励学生积极参与项目协作，主动探索，学会独立进行科学研究和自我展示，培养和解决实际问题的能力</p>
            </li>
        </ul>
    </div>
</div>
<!--课程特色-->

<!--主修课majorsubject-->
<div class="section" style="height:550px;background-color:#f2f2f2;">
    <div class="container p-y-xl b-b">
        <div class="row m-b-md" style="padding:20px;">
            <div class="col-md-6 col-md-offset-3 text-center">
                <h2 class="h2 display-2 m-t">主修课</h2>
            </div>
        </div><!-- .row -->
        <table class="table">
            <tbody>
            <tr>
                <td style="border: 1px solid transparent !important;vertical-align: middle;"><img src="${base}/resources/front/img/majorsubject1.png" class="img-rounded" ></td>
                <td style="border: 1px solid transparent !important;vertical-align: middle;"><p class="text-muted">DeerMe左右课程设计，都参照美国中小学共同核心课程标准（Common Core State Standards for K12,简称CCSS）</p></td>
            </tr>
            <tr>
                <td style="border: 1px solid transparent !important;vertical-align: middle;"><img src="${base}/resources/front/img/majorsubject2.png" class="img-rounded" ></td>
                <td style="border: 1px solid transparent !important;vertical-align: middle;"><p class="text-muted">DeerMe左右课程设计，都参照美国中小学共同核心课程标准（Common Core State Standards for K12,简称CCSS）</p></td>
            </tr>
            <tr>
                <td style="border: 1px solid transparent !important;vertical-align: middle;"><img src="${base}/resources/front/img/majorsubject3.png" class="img-rounded" ></td>
                <td style="border: 1px solid transparent !important;vertical-align: middle;"><p class="text-muted">DeerMe左右课程设计，都参照美国中小学共同核心课程标准（Common Core State Standards for K12,简称CCSS）</p></td>
            </tr>
            </tbody>
        </table>
    </div><!-- .container -->
</div><!-- .section -->
<!--主修课-->

<!--主题课majortheme-->
<div id="majortheme-unit" style="height:1100px;background-color:#ffffff;">
    <div class="container p-y-xl b-b">
        <div class="row m-b-md" style="padding:20px;">
            <div class="col-md-6 col-md-offset-3 text-center">
                <h2 class="h2 display-2 m-t">主题课</h2>
            </div>
        </div><!-- .row -->
        <div>
            <ul style="width:1200px;margin:0 auto;">
                <li class="advantage-li" style="float:left;width:520px;height:500px;list-style:none;text-align:center">
                    <img src="${base}/resources/front/img/majortheme1.png" class="img-rounded" style="padding:10px;text-align:center">
                    <h4 style="text-align:left;margin-left:35px">小小牛顿</h4>
                    <p style="text-align:left;padding-left:35px;padding-right:35px">用有趣的方式将孩子带人物理的奇妙世界</p>
                </li>
                <li class="advantage-li" style="float:left;width:520px;height:500px;list-style:none;text-align:center">
                    <img src="${base}/resources/front/img/majortheme2.png" class="img-rounded" style="padding:10px;text-align:center">
                    <h4 style="text-align:left;margin-left:35px">小小数学家</h4>
                    <p style="text-align:left;padding-left:35px;padding-right:35px">通过数学、图形、商业、游戏四个领域中的趣味故事，激发孩子们对数学的热情，培养孩子对数字的感觉和逻辑分析的能力</p>
                </li>
                <li class="advantage-li" style="float:left;width:520px;height:500px;list-style:none;text-align:center">
                    <img src="${base}/resources/front/img/majortheme3.png" class="img-rounded" style="padding:10px;text-align:center">
                    <h4 style="text-align:left;margin-left:35px">小小哥伦布</h4>
                    <p style="text-align:left;padding-left:35px;padding-right:35px">结合精美的课件，对全世界各个地方的地址知识、自然风光和文化习俗进行有趣的介绍，带入奇妙的环球探索之旅</p>
                </li>
                <li class="advantage-li" style="float:left;width:520px;height:500px;list-style:none;text-align:center">
                    <img src="${base}/resources/front/img/majortheme4.png" class="img-rounded" style="padding:10px;text-align:center">
                    <h4 style="text-align:left;margin-left:35px">小小达尔文</h4>
                    <p style="text-align:left;padding-left:35px;padding-right:35px">和外教一起，去探索地球上奇妙的生物，增长孩子对世界的认识</p>
                </li>
            </ul>
        </div><br>
    </div>
</div>
<!--主题课majortheme-->

<!--底部大图bottompic-->
<div id="begin-unit" style="height:650px;background-color:#f2f2f2;text-align:center;padding:50px;">
    <img src="${base}/resources/front/img/bottompic.png" class="img-rounded">
</div>
<!--底部大图bottompic-->

<!--底部固定-->
<div style="position: fixed;vertical-align: middle;" id="register" class="register-bar">
    <div class="inner">
        <div class="form-inline">
            <b>申请免费体验</b>
            <div class="form-group">
                <a href="#" id="tooltip-apply-child" data-toggle="tooltip" title="孩子姓名格式有误">
                    <input type="text" class="form-control" id="apply-child" placeholder="孩子姓名">
                </a>
            </div>
            <div class="form-group">
                <a href="#" id="tooltip-apply-mobile" data-toggle="tooltip" title="家长手机号格式有误">
                    <input type="text" class="form-control" id="apply-mobile" placeholder="家长手机号">
                </a>
            </div>
            <button type="button" class="btn btn-danger btn-apply">立即申请</button>
            <b style="font-size:14px">今日只剩64个名额</b>
        </div>
    </div>
</div>
<!--底部固定-->

<!-- 底部版权信息 -->
<div id="footer">
    <div id="info-foot">
        <p>Copyright 2016 DeerMe培训平台. All rights reserved.</p>
    </div>
</div>
<!-- /底部版权信息 -->

<script src="${base}/resources/front/js/jquery-1.8.1.min.js"></script>
<script src="${base}/resources/front/js/bootstrap.min.js"></script>
<script src="${base}/resources/front/js/portal.common.js"></script>
<script src="${base}/resources/front/js/courses.js"></script>

<script type="text/javascript">

    $(document).ready(function(){
        var $headerUsername =  $(".header-username");
        var $headerLogin =  $(".header-login");
        var $headerRegister =  $(".header-register");
        var $headerLogout =  $(".header-logout");
        var $register = $("#register");

        var username = getCookie("username");
        if (username != null) {
            $headerUsername.text("hi," + username).show();
            $headerLogin.hide();
            $headerRegister.hide();
            $headerLogout.show();
            $register.hide();
        } else {
            $headerUsername.hide();
            $headerLogin.show();
            $headerRegister.show();
            $headerLogout.hide();
            $register.show();
        }

        //提交申请
        var $btnApply = $(".btn-apply");
        $btnApply.off("click").on("click", function(){
            var $mobile = $("#apply-mobile");
            var $child = $("#apply-child");
            var isMobile = /^((\(\d{3}\))|(\d{3}\-))?13\d{9}|14[57]\d{8}|15\d{9}|18\d{9}$/;
            if ($mobile.val() != null && $mobile.val() != "" && $mobile.val().match(isMobile)) {
                var mobile = $.trim($mobile.val());
                var child = $.trim($child.val());
                window.location.href= "index/apply.jhtml?child=" + encodeURI(encodeURI(child)) +"&mobile=" + mobile;
            } else {
                $('#tooltip-apply-mobile').tooltip('show');
            }
        });

        $('#tooltip-inputname').tooltip('hide');//input输入错误提示工具
        $('#tooltip-inputmobile').tooltip('hide');
    });

</script>
</body>
</html>