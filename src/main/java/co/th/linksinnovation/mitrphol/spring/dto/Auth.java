/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.th.linksinnovation.mitrphol.spring.dto;

/**
 *
 * @author Jirawong
 */
public class Auth
{
    private Success success;

    public Success getSuccess ()
    {
        return success;
    }

    public void setSuccess (Success success)
    {
        this.success = success;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [success = "+success+"]";
    }
}
