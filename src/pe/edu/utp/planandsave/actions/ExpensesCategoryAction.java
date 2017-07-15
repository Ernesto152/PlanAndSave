package pe.edu.utp.planandsave.actions;

import com.opensymphony.xwork2.ActionSupport;
import pe.edu.utp.planandsave.models.*;

import pe.edu.utp.planandsave.services.PSService;

/**
 * Created by Abraham on 13/07/2017.
 */
public class ExpensesCategoryAction extends ActionSupport {

    private int id;
    private String name;
    private ExpensesCategory expensesCategory;

    /*-------------------------------------------------------------------------------*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ExpensesCategory getExpensesCategory() {
        return expensesCategory;
    }

    public void setExpensesCategory(ExpensesCategory expensesCategory) {
        this.expensesCategory = expensesCategory;
    }

    public String add() {
        expensesCategory = new ExpensesCategory(id, name);
        try {
            PSService PSS = new PSService();
            PSS.createExpenseCategory(expensesCategory);
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return "input";
        }
    }

    public String execute() {
        return SUCCESS;
    }

    }
