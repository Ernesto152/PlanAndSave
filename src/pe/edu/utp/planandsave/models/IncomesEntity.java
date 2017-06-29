package pe.edu.utp.planandsave.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by usuario on 27/06/2017.
 */
public class IncomesEntity extends BaseEntity {
    public IncomesEntity(Connection connection) {super(connection, "incomes");}

    public IncomesEntity() { super();}

    List<Income> findAll(UsersEntity usersEntity, SubscriptionsEntity subscriptionsEntity, CurrenciesEntity currenciesEntity){
        return findByCriteria("", usersEntity, subscriptionsEntity, currenciesEntity);
    }
    public Income findByCriteria(int id, UsersEntity usersEntity, SubscriptionsEntity subscriptionsEntity,
                                 CurrenciesEntity currenciesEntity){
        String criteria = " id = " + id;
        return findByCriteria(criteria, usersEntity, subscriptionsEntity, currenciesEntity).get(0);
    }
    public List<Income> findByCriteria(String criteria, UsersEntity usersEntity, SubscriptionsEntity subscriptionsEntity,
                                         CurrenciesEntity currenciesEntity) {
        String sql = getDefaultQuery() + (criteria.isEmpty() ? "" : " WHERE " + criteria);
        List<Income> incomes = new ArrayList<>();
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
            if(resultSet == null) return null;
            while(resultSet.next()) {
                incomes.add(Income.build(resultSet, usersEntity, subscriptionsEntity, currenciesEntity));
            }
            return incomes;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
