package com.mycompany.assignment2_final.Project;

import com.mycompany.assignment2_final.Task.Task;
import com.mycompany.assignment2_final.Task.TaskEJB;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Div
 */
@ManagedBean
@RequestScoped
public class ProjectController 
{
    //attributes    
    private Project project;// = new Project();
    private List<Project> projectList;//=new ArrayList<Project>(); 
    private Long projectId;
    @EJB    
    private ProjectEJB projectEJB; 
    @EJB
    private TaskEJB taskEJB; 
    //private String Project_Name;

    @PostConstruct
    public void init()
    {
    project = new Project();
    projectList=new ArrayList<Project>();
    }
    
    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<Project> getProjectList() {
        projectList = projectEJB.listAllProjects();        
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
    
    public String AllProjects() 
    {
        project=projectEJB.createProject(project);
        projectList = projectEJB.listAllProjects();
        return "userProfile.xhtml";
    }  

    public String ShowProjectsList() 
    {
        project=projectEJB.createProject(project);
        projectList = projectEJB.listAllProjects();
        return "projects.xhtml";
    }      
    
    public void delete(Project project) 
    {
        projectEJB.delete_P(project);        
    }  
    
 
}//class ends
