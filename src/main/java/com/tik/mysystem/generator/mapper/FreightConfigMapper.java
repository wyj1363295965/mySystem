package com.tik.mysystem.generator.mapper;

import com.tik.mysystem.generator.entity.FreightConfig;

public interface FreightConfigMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FreightConfig record);

    int insertSelective(FreightConfig record);

    FreightConfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FreightConfig record);

    int updateByPrimaryKey(FreightConfig record);
}