//sync class
package com.mycompany.assignment2_final.Sync;

import com.mycompany.assignment2_final.Customer.Customer;
import com.mycompany.assignment2_final.Log.Log;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Past;

/**
 *
 * @author Div
 */
@Entity
@Table(name = "Sync")
public class Sync implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "Sync_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "SYNC_DATE_FIELD")
    private java.util.Date Sync_date;   
    
    @Temporal(TemporalType.TIME)
    @Column(name = "SYNC_TIME_FIELD")
    private java.util.Date Sync_Time;
    
//    @OneToOne(optional=false)
//    @JoinColumn(name = "CUST_ID") 
//    private Customer customer;
    
    //unidirectional relationship
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="LOG_FK", referencedColumnName = "LOG_ID")
    private Log log;    
    
    //constructor
    public Sync() {
    }

    public Sync(Long id, Date Sync_date, Date Sync_Time) {
        this.id = id;
        this.Sync_date = Sync_date;
        this.Sync_Time = Sync_Time;
    }
    
    //getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getSync_date() {
        return Sync_date;
    }

    public void setSync_date(Date Sync_date) {
        this.Sync_date = Sync_date;
    }

    public Date getSync_Time() {
        return Sync_Time;
    }

    public void setSync_Time(Date Sync_Time) {
        this.Sync_Time = Sync_Time;
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
        if (!(object instanceof Sync)) {
            return false;
        }
        Sync other = (Sync) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Sync{" + "id=" + id + ", Sync_date=" + Sync_date + ", Sync_Time=" + Sync_Time + '}';
    }
}