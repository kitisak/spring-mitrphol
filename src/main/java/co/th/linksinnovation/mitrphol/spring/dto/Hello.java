/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.th.linksinnovation.mitrphol.spring.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Jirawong
 */
@Data
@NoArgsConstructor
public class Hello {
    private String message;
    private String title;
    private String prefix;
    private String posfix;

    public Hello(String message, String title, String prefix, String posfix) {
        this.message = message;
        this.title = title;
        this.prefix = prefix;
        this.posfix = posfix;
    }

    
}
