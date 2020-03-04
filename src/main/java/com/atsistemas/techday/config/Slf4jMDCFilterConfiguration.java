package com.atsistemas.techday.config;


import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.atsistemas.techday.filter.Slf4jMDCFilter;

import lombok.Data;

@Data
@Configuration
public class Slf4jMDCFilterConfiguration {

    public static final String DEFAULT_RESPONSE_TOKEN_HEADER = "Response_Token";
    public static final String DEFAULT_MDC_UUID_TOKEN_KEY = "Slf4jMDCFilter.UUID";
    public static final String DEFAULT_MDC_CLIENT_IP_KEY = "Slf4jMDCFilter.ClientIP";
    public static final String DEFAULT_REQUEST_TOKEN_HEADER ="X-Header-Token";

    private String responseHeader = DEFAULT_RESPONSE_TOKEN_HEADER;
    private String mdcTokenKey = DEFAULT_MDC_UUID_TOKEN_KEY;
    private String mdcClientIpKey = DEFAULT_MDC_CLIENT_IP_KEY;
    private String requestHeader = DEFAULT_REQUEST_TOKEN_HEADER;

    @Bean
    public FilterRegistrationBean<Slf4jMDCFilter> servletRegistrationBean() {
        final FilterRegistrationBean<Slf4jMDCFilter> registrationBean = new FilterRegistrationBean<Slf4jMDCFilter>();
        final Slf4jMDCFilter log4jMDCFilterFilter = new Slf4jMDCFilter(responseHeader, mdcTokenKey, mdcClientIpKey, requestHeader);
        registrationBean.setFilter(log4jMDCFilterFilter);
        registrationBean.setOrder(2);
        return registrationBean;
    }
}
