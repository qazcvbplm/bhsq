package com.medusa.bhsq.dao;

import java.util.Map;

import com.medusa.bhsq.entity.Ship;

public interface ShipMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Ship record);

    int insertSelective(Ship record);

    Ship selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Ship record);

    int updateByPrimaryKey(Ship record);
    
    int findshipcount(Map<String,Object> map);
    
    int findzan(int articleid);
}