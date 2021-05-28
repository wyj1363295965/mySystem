package com.tik.mysystem.generator.mapper;

import com.tik.mysystem.generator.entity.LogisticsCarrier;

public interface LogisticsCarrierMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LogisticsCarrier record);

    int insertSelective(LogisticsCarrier record);

    LogisticsCarrier selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LogisticsCarrier record);

    int updateByPrimaryKey(LogisticsCarrier record);
}