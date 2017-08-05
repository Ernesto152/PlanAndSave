package pe.edu.utp.planandsave.actions;

import com.opensymphony.xwork2.ActionSupport;
import pe.edu.utp.planandsave.models.*;
import pe.edu.utp.planandsave.services.PSService;
import java.sql.Date;

/**
 * Created by Abraham on 15/07/2017.
 */
public class ExpenseAction extends ActionSupport {
    private int id;
    private float amount;
    private Date registration_date;
    private String description;
    private int user;
    private int expenseCategory;
    private int currency;
    private Expense expense;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Date getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(Date registration_date) {
        this.registration_date = registration_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getExpenseCategory() {
        return expenseCategory;
    }

    public void setExpenseCategory(int expenseCategory) {
        this.expenseCategory = expenseCategory;
    }

    public int getCurrency() {
        return currency;
    }

    public void setCurrency(int currency) {
        this.currency = currency;
    }

    public Expense getExpense() {
        return expense;
    }

    public void setExpense(Expense expense) {
        this.expense = expense;
    }

    public String add(){
        try {
            PSService PSS = new PSService();
            expense = new Expense(id, amount, registration_date, description, PSS.getUsersById(user),PSS.getExpenseCategoriesById(expenseCategory) , PSS.getCurrenciesById(currency) );
            PSS.createExpense(expense);
            return SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return "input";
        }
    }

    public String delete(){
        try {
            PSService PSS = new PSService();
            expense = PSS.getExpenseById(id);
            PSS.deleteExpense(expense);
            return SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return INPUT;
        }
    }

    public String edit(){
        try {
            PSService service = new PSService();
            expense = service.getExpenseById(id);
            id = expense.getId();
            amount = expense.getAmount();
            description = expense.getDescription();
            return SUCCESS;
        }catch (Exception e) {
            e.printStackTrace();
            return INPUT;
        }
    }

    public String update(){
        try {
            PSService service = new PSService();
            expense = new Expense(id, amount, registration_date, description, service.getUsersById(user), service.getExpenseCategoriesById(expenseCategory), service.getCurrenciesById(currency));
            service.updateExpense(expense);
            return SUCCESS;
        }catch(Exception e) {
            e.printStackTrace();
            return INPUT;
        }
    }

    public String execute() {
        return SUCCESS;
    }

}

