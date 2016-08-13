<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>DeerMe注册页面</title>
    <link rel="stylesheet" href="${base}/resources/front/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="${base}/resources/front/css/index.css" type="text/css">
    <link rel="stylesheet" href="${base}/resources/front/css/navfixed.css" type="text/css">
    <link rel="stylesheet" href="${base}/resources/front/css/common.css" type="text/css">

</head>

<body>
[#include "/front/sharing/header.ftl" /]

<!-- 横线分离条 -->
<hr/>

<div class="col-xs-12 col-md-6">
    <article class="post tag-ad">
        <form class="form-horizontal" id="registerForm" action="${base}/register/apply.jhtml" method="post"><br>
            <!--孩子姓名-->
            <div class="form-group" style="width:600px">
                <label for="child" class="col-sm-4 control-label"><label style="color:#ff0000;">*</label>孩子姓名</label>
                <div class="col-sm-6" style="width:300px">
                    <input type="text" class="form-control" id="child" name="child" [#if child??]value="${child}"[/#if] placeholder="请输入您的孩子姓名">
                </div>
            </div>

			<!--用户名-->
            <div class="form-group" style="width:600px">
                <label for="username" class="col-sm-4 control-label"><label style="color:#ff0000;">*</label>手机号码</label>
                <div class="col-sm-6" style="width:300px">
                    <input type="text" class="form-control" id="username" name="username" [#if username??]value="${username}"[/#if] placeholder="请输入您的手机号码">
                </div>
            </div>



            <!--密码-->
            <div class="form-group" style="width:600px">
                <label for="password" class="col-sm-4 control-label"><label style="color:#ff0000;">*</label>密码</label>
                <div class="col-sm-6" style="width:300px">
                    <input type="password" class="form-control" id="password" name="password" placeholder="请设置密码">
                </div>
            </div>


            <!--确认密码-->
            <div class="form-group" style="width:600px">
                <label for="inputEmail3" class="col-sm-4 control-label"><label style="color:#ff0000;">*</label>确认密码</label>
                <div class="col-sm-4" style="width:300px">
                    <input type="password" class="form-control" id="rePassword" name="rePassword"" placeholder="请重新输入密码">
                </div>

            </div>


			<!--推荐人手机号-->
            <div class="form-group" style="width:600px">
                <label for="recommender" class="col-sm-4 control-label">推荐人手机号码</label>
                <div class="col-sm-6" style="width:300px">
                    <input type="text" class="form-control" id="recommender" name="recommender" placeholder="选填推荐人手机号码，没有可不填">
                </div>
            </div>

            <!--验证码-->
            <div class="form-group" style="width:600px">
                <label for="inputEmail3" class="col-sm-4 control-label"><label style="color:#ff0000;">*</label>图片验证码</label>
                <div class="col-sm-4" style="width:300px">
                    <input type="text" class="form-control" id="captcha" name="captcha"" placeholder="请输入图片验证码">
                </div>
                <div class="col-sm-2" style="width:100px">
                    <span class="label" ><img id="captchaImage" src="${base}/captcha.jhtml" width="110" height="34"/></span>
                </div>
            </div>

            <div class="form-group" style="width:600px">
                <label for="inputEmail3" class="col-sm-2 control-label"></label>
                <div class="col-sm-offset-2 col-sm-6" style="width:300px">
                    <label>
                        我已阅读并同意《VIPKID用户注册协议》
                    </label>
                </div>
            </div>
            <div class="form-group" style="width:600px">
                <label for="inputEmail3" class="col-sm-2 control-label"></label>
                <div class="col-sm-offset-2 col-sm-6" style="width:300px">
                    <input type="submit" class="btn btn-danger btn-large btn-block" value="注册"/>
                </div>
            </div>
        </form>
    </article>
</div>
<div class="col-xs-12 col-md-6">
    <article class="post tag-ad" style="text-align:center">
        <img src="${base}/resources/front/img/regist.jpg" />
    </article>
</div>
<!-- 底部版权信息 -->
<div class="col-xs-12 col-md-6" style="text-align:center;padding:20px 0 10px;background-color:#cccccc;display: block;width:100%; position:fixed; left:0; bottom:0">
    <div id="info-foot" style="margin-bottom:0px;text-align:center;color:#ffffff">
        <p>Copyright 2016 DeerMe培训平台. All rights reserved.</p>
    </div>
</div>
<!-- /底部版权信息 -->

<script src="${base}/resources/front/js/jquery-1.8.1.min.js"></script>
<script src="${base}/resources/front/js/bootstrap.min.js"></script>
<script src="${base}/resources/front/js/jquery.validate.min.js"></script>
<script src="${base}/resources/front/js/portal.common.js"></script>

<script>
    $(document).ready(function() {
        var $registerForm = $("#registerForm");
        var $child = $("#child");
        var $username = $("#username");
        var $password = $("#password");
        var $captcha = $("#captcha");
        var $captchaImage = $("#captchaImage");
        var $recommender = $("#recommender");
        var $submit = $(":submit");

        //重新设置验证码
        $captchaImage.click(function () {
            $captchaImage.attr("src", "${base}/captcha.jhtml?timestamp=" + (new Date()).valueOf());
        });

        // 表单验证
        $registerForm.validate({
            rules: {
                child: {
                    required: true,
                },
                username: {
                    required: true,
                    minlength: 11,
                    mobile: true,
                },
                password: {
                    required: true,
                    minlength: 6,
                    maxlength: 20
                },
                rePassword: {
                    required: true,
                    equalTo: "#password"
                },
                captcha: "required",
            },
            messages: {},
            submitHandler: function (form) {
                console.log("form_serialize:", $registerForm.serialize());
                $.ajax({
                    url: $registerForm.attr("action"),
                    type: "POST",
                    data: {
                        username: $username.val(),
                        password: $password.val(),
                       /* captchaId: "${captchaId}",*/
                        captcha: $captcha.val(),
                        recommender: $recommender.val(),
                        child: $child.val()
                    },
                    dataType: "json",
                    cache: false,
                    success: function (message) {
                        console.log(message);
                        $.message(message);
                        if (message.type == "success") {
                            window.setTimeout(function () {
                                $submit.prop("disabled", false);
                                location.href = "${base}/index.jhtml";
                            }, 3000);
                        } else {
                            $submit.prop("disabled", false);
                            $captcha.val("");
                            $captchaImage.attr("src", "${base}/captcha.jhtml?timestamp=" + (new Date()).valueOf());
                        }
                    }
                });
            }

        });

        var $headerUsername =  $(".header-username");
        var $headerLogin =  $(".header-login");
        var $headerRegister =  $(".header-register");
        var $headerLogout =  $(".header-logout");

        var username = getCookie("username");
        if (username != null) {
            $headerUsername.text("hi," + username).show();
            $headerLogin.hide();
            $headerRegister.hide();
            $headerLogout.show();
        } else {
            $headerUsername.hide();
            $headerLogin.show();
            $headerRegister.show();
            $headerLogout.hide();
        }

    });

</script>

</body>
</html>