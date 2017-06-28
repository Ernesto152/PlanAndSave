package pe.edu.utp.planandsave.models;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by usuario on 16/06/2017.
 */
public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private float salary;
    private Subscription subscription;

    public User(int id, String firstName, String lastName, String email, String password, float salary, Subscription subscription) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.salary = salary;
        this.subscription = subscription;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public String getIdAsString(){
        return String.valueOf(getId());
    }

    public User setId(int id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFirstNameAsValue(){
        return "'" + getFirstName() + "'";
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLastNameAsValue(){
        return "'" + getLastName() + "'";
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public String getEmailAsValue(){
        return "'" + getEmail() + "'";
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordAsValue(){
        return "'" + getPassword() + "'";
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public float getSalary() {
        return salary;
    }

    public String getSalaryAsString(){
        return String.valueOf(getSalary());
    }

    public User setSalary(float salary) {
        this.salary = salary;
        return this;
    }

    public Subscription getSubscription() {
        return subscription;
    }


    public User setSubscription(Subscription subscription) {
        this.subscription = subscription;
        return this;
    }

    public static User build(ResultSet resultSet, SubscriptionsEntity subscriptionsEntity){
        try {
            return (new User())
                    .setId(resultSet.getInt("id"))
                    .setFirstName(resultSet.getString("first_name"))
                    .setLastName(resultSet.getString("last_name"))
                    .setEmail(resultSet.getString("email"))
                    .setPassword(resultSet.getString("password"))
                    .setSalary(resultSet.getFloat("salary"))
                    .setSubscription(subscriptionsEntity.findById(resultSet.getInt("user_category_id")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
