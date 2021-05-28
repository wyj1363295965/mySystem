package com.tik.mysystem.generator.mapper;

import com.tik.mysystem.generator.entity.OssFile;

public interface OssFileMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OssFile record);

    int insertSelective(OssFile record);

    OssFile selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OssFile record);

    int updateByPrimaryKey(OssFile record);
}