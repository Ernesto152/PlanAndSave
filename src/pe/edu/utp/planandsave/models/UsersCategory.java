package pe.edu.utp.planandsave.models;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Ernesto Chira on 16/06/2017.
 */
public class UsersCategory {
    private int id;
    private String name;
    private float price;

    public int getId() {
        return id;
    }

    public String getIdAsString(){
        return String.valueOf(getId());
    }

    public UsersCategory setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getNameAsValue(){
        return "'" + getName() + "'";
    }

    public UsersCategory setName(String name) {
        this.name = name;
        return this;
    }

    public float getPrice() {
        return price;
    }

    public String getPriceAsString(){
        return String.valueOf(getPrice());
    }

    public UsersCategory setPrice(float price) {
        this.price = price;
        return this;
    }

    public static UsersCategory build(ResultSet resultSet){
        try {
            return (new UsersCategory())
                    .setId(resultSet.getInt("id"))
                    .setName(resultSet.getString("name"))
                    .setPrice(resultSet.getFloat("price"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
