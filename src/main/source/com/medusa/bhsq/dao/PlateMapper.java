package com.medusa.bhsq.dao;

import com.medusa.bhsq.entity.Place;

public interface PlaceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Place record);

    int insertSelective(Place record);

    Place selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Place record);

    int updateByPrimaryKey(Place record);
}