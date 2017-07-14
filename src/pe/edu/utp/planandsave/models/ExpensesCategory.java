package pe.edu.utp.planandsave.models;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by usuario on 16/06/2017.
 */
public class ExpensesCategory {
    private int id;
    private String name;

    public ExpensesCategory(){
    }

    public ExpensesCategory(int id, String name){
        this.id=id;
        this.name=name;
    }

    public int getId() {
        return id;
    }

    public String getIdAsString(){
        return String.valueOf(getId());
    }

    public ExpensesCategory setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getNameAsValue(){
        return "'" + getName() + "'";
    }

    public ExpensesCategory setName(String name) {
        this.name = name;
        return this;
    }

    public static ExpensesCategory build(ResultSet resultSet){
        try {
            return (new ExpensesCategory())
                    .setId(resultSet.getInt("id"))
                    .setName(resultSet.getString("name"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
