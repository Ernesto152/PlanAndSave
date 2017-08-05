package pe.edu.utp.planandsave.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by usuario on 16/06/2017.
 */
public class DebtsEntity extends BaseEntity{

    public DebtsEntity(Connection connection) {
        super(connection, "debts");
    }

    public DebtsEntity() {super();}

    public List<Debt> findAll(UsersEntity usersEntity, SubscriptionsEntity subscriptionsEntity,
                              ExpensesCategoryEntity expensesCategoryEntity, CurrenciesEntity currenciesEntity, PeriodsEntity periodsEntity){
        return findByCriteria("", usersEntity, subscriptionsEntity, expensesCategoryEntity, currenciesEntity, periodsEntity);
    }

    public Debt findById(int id, UsersEntity usersEntity, SubscriptionsEntity subscriptionsEntity, ExpensesCategoryEntity expensesCategoryEntity, CurrenciesEntity currenciesEntity, PeriodsEntity periodsEntity){
        String criteria = " id = " + String.valueOf(id);
        return findByCriteria(criteria, usersEntity, subscriptionsEntity, expensesCategoryEntity, currenciesEntity, periodsEntity).get(0);
    }

    public List<Debt> findByCriteria(String criteria, UsersEntity usersEntity, SubscriptionsEntity subscriptionsEntity,
                                     ExpensesCategoryEntity expensesCategoryEntity, CurrenciesEntity currenciesEntity, PeriodsEntity periodsEntity){
        String sql = getDefaultQuery() + (criteria.isEmpty() ? "" : " WHERE " + criteria);
        List<Debt> debts = new ArrayList<>();
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
            if (resultSet == null) return null;
            while (resultSet.next()){
                debts.add(Debt.build(resultSet, usersEntity, subscriptionsEntity, expensesCategoryEntity, currenciesEntity, periodsEntity));
            }
            return debts;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean add(Debt debt) {
        String sql = "INSERT INTO debts(description, quota, interest, free_amount, period_amount, start_date, user_id, expense_category_id, currency_id, period_id) " +
                "VALUES(    " +
                debt.getDescriptionAsValue() + ", " +
                debt.getQuotaAsString() + ", " +
                debt.getInterestAsString() + ", " +
                debt.getFreeAmountAsString() + ", " +
                debt.getPeriodAmountAsString() + ", " +
                "CURDATE(), "+
                debt.getUser().getIdAsString() + " , " +
                debt.getExpensesCategory().getIdAsString() + ", " +
                debt.getCurrency().getIdAsString() + ", " +
                debt.getPeriod().getIdAsString() +")";
        return change(sql);
    }


    public boolean delete(Debt debt){
        String sql = "DELETE FROM debts WHERE id = " + debt.getIdAsString();
        return change(sql);
    }



}
