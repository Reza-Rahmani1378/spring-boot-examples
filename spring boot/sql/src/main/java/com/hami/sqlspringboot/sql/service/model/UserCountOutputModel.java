package com.hami.sqlspringboot.sql.service.model;

import lombok.Data;

@Data
public class UserCountOutputModel {
    private Long countLocked;
    private Long countUnlocked;
}
