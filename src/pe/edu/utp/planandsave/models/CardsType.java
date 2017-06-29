package pe.edu.utp.planandsave.models;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by usuario on 27/06/2017.
 */
public class CardsType {
    private int id;
    private String type;
    private String name;


    public int getId() {  return id;}

    public String getIdAsString(){return String.valueOf(getId());}

    public CardsType setId(int id) {
        this.id = id;
        return this;
    }

    public String getType() {return type;}

    public String getTypeAsValue(){ return "'" + getType() + "'";}

    public CardsType setType(String type) {
        this.type = type;
        return this;
    }

    public String getName() {return name;}

    public String getNameAsValue(){return "'" + getName() + "'";}

    public CardsType setName(String name) {
        this.name = name;
        return this;
    }

    public static CardsType build(ResultSet resultSet){
        try {
            return (new CardsType())
                .setId(resultSet.getInt("id"))
                .setType(resultSet.getString("type"))
                .setName(resultSet.getString("name"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
