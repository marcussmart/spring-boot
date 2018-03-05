package com.ken.spring.boot.dao;

import com.ken.spring.boot.BaseTest;
import com.ken.spring.boot.dao.domain.Hotel;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by s on 2018/3/1.
 */
public class HotelDaoTest extends BaseTest {

    @Resource
    private HotelDao hotelDao;


    @Test
    public void testSelect() throws Exception {

        List<Hotel> a = hotelDao.selectSelective(null);
        System.out.println(a);
    }

}