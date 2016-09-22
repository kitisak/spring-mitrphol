/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.th.linksinnovation.mitrphol.spring.repositroy;

import co.th.linksinnovation.mitrphol.spring.model.DocDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Jirawong
 */
public interface DocDetailRepository extends JpaRepository<DocDetail, Integer>{
    
}
