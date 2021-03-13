package com.neux.garden.ec.runtime.interceptor;

import com.neux.garden.ec.runtime.service.DateService;
import com.neux.garden.ec.runtime.service.TokenService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: Titan
 * Date: 2019/3/16
 * Time: 下午 12:18
 * To change this template use File | Settings | File Templates.
 */
@Component
public class APIGenerationInterceptor implements HandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(APIGenerationInterceptor.class);

    @Autowired
    private DateService dateService;

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        //To change body of implemented methods use File | Settings | File Templates.

    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute("RequestTime",dateService.toDateString(dateService.getTodayDate(),"yyyy-MM-dd HH:mm:ss"));
        return true;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        //To change body of implemented methods use File | Settings | File Templates.
    }


}
