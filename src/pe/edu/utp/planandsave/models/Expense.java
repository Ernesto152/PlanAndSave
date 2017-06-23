package pe.edu.utp.planandsave.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by usuario on 17/06/2017.
 */
public class Expense {
    private int id;
    private float amount;
    private Date registrationDate;
    private String description;
    private User user;
    private ExpensesCategory expensesCategory;
    private Currency currency;

    public Expense() {
    }

    public Expense(int id, float amount, Date registrationDate, String description, User user, ExpensesCategory expensesCategory, Currency currency) {
        this.setId(id);
        this.setAmount(amount);
        this.setRegistrationDate(registrationDate);
        this.setDescription(description);
        this.setUser(user);
        this.setExpensesCategory(expensesCategory);
        this.setCurrency(currency);
    }

    public int getId() {
        return id;
    }

    public String getIdAsString(){
        return String.valueOf(getId());
    }

    public Expense setId(int id) {
        this.id = id;
        return this;
    }

    public float getAmount() {
        return amount;
    }

    public String getAmountAsString(){
        return String.valueOf(getAmount());
    }

    public Expense setAmount(float amount) {
        this.amount = amount;
        return this;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public String getRegistrationDateAsValue(){
        return "'" + getRegistrationDate() + "'";
    }

    public Expense setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public String getDescriptionAsValue(){
        return "'" + getDescription() + "'";
    }

    public Expense setDescription(String description) {
        this.description = description;
        return this;
    }

    public User getUser() {
        return user;
    }

    public String getUserAsString(){
        return String.valueOf(getUser());
    }

    public Expense setUser(User user) {
        this.user = user;
        return this;
    }

    public ExpensesCategory getExpensesCategory() {
        return expensesCategory;
    }

    public String getExpensesCategoryAsString(){
        return String.valueOf(getExpensesCategory());
    }

    public Expense setExpensesCategory(ExpensesCategory expensesCategory) {
        this.expensesCategory = expensesCategory;
        return this;
    }

    public Currency getCurrency() {
        return currency;
    }

    public String getCurrencyAsString(){
        return String.valueOf(getCurrency());
    }

    public Expense setCurrency(Currency currency) {
        this.currency = currency;
        return this;
    }

    public static Expense build(ResultSet resultSet, UsersEntity usersEntity, UsersCategoryEntity usersCategoryEntity,
                                ExpensesCategoryEntity expensesCategoryEntity, CurrenciesEntity currenciesEntity) {
        try {
            return (new Expense())
                    .setId(resultSet.getInt("id"))
                    .setAmount(resultSet.getFloat("amount"))
                    .setRegistrationDate(resultSet.getDate("registration_date"))
                    .setDescription(resultSet.getString("description"))
                    .setUser(usersEntity.findById(resultSet.getInt("user_id"), usersCategoryEntity))
                    .setExpensesCategory(expensesCategoryEntity.findById(resultSet.getInt("expense_category_id")))
                    .setCurrency(currenciesEntity.findById(resultSet.getInt("currency_id")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
