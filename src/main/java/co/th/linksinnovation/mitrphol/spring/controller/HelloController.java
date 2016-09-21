/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.th.linksinnovation.mitrphol.spring.controller;

import co.th.linksinnovation.mitrphol.spring.dto.Data;
import co.th.linksinnovation.mitrphol.spring.dto.Hello;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Jirawong Wongdokpuang <jirawong@linksinnovation.com>
 */
@RestController
public class HelloController {
    
    //@PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/api/hello")
    String get(@AuthenticationPrincipal Object user){
        //SecurityContextHolder.getContext().getAuthentication().getPrincipal()
        return "Hello, "+user;
    }
    
    @GetMapping("/api/secured")
    String getSecured(@AuthenticationPrincipal User user){
        return "secured, "+user.getUsername() +" "+user.getAuthorities();
    }
    
    @GetMapping("/api/rest/hello")
    public Hello getRest(){
        RestTemplate rt = new RestTemplate();
        ResponseEntity<Hello> response = rt.getForEntity("http://localhost:8080/api/hello", Hello.class);
        return response.getBody();
    }
}
