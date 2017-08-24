//TimeTracker class
package com.mycompany.assignment2_final.TimeTracker;

import com.mycompany.assignment2_final.Project.Project;
import com.mycompany.assignment2_final.Task.Task;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Past;

/**
 *
 * @author Div
 */
@Entity
@Table(name = "TimeTracker")
@NamedQueries({@NamedQuery(name = "findAllEntries", query = "SELECT t FROM TimeTracker t")})//, 
//@NamedQuery(name = "findAll", query = "SELECT TASK.TASK_NAME, PROJECT.PROJECT_NAME, TIMETRACKER.TT_SDATE, TIMETRACKER.TT_EDATE, TIMETRACKER.TT_ETIME"
//        + "FROM TimeTracker"
//        + "INNER JOIN TASK ON"
//        + "TASK.TASK_ID=TIMETRACKER.TT_ID"
//        + "INNER JOIN PROJECT ON"
//        + "PROJECT.PROJECT_ID=TIMETRACKER.TT_ID")})
public class TimeTracker implements Serializable 
{
    private static final long serialVersionUID = 1L;
    @Id    
    @Column(name = "TT_ID")
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
//    @Temporal(TemporalType.DATE)
//    @Column(name = "TT_START_DATE")
//    private java.util.Date TT_Sdate;    
//
//    @Temporal(TemporalType.DATE)
//    @Column(name = "TT_END_DATE")
//    private java.util.Date TT_Edate;    
//    
//    @Temporal(TemporalType.TIME)
//    @Column(name = "TT_END_TIME")
//    private java.util.Date TT_ETime;
    private String TT_Sdate;    
    private String TT_Edate;    
    //@Transient
    private String TT_ETime;
//    private Long taskID;
//    private Long projectID;    
    
    //relationship mapping
//    @OneToOne(optional=false)
//    @JoinColumn(name = "TASK_ID") 
//    private Task task;   
//    
//    @OneToOne(optional=false)
//    @JoinColumn(name = "PROJECT_ID") 
//    private Project project;     

    //constructors
    public TimeTracker() {
    }

    public TimeTracker(String TT_Sdate, String TT_Edate, String TT_ETime) {
        //super();
        //this.id = id;
        this.TT_Sdate = TT_Sdate;
        this.TT_Edate = TT_Edate;
        this.TT_ETime = TT_ETime;
        //taskID=tid;
        //projectID=pid;
    }
    
    //setters and getters
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTT_Sdate() {
        return TT_Sdate;
    }

    public void setTT_Sdate(String TT_Sdate) {
        this.TT_Sdate = TT_Sdate;
    }

    public String getTT_Edate() {
        return TT_Edate;
    }

    public void setTT_Edate(String TT_Edate) {
        this.TT_Edate = TT_Edate;
    }

    public String getTT_ETime() {
        return TT_ETime;
    }

    public void setTT_ETime(String TT_ETime) {
        this.TT_ETime = TT_ETime;
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
        if (!(object instanceof TimeTracker)) {
            return false;
        }
        TimeTracker other = (TimeTracker) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TimeTracker{" + "id=" + id + ", TT_Sdate=" + TT_Sdate + ", TT_Edate=" + TT_Edate + ", TT_ETime=" + TT_ETime + '}';
    }
}//end class TimeTracker
