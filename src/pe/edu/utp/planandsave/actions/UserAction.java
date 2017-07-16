package pe.edu.utp.planandsave.actions;

import com.opensymphony.xwork2.ActionSupport;
import pe.edu.utp.planandsave.models.Subscription;
import pe.edu.utp.planandsave.models.SubscriptionsEntity;
import pe.edu.utp.planandsave.models.User;
import pe.edu.utp.planandsave.services.PSService;

import java.sql.Date;

/**
 * Created by Abraham on 15/07/2017.
 */
public class UserAction extends ActionSupport{
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Date subscriptionStart;
    private Date subscriptionRenovation;
    private Subscription subscription;
    private SubscriptionsEntity subscriptionsEntity;
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getSubscriptionStart() {
        return subscriptionStart;
    }

    public void setSubscriptionStart(Date subscriptionStart) {
        this.subscriptionStart = subscriptionStart;
    }

    public Date getSubscriptionRenovation() {
        return subscriptionRenovation;
    }

    public void setSubscriptionRenovation(Date subscriptionRenovation) {
        this.subscriptionRenovation = subscriptionRenovation;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public SubscriptionsEntity getSubscriptionsEntity() {
        return subscriptionsEntity;
    }

    public void setSubscriptionsEntity(SubscriptionsEntity subscriptionsEntity) {
        this.subscriptionsEntity = subscriptionsEntity;
    }

    public String add(){
        user = new User(id, firstName, lastName, email, password, subscriptionStart, subscriptionRenovation, subscription);
        try {
            PSService PSS = new PSService();
            PSS.createUser(user);
            return SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return "input";
        }
    }

    public String login(){
        PSService PSS = new PSService();
        try {
            PSS.getUsersByEmail(email, subscriptionsEntity);
            if(PSS.getUsersByEmail(email, subscriptionsEntity) == null) {
                return "input";
            }else {
                User user = new User();
                if(user.getPassword().equals(password)) {
                    return SUCCESS;
                }
            }
            PSS.getUsersById(0, subscriptionsEntity);
            return "input";
        }catch (Exception e){
            e.printStackTrace();
            return "input";
        }
    }


    public String execute(){
        return SUCCESS;
    }


}

