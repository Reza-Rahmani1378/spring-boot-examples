package com.hami.springbootexamples.api.controller;

import com.hami.springbootexamples.api.dto.UserInputModel;
import com.hami.springbootexamples.api.dto.UserOutputModel;
import com.hami.springbootexamples.api.facade.UserFacade;
import com.hami.springbootexamples.dal.entity.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/validation")
@RequiredArgsConstructor
public class UserController {


    private final UserFacade userFacade;

    @PostMapping
    public ResponseEntity<UserOutputModel> createUser(@Valid @RequestBody UserInputModel userInputModel) {
        return new ResponseEntity (userFacade.createUser(userInputModel),HttpStatus.CREATED);
    }
}

