/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.th.linksinnovation.mitrphol.spring.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

/**
 *
 * @author Jirawong
 */
@Data
@Entity
@Table(name = "KONG_DOCIN")
public class Docin {
    private Integer docId;
    @Id
    private String docCode;
    private Boolean docStatus;
    private String approver;
    private Date approveDate;
    
    @OneToMany(mappedBy = "docin",cascade = CascadeType.ALL)
    @NotFound(action = NotFoundAction.IGNORE)
    @JsonManagedReference
    private List<DocDetail> docDetails;
    
    public void addDocDetail(DocDetail docDetail){
        if(docDetails == null){
            this.docDetails = new ArrayList<>();
        }
        docDetail.setDocin(this);
        this.docDetails.add(docDetail);
    }
}
