package com.neux.garden.ec.runtime.configuration;

import com.neux.garden.ec.runtime.interceptor.APIGenerationInterceptor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created with IntelliJ IDEA.
 * User: Titan
 * Date: 2019/2/22
 * Time: 下午 4:32
 * To change this template use File | Settings | File Templates.
 */

@Configuration
public class RestfulAPIConfiguration extends WebMvcConfigurerAdapter  {

    @Autowired
    private BeanFactory beanFactory;

    @Override
    public void addInterceptors(InterceptorRegistry registry){

        registry.addInterceptor(beanFactory.getBean(APIGenerationInterceptor.class));

//        registry.addInterceptor(beanFactory.getBean(TokenAuthenticationInterceptor.class))
//                .addPathPatterns("/Configuration")
//                .addPathPatterns("/appointment")
//                .addPathPatterns("/customerprofiles")
//                .addPathPatterns("/Goal")
//                .addPathPatterns("/Actual")
//                .addPathPatterns("/AgencyPlan")
//                .addPathPatterns("/Progress")
//                .addPathPatterns("/SubmitGoal")
//                .addPathPatterns("/ApproveGoal")
//                .addPathPatterns("/AppClickLog")
//                .addPathPatterns("/errorLog")
//                .addPathPatterns("/goalExpected")
////                .addPathPatterns("/logout")
//                .addPathPatterns("/message")
////                .addPathPatterns("/version")
//                .addPathPatterns("/datalists")
//                .addPathPatterns("/datalists/all")
////                .addPathPatterns("/deviceChange")
////                .addPathPatterns("/deviceUnbind")
//                .addPathPatterns("/notes");

    }

}