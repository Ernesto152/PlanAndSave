package pe.edu.utp.planandsave.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by usuario on 16/06/2017.
 */
public class GoalsEntity extends BaseEntity{

    public GoalsEntity(Connection connection) {
        super(connection, "goals");
    }

    public GoalsEntity() {
        super();
    }

    List<Goal> findAll(UsersEntity usersEntity, SubscriptionsEntity subscriptionsEntity,
                       CurrenciesEntity currenciesEntity){
        return findByCriteria("", usersEntity, subscriptionsEntity, currenciesEntity);
    }

    public Goal findById(int id, UsersEntity usersEntity, SubscriptionsEntity subscriptionsEntity,
                         CurrenciesEntity currenciesEntity){
        String criteria = " id = " + id;
        return findByCriteria(criteria, usersEntity, subscriptionsEntity, currenciesEntity).get(0);
    }

    public Goal findByName(String name, UsersEntity usersEntity, SubscriptionsEntity subscriptionsEntity,
                           CurrenciesEntity currenciesEntity){
        String criteria = " name = '" + name + "'";
        return findByCriteria(criteria, usersEntity, subscriptionsEntity, currenciesEntity).get(0);
    }

    public Goal findByCost(String cost, UsersEntity usersEntity, SubscriptionsEntity subscriptionsEntity,
                           CurrenciesEntity currenciesEntity){
        String criteria = " cost = '" + cost + "'";
        return findByCriteria(criteria, usersEntity, subscriptionsEntity, currenciesEntity).get(0);
    }

    public List<Goal> findByCriteria(String criteria, UsersEntity usersEntity, SubscriptionsEntity subscriptionsEntity,
                                     CurrenciesEntity currenciesEntity){
        String sql = getDefaultQuery() + (criteria.isEmpty() ? "" : " WHERE " + criteria);
        List<Goal> goals = new ArrayList<>();
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
            if (resultSet == null) return null;
            while (resultSet.next()){
                goals.add(Goal.build(resultSet, usersEntity, subscriptionsEntity, currenciesEntity));
            }
            return goals;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
