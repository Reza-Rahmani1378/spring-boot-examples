package com.hami.sqlspringboot.sql.dal.repository;


import com.hami.sqlspringboot.sql.dal.entity.User;
import com.hami.sqlspringboot.sql.service.model.UserCountModel;
import jakarta.persistence.NamedNativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,String>{


 /*   @Query(value = """
    select (select count(user) from user where locked = false) as countLocked,
    (select count(user) from user where locked = true) as countUnlocked
    """)
    UserCountModel countLockedAndUnlockedUsers();*/

    @Query(value = "select (select count(*) from user where locked = true) as countLocked,(select count(*) from user where locked = false) as countUnlocked",nativeQuery = true)
     UserCountModel countLockedAndUnlockedUsers();

}
