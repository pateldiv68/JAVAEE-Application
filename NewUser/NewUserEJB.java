/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assignment2_final.NewUser;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ejb.Stateless;

/**
 *
 * @author Div
 */
@Stateless
public class NewUserEJB 
{
    //attributes
    @PersistenceContext(unitName = "PU")
    private EntityManager em;  
    
    //method to persist customer in DB
    public NewUser createNewEntry(NewUser newUser) 
    {
        em.persist(newUser);
        return newUser;
    }       
}
