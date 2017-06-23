package pe.edu.utp.planandsave.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by usuario on 16/06/2017.
 */
public class UsersCategoryEntity extends BaseEntity {

    public UsersCategoryEntity(Connection connection) {
        super(connection, "user_category");
    }

    public UsersCategoryEntity() {
    }

    List<UsersCategory> findAll(){
        return findByCriteria("");
    }

    public UsersCategory findById(int id){
        String criteria = " id = " + String.valueOf(id);
        return findByCriteria(criteria).get(0);
    }

    public UsersCategory findByName(String name){
        String criteria = " name = '" + name + "'";
        return findByCriteria(criteria).get(0);
    }

    public List<UsersCategory> findByCriteria(String criteria){
        String sql = getDefaultQuery() + criteria == "" ? "" : " WHERE " + criteria;
        List<UsersCategory> userCategories = new ArrayList<>();
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
            if (resultSet == null) return null;
            while (resultSet.next()){
                userCategories.add(UsersCategory.build(resultSet));
            }
            return userCategories;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
