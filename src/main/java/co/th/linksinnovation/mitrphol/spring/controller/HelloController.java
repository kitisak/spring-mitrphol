/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.th.linksinnovation.mitrphol.spring.controller;

import co.th.linksinnovation.mitrphol.spring.dto.Hello;
import co.th.linksinnovation.mitrphol.spring.model.DocDetail;
import co.th.linksinnovation.mitrphol.spring.model.Docin;
import co.th.linksinnovation.mitrphol.spring.repositroy.DocinRepository;
import co.th.linksinnovation.mitrphol.spring.repositroy.UnknowRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
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
    
    @Autowired
    private DocinRepository docinRepository;
    
    @Autowired
    private UnknowRepository unknowRepository;
    
    //@PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/api/hello")
    String get(@AuthenticationPrincipal Object user){
        
        Docin docin = new Docin();
        docin.setDocCode("xxxxx");
        
        DocDetail dd = new DocDetail();
        dd.setItemId(1);
        dd.setItemDetail("xxxxxxxxxxxx");
        
        docin.addDocDetail(dd);
        
        docinRepository.save(docin);
        
        return "Hello, "+user;
    }
    
    @GetMapping("/api/docin")
    List<Docin> get(){
        unknowRepository.getSomething();
         return docinRepository.findAll(new Sort(Sort.Direction.DESC, "docCode","approveDate"));
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
