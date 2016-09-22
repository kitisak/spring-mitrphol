/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.th.linksinnovation.mitrphol.spring.repositroy;

import co.th.linksinnovation.mitrphol.spring.model.Docin;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Jirawong
 */
public interface DocinRepository extends JpaRepository<Docin, String>{
    
    public Docin findByDocCode(String docCode,Sort sort,Pageable pageable);
    public List<Docin> findByApproverIn(List<String> aaa);
    
    @Query(value="SELECT * FROM KONG_DOCIN WERER docCode=?1",nativeQuery = true)
    public List<Object[]> nativeQuery(String docCode);
    
}
