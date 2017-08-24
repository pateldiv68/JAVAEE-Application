/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assignment2_final.TimeTracker;

import com.mycompany.assignment2_final.Customer.Customer;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Div
 */
@Stateless
public class TimeTrackerEJB 
{
    //attributes
    @PersistenceContext(unitName = "PU")
    private EntityManager em;   
    
    public void createTimerEntry(TimeTracker timeTracker) 
    {
        em.persist(timeTracker);
        //return customer;
    }     

    //public methods
    public List<TimeTracker> listAllEntries() 
    {
        TypedQuery<TimeTracker> query = em.createNamedQuery("findAllEntries", TimeTracker.class);
        return query.getResultList();
    }        
}
