/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assignment2_final.Task;


import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Div
 */
@ManagedBean
@RequestScoped
public class TaskController 
{
    private Task task=new Task();
    @EJB
    private TaskEJB taskEJB;
    private String Task_Name;
    private Long ID;
    private List<Task> taskList;//=new ArrayList<Project>();     
    @PersistenceContext(unitName = "PU")
    private EntityManager em;    
    
    //constructors
    public TaskController() {
    }

    @PostConstruct
    public void init()
    {
    task = new Task("what is your aim today");
    taskList=new ArrayList<Task>();
    }
    
    
    public TaskController(String Task_Name) {
        this.Task_Name = Task_Name;
    }
    
    //setters and getters
    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
   

    public String getTask_Name() {
        return Task_Name;
    }

    public void setTask_Name(String Task_Name) {
        this.Task_Name = Task_Name;
    }

    public List<Task> getTaskList() {
        taskList = taskEJB.listAllProjects();                
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }
    
    //method to create a new task
    public void doCreateNewTask() 
    {
        //FacesContext ctx = FacesContext.getCurrentInstance();        
        taskEJB.createTaskEntry(task);
    }    
    
    public void delete_task(Task task) 
    {
        taskEJB.delete_task(task);        
    }         
}
