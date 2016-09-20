/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.th.linksinnovation.mitrphol.spring.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jirawong Wongdokpuang <jirawong@linksinnovation.com>
 */
@RestController
public class HelloController {
    
    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/api/hello")
    String get(@AuthenticationPrincipal User user){
        return "Hello, "+user.getUsername() +" "+user.getAuthorities();
    }
    
    @GetMapping("/api/secured")
    String getSecured(@AuthenticationPrincipal User user){
        return "secured, "+user.getUsername() +" "+user.getAuthorities();
    }
}
