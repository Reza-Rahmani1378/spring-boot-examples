package com.hami.sqlspringboot.sql.service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserCountOutputModel {
    private Long totalCount;
    private Long countLocked;
    private Long countUnlocked;
}
