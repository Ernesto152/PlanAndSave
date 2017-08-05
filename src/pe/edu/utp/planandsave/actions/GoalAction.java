package pe.edu.utp.planandsave.actions;

import com.opensymphony.xwork2.ActionSupport;
import pe.edu.utp.planandsave.models.*;
import pe.edu.utp.planandsave.services.PSService;

import java.util.Date;

public class GoalAction extends ActionSupport {
    private int id;
    private String name;
    private float amount;
    private String status;
    private int image;
    private int user;
    private int currency;
    private Goal goal;
    private Expense expense;
    private Date date;
    private float saves;

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public float getAmount() {return amount;}

    public void setAmount(float amount) {this.amount = amount; }

    public String getStatus() { return status;}

    public void setStatus(String status) {this.status = status;}

    public int getImage() {return image;}

    public void setImage(int image) {this.image = image; }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getCurrency() {
        return currency;
    }

    public void setCurrency(int currency) {
        this.currency = currency;
    }

    public Goal getGoal() {
        return goal;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }

    public Expense getExpense() {
        return expense;
    }

    public void setExpense(Expense expense) {
        this.expense = expense;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getSaves() {
        return saves;
    }

    public void setSaves(float saves) {
        this.saves = saves;
    }

    public String add() {
        try {
            PSService PSS = new PSService();
            goal = new Goal(id, name, amount, "Incompleto", PSS.getImageById(image), PSS.getUsersById(user), PSS.getCurrenciesById(currency));
            PSS.createGoal(goal);
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return "input";
        }
    }

    public String delete(){
        try {
            PSService PSS = new PSService();
            goal = PSS.getGoalById(id);
            PSS.deleteGoal(goal);
            return SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return INPUT;
        }
    }

    public String complete(){
        try {
            PSService PSS = new PSService();
            goal = PSS.getGoalById(id);
            if(saves> goal.getAmount()){
                PSS.completeGoal(goal);
                expense = new Expense(1, goal.getAmount(), date, goal.getName(), goal.getUser(), PSS.getExpenseCategoriesById(3), goal.getCurrency());
                PSS.createExpense(expense);
            }
            return SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return INPUT;
        }
    }

    public String execute() {
        return SUCCESS;
    }


}
