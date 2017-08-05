package pe.edu.utp.planandsave.actions;

import com.opensymphony.xwork2.ActionSupport;
import pe.edu.utp.planandsave.models.*;
import pe.edu.utp.planandsave.services.PSService;

import java.util.Date;

/**
 * Created by Abraham on 15/07/2017.
 */
public class IncomeAction extends ActionSupport {
    private int id;
    private float amount;
    private String description;
    private Date registration_date;
    private int user;
    private int currency;
    private Income income;
    private String status;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(Date registration_date) {
        this.registration_date = registration_date;
    }

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

    public Income getIncome() {
        return income;
    }

    public void setIncome(Income income) {
        this.income = income;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String add(){
        try {
            PSService PSS = new PSService();
            income = new Income(id,amount,description,registration_date, PSS.getUsersById(user), PSS.getCurrenciesById(currency));
            PSS.createIncome(income);
            return SUCCESS;
        }catch(Exception e) {
            e.printStackTrace();
            return INPUT;
        }
    }

    public String delete(){
        try {
            PSService PSS = new PSService();
            income = PSS.getIncomesById(id);
            PSS.deleteIncome(income);
            return SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return INPUT;
        }
    }

    public String edit(){
        try {
            PSService service = new PSService();
            income = service.getIncomesById(id);
            id = income.getId();
            amount = income.getAmount();
            description = income.getDescription();
            return SUCCESS;
        }catch (Exception e) {
            e.printStackTrace();
            return INPUT;
        }
    }

    public String update(){
        try {
            PSService PSS = new PSService();
            income = new Income(id,amount,description,registration_date, PSS.getUsersById(user), PSS.getCurrenciesById(currency));
            PSS.updateIncome(income);
            return SUCCESS;
        }catch(Exception e) {
            e.printStackTrace();
            return INPUT;
        }
    }

    public  String execute(){
        return SUCCESS;
    }

}

