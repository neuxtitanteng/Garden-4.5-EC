package com.neux.garden.ec.runtime.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * Created with IntelliJ IDEA.
 * User: Titan
 * Date: 2019/4/14
 * Time: 下午 6:40
 * To change this template use File | Settings | File Templates.
 */
@Configuration
public class CorsConfig {

	private static final Logger log = LoggerFactory.getLogger(CorsConfig.class);
	 
    @Value("${cors.allowedOrigin:}")
    private String OriginExtension;
    
    @Value("${spring.profiles.active}")
    private String profileID;

	@Bean
	public FilterRegistrationBean<CorsFilter> corsFilter() {

		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);

		config.addAllowedOrigin("*");
		config.addAllowedMethod("*");
		config.addAllowedHeader("*");

		UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
		configSource.registerCorsConfiguration("/**", config);
		FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(configSource));
		bean.setOrder(0);

		return bean;

	}
}
