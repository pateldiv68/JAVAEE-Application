//new user comtroller
package com.mycompany.assignment2_final.NewUser;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
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
public class NewUserController 
{
    private NewUser newUser;//=new NewUser();
    private List<NewUser> userList;
    @EJB
    private NewUserEJB newUserEJB;
    private String UserName;   
    private String TogglToken;
    private String WorkSpaceId;
    private String UserAgent; 
    
    private Long ID;
    @PersistenceContext(unitName = "PU")
    private EntityManager em;   
    
    @PostConstruct
    public void init()
    {
    newUser = new NewUser("Username", "abcd123cfd54xads56", "91457821", "project_E-mail ID");
    userList = new ArrayList<NewUser>();
    }

    //method to create a new customer
    public String doCreateCustomerEntry() 
    {
        //FacesContext ctx = FacesContext.getCurrentInstance();

//        if (newUser.getTogglToken()== null || "".equals(newUser.getTogglToken())) 
//        {
//            ctx.addMessage("CustomerForm:token", new FacesMessage(FacesMessage.SEVERITY_WARN, "token not filled", "token is required"));
//        }
//        
//        if (newUser.getWorkSpaceId()== null || "".equals(newUser.getWorkSpaceId())) 
//        {
//            ctx.addMessage("CustomerForm:wid", new FacesMessage(FacesMessage.SEVERITY_WARN, "workspace_id not filled", "workspace_id is required"));
//        }
//
//        if (newUser.getUserAgent()== null || "".equals(newUser.getUserAgent())) 
//        {
//            ctx.addMessage("CustomerForm:agent", new FacesMessage(FacesMessage.SEVERITY_WARN, "user_agent not filled", "user_agent is required"));
//        }
//
//        if (ctx.getMessageList().size() != 0)
//            return null;
        
        newUser = newUserEJB.createNewEntry(newUser);
        return "index.xhtml";
    }

    ///////////////////////
    //setters and getters//
    ///////////////////////

    public NewUser getNewUser() {
        return newUser;
    }

    public void setNewUser(NewUser newUser) {
        this.newUser = newUser;
    }

    public List<NewUser> getUserList() {
        return userList;
    }

    public void setUserList(List<NewUser> userList) {
        this.userList = userList;
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
}//class ends

/*
@POST CONSTRUCT
because when the constructor is called, the bean is not yet initialized - 
i.e. no dependencies are injected. 
In the @PostConstruct method the bean is fully initialized and you can use the dependencies.
because this is the contract that guarantees that this method will be 
invoked only once in the bean lifecycle. It may happen (though unlikely) 
that a bean is instantiated multiple times by the container in its internal 
working, but it guarantees that @PostConstruct will be invoked only once.
*/
