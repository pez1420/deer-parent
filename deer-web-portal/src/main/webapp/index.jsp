<%@page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<body>
<h2>Hello World!</h2>

<form action="captchaValidationServlet" method="post">
    <table>
        <tr>
            <td colspan="2"><img src="imageCaptchaServlet" /></td>
        </tr>
        <tr>
            <td> 请输入您所看到的字符 :</td>
            <td><input type="text" name="captcha" value="" />
                <%=request.getAttribute("ERROR") == null ? "" :
                        request.getAttribute("ERROR")%></td>
        </tr>
        <tr>

            <td><input type="submit" value="提交" /></td>
        </tr>
    </table>
</form>

</body>
</html>
