package pe.edu.utp.planandsave.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Abraham on 18/07/2017.
 */
public class PeriodsEntity extends BaseEntity {

    public PeriodsEntity(Connection connection) {
        super(connection,"periods");
    }

    public PeriodsEntity(){
    }

    List<Period> findAll(){
        return findByCriteria("");
    }

    public Period findById(int id){
        String criteria = " id = " + String.valueOf(id);
        return findByCriteria(criteria).get(0);
    }

    public List<Period> findByCriteria(String criteria){
        String sql = getDefaultQuery() + (criteria.isEmpty() ? "" : " WHERE " + criteria);
        List<Period> periods = new ArrayList<>();
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
            if (resultSet == null) return null;
            while (resultSet.next()){
                periods.add(Period.build(resultSet));
            }
            return periods;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
