package com.johncnstn.spring.crosscutting_concerns.config;

import com.johncnstn.spring.crosscutting_concerns.interceptor.MethodInterceptorImpl;
import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AopConfig {

    @Bean
    public Advice methodInterceptorImpl() {
        return new MethodInterceptorImpl();
    }

    @Bean
    public Advisor methodInterceptorImplAdvisor(Advice methodInterceptorImpl) {
        JdkRegexpMethodPointcut pointcut = new JdkRegexpMethodPointcut();
        pointcut.setPattern("com\\.johncnstn\\.spring\\.crosscutting_concerns\\.service\\..*");
        return new DefaultPointcutAdvisor(pointcut, methodInterceptorImpl);
    }

}
