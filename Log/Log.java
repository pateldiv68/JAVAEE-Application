//log class
package com.mycompany.assignment2_final.Log;

import com.mycompany.assignment2_final.TimeTracker.TimeTracker;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Div
 */
@Entity
@Table(name = "Log")
public class Log implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "Log_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String Log_Task;
    private String Log_Project;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "Log_START_DATE")
    private java.util.Date Log_Sdate;

    @Temporal(TemporalType.DATE)
    @Column(name = "Log_END_DATE")
    private java.util.Date Log_Edate;

    @Temporal(TemporalType.TIME)
    @Column(name = "Log_TIME")
    private java.util.Date Log_Time;
    
    //unidirectional relationship
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="TT_FK", referencedColumnName = "TT_ID")
    private TimeTracker timeTracker;    

    //constructor
    public Log() {
    }

    public Log(Long id, String Log_Task, String Log_Project, Date Log_Sdate, Date Log_Edate, Date Log_Time) {
        this.id = id;
        this.Log_Task = Log_Task;
        this.Log_Project = Log_Project;
        this.Log_Sdate = Log_Sdate;
        this.Log_Edate = Log_Edate;
        this.Log_Time = Log_Time;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLog_Task() {
        return Log_Task;
    }

    public void setLog_Task(String Log_Task) {
        this.Log_Task = Log_Task;
    }

    public String getLog_Project() {
        return Log_Project;
    }

    public void setLog_Project(String Log_Project) {
        this.Log_Project = Log_Project;
    }

    public Date getLog_Sdate() {
        return Log_Sdate;
    }

    public void setLog_Sdate(Date Log_Sdate) {
        this.Log_Sdate = Log_Sdate;
    }

    public Date getLog_Edate() {
        return Log_Edate;
    }

    public void setLog_Edate(Date Log_Edate) {
        this.Log_Edate = Log_Edate;
    }

    public Date getLog_Time() {
        return Log_Time;
    }

    public void setLog_Time(Date Log_Time) {
        this.Log_Time = Log_Time;
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
        if (!(object instanceof Log)) {
            return false;
        }
        Log other = (Log) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Log{" + "id=" + id + ", Log_Task=" + Log_Task + ", Log_Project=" + Log_Project + ", Log_Sdate=" + Log_Sdate + ", Log_Edate=" + Log_Edate + ", Log_Time=" + Log_Time + '}';
    }

}
