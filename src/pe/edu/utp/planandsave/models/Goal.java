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
    private Image image;
    private User user;
    private Currency currency;

    public Goal() {
    }

    public Goal(int id, String name, float amount, String status, Image image, User user, Currency currency) {
        this.setId(id);
        this.setName(name);
        this.setAmount(amount);
        this.setStatus(status);
        this.setImage(image);
        this.setUser(user);
        this.setCurrency(currency);
    }

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

    public Image getImage() {
        return image;
    }

    public Goal setImage(Image image) {
        this.image = image;
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

    public static Goal build(ResultSet resultSet, UsersEntity usersEntity, SubscriptionsEntity subscriptionsEntity,ImagesEntity imagesEntity,
                             CurrenciesEntity currenciesEntity){
        try {
            return (new Goal())
                    .setId(resultSet.getInt("id"))
                    .setName(resultSet.getString("name"))
                    .setAmount(resultSet.getFloat("amount"))
                    .setStatus(resultSet.getString("status"))
                    .setImage(imagesEntity.findById(resultSet.getInt("image_id")))
                    .setUser(usersEntity.findById(resultSet.getInt("user_id"), subscriptionsEntity))
                    .setCurrency(currenciesEntity.findById(resultSet.getInt("currency_id")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}

