/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.th.linksinnovation.mitrphol.spring.repositroy;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jirawong
 */
@Repository
public class UnknowRepository {
    
    @PersistenceContext
    private EntityManager em;
    
    public void getSomething(){
        Query q = em.createNativeQuery("SELECT * FROM KONG_DOCIN");
        q.getResultList();    
    }
    
}
