package pe.edu.utp.planandsave.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Abraham on 05/08/2017.
 */
public class ImagesEntity extends BaseEntity{

    public ImagesEntity(Connection connection) {
        super(connection, "images");
    }

    public ImagesEntity() {
    }

    List<Image> findAll(){
        return findByCriteria("");
    }

    public Image findById(int id){
        String criteria = " id = " + String.valueOf(id);
        return findByCriteria(criteria).get(0);
    }

    public List<Image> findByCriteria(String criteria){
        String sql = getDefaultQuery() +(criteria.equalsIgnoreCase("") ? "" : " WHERE " + criteria);
        List<Image> images = new ArrayList<>();
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
            if (resultSet == null) return null;
            while (resultSet.next()){
                images.add(Image.build(resultSet));
            }
            return images;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
