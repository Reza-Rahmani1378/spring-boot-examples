package com.hami.springbootexamples.api.mapper;

import com.hami.springbootexamples.api.dto.UserInputModel;
import com.hami.springbootexamples.api.dto.UserOutputModel;
import com.hami.springbootexamples.dal.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserFacadeMapper {

    User getUserByFromInputModel(UserInputModel userInputModel);

    UserOutputModel getUserOutputModelFromUser(User user);
}
