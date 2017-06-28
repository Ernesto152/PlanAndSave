package pe.edu.utp.planandsave.models;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * Created by usuario on 16/06/2017.
 */
public class Goal {
    private int id;
    private String name;
    private float amount;
    private String status;
    private String imageUrl;
    private User user;
    private Currency currency;

    public int getId() {
        return id;
    }

    public String getIdAsString(){
        return String.valueOf(getId());
    }

    public Goal setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getNameAsValue(){
        return "'" + getName() + "'";
    }

    public Goal setName(String name) {
        this.name = name;
        return this;
    }

    public float getAmount() {
        return amount;
    }

    public String getAmountAsString(){
        return String.valueOf(getAmount());
    }

    public Goal setAmount(float amount) {
        this.amount = amount;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public String getStatusAsValue(){
        return "'" + getStatus() + "'";
    }

    public Goal setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getImageUrlAsValue(){
        return "'" + getImageUrl() + "'";
    }

    public Goal setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Goal setUser(User user) {
        this.user = user;
        return this;
    }

    public Currency getCurrency() {
        return currency;
    }

    public Goal setCurrency(Currency currency) {
        this.currency = currency;
        return this;
    }

    public static Goal build(ResultSet resultSet, UsersEntity usersEntity, SubscriptionsEntity subscriptionsEntity,
                             CurrenciesEntity currenciesEntity){
        try {
            return (new Goal())
                    .setId(resultSet.getInt("id"))
                    .setName(resultSet.getString("name"))
                    .setAmount(resultSet.getFloat("amount"))
                    .setStatus(resultSet.getString("status"))
                    .setImageUrl(resultSet.getString("image_url"))
                    .setUser(usersEntity.findById(resultSet.getInt("user_id"), subscriptionsEntity))
                    .setCurrency(currenciesEntity.findById(resultSet.getInt("currency_id")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}

