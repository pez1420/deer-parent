<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>DeerMe培训平台</title>
    <link rel="stylesheet" href="${base}/resources/front/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="${base}/resources/front/css/common.css" type="text/css">
    <link rel="stylesheet" href="${base}/resources/front/css/slider.css" type="text/css">
    <link rel="stylesheet" href="${base}/resources/front/css/index.css" type="text/css">
    <link rel="stylesheet" href="${base}/resources/front/css/rightfix.css" type="text/css">
    <link rel="stylesheet" href="${base}/resources/front/css/teachershow.css" type="text/css">
    <link rel="stylesheet" href="${base}/resources/front/css/navfixed.css" type="text/css">

    <script src="${base}/resources/front/js/jquery-1.8.1.min.js"></script>
    <script src="${base}/resources/front/js/jquery.flexslider-min.js"></script>
    <script src="${base}/resources/front/js/bootstrap.min.js"></script>
    <script src="${base}/resources/front/js/jquery.validate.min.js"></script>
    <script src="${base}/resources/front/js/portal.common.js"></script>
    <script src="${base}/resources/front/js/index.js"></script>
    <script>
        $(document).ready(function(){
            var $loginForm = $("#loginForm");
            var $username = $("#u_name");
            var $password = $("#u_password");
            var $isRememberUsername = $("#isRememberUsername");
            var $submit = $(":submit");

            // 登录表单验证
            $loginForm.validate({
                rules: {
                    u_name: {
                        required: true,
                        mobile:true,
                    },
                    u_password: {
                        required: true,
                    }
                },
                messages : {

                },
                submitHandler: function(form) {
                    console.log("form_serialize:", $loginForm.serialize());
                    $.ajax({
                        url: $loginForm.attr("action"),
                        type: "POST",
                        data: {
                            username: $username.val(),
                            password: $password.val(),
                        },
                        dataType: "json",
                        cache: false,
                        success: function(message) {
                            if ($isRememberUsername.prop("checked")) {
                                addCookie("memberUsername", $username.val(), {expires: 7 * 24 * 60 * 60});
                            } else {
                                removeCookie("memberUsername");
                            }
                            $submit.prop("disabled", false);
                            if (message.type == "success") {
                                [#if redirectUrl??]
                                    window.setTimeout(function() {
                                        $submit.prop("disabled", false);
                                        location.href = "${redirectUrl}/";
                                    }, 2000);
                                [#else]
                                    window.setTimeout(function() {
                                        $submit.prop("disabled", false);
                                        location.href = "${base}/";
                                    }, 2000);
                                [/#if]
                            } else {
                                $.message(message);
                                console.log("message == ", message);
                            }
                        }
                    });
                }

            });

            var isMobile = /^((\(\d{3}\))|(\d{3}\-))?13\d{9}|14[57]\d{8}|15\d{9}|18\d{9}$/;
            //提交申请
            $(".btn-apply").off("click").on("click", function(){
                var $mobile = $("#apply-mobile");
                var $child = $("#apply-child");
                if ($mobile.val() != null && $mobile.val() != "" && $mobile.val().match(isMobile)) {
                    var mobile = $.trim($mobile.val());
                    var child = $.trim($child.val());
                    window.location.href= "index/apply.jhtml?child=" + encodeURI(encodeURI(child)) +"&mobile=" + mobile;
                } else {
                    $('#tooltip-apply-mobile').tooltip('show');
                }
            });

/*            var $headerUsername =  $(".header-username");
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
            }*/

        });

    </script>
</head>

<body>
[#--<div class="top-tip">
    <div class="top-tip-container">
        <div class="top-tip-rl" style="margin-top:-2px;margin-right:10px">
            <a class="btn btn-default btn-sm header-login" href="login.jhtml">登录</a>&nbsp;&nbsp;&nbsp;&nbsp;
            <a class="btn btn-default btn-sm header-register" href="register.jhtml">注册</a>
            <a class="btn btn-default btn-sm header-username" href="#"></a>
            <a class="btn btn-default btn-sm header-logout" href="logout.jhtml">[退出]</a>
        </div>
    </div>
</div>--]

<div class="header">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="#"><img src="${base}/resources/front/img/logo.png"></a>
        </div>
        <div class="collapse navbar-collapse navbar-responsive-collapse navbar-right nav-right">
            <ul class="nav navbar-nav" id="navbar">
                <li><a class="active" href="#">首页</a></li>
                <li><a href="#">公开课</a></li>
                <li><a href="courses.jhtml">课程体系</a></li>
                <li><a href="${base}/recruit.html">人才招聘</a></li>
                <li><a target="_blank" href="login.jhtml">登录</a></li>
                <li><a target="_blank" href="register.jhtml">注册</a></li>
            </ul>
        </div>
    </div>
</div>
<center>
    <div class="flex-container">
        <div class="flexslider">
            <ul class="slides">
                <li>
                    <img src="${base}/resources/front/img/slide1.jpg" />
                    <div style="position:absolute;top:220px;left:60px; width:620px;background:#333;opacity:.5;color:#fff">
                        <p style="padding:18px;text-align:left;font-size:20px;font-family:'Microsoft YaHei',Helvetica,sans-serif" >
                            <span style="font-size:30px">同步美国中小学课程，在家就能留学美国</span><br><br><br>
                            <span class="glyphicon glyphicon-triangle-left" aria-hidden="true"></span>采用美国教育部共同核心课程标准（CCSS）<br><br>
                            <span class="glyphicon glyphicon-triangle-left" aria-hidden="true"></span>精选北美优秀ESL教师
                        </p>
                    </div>
                </li>
                <li>
                    <img src="${base}/resources/front/img/slide2.jpg" />
                    <div style="position:absolute;top:550px;left:290px;width:600px;background:#333;opacity:.5; color:#fff">
                        <p style="padding:18px;text-align:left;font-size:20px;font-family:'Microsoft YaHei',Helvetica,sans-serif" >
                            <span style="font-size:24px">全方位学科体系，掌握学科英语应用能力</span><br><br>
                            <span class="glyphicon glyphicon-triangle-left" aria-hidden="true"></span>覆盖文学、科学、社会学等主要学科，全面衔接北美课堂<br><br>
                            <span class="glyphicon glyphicon-triangle-left" aria-hidden="true"></span>运用SIOP教学模式，真正掌握学术语言运用能力
                        </p>
                    </div>
                </li>
                <li>
                    <img src="${base}/resources/front/img/slide3.jpg" />
                    <div style="position:absolute;top:200px;left:80px;width:600px;background:#333;opacity:.5;color:#fff">
                        <p style="padding:18px;text-align:left;font-size:20px;font-family:'Microsoft YaHei',Helvetica,sans-serif" >
                            <span style="font-size:24px">探索性学习方式，开发创新思维</span><br><br>
                            <span class="glyphicon glyphicon-triangle-left" aria-hidden="true"></span>以学生为中心的定制化教学，全面激发探索能力<br><br>
                            <span class="glyphicon glyphicon-triangle-left" aria-hidden="true"></span>运用思维导图和设计思维理念，注重逻辑能力与动手实践
                        </p>
                    </div>
                </li>

            </ul>
        </div>
    </div>
</center>

<div class="jumbotron" style="height:120px;text-align:center;background:#ff6666;color:#ffffff;margin-top:-20px">
    <div class="container" >
        <h3><b>接轨优质国际教育资源，从DeerKid开始</b></h3>
    </div>
</div>

<!--我们的优势-->
<div id="advantage-unit" style="height:980px;background-color:#ffffff;">
    <div class="unit-header">
        <h2>我们的优势</h2>
    </div>
    <div>
        <ul style="width:1130px;margin:0 auto;">
            <li class="advantage-li" style="float:left;width:320px;height:380px;list-style:none;background-color:#f2f2f2;border:2px solid #99ccff">
                <img src="${base}/resources/front/img/advantage1.jpg" class="img-rounded" style="padding:10px">
                <h4 style="margin-left:20px">强大的北美外教团队：</h4>
                <p style="padding:10px">全美国和加拿大外籍外教，北美名校毕业。持有全球认证的国际英语教学资格证书，具有丰富的少儿ESL教学经验。</p>
            </li>
            <li class="advantage-li" style="float:left;width:320px;height:380px;list-style:none;background-color:#f2f2f2;border:2px solid #99ccff;margin-left:40px">
                <img src="${base}/resources/front/img/advantage2.jpg" class="img-rounded" style="padding:10px">
                <h4 style="margin-left:20px">线上一对一真人授课：</h4>
                <p style="padding:10px">北美外教一对一线上授课，100%沉浸式英语教学环境；足不出户，便可把北美名师“请回家”。</p>
            </li>
            <li class="advantage-li" style="float:left;width:320px;height:380px;list-style:none;background-color:#f2f2f2;border:2px solid #99ccff;margin-left:40px">
                <img src="${base}/resources/front/img/advantage3.jpg" class="img-rounded" style="padding:10px">
                <h4 style="margin-left:20px">国际最为主流的CLIL教学法：</h4>
                <p style="padding:10px">采用先进的“内容和语言整合学习法”（CLIL），以学科知识为背景，以英语为媒介，将语言学习和学科知识结合在一起。</p>
            </li>
            <li class="advantage-li" style="float:left;width:320px;height:380px;list-style:none;background-color:#f2f2f2;border:2px solid #99ccff;margin-top:40px;">
                <img src="${base}/resources/front/img/advantage4.jpg" class="img-rounded" style="padding:10px">
                <h4 style="margin-left:20px">同步美国小学标准：</h4>
                <p style="padding:10px">课程体系基于全美教育标准CCSS，同美国小学课程无缝连接；所用教材由DeerKid在美国主流小学教材基础之上独家研发。</p>
            </li>
            <li class="advantage-li" style="float:left;width:320px;height:380px;list-style:none;background-color:#f2f2f2;border:2px solid #99ccff;margin-top:40px;margin-left:40px">
                <img src="${base}/resources/front/img/advantage5.jpg" class="img-rounded" style="padding:10px">
                <h4 style="margin-left:20px">强大的网络上课平台：</h4>
                <p style="padding:10px">高清流畅的网络视频传输和语音互动，带来不输于真实课堂的上课体验；课程结束，自动录播，随时了解孩子的课堂表现。</p>
            </li>
            <li class="advantage-li" style="float:left;width:320px;height:380px;list-style:none;background-color:#f2f2f2;border:2px solid #99ccff;margin-top:40px;margin-left:40px">
                <img src="${base}/resources/front/img/advantage6.jpg" class="img-rounded" style="padding:10px">
                <h4 style="margin-left:20px">专业的中文助教团队：</h4>
                <p style="padding:10px">每名学生配有一位中文助教，全程跟踪辅导学生，助教团队均为英语专业8级或具有海外留学经验。</p>
            </li>
        </ul>
    </div>
    <div style="text-align:center;padding-top:830px">
        <button type="button" class="btn btn-danger btn-lg">免费预约体验课 ></button>
    </div>
</div>
<!--我们的优势-->

<!--我们的外教团队-->
<div id="teacher-unit" style="height:550px;background-color:#f2f2f2">
    <div class="unit-header">
        <h2 style="padding-top:30px">我们的外教团队</h2>
        <p style="font-size:18px">我们的外教全部来自北美英语国家，100%本科学历之上，均持有TESOL和TEFL等
            全球认证的国际英语教学资格证书，<br>具有丰富的ESL教学经验和北美小学任教资质。</p>
    </div>
    <div style="text-align:center">
        <ul class="pictureshow">
            <li style="margin-left:-20px">
                <div class="boxgrid slidedown" id="boxgrid1">
                    <img src="${base}/resources/front/img/teacher1.jpg" width="280" height="280" class="cover" style="top: 0px;">
                    <h3>
                        <b>Tommy.T</b>
                    </h3>
                    <p style="padding:10px">Tommy.T毕业于英国Warwick大学，并获得理学（经济类）学士，拥有原汁原味伦敦口音的英国绅士。</p>
                </div>
            </li>
            <li>
                <div class="boxgrid slidedown" id="boxgrid2">
                    <img src="${base}/resources/front/img/teacher2.jpg" width="280" height="280" class="cover" style="top: 0px;">
                    <h3>
                        <b>Hellen.J</b>
                    </h3>
                    <p style="padding:10px">Hellen.J毕业于英国Warwick大学，并获得理学（经济类）学士，拥有原汁原味伦敦口音的英国绅士。</p>
                </div>
            </li>
            <li>
                <div class="boxgrid slidedown" id="boxgrid3">
                    <img src="${base}/resources/front/img/teacher3.jpg" width="280" height="280" class="cover" style="top: 0px;">
                    <h3>
                        <b>Carrie.S</b>
                    </h3>
                    <p style="padding:10px">Carrie.S毕业于英国Warwick大学，并获得理学（经济类）学士，拥有原汁原味伦敦口音的英国绅士。</p>
                </div>
            </li>
            <li>
                <div class="boxgrid slidedown" id="boxgrid4">
                    <img src="${base}/resources/front/img/teacher4.jpg" width="280" height="280" class="cover" style="top: 0px;">
                    <h3>
                        <b>Gabriel</b>
                    </h3>
                    <p style="padding:10px">Gabriel毕业于英国Warwick大学，并获得理学（经济类）学士，拥有原汁原味伦敦口音的英国绅士。</p>
                </div>
            </li>
            <li style="text-align:center;height:100px;">
                <h3>
                    <b>Tommy.T&nbsp;&nbsp;</b>
                </h3>
            </li>
            <li style="text-align:center;height:100px;">
                <h3>
                    <b>Hellen.J&nbsp;&nbsp;</b>
                </h3>
            </li>
            <li style="text-align:center;height:100px;">
                <h3>
                    <b>Carrie.S&nbsp;&nbsp;</b>
                </h3>
            </li>
            <li style="text-align:center;height:100px;">
                <h3>
                    <b>Gabriel&nbsp;&nbsp;</b>
                </h3>
            </li>
            <div class="cle"></div>
        </ul>
    </div>
</div>
<!--我们的外教团队-->

<!--课程级别-->
<div id="course-unit" style="height:700px;background-color:#ffffff;">
    <div class="unit-header">
        <h2 style="padding-top:20px">课程级别</h2>
        <p style="font-size:18px">同步美国小学标准，根据一对一测评结果，选择合适级别的课程。</p>
    </div>
    <div style="text-align:center;padding-top:40px">
        <img src="${base}/resources/front/img/course.jpg" /><br><br><br>
        <p class="text-center" style="padding-left:200px;padding-right:200px">Deerkids课程研发团队基于美国中小学共同核心课程标准（CCSS），结合英语非母语学生学习特点，选取和优化了适应不同年龄段和层级的英语学科教材，内容涵盖美国中小学核心课程，着重强调英语能力和学科语言运用能力，力求帮助学生达到美国教育体系的学习标准。</p><br><br>
        <button type="button" class="btn btn-danger btn-lg">免费预约体验课 ></button>
    </div>

</div>
<!--课程级别-->

<!--教学质量管理体系-->
<div id="teachingquality-unit" style="height:650px;background-color:#f2f2f2;">
    <div class="unit-header">
        <h2 style="padding-top:30px">教学质量管理体系</h2>
    </div>
    <div>
        <ul style="width:1130px;margin:0 auto;">
            <li style="float:left;width:250px;height:400px;list-style:none;background-color:#ffffff;margin-left:-18px">
                <img src="${base}/resources/front/img/teaching1.png" class="img-rounded" style="padding:10px">
                <h5 style="margin-left:20px">入学前水平测试，确定课程级别</h5>
            </li>
            <li style="float:left;width:250px;height:400px;list-style:none;background-color:#ffffff;margin-left:30px">
                <img src="${base}/resources/front/img/teaching2.png" class="img-rounded" style="padding:10px">
                <h5 style="margin-left:20px">根据学生学习情况，制定个性化学习方案</h5>
            </li>
            <li style="float:left;width:250px;height:400px;list-style:none;background-color:#ffffff;margin-left:30px">
                <img src="${base}/resources/front/img/teaching3.png" class="img-rounded" style="padding:10px">
                <h5 style="margin-left:20px">每次上课后，外教及时给予教学反馈，家长可获得孩子的一手学习情况；同事学生可对外教进行评分，提出建议</h5>
            </li>
            <li style="float:left;width:250px;height:400px;list-style:none;background-color:#ffffff;margin-left:30px">
                <img src="${base}/resources/front/img/teaching4.png" class="img-rounded" style="padding:10px">
                <h5 style="margin-left:20px">教学督导团队对学生学习进度和效果进行评估，结合学生家长意见，调整外教的教学方案，优化教学目标</h5>
            </li>
        </ul>
    </div><br><br>
    <div style="text-align:center;margin-top:380px"><br>
        <button type="button" class="btn btn-danger btn-lg">免费预约体验课 ></button>
    </div>
</div>
<!--教学质量管理体系-->

<div id="begin-unit" style="height:600px;background:url(${base}/resources/front/img/begin.jpg);background-size:100% 100%;background-color:#ffffff;">
    <div class="unit-header" style="padding:80px">
        <button type="button" class="btn btn-danger btn-lg">立即预约 ></button><br><br><br>
        <p class="text-center" style="color:#ffffff;font-size:18px">在线注册，申请体验课，确定试听时间</p><br><br><br>
        <p class="text-center" style="color:#ffffff;font-size:24px"><b>仅需3步，轻松体验外教趣味体验课</b></p>
    </div>
</div>

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

<!-- 右侧导航 -->
<div class="rightNav" style="z-index:9999;">
    <a class="bigfix" target="_blank" href="http://www.apple.com/cn/"><img src="${base}/resources/front/img/fix11.png" title="点击链接到苹果官网"/></a>
    <a class="smallfix" target="_blank" href="https://www.baidu.com" style="right: -110px;"><em><img src="${base}/resources/front/img/fix1.png"/></em>访问百度</a>
    <a class="smallfix" target="_blank" href="http://www.qq.com" style="right: -110px;"><em>大</em>电话咨询</a>
    <a class="smallfix" target="_blank" href="http://www.sina.com.cn/" style="right: -110px;"><em>本</em>访问新浪</a>
</div>
<script type="text/javascript">
    var btb=$(".rightNav");
    var tempS;
    $(".rightNav").hover(function(){
        var thisObj = $(this);
        tempS = setTimeout(function(){
            thisObj.find("a").each(function(i){
                var tA=$(this);
                setTimeout(function(){ tA.animate({right:"0"},300);},50*i);
            });
        },200);

    },function(){
        if(tempS){ clearTimeout(tempS); }
        $(this).find("a").each(function(i){
            var tA=$(this);
            setTimeout(function(){ tA.animate({right:"-110"},300,function(){
            });},50*i);
        });

    });
    var isIE6 = !!window.ActiveXObject&&!window.XMLHttpRequest;
    if( isIE6 ){ $(window).scroll(function(){ btb.css("top", $(document).scrollTop()+100) }); }

    $(function () {
        $('#tooltip-inputname').tooltip('hide');//input输入错误提示工具
        $('#tooltip-inputmobile').tooltip('hide');
    });
</script>
</body>
</html>