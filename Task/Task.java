//Task class123
package com.mycompany.assignment2_final.Task;

import com.mycompany.assignment2_final.Customer.Customer;
import com.mycompany.assignment2_final.TimeTracker.TimeTracker;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Div
 */
@Entity
@Table(name = "Task")
@NamedQueries({
@NamedQuery(name = "findAllTasks", query = "SELECT t FROM Task t")}) 
public class Task implements Serializable 
{
    //attributes
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "TASK_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String Task_Name;
    
    //relationship mapping bidirectional relationshhip
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="CUST_FK", referencedColumnName = "CUST_ID")
    private Customer customer;
    
    //added extra
//    @OneToOne(cascade=CascadeType.ALL)
//    //@JoinColumn(name = "TT_ID") 
//    private TimeTracker timeTracker; 

    //constructors 
    public Task() {
    }

    public Task(String Task_Name) {
        //this.id = id;
        this.Task_Name = Task_Name;
    }
    
    //getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTask_Name() {
        return Task_Name;
    }

    public void setTask_Name(String Task_Name) {
        this.Task_Name = Task_Name;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Task)) {
            return false;
        }
        Task other = (Task) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Task{" + "id=" + id + ", Task_Name=" + Task_Name + '}';
    }    
}