package com.mycompany.assignment2_final.Task;

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
public class TaskEJB {

    //attributes
    @PersistenceContext(unitName = "PU")
    private EntityManager em;  

    //method to persist task in DB
    public void createTaskEntry(Task task) 
    {
        em.persist(task);
    }
    
    //list all tasks
    public List<Task> listAllProjects() 
    {
        TypedQuery<Task> query = em.createNamedQuery("findAllTasks", Task.class);
        return query.getResultList();         
    }

    //delete project entry
    public void delete_task(Task task) 
    {
        em.remove(em.contains(task) ? task : em.merge(task));
    }      
}
