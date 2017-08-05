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

    List<Goal> findAll(UsersEntity usersEntity, SubscriptionsEntity subscriptionsEntity, CurrenciesEntity currenciesEntity,ImagesEntity imagesEntity){
        return findByCriteria("", usersEntity, subscriptionsEntity, currenciesEntity, imagesEntity);
    }

    public Goal findById(int id, UsersEntity usersEntity, SubscriptionsEntity subscriptionsEntity,
                         CurrenciesEntity currenciesEntity, ImagesEntity imagesEntity){
        String criteria = " id = " + String.valueOf(id);
        return findByCriteria(criteria, usersEntity, subscriptionsEntity, currenciesEntity, imagesEntity).get(0);
    }

    public Goal findByName(String name, UsersEntity usersEntity, SubscriptionsEntity subscriptionsEntity,
                           CurrenciesEntity currenciesEntity, ImagesEntity imagesEntity){
        String criteria = " name = '" + name + "'";
        return findByCriteria(criteria, usersEntity, subscriptionsEntity, currenciesEntity, imagesEntity).get(0);
    }

    public Goal findByCost(String cost, UsersEntity usersEntity, SubscriptionsEntity subscriptionsEntity,
                           CurrenciesEntity currenciesEntity, ImagesEntity imagesEntity){
        String criteria = " cost = '" + cost + "'";
        return findByCriteria(criteria, usersEntity, subscriptionsEntity, currenciesEntity, imagesEntity).get(0);
    }

    public List<Goal> findByCriteria(String criteria, UsersEntity usersEntity, SubscriptionsEntity subscriptionsEntity,
                                     CurrenciesEntity currenciesEntity, ImagesEntity imagesEntity){
        String sql = getDefaultQuery() + (criteria.isEmpty() ? "" : " WHERE " + criteria);
        List<Goal> goals = new ArrayList<>();
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
            if (resultSet == null) return null;
            while (resultSet.next()){
                goals.add(Goal.build(resultSet, usersEntity, subscriptionsEntity, imagesEntity, currenciesEntity));
            }
            return goals;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean add(Goal goal) {
        String sql = "INSERT INTO goals(name, amount, status, image_id, user_id, currency_id) " +
                "VALUES(    " +
                goal.getNameAsValue()+ ", " +
                goal.getAmountAsString() + ", " +
                goal.getStatusAsValue() + ", " +
                goal.getImage().getIdAsString() + ", " +
                goal.getUser().getIdAsString() + " , " +
                goal.getCurrency().getIdAsString() +")";
        return change(sql);
    }

    public boolean delete(Goal goal){
        String sql = "DELETE FROM goals WHERE id = " + goal.getIdAsString();
        return change(sql);
    }

    public boolean complete(Goal goal){
        String sql = "UPDATE goals SET status = 'Completado' WHERE id = " + goal.getId();
        return change(sql);
    }

}
