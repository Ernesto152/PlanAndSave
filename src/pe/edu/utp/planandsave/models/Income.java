package pe.edu.utp.planandsave.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by usuario on 27/06/2017.
 */
public class Income {
    private int id;
    private float amount;
    private String description;
    private Date registrationDate;
    private User user;
    private Currency currency;

    public Income() {
    }
    public Income(int id, float amount, String description, Date registrationDate, User user, Currency currency){
        this.setId(id);
        this.setAmount(amount);
        this.setDescription(description);
        this.setRegistrationDate(registrationDate);
        this.setUser(user);
        this.setCurrency(currency);
    }

    public int getId() {return id;    }

    public String getIdAsString(){
        return String.valueOf(getId());
    }

    public Income setId(int id) {
        this.id = id;
        return this;
    }

    public float getAmount() { return amount;   }

    public String getAmountAsString(){
        return String.valueOf(getAmount());
    }

    public Income setAmount(float amount) {
        this.amount = amount;
        return this;
    }

    public String getDescription() { return description;   }

    public String getDescriptionAsValue(){
        return "'" + getDescription() + "'";
    }

    public Income setDescription(String description) {
        this.description = description;
        return this;
    }

    public Date getRegistrationDate() { return registrationDate; }

    public String getRegistrationDateAsValue(){
        return "'" + getRegistrationDate() + "'";
    }

    public Income setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
        return this;
    }

    public User getUser() { return user;    }

    public String getUserAsString(){
        return String.valueOf(getUser());
    }

    public Income setUser(User user) {
        this.user = user;
        return this;
    }

    public Currency getCurrency() { return currency;    }

    public String getCurrencyAsString(){
        return String.valueOf(getCurrency());
    }

    public Income setCurrency(Currency currency) {
        this.currency = currency;
        return this;
    }
    public static Income build(ResultSet resultSet, UsersEntity usersEntity, SubscriptionsEntity subscriptionsEntity,
                               CurrenciesEntity currenciesEntity){
        try {
            return (new Income())
                    .setId(resultSet.getInt("id"))
                    .setAmount(resultSet.getFloat("amount"))
                    .setDescription(resultSet.getString("description"))
                    .setRegistrationDate(resultSet.getDate("registration_date"))
                    .setUser(usersEntity.findById(resultSet.getInt("user_id"), subscriptionsEntity))
                    .setCurrency(currenciesEntity.findById(resultSet.getInt("currency_id")));
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;
    }


}
