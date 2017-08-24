//User class
package com.mycompany.assignment2_final.Customer;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Div
 */

@Entity 
@Table(name = "Customer")
//user class
public class Customer implements Serializable 
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)    
    @Column(name = "CUST_ID")
    private Long id; //primary key, not private
    @NotNull
    private String UserName;   
    private String Password;
    private static final long serialVersionUID = 1L;

    //relationship mapping-bidirectional relationship...added extra
//    @OneToMany(fetch = FetchType.LAZY)
//    //@JoinColumn(name="CUST_FK", referencedColumnName = "CUST_ID")
//    private Project project;
    
    //relationship mapping-bidirectional relationship...added extra
//    @OneToMany(fetch = FetchType.LAZY)
//    //@JoinColumn(name="CUST_FK", referencedColumnName = "CUST_ID")
//    private Task task;
    
//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinColumn(name="SYNC_FK", referencedColumnName = "Sync_ID")
//    private Sync sync;
    
    //constructor
    public Customer() 
    {
    }
    
    //constructor
    public Customer(String UserName, String Password) 
    {
        this.id = id;
        this.UserName = UserName;
        this.Password = Password;
    }

    ///////////////////////
    //setters and getters//
    ///////////////////////
    
    public Long getId() {
        return id;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public void setId(Long id) {
        this.id = id;
    }  

    // ======================================
    // =         hash, equals, toString     =
    // ======================================
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", UserName=" + UserName + ", Password=" + Password + '}';
    }

}//class ends