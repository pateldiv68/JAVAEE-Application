//customer controller
package com.mycompany.assignment2_final.Customer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.component.html.HtmlInputText;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Div
 */
@ManagedBean
@RequestScoped
public class CustomerController 
{
    private Customer customer;// = new Customer();
    private List<Customer> custList;
    @EJB
    private CustomerEJB custEJB;
    private String UserName, Password;
    private Long ID;
    @PersistenceContext(unitName = "PU")
    private EntityManager em;    
    
    @PostConstruct
    public void init()
    {
    customer = new Customer("Username", "Password");
    custList = new ArrayList<Customer>();
    }

    //method to create a new user
    public String doCreateUserEntry() 
    {
        FacesContext ctx = FacesContext.getCurrentInstance();

        if (customer.getUserName()== null || "".equals(customer.getUserName())) 
        {
            ctx.addMessage("userform:username", new FacesMessage(FacesMessage.SEVERITY_WARN, "Username not filled", "Username is mandatory"));
        }
        
        if (customer.getPassword()== null || "".equals(customer.getPassword())) 
        {
            ctx.addMessage("userform:password", new FacesMessage(FacesMessage.SEVERITY_WARN, "Password not provided", "user's password is mandatory"));
        }
        if (ctx.getMessageList().size() != 0)
            return null;
        
        customer = custEJB.createUserEntry(customer);
        //custList = customerEJB.listAllCustomers();
        return "userProfile.xhtml";
    }
    
    ///////////////////////
    //setters and getters//
    ///////////////////////

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Customer> getCustList() {
        return custList;
    }

    public void setCustList(List<Customer> custList) {
        this.custList = custList;
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

}//class ends