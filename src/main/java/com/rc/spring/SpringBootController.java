package com.rc.spring;

/**
 *
 * @author ramcharan.adapa
 */
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringBootController {

    @Autowired
    private UserService userService;
    
    //Sample
    @RequestMapping(value = "/webservice", method = RequestMethod.GET)
    public String sampleWebService() {
        return "Hello";
    }
    
    //Get a User by UserId
    @RequestMapping(value="/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserEntity> getUserById(@PathVariable("id") int id){
        UserEntity ue = userService.getUserById(id);
        return new ResponseEntity<>(ue, HttpStatus.OK);
    }
    
    //Get List of Users
    @RequestMapping(value="/user", method = RequestMethod.GET)
    public List<UserEntity> getUsers(){
        return userService.getAllUsers();
    }
    
    //Saving a User
    @RequestMapping(value="/user", method=RequestMethod.POST)
    public void saveUser(@RequestBody UserEntity userEntity){
        userService.saveUser(userEntity);
    }
    
    //Delete a User based on UserId
    @RequestMapping(value="/user/{id}", method=RequestMethod.DELETE)
    public void deleteUser(@PathVariable("id") int id){
        userService.deleteUser(id);
    }
}
