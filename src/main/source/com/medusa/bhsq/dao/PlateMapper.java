package com.medusa.bhsq.dao;

import com.medusa.bhsq.entity.Plate;

public interface PlateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Plate record);

    int insertSelective(Plate record);

    Plate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Plate record);

    int updateByPrimaryKey(Plate record);
}