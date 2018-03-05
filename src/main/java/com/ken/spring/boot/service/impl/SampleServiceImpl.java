package com.ken.spring.boot.service.impl;

import com.ken.spring.boot.dao.CityDao;
import com.ken.spring.boot.dao.HotelDao;
import com.ken.spring.boot.dao.domain.City;
import com.ken.spring.boot.dao.domain.Hotel;
import com.ken.spring.boot.service.SampleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by s on 2018/3/1.
 */
@Service
public class SampleServiceImpl implements SampleService {

    @Resource
    private CityDao cityDao;

    @Resource
    private HotelDao hotelDao;


    @Override
    public String get() {

        City city = new City();
        city.setName("计算机世界上");
        cityDao.insert(city);

        int i = 1/0;

        Hotel hotel = hotelDao.select(1);

        return "get sample service";
    }


}
