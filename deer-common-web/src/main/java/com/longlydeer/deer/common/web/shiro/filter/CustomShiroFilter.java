package com.longlydeer.deer.common.web.shiro.filter;

import com.longlydeer.deer.common.web.shiro.CaptchaUsernamePasswordToken;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * shiro机制 身份认证过滤器
 * 
 * @author
 * 
 */
public class CustomShiroFilter extends FormAuthenticationFilter {

	private static  final Logger logger = Logger.getLogger(CustomShiroFilter.class);

	// 添加 captchaParam 等变量
	// 为的是页面表单提交验证码的参数名可以进行灵活配置
	private String captchaIdParam = "captchaId";
	private String captchaParam = "captcha";

	/**
	 * 首先覆盖createToken方法，以便获取CaptchaUsernamePasswordToken实例
	 *
	 * @param servletRequest
	 * @param servletResponse
     * @return
     */
	protected org.apache.shiro.authc.AuthenticationToken createToken(
			ServletRequest servletRequest, ServletResponse servletResponse) {
		String username = getUsername(servletRequest);
		String password = getPassword(servletRequest);
		String captchaId = getCaptchaId(servletRequest);
		String captcha = getCaptcha(servletRequest);
		boolean rememberMe = isRememberMe(servletRequest);
		String host = getHost(servletRequest);
		logger.debug(username + ", " + password + ", " + captchaId + ", " + captcha + ", " + rememberMe);

		return new CaptchaUsernamePasswordToken(username, password,
				captcha, captchaId, rememberMe, host);
	}

	/** 访问拒绝
	 *
	 * @param servletRequest
	 * @param servletResponse
	 * @return
     * @throws Exception
     */
	protected boolean onAccessDenied(ServletRequest servletRequest,
									 ServletResponse servletResponse) throws Exception {
		HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
		HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
		// Ajax 请求多了个 "x-requested-with"参数
		String requestType = httpServletRequest.getHeader("X-Requested-With");
		if (requestType != null && requestType.equalsIgnoreCase("XMLHttpRequest")) {
			httpServletResponse.addHeader("loginStatus", "accessDenied");
			httpServletResponse.sendError(403);
			return false;
		}
		return super.onAccessDenied(httpServletRequest, httpServletResponse);
	}

	/** 登陆成功
	 *
	 * @param token
	 * @param subject
	 * @param servletRequest
	 * @param servletResponse
	 * @return
     * @throws Exception
     */
	protected boolean onLoginSuccess(AuthenticationToken token, Subject subject,
			ServletRequest servletRequest, ServletResponse servletResponse)
			throws Exception {
		Session session = subject.getSession();
		HashMap<Object, Object> hashMap = new HashMap<Object,Object>();
		Collection<Object> attributeKeys = session.getAttributeKeys();

		if (attributeKeys != null) {
			for (Object attributeKey : attributeKeys) {
				hashMap.put(attributeKey, session.getAttribute(attributeKey));
			}
		}

		session.stop();

		session = subject.getSession();
		for (Map.Entry<Object, Object> entry : hashMap.entrySet()) {
			session.setAttribute(entry.getKey(), entry.getValue());
		}

		return super.onLoginSuccess(token, subject, servletRequest, servletResponse);
	}

	protected String getCaptchaId(ServletRequest servletRequest) {
		String captchaId = WebUtils.getCleanParam(servletRequest,
				this.captchaIdParam);
		if (captchaId == null) {
			captchaId = ((HttpServletRequest) servletRequest).getSession().getId();
		}
		return captchaId;
	}

	protected String getCaptcha(ServletRequest servletRequest) {
		return WebUtils.getCleanParam(servletRequest, this.captchaParam);
	}

	public String getCaptchaIdParam() {
		return this.captchaIdParam;
	}

	public void setCaptchaIdParam(String captchaIdParam) {
		this.captchaIdParam = captchaIdParam;
	}

	public String getCaptchaParam() {
		return this.captchaParam;
	}

	public void setCaptchaParam(String captchaParam) {
		this.captchaParam = captchaParam;
	}
}
