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
    private int quota;
    private float interest;
    private float freeAmount;
    private float totalAmount;
    private Date startDate;
    private User user;
    private ExpensesCategory expensesCategory;
    private Currency currency;
    private Period period;



    public Debt() {
    }

    public Debt(int id, String description, int quota, float interest, float freeAmount, float totalAmount, Date startDate, User user, ExpensesCategory expensesCategory, Currency currency) {
        this.id = id;
        this.description = description;
        this.quota = quota;
        this.totalAmount = totalAmount;
        this.interest = interest;
        this.freeAmount = freeAmount;
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

    public String getDescriptionAsValue(){
        return "'" + getDescription() + "'";
    }

    public Debt setDescription(String description) {
        this.description = description;
        return this;
    }

    public int getQuota() {
        return quota;
    }

    public String getQuotaAsString(){
        return  String.valueOf(getQuota());
    }

    public Debt setQuota(int quota) {
        this.quota = quota;
        return this;
    }

    public float getInterest() {
        return interest;
    }

    public String getInterestAsString(){
        return String.valueOf(getInterest());
    }

    public Debt setInterest(float interest) {
        this.interest = interest;
        return this;
    }

    public float getFreeAmount() {
        return freeAmount;
    }

    public String getFreeAmountAsString(){
        return String.valueOf(getFreeAmount());
    }

    public Debt setFreeAmount(float freeAmount) {
        this.freeAmount = freeAmount;
        return this;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public String getTotalAmountAsString(){
        return String.valueOf(getTotalAmount());
    }

    public Debt setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
        return this;
    }

    public Date getStartDate() {
        return startDate;
    }

    public String getStartDateAsValue(){
        return "'" + getStartDate() + "'";
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

    public Period getPeriod() {
        return period;
    }

    public Debt setPeriod(Period period) {
        this.period = period;
        return this;
    }

    public static Debt build(ResultSet resultSet, UsersEntity usersEntity, SubscriptionsEntity subscriptionsEntity,
                             ExpensesCategoryEntity expensesCategoryEntity, CurrenciesEntity currenciesEntity,PeriodsEntity periodsEntity){
        try {
            return (new Debt())
                    .setId(resultSet.getInt("id"))
                    .setDescription(resultSet.getString("description"))
                    .setQuota(resultSet.getInt("quota"))
                    .setInterest(resultSet.getFloat("interest"))
                    .setFreeAmount(resultSet.getFloat("free_amount"))
                    .setTotalAmount(resultSet.getFloat("total_amount"))
                    .setStartDate(resultSet.getDate("start_date"))
                    .setUser(usersEntity.findById(resultSet.getInt("user_id"), subscriptionsEntity))
                    .setExpensesCategory(expensesCategoryEntity.findById(resultSet.getInt("expense_category_id")))
                    .setCurrency(currenciesEntity.findById(resultSet.getInt("currency_id")))
                    .setPeriod(periodsEntity.findById(resultSet.getInt("period_id")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
