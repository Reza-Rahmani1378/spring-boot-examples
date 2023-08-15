package com.hami.springbootexamples.dal.entity.repository;

import com.hami.springbootexamples.dal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
