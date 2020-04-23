package com.tik.mysystem.system.mybatisPlus;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.tik.mysystem.system.entity.mybatisPlus.MybatisUser;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<MybatisUser> {
}
