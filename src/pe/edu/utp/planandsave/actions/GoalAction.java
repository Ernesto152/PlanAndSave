package pe.edu.utp.planandsave.actions;

import com.opensymphony.xwork2.ActionSupport;
import pe.edu.utp.planandsave.models.Goal;
import pe.edu.utp.planandsave.models.User;
import pe.edu.utp.planandsave.services.PSService;
import java.util.*;

public class GoalAction extends ActionSupport {
    private int id;
    private String name;
    private float amount;
    private String status;
    private String imageUrl;
    private User user;
    private Currency currency;
    private Goal goal;

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public float getAmount() {return amount;}

    public void setAmount(float amount) {this.amount = amount;}

    public String getStatus() {return status;}

    public void setStatus(float status) { this.status = status;}

    public String getImageUrl() { return imageUrl;}

    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl;}

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public Currency getCurrency() { return currency; }

    public void setCurrency(Currency currency) { this.currency = currency; }

    public Goal getGoal() { return goal; }

    public void setGoal(Goal goal) { this.goal = goal; }
    
    public String addGoal(){
        try {
            PSService PSS = new PSService();
            goal = new Goal(id, name, amount, status, imageUrl, PSS.getUsersById(user), PSS.getCurrenciesById(currency));
            PSS.createGoal(goal);
            return SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return "input";
        }
    }

public String execute(){return SUCCESS;}
