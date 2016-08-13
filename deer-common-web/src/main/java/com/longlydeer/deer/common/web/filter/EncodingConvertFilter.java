package com.longlydeer.deer.common.web.filter;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;

/**
 * 编码过滤器
 * @author pez1420@163.com
 * @version 1.0
 */
public class EncodingConvertFilter extends OncePerRequestFilter{

    private String fromEncoding = "ISO-8859-1";
    private String toEncoding = "UTF-8";

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws IOException, ServletException {
        if (request.getMethod().equalsIgnoreCase("GET")) {
            Iterator it = request.getParameterMap().values().iterator();
            while (it.hasNext()) {
                String[] values = (String[]) it.next();
                for (int i = 0; i < values.length; i++)
                    try {
                        values[i] = new String(values[i].getBytes(this.fromEncoding), this.toEncoding);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
            }
        }
        filterChain.doFilter(request, response);
    }

    public String getFromEncoding() {
        return this.fromEncoding;
    }

    public void setFromEncoding(String fromEncoding) {
        this.fromEncoding = fromEncoding;
    }

    public String getToEncoding() {
        return this.toEncoding;
    }

    public void setToEncoding(String toEncoding) {
        this.toEncoding = toEncoding;
    }
}
