package com.ken.spring.boot.dao;

import com.ken.spring.boot.dao.domain.City;

import java.util.List;

public interface CityDao {
    int delete(Integer id);

    int insert(City record);

    City select(Integer id);

    int update(City record);

    City selectOne(City record);

    List<City> selectSelective(City record);
}