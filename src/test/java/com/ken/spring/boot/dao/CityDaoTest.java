package com.ken.spring.boot.dao;


import com.ken.spring.boot.BaseTest;
import com.ken.spring.boot.dao.domain.City;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by s on 2018/3/1.
 */
public class CityDaoTest extends BaseTest {

    @Resource
    private CityDao cityDao;

    @Test
    public void testGetAll() throws Exception {

        List<City> cities = cityDao.selectSelective(null);
        System.out.println(cities);
    }
}