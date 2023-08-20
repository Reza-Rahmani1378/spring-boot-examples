package com.hami.sqlspringboot.sql.dal.repository;


import com.hami.sqlspringboot.sql.dal.entity.User;
import com.hami.sqlspringboot.sql.service.model.UserCountGroupModel;
import com.hami.sqlspringboot.sql.service.model.UserCountModel;
import jakarta.persistence.NamedNativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {


 /*   @Query(value = """
    select (select count(user) from user where locked = false) as countLocked,
    (select count(user) from user where locked = true) as countUnlocked
    """)
    UserCountModel countLockedAndUnlockedUsers();*/

   /* @Query(value = """
     select
     (select * from user where (:from is not null and created_date >=:from) and (:to is not null and created_date<=:to)),
     (select count(*) from user where locked = true) as countLocked,
     (select count(*) from user where locked = false) as countUnlocked
     """,nativeQuery = true)
     UserCountModel countLockedAndUnlockedUsers(@Param("from")LocalDateTime from , @Param("to") LocalDateTime end);*/

    @Query(value = """ 
            select user.locked as isLocked , count(user.locked) as countUser from User user
            where ((:from is not null and user.createdDate >=:from) and (:to is not null and user.createdDate<=:to)
            or (:from is null and user.createdDate<=:to)
            or(:to is null and user.createdDate>=:from)
            or(:to is null and :from is null))
            group by user.locked
            """)
    List<UserCountGroupModel> countLockedAndUnlockedUsers(@Param("from") LocalDateTime from, @Param("to") LocalDateTime end);


}
