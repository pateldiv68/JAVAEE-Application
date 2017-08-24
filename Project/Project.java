//project class
package com.mycompany.assignment2_final.Project;

import com.mycompany.assignment2_final.Customer.Customer;
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
@Table(name = "Project")
@NamedQueries({
@NamedQuery(name = "findAllProjects", query = "SELECT p FROM Project p")}) 
public class Project implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "PROJECT_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String Project_Name;
    
    //relationship mapping
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="CUST_FK", referencedColumnName = "CUST_ID")
    private Customer customer;
    
    //added extra
//    @OneToOne(cascade=CascadeType.ALL)
//    //@JoinColumn(name = "TT_ID") 
//    private TimeTracker timeTracker;     

    //constructor
    public Project() {
    }
    
    public Project(String Project_Name) {
        //this.id = id;
        this.Project_Name = Project_Name;
    }
    
    //setters and getters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProject_Name() {
        return Project_Name;
    }

    public void setProject_Name(String Project_Name) {
        this.Project_Name = Project_Name;
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
        if (!(object instanceof Project)) {
            return false;
        }
        Project other = (Project) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Project{" + "id=" + id + ", Project_Name=" + Project_Name + '}';
    }
}
