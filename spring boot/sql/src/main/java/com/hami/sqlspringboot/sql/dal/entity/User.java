package com.hami.sqlspringboot.sql.dal.entity;

import com.hami.sqlspringboot.sql.dal.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class User extends BaseEntity<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "locked", nullable = false)
    private Boolean locked=Boolean.FALSE;
    @Column(name = "is_microservice", nullable = false)
    private Boolean isMicroservice = Boolean.FALSE;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;



}
