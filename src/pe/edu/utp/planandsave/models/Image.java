package pe.edu.utp.planandsave.models;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Abraham on 05/08/2017.
 */
public class Image {
    private int id;
    private String url;

    public Image(int id, String url) {
        this.id = id;
        this.url = url;
    }

    public Image() {
    }

    public int getId() {
        return id;
    }

    public String getIdAsString(){
        return String.valueOf(getId());
    }

    public Image setId(int id) {
        this.id = id;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public String getUrlAsValue(){
        return "'" + getUrl() + "'";
    }

    public Image setUrl(String url) {
        this.url = url;
        return this;
    }

    public static Image build(ResultSet resultSet){
        try {
            return (new Image())
                    .setId(resultSet.getInt("id"))
                    .setUrl(resultSet.getString("url"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
