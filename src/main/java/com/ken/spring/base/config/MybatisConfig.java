package com.ken.spring.base.config;

import org.aspectj.lang.annotation.Aspect;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import javax.annotation.Resource;
import java.util.Properties;

/**
 * Created by s on 2018/3/2.
 */
@Configuration
@MapperScan("com.ken.spring.boot.dao")
//@EnableTransactionManagement
public class MybatisConfig {

    private static final String AOP_POINTCUT_EXPRESSION = "execution(* com.ken.spring.boot.service.*.*(..))";

    @Resource
    private PlatformTransactionManager transactionManager;


    public MybatisConfig() {
        System.out.println("spring容器启动初始化。。。");
    }
/*

    @Bean("transactionInterceptor")
    public TransactionInterceptor transactionInterceptor() {

        */
/*
            <tx:method name="add*" propagation="REQUIRED" />
			<tx:method name="insert*" propagation="REQUIRED" />
			<tx:method name="update*" propagation="REQUIRED" />
			<tx:method name="delete*" propagation="REQUIRED" />
			<tx:method name="query*" propagation="SUPPORTS" read-only="true" />
			<tx:method name="get*" propagation="SUPPORTS" read-only="true" />
			<tx:method name="find*" propagation="SUPPORTS" read-only="true" />
			<tx:method name="select*" propagation="SUPPORTS" read-only="true" />
         *//*


        // PROPAGATION_NAME,ISOLATION_NAME,readOnly,timeout_NNNN,+Exception1,-Exception2
        Properties properties = new Properties();
//        properties.put("add*", "PROPAGATION_REQUIRED");
//        properties.put("insert*", "PROPAGATION_REQUIRED");
//        properties.put("update*", "PROPAGATION_REQUIRED");
//        properties.put("delete*", "PROPAGATION_REQUIRED");
//        properties.put("query*", "PROPAGATION_SUPPORTS");
////        properties.put("get*", "PROPAGATION_SUPPORTS");
//        properties.put("find*", "PROPAGATION_SUPPORTS");
//        properties.put("select*", "PROPAGATION_SUPPORTS");
        properties.put("get*", "PROPAGATION_REQUIRED");

        NameMatchTransactionAttributeSource transactionAttributeSource = new NameMatchTransactionAttributeSource();
        transactionAttributeSource.setProperties(properties);

        return new TransactionInterceptor(transactionManager, transactionAttributeSource);
    }



    @Bean
    public Advisor transactionAdvisor(@Qualifier("transactionInterceptor") TransactionInterceptor transactionInterceptor) {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(AOP_POINTCUT_EXPRESSION);

        Advisor advisor = new DefaultPointcutAdvisor(pointcut, transactionInterceptor);
        return advisor;
    }
*/



    @Bean
    public DefaultPointcutAdvisor defaultPointcutAdvisor(){
        Properties attributes = new Properties();
        attributes.setProperty("get*", "PROPAGATION_REQUIRED,-Exception");
        attributes.setProperty("add*", "PROPAGATION_REQUIRED,-Exception");
        attributes.setProperty("update*", "PROPAGATION_REQUIRED,-Exception");
        attributes.setProperty("delete*", "PROPAGATION_REQUIRED,-Exception");
        TransactionInterceptor txAdvice = new TransactionInterceptor(transactionManager, attributes);

        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(AOP_POINTCUT_EXPRESSION);
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();
        advisor.setPointcut(pointcut);
        advisor.setAdvice(txAdvice);
        return advisor;
    }

}
