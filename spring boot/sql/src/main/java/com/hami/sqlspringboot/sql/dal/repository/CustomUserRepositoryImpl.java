/*
package com.hami.sqlspringboot.sql.dal.repository;

import com.hami.sqlspringboot.sql.service.model.UserCountModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;


public class CustomUserRepositoryImpl implements CustomUserRepository{

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public UserCountModel countLockedAndUnlockedUsers() {
        Query query = entityManager.createNativeQuery("select (select count(*) from user where locked = false) as countLocked,(select count(*) from user where locked = true) as countUnlocked");
        return (UserCountModel) query.getSingleResult();
    }
}
*/
