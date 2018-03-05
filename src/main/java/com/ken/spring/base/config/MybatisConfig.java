package com.ken.spring.base.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import java.util.Properties;

/**
 * Created by s on 2018/3/2.
 */
@Configuration
@MapperScan("com.ken.spring.boot.dao")
public class MybatisConfig {

    private static final String AOP_POINTCUT_EXPRESSION = "execution(* com.ken.spring.boot.service.*.*(..))";



    @Bean
    public Advisor advisor(PlatformTransactionManager transactionManager){
        Properties attributes = new Properties();
        attributes.setProperty("add*", "PROPAGATION_REQUIRED,-Exception");
        attributes.setProperty("insert*", "PROPAGATION_REQUIRED,-Exception");
        attributes.setProperty("update*", "PROPAGATION_REQUIRED,-Exception");
        attributes.setProperty("delete*", "PROPAGATION_REQUIRED,-Exception");
        attributes.setProperty("remove*", "PROPAGATION_REQUIRED,-Exception");

        attributes.setProperty("get*", "PROPAGATION_SUPPORTS,-Exception");
        attributes.setProperty("query*", "PROPAGATION_SUPPORTS,-Exception");
        attributes.setProperty("find*", "PROPAGATION_SUPPORTS,-Exception");
        attributes.setProperty("select*", "PROPAGATION_SUPPORTS,-Exception");
        attributes.setProperty("*", "PROPAGATION_REQUIRED,-Exception");
        TransactionInterceptor txAdvice = new TransactionInterceptor(transactionManager, attributes);

        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(AOP_POINTCUT_EXPRESSION);
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();
        advisor.setPointcut(pointcut);
        advisor.setAdvice(txAdvice);
        return advisor;
    }

}
