/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rc.spring;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ramcharan.adapa
 */
@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public UserEntity getUserById(int userId) {
        //Operations
        UserEntity obj = userDAO.getUserById(userId);
        return obj;
    }

    public List<UserEntity> getAllUsers() {
        return userDAO.getAllUsers();
    }
    
    public void saveUser(UserEntity userObj){
        userDAO.saveUser(userObj);
    }
    
    public void deleteUser(int uId){
        userDAO.deleteUser(uId);
    }
}
