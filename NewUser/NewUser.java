//newuser class
package com.mycompany.assignment2_final.NewUser;

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
@Table(name = "NewUser")
//newuser class
public class NewUser implements Serializable 
{
    @Id
    @Column(name = "NEWUSER_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)    
    private Long id; //primary key, not private
    @NotNull
    private String UserName;   
    private String TogglToken;
    private String WorkSpaceId;
    private String UserAgent;
        
    //private int ordercount;
    private static final long serialVersionUID = 1L;
    
    //constructor
    public NewUser() 
    {
    }

    //constructor
    public NewUser(String UserName, String TogglToken, String WorkSpaceId, String UserAgent) {
        //this.id = id;
        this.UserName = UserName;
        this.TogglToken = TogglToken;
        this.WorkSpaceId = WorkSpaceId;
        this.UserAgent = UserAgent;
    }
    
    ///////////////////////
    //setters and getters//
    ///////////////////////

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getTogglToken() {
        return TogglToken;
    }

    public void setTogglToken(String TogglToken) {
        this.TogglToken = TogglToken;
    }

    public String getWorkSpaceId() {
        return WorkSpaceId;
    }

    public void setWorkSpaceId(String WorkSpaceId) {
        this.WorkSpaceId = WorkSpaceId;
    }

    public String getUserAgent() {
        return UserAgent;
    }

    public void setUserAgent(String UserAgent) {
        this.UserAgent = UserAgent;
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
        if (!(object instanceof NewUser)) {
            return false;
        }
        NewUser other = (NewUser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "NewUser{" + "id=" + id + ", UserName=" + UserName + ", TogglToken=" + TogglToken + ", WorkSpaceId=" + WorkSpaceId + ", UserAgent=" + UserAgent + '}';
    }

}//class ends