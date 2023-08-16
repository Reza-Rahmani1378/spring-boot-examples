package com.hami.sqlspringboot.sql.service.mapper;

import com.hami.sqlspringboot.sql.dal.entity.User;
import com.hami.sqlspringboot.sql.service.model.UserCountModel;
import com.hami.sqlspringboot.sql.service.model.UserCountOutputModel;
import com.hami.sqlspringboot.sql.service.model.UserPodamModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserServiceMapper {
    User getEntityFromUserPodamModel(UserPodamModel model);

    UserCountOutputModel getUserCountOutputModelFromModel(UserCountModel model);
}
