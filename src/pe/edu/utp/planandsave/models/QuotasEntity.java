package pe.edu.utp.planandsave.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by usuario on 27/06/2017.
 */
public class QuotasEntity extends BaseEntity {
    public QuotasEntity(Connection connection) {super(connection, "quotas");}

    public QuotasEntity() { super();}

    List<Quota> findAll(DebtsEntity debtsEntity){
        return findByCriteria("", debtsEntity);
    }
    public Quota findByCriteria(int id, DebtsEntity debtsEntity){
        String criteria = " id = " + id;
        return findByCriteria(criteria, debtsEntity).get(0);
    }
    public List<Quota> findByCriteria(String criteria, DebtsEntity debtsEntity) {
        String sql = getDefaultQuery() + (criteria.isEmpty() ? "" : " WHERE " + criteria);
        List<Quota> quotas = new ArrayList<>();
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
            if(resultSet == null) return null;
            while(resultSet.next()) {
                quotas.add(Quota.build(resultSet, debtsEntity));
            }
            return quotas;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
