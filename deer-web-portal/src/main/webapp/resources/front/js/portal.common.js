(function ($) {

    /**
     * 防CSRF攻击,规定AJAX请求即将发送时运行的函数
     * 从cookie中获取token,加入请求头
     */
    $(document).ajaxSend(function (event, request, settings) {
        console.log("ajaxSend:" + settings);
    });

    /**
     * AJAX发送完成时运行的函数
     */
    $(document).ajaxComplete(function (event, request, settings) {
        console.log("ajaxComplete:" + settings)
    });

})(jQuery);

$(document).ready(function () {
    $("form").submit(function () {
        var $this = $(this);
        if ($this.attr("method") != null && $this.attr("method").toLowerCase() == "post" && $this.find("input[name='token']").size() == 0) {
            console.log("# It will added token in next!");
        }
    });
});