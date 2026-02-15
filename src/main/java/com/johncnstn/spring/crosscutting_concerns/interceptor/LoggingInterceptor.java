package com.johncnstn.spring.crosscutting_concerns.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import static com.johncnstn.spring.crosscutting_concerns.utils.LoggingUtils.logObjectMetadata;

@Component
public class LoggingInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        LoggingInterceptor interceptor = this;
        System.out.println("\n===Interceptor:===");

        if (handler instanceof HandlerMethod handlerMethod) {
            Object beanClass = handlerMethod.getBean().getClass();
            String simpleName = handlerMethod.getBeanType().getSimpleName();
            String methodName = handlerMethod.getMethod().getName();
            System.out.println("###");
            System.out.println("beanClass: " + beanClass);
            System.out.println("simpleName: " + simpleName);
            System.out.println("methodName: " + methodName);
            System.out.println("###");
        }

        logObjectMetadata(interceptor);
        System.out.println("===endInterceptor===\n");
        return true;
    }

}
