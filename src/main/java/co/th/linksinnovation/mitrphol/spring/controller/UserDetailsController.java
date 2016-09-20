/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.th.linksinnovation.mitrphol.spring.controller;

import co.th.linksinnovation.mitrphol.spring.model.UserDetails;
import co.th.linksinnovation.mitrphol.spring.repository.UserDetailsRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jirawong Wongdokpuang <jirawong@linksinnovation.com>
 */
@RestController
@Profile("dev")
public class UserDetailsController {
    
    @Autowired
    private UserDetailsRepository userDetailsRepository;
    
    @GetMapping("/api/adduser/{username}/{password}")
    UserDetails addUser(@PathVariable("username") String username,@PathVariable("password") String password){
        UserDetails userDetails = new UserDetails();
        userDetails.setUsername(username);
        userDetails.setPassword(password);
        return userDetailsRepository.save(userDetails);
    }
    
    @GetMapping("/api/users")
    List<Object[]> getAllUser(){
        return userDetailsRepository.getAllUserObject();
    }
    
}
