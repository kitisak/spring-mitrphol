/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.th.linksinnovation.mitrphol.spring.repository;

import co.th.linksinnovation.mitrphol.spring.model.UserDetails;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Jirawong Wongdokpuang <jirawong@linksinnovation.com>
 */
public interface UserDetailsRepository extends JpaRepository<UserDetails, String>{
    
    @Query(value="SELECT * FROM USER_DETAILS",nativeQuery = true)
    public List<UserDetails> getAllUser();
    
    @Query(value="SELECT * FROM USER_DETAILS",nativeQuery = true)
    public List<Object[]> getAllUserObject();
    
    @Query(value="SELECT * FROM USER_DETAILS WHERE username=?1",nativeQuery = true)
    public List<Object[]> getAllUserObjectWhereUsername(String username);
    
}
