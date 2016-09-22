/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.th.linksinnovation.mitrphol.spring.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author Jirawong
 */
@Data
@Entity
@Table(name = "KONG_DOCDETAIL")
public class DocDetail {
    @Id
    private Integer itemId;
    private String itemDetail;
    private String itemNote;
    private Integer qty;
    
    @ManyToOne
    @JsonBackReference
    private Docin docin;
}
