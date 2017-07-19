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

    List<Quota> findAll(DebtsEntity debtsEntity, UsersEntity usersEntity, SubscriptionsEntity subscriptionsEntity, ExpensesCategoryEntity expensesCategoryEntity,
                        CurrenciesEntity currenciesEntity, PeriodsEntity periodsEntity){
        return findByCriteria("", debtsEntity, usersEntity, subscriptionsEntity,expensesCategoryEntity,currenciesEntity, periodsEntity);
    }
    public Quota findById(int id, DebtsEntity debtsEntity, UsersEntity usersEntity, SubscriptionsEntity subscriptionsEntity, ExpensesCategoryEntity expensesCategoryEntity,
                                CurrenciesEntity currenciesEntity, PeriodsEntity periodsEntity){
        String criteria = " id = " + String.valueOf(id);
        return findByCriteria(criteria, debtsEntity, usersEntity, subscriptionsEntity,expensesCategoryEntity,currenciesEntity, periodsEntity).get(0);
    }
    public List<Quota> findByCriteria(String criteria, DebtsEntity debtsEntity, UsersEntity usersEntity, SubscriptionsEntity subscriptionsEntity, ExpensesCategoryEntity expensesCategoryEntity,
                                      CurrenciesEntity currenciesEntity, PeriodsEntity periodsEntity) {
        String sql = getDefaultQuery() + (criteria.isEmpty() ? "" : " WHERE " + criteria);
        List<Quota> quotas = new ArrayList<>();
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
            if(resultSet == null) return null;
            while(resultSet.next()) {
                quotas.add(Quota.build(resultSet, debtsEntity, usersEntity, subscriptionsEntity, expensesCategoryEntity, currenciesEntity, periodsEntity));
            }
            return quotas;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean add(Quota quota) {
        int i;
        for (i=1; i<quota.getDebt().getQuota(); i++){
        String sql = "INSERT INTO quotas(number, payment_date, amount, debt_id) " +
                "VALUES(    " +
                quota.getNumberAsString() + ", " +
                "DATE_ADD(" + quota.getPaymentDateAsValue() + ", INTERVAL " + i + " " + quota.getDebt().getPeriod().getValue() + "), "  +
                quota.getAmountAsString() + ", " +
                quota.getDebt().getIdAsString()+")";
        return change(sql);
    }
    return false;
    }
}
