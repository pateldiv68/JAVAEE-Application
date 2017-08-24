package com.mycompany.assignment2_final.Project;

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
public class ProjectEJB 
{
    //persistant unit and EM
    @PersistenceContext(unitName = "PU")
    private EntityManager em;  

    //list all projects
    public List<Project> listAllProjects() 
    {
        TypedQuery<Project> query = em.createNamedQuery("findAllProjects", Project.class);
        return query.getResultList();         
    }
    
    //persist a new project in DB
    public Project createProject(Project p) 
    {
        em.persist(p);
        return p;        
    }

    //delete project entry
    public void delete_P(Project project) 
    {
        em.remove(em.contains(project) ? project : em.merge(project));
    }        
}
