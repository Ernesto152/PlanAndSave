package pe.edu.utp.planandsave.actions;

import com.opensymphony.xwork2.ActionSupport;
import pe.edu.utp.planandsave.models.Debt;
import pe.edu.utp.planandsave.services.PSService;
import java.util.*;

/**
 * Created by Abraham on 18/07/2017.
 */
public class DebtAction extends ActionSupport {
    private int debt_id;
    private String debt_description;
    private int debt_quota;
    private float debt_interest;
    private float debt_freeAmount;
    private float debt_periodAmount;
    private Date debt_startDate;
    private int user;
    private int expenseCategory;
    private int currency;
    private int period;
    private Debt debt;

    /*private int quota_id;
    private int quota_number;
    private Date quota_paymentDate;
    private float quota_amount;
    private Quota quota;*/

    public int getDebt_id() {
        return debt_id;
    }

    public void setDebt_id(int debt_id) {
        this.debt_id = debt_id;
    }

    public String getDebt_description() {
        return debt_description;
    }

    public void setDebt_description(String debt_description) {
        this.debt_description = debt_description;
    }

    public int getDebt_quota() {
        return debt_quota;
    }

    public void setDebt_quota(int debt_quota) {
        this.debt_quota = debt_quota;
    }

    public float getDebt_interest() {
        return debt_interest;
    }

    public void setDebt_interest(float debt_interest) {
        this.debt_interest = debt_interest;
    }

    public float getDebt_freeAmount() {
        return debt_freeAmount;
    }

    public void setDebt_freeAmount(float debt_freeAmount) {
        this.debt_freeAmount = debt_freeAmount;
    }

    public float getDebt_periodAmount() {
        return debt_periodAmount;
    }

    public void setDebt_periodAmount(float debt_periodAmount) {
        this.debt_periodAmount = debt_periodAmount;
    }

    public Date getDebt_startDate() {
        return debt_startDate;
    }

    public void setDebt_startDate(Date debt_startDate) {
        this.debt_startDate = debt_startDate;
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

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public Debt getDebt() {
        return debt;
    }

    public void setDebt(Debt debt) {
        this.debt = debt;
    }

    public String add(){
        try {
            PSService PSS = new PSService();
            debt_interest = (debt_periodAmount * debt_quota) - debt_freeAmount;
            debt = new Debt(debt_id, debt_description, debt_quota, debt_interest, debt_freeAmount, debt_periodAmount, debt_startDate, PSS.getUsersById(user), PSS.getExpenseCategoriesById(expenseCategory), PSS.getCurrenciesById(currency), PSS.getPeriodById(period));
            PSS.createDebt(debt);
            return SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return "input";
        }
    }

    public String delete(){
        try {
            PSService PSS = new PSService();
            debt = PSS.getDebtById(debt_id);
            PSS.deleteDebt(debt);
            return SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return "input";
        }
    }

    public String execute(){return SUCCESS;}




   /* public int getQuota_id() {
        return quota_id;
    }

    public void setQuota_id(int quota_id) {
        this.quota_id = quota_id;
    }

    public int getQuota_number() {
        return quota_number;
    }

    public void setQuota_number(int quota_number) {
        this.quota_number = quota_number;
    }

    public Date getQuota_paymentDate() {
        return quota_paymentDate;
    }

    public void setQuota_paymentDate(Date quota_paymentDate) {
        this.quota_paymentDate = quota_paymentDate;
    }

    public float getQuota_amount() {
        return quota_amount;
    }

    public void setQuota_amount(float quota_amount) {
        this.quota_amount = quota_amount;
    }

    public Quota getQuota() {
        return quota;
    }

    public void setQuota(Quota quota) {
        this.quota = quota;



    public String add(){
        try {
            PSService PSS = new PSService();
            debt = new Debt(debt_id, debt_description, debt_quota, debt_interest, debt_freeAmount, debt_periodAmount, debt_startDate, user, PSS.getExpenseCategoriesById(expenseCategory), PSS.getCurrenciesById(currency), PSS.getPeriodById(period));
            quota = new Quota(quota_id, quota_number, quota_paymentDate, quota_amount, PSS.getDebtById(debt_id));
            return SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return "input";
        }

    }*/


}
