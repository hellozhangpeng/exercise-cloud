package com.zp.infrastructure.shiro;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: ZhangPeng
 * @Date: 2019/11/29 10:21
 * @Description:
 */
public class ShiroJwtFilter extends BasicHttpAuthenticationFilter {
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        Subject subject = this.getSubject(request, response);
        if (!subject.isAuthenticated()) {
            return false;
        }
        return true;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = WebUtils.toHttp(request);
        if (httpServletRequest.getMethod().equals("OPTIONS")) {
            return true;
        }
        String token = httpServletRequest.getHeader(AUTHENTICATE_HEADER);
        if (StringUtils.isBlank(token))
            return false;

        return super.onAccessDenied(request, response);
    }

}
