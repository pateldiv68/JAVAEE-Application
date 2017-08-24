package com.mycompany.assignment2_final.Customer;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Div
 */
@Stateless
public class CustomerEJB 
{
    //attributes
    @PersistenceContext(unitName = "PU")
    private EntityManager em;  
    
    //method to persist user in DB
    public Customer createUserEntry(Customer customer) 
    {
        em.persist(customer);
        return customer;
    }      

}//class ends