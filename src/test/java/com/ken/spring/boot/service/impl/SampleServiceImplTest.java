package com.ken.spring.boot.service.impl;

import com.ken.spring.boot.BaseTest;
import com.ken.spring.boot.service.SampleService;
import org.junit.Test;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.annotation.Resource;


/**
 * Created by s on 2018/3/2.
 */
public class SampleServiceImplTest extends BaseTest{

    @Resource
    SampleService sampleService;

    @Resource
    DataSourceTransactionManager dataSourceTransactionManager;


    @Test
    public void testGet() throws Exception {
        sampleService.get();
    }
}