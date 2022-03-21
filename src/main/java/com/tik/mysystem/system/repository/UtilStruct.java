package com.tik.mysystem.system.repository;

import com.tik.mysystem.system.entity.User;
import com.tik.mysystem.system.entity.User1;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UtilStruct {

    @Mappings({
            @Mapping(target = "id", source = "id"),
//            @Mapping(target = "username", source = "username")
    })
    User1 convert(User user);
}
