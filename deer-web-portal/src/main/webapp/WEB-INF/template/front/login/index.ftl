<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>DeerMe登录页面</title>
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
    <article class="post tag-ad" style="text-align:center">
        <img src="${base}/resources/front/img/login_ad.jpg" />
    </article>
</div>

<div class="col-xs-12 col-md-6" style="margin-top:80px">
    <article class="post tag-ad">
        <form class="form-horizontal" id="loginForm" action="${base}/login/submit.jhtml" method="post">
            <div class="form-group" style="width:600px">
                <label for="u_name" class="col-sm-4 control-label"><label style="color:#ff0000;"></label><span class="glyphicon glyphicon-phone"></span></label>
                <div class="col-sm-6" style="width:300px">
                    <input type="text" id="u_name" name="u_name" class="form-control" placeholder="请输入您的手机号码" aria-describedby="basic-addon1">
                </div>
            </div>

            <div class="form-group" style="width:600px">
                <label for="u_password" class="col-sm-4 control-label"><label style="color:#ff0000;"></label><span class="glyphicon glyphicon-lock"></span></label>
                <div class="col-sm-6" style="width:300px">
                    <input type="password" id="u_password" name="u_password" class="form-control" placeholder="请输入您的登录密码" aria-describedby="basic-addon1">
                </div>
            </div>

            <div class="checkbox" style="width:600px">
                <label for="isRememberUsername" class="col-sm-4 control-label"><label style="color:#ff0000;"></label></label>
                <div class="col-sm-6" style="width:300px">
                    <label>
                    <input type="checkbox" id="isRememberUsername" name="isRememberUsername" value="true">下次自动登录
                </label>
                    <label>
                        <a style="margin-left:50px" href="#">忘记密码？</a>
                    </label>
                </div>
            </div><br>

            <div class="form-group" style="width:600px">
                <label for="inputEmail3" class="col-sm-2 control-label"></label>
                <div class="col-sm-offset-2 col-sm-6" style="width:300px">
                    <input type="submit" class="btn btn-danger btn-large btn-block" value="登录"/>
                </div>
            </div>
        </form>
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
                            $.message(message);
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