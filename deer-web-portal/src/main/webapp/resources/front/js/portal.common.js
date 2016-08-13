
var messages = {
    "front.message.success": "操作成功",
    "front.message.error": "操作错误",
    "front.dialog.ok": "确&nbsp;&nbsp;定",
    "front.dialog.cancel": "取&nbsp;&nbsp;消",
    "front.dialog.deleteConfirm": "您确定要删除吗？",
    "front.dialog.clearConfirm": "您确定要清空吗？",
    "front.validate.required": "必填",
    "front.validate.email": "E-mail格式错误",
    "front.validate.url": "网址格式错误",
    "front.validate.date": "日期格式错误",
    "front.validate.dateISO": "日期格式错误",
    "front.validate.pointcard": "信用卡格式错误",
    "front.validate.number": "只允许输入数字",
    "front.validate.digits": "只允许输入零或正整数",
    "front.validate.minlength": "长度不允许小于{0}",
    "front.validate.maxlength": "长度不允许大于{0}",
    "front.validate.rangelength": "长度必须在{0}-{1}之间",
    "front.validate.min": "不允许小于{0}",
    "front.validate.max": "不允许大于{0}",
    "front.validate.range": "必须在{0}-{1}之间",
    "front.validate.accept": "输入后缀错误",
    "front.validate.equalTo": "两次输入不一致",
    "front.validate.remote": "输入错误",
    "front.validate.integer": "只允许输入整数",
    "front.validate.positive": "只允许输入正数",
    "front.validate.negative": "只允许输入负数",
    "front.validate.decimal": "数值超出了允许范围",
    "front.validate.pattern": "格式错误",
    "front.validate.extension": "文件格式错误"
};

// 添加Cookie
function addCookie(name, value, options) {
    if (arguments.length > 1 && name != null) {
        if (options == null) {
            options = {};
        }
        if (value == null) {
            options.expires = -1;
        }
        if (typeof options.expires == "number") {
            var time = options.expires;
            var expires = options.expires = new Date();
            expires.setTime(expires.getTime() + time * 1000);
        }
        document.cookie = encodeURIComponent(String(name)) + "=" + encodeURIComponent(String(value)) + (options.expires ? "; expires=" + options.expires.toUTCString() : "") + (options.path ? "; path=" + options.path : "") + (options.domain ? "; domain=" + options.domain : ""), (options.secure ? "; secure" : "");
    }
}

// 获取Cookie
function getCookie(name) {
    if (name != null) {
        var value = new RegExp("(?:^|; )" + encodeURIComponent(String(name)) + "=([^;]*)").exec(document.cookie);
        return value ? decodeURIComponent(value[1]) : null;
    }
}

// 移除Cookie
function removeCookie(name, options) {
    addCookie(name, null, options);
}


// 多语言
function message(code) {
    if (code != null) {
        var content = messages[code] != null ? messages[code] : code;
        if (arguments.length == 1) {
            return content;
        } else {
            if ($.isArray(arguments[1])) {
                $.each(arguments[1], function(i, n) {
                    content = content.replace(new RegExp("\\{" + i + "\\}", "g"), n);
                });
                return content;
            } else {
                $.each(Array.prototype.slice.apply(arguments).slice(1), function(i, n) {
                    content = content.replace(new RegExp("\\{" + i + "\\}", "g"), n);
                });
                return content;
            }
        }
    }
}

(function ($) {
    var zIndex = 100;

    // 消息框
    var $message;
    var messageTimer;
    $.message = function() {
        var message = {};
        if ($.isPlainObject(arguments[0])) {
            message = arguments[0];
        } else if (typeof arguments[0] === "string" && typeof arguments[1] === "string") {
            message.type = arguments[0];
            message.content = arguments[1];
        } else {
            return false;
        }

        if (message.type == null || message.content == null) {
            return false;
        }

        if ($message == null) {
            $message = $('<div class="xxMessage"><div class="messageContent message' + message.type + 'Icon"><\/div><\/div>');
            if (!window.XMLHttpRequest) {
                $message.append('<iframe class="messageIframe"><\/iframe>');
            }
            $message.appendTo("body");
        }

        $message.children("div").removeClass("messagewarnIcon messageerrorIcon messagesuccessIcon").addClass("message" + message.type + "Icon").html(message.content);
        $message.css({"margin-left": - parseInt($message.outerWidth() / 2), "z-index": zIndex ++}).show();
        console.log("message:", $message);

        clearTimeout(messageTimer);
        messageTimer = setTimeout(function() {
            $message.hide();
        }, 3000);
        return $message;
    }

    /**
     * 防CSRF攻击,规定AJAX请求即将发送时运行的函数
     * 从cookie中获取token,加入请求头
     */
    $(document).ajaxSend(function (event, request, settings) {
        console.log("ajaxSend:" + settings);
        if (!settings.crossDomain && settings.type != null && settings.type.toLowerCase() == "post") {
            var token = getCookie("token");
            if (token != null) {
                request.setRequestHeader("token", token);
            }
        }

    });

    /**
     * AJAX发送完成时运行的函数
     * 如果AJAX请求发送完成,token验证失败,那么再次尝试(因此服务端会返回token cookie)
     * 从cookie读取token放入ajax头部重新发送一次AJAX请求
     */
    $(document).ajaxComplete(function (event, request, settings) {
        var tokenStatus = request.getResponseHeader("tokenStatus");
        if (tokenStatus == "accessDenied") {
            var token = getCookie("token");
            if (token != null) {
                $.extend(settings, {
                    global: false,
                    headers: {token: token}
                });
                $.ajax(settings);
                console.log("ajaxComplete:" + settings);
            }
        }

    });

})(jQuery);

$(document).ready(function () {
    $("form").submit(function () {
        var $this = $(this);
        if ($this.attr("method") != null && $this.attr("method").toLowerCase() == "post" && $this.find("input[name='token']").size() == 0) {
            var token = getCookie("token");
            if (token != null) {
                $this.append('<input type="hidden" name="token" value="' + token + '" \/>');
            }
        }
    });
});


// 验证消息
if ($.validator != null) {
    $.extend($.validator.messages, {
        required: message("front.validate.required"),
        email: message("front.validate.email"),
        url: message("front.validate.url"),
        date: message("front.validate.date"),
        dateISO: message("front.validate.dateISO"),
        pointcard: message("front.validate.pointcard"),
        number: message("front.validate.number"),
        digits: message("front.validate.digits"),
        minlength: $.validator.format(message("front.validate.minlength")),
        maxlength: $.validator.format(message("front.validate.maxlength")),
        rangelength: $.validator.format(message("front.validate.rangelength")),
        min: $.validator.format(message("front.validate.min")),
        max: $.validator.format(message("front.validate.max")),
        range: $.validator.format(message("front.validate.range")),
        accept: message("front.validate.accept"),
        equalTo: message("front.validate.equalTo"),
        remote: message("front.validate.remote"),
        integer: message("front.validate.integer"),
        positive: message("front.validate.positive"),
        negative: message("front.validate.negative"),
        decimal: message("front.validate.decimal"),
        pattern: message("front.validate.pattern"),
        extension: message("front.validate.extension")
    });

    // 增加手机号码验证
    $.validator.addMethod("mobile", function(value, element) {
        var length = value.length;
        var mobile = /^(13[0-9]{9})|(18[0-9]{9})|(14[0-9]{9})|(17[0-9]{9})|(15[0-9]{9})$/;
        return this.optional(element) || (length == 11 && mobile.test(value));
    }, "请正确填写您的手机号码");

    $.validator.setDefaults({
        errorClass: "fieldError",
        ignore: ".ignore",
        ignoreTitle: true,
        errorPlacement: function(error, element) {
            var fieldSet = element.closest("span.fieldSet");
            if (fieldSet.size() > 0) {
                error.appendTo(fieldSet);
            } else {
                error.insertAfter(element);
            }
        },
        submitHandler: function(form) {
            $(form).find(":submit").prop("disabled", true);
            form.submit();
        }
    });
}