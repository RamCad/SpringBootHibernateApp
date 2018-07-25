/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramcharan.samplespringbootapp;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ramcharan.adapa
 */
@Transactional
@Repository
public class UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public UserEntity getUserById(int userId) {
        return entityManager.find(UserEntity.class, userId);
    }

    public List<UserEntity> getAllUsers() {
        String hql = "FROM UserEntity as ue ORDER BY ue.id";
        return (List<UserEntity>) entityManager.createQuery(hql).getResultList();
    }
    
    public void saveUser(UserEntity userObj){
        entityManager.persist(userObj);
    }
    
    public void deleteUser(int uId){
        UserEntity uEntity = entityManager.find(UserEntity.class, uId);
        entityManager.remove(uEntity);
    }
}
