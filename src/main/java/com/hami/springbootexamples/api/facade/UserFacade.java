package com.hami.springbootexamples.api.facade;

import com.hami.springbootexamples.api.dto.UserInputModel;
import com.hami.springbootexamples.api.dto.UserOutputModel;
import com.hami.springbootexamples.api.mapper.UserFacadeMapper;
import com.hami.springbootexamples.dal.entity.User;
import com.hami.springbootexamples.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserFacade {

    private final UserService userService;
    private final UserFacadeMapper mapper;

    public UserOutputModel createUser(UserInputModel userInputModel) {
        User user = mapper.getUserByFromInputModel(userInputModel);
        return mapper.getUserOutputModelFromUser(userService.createUser(user));
    }
}
