package pe.edu.utp.planandsave.models;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Abraham on 18/07/2017.
 */
public class Period {
    private int id;
    private String name;
    private String value;

    public Period(){
    }

    public Period(int id, String name, String value){
        this.id = id;
        this.name = name;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public String getIdAsString(){
        return String.valueOf(getId());
    }

    public Period setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getNameAsValue(){
        return "'" + getName() + "'";
    }

    public Period setName(String name) {
        this.name = name;
        return this;
    }

    public String getValue() {
        return value;
    }

    public Period setValue(String value) {
        this.value = value;
        return this;
    }

    public static Period build(ResultSet resultSet){
        try{
            return (new Period())
                    .setId(resultSet.getInt("id"))
                    .setName(resultSet.getString("name"))
                    .setValue(resultSet.getString("value"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
