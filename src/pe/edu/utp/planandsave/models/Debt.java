package pe.edu.utp.planandsave.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by usuario on 16/06/2017.
 */
public class Debt {
    private int id;
    private String description;
    private String paymentPeriod;
    private int paymentTime;
    private float totalAmount;
    private Date startDate;
    private User user;
    private ExpensesCategory expensesCategory;
    private Currency currency;



    public Debt() {
    }

    public Debt(int id, String description, String paymentPeriod, int paymentTime, float totalAmount, Date startDate, User user, ExpensesCategory expensesCategory, Currency currency) {
        this.id = id;
        this.description = description;
        this.paymentPeriod = paymentPeriod;
        this.paymentTime = paymentTime;
        this.setTotalAmount(totalAmount);
        this.startDate = startDate;
        this.user = user;
        this.expensesCategory = expensesCategory;
        this.currency = currency;
    }

    public int getId() {
        return id;
    }

    public String getIdAsString(){
        return String.valueOf(getId());
    }

    public Debt setId(int id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Debt setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getPaymentPeriod() {
        return paymentPeriod;
    }

    public Debt setPaymentPeriod(String paymentPeriod) {
        this.paymentPeriod = paymentPeriod;
        return this;
    }

    public int getPaymentTime() {
        return paymentTime;
    }

    public Debt setPaymentTime(int paymentTime) {
        this.paymentTime = paymentTime;
        return this;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public Debt setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
        return this;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Debt setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Debt setUser(User user) {
        this.user = user;
        return this;
    }

    public ExpensesCategory getExpensesCategory() {
        return expensesCategory;
    }

    public Debt setExpensesCategory(ExpensesCategory expensesCategory) {
        this.expensesCategory = expensesCategory;
        return this;
    }

    public Currency getCurrency() {
        return currency;
    }

    public Debt setCurrency(Currency currency) {
        this.currency = currency;
        return this;
    }

    public static Debt build(ResultSet resultSet, UsersEntity usersEntity, SubscriptionsEntity subscriptionsEntity,
                             ExpensesCategoryEntity expensesCategoryEntity, CurrenciesEntity currenciesEntity){
        try {
            return (new Debt())
                    .setId(resultSet.getInt("id"))
                    .setDescription(resultSet.getString("description"))
                    .setPaymentPeriod(resultSet.getString("payment_period"))
                    .setPaymentTime(resultSet.getInt("payment_time"))
                    .setTotalAmount(resultSet.getFloat("total_amount"))
                    .setStartDate(resultSet.getDate("start_date"))
                    .setUser(usersEntity.findById(resultSet.getInt("user_id"), subscriptionsEntity))
                    .setExpensesCategory(expensesCategoryEntity.findById(resultSet.getInt("expense_category_id")))
                    .setCurrency(currenciesEntity.findById(resultSet.getInt("currency_id")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
