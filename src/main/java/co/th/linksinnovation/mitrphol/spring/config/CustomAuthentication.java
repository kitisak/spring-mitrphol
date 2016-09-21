/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.th.linksinnovation.mitrphol.spring.config;

import co.th.linksinnovation.mitrphol.spring.dto.Auth;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Jirawong
 */
@Component
public class CustomAuthentication implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        RestTemplate rt = new RestTemplate();
        Map<String, String> map = new HashMap<>();
        map.put("username", authentication.getName());
        map.put("password", authentication.getCredentials().toString());
        System.out.println(authentication.getName() +" "+authentication.getCredentials().toString());
        ResponseEntity<Auth> entity = rt.postForEntity("http://10.25.65.171:99/casService/auth/json/", map, Auth.class);
        //ResponseEntity<String> xxx = rt.postForEntity("http://10.25.65.171:99/casService/auth/json/", map, String.class);
        //System.out.println("------- "+xxx.getBody());

        if (entity.getBody().getSuccess().getCode().equals("200")) {
            List<GrantedAuthority> grantedAuths = new ArrayList<>();
            grantedAuths.add(new SimpleGrantedAuthority("User"));
            System.out.println(entity.getBody().getSuccess().getData()[0]);
            Authentication auth = new UsernamePasswordAuthenticationToken(entity.getBody().getSuccess().getData()[0], authentication.getCredentials().toString(), grantedAuths);
            return auth;
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
