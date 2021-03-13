package com.neux.garden.ec.runtime.interceptor;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SecurityFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        httpServletResponse.addHeader("X-XSS-Protection","1; mode=block");
        httpServletResponse.addHeader("X-Content-Type-Options","nosniff");
        httpServletResponse.addHeader("X-Frame-Options","SAMEORIGIN");

        httpServletResponse.addHeader("Strict-Transport-Security","max-age=31536000 ; includeSubDomains");


        httpServletResponse.addHeader("Content-Security-Policy","script-src 'self'");
        httpServletResponse.addHeader("X-Permitted-Cross-Domain-Policies","none");
        httpServletResponse.addHeader("Referrer-Policy","no-referrer");
        httpServletResponse.addHeader("Expect-CT","max-age=86400, enforce");
        httpServletResponse.addHeader("Feature-Policy","vibrate 'none'; geolocation 'none'");

        filterChain.doFilter(servletRequest,httpServletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
