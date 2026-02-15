package com.johncnstn.spring.crosscutting_concerns.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.jspecify.annotations.Nullable;

public class MethodInterceptorImpl implements MethodInterceptor {
    @Override
    public @Nullable Object invoke(MethodInvocation invocation) throws Throwable {
        var method = invocation.getMethod();
        var target = invocation.getThis();

        System.out.println("===MethodInterceptor: BEFORE===");
        System.out.println("target: " + target);
        System.out.println("class: " + (target != null ? target.getClass().getName() : "null"));
        System.out.println("method: " + method.getDeclaringClass().getSimpleName() + "." + method.getName());
        System.out.println("===============================");

        try {
            Object result = invocation.proceed();

            System.out.println("===MethodInterceptor: AFTER===");
            System.out.println("result: " + result);
            System.out.println("==============================");
            return result;
        } catch (Throwable t) {
            System.out.println("===MethodInterceptor: ERROR===");
            System.out.println("ex: " + t);
            System.out.println("==============================");
            throw t;
        }
    }
}
