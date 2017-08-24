package com.mycompany.assignment2_final.TimeTracker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Div
 */
@ManagedBean
@RequestScoped
public class TimeTrackerController 
{
    //attributes
    private TimeTracker timeTracker = new TimeTracker();
    private List<TimeTracker> togglList;
    @EJB
    private TimeTrackerEJB timerTrackerEJB;
    private Long ID;
    @PersistenceContext(unitName = "PU")
    private EntityManager em;    
    private String TT_Sdate;    
    private String TT_Edate;    
    private String TT_ETime;
    private String taskID;
    private String projectID;
    private String s;    
    
    
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
    
    DateFormat S_dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    Date S_date = new Date();
    DateFormat E_dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    Date E_date = new Date();

    //setters and getters
    public TimeTracker getTimeTracker() {
        return timeTracker;
    }

    public void setTimeTracker(TimeTracker timeTracker) {
        this.timeTracker = timeTracker;
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

    public List<TimeTracker> getTogglList() {
        togglList = timerTrackerEJB.listAllEntries();        
        return togglList;
    }

    public void setTogglList(List<TimeTracker> togglList) {
        this.togglList = togglList;
    }

    //method to create a new customer
    public void doCreateTimerEntry() 
    {
        timerTrackerEJB.createTimerEntry(timeTracker);
    }
    
    public void setStartDate()
    {
        TT_Sdate=S_dateFormat.format(S_date);
        timeTracker.setTT_Sdate(TT_Sdate);        
    }
    
    public void setEndDate()
    {
        TT_Edate=E_dateFormat.format(E_date);
        timeTracker.setTT_Edate(TT_Edate);
    }
    
    public void setTaskTime(String c)
    {
        TT_ETime=c;
        timeTracker.setTT_ETime(TT_ETime);
    }
}
