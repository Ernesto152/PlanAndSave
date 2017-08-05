package pe.edu.utp.planandsave.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by usuario on 16/06/2017.
 */
public class ExpensesEntity extends BaseEntity {

    public ExpensesEntity(Connection connection) {
        super(connection, "expenses");
    }

    public ExpensesEntity() {
        super();
    }

    List<Expense> findAll(UsersEntity usersEntity, SubscriptionsEntity subscriptionsEntity, ExpensesCategoryEntity expensesCategoryEntity,
                          CurrenciesEntity currenciesEntity){
        return findByCriteria("", usersEntity, subscriptionsEntity, expensesCategoryEntity, currenciesEntity);
    }

    public Expense findById(int id, UsersEntity usersEntity, SubscriptionsEntity subscriptionsEntity,
                            ExpensesCategoryEntity expensesCategoryEntity, CurrenciesEntity currenciesEntity){
        String criteria = " id = " + String.valueOf(id);
        return findByCriteria(criteria, usersEntity, subscriptionsEntity, expensesCategoryEntity, currenciesEntity).get(0);
    }

    public List<Expense> findByCriteria(String criteria, UsersEntity usersEntity, SubscriptionsEntity subscriptionsEntity,
                                        ExpensesCategoryEntity expensesCategoryEntity, CurrenciesEntity currenciesEntity) {
        String sql = getDefaultQuery() + (criteria.isEmpty() ? "" : " WHERE " + criteria);
        List<Expense> expenses = new ArrayList<>();
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
            if(resultSet == null) return null;
            while(resultSet.next()) {
                expenses.add(Expense.build(resultSet, usersEntity, subscriptionsEntity,
                        expensesCategoryEntity, currenciesEntity));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return expenses;
    }

    public boolean add(Expense expense) {
        String sql = "INSERT INTO expenses(amount, registration_date, description, user_id, expense_category_id, currency_id) " +
                "VALUES(    " +
                            expense.getAmountAsString() + ", " +
                            "CURDATE(), " +
                            expense.getDescriptionAsValue() + "," +
                            expense.getUser().getIdAsString() + ", " +
                            expense.getExpensesCategory().getIdAsString() + " ," +
                            expense.getCurrency().getIdAsString() + ")";
        return change(sql);
    }

    public boolean delete(Expense expense){
        String sql = "DELETE FROM expenses WHERE id = " + expense.getIdAsString();
        return change(sql);
    }

    public boolean update(Expense expense){
        String sql = "UPDATE expenses SET amount = " + expense.getAmountAsString() + ", " +
                            "description = " + expense.getDescriptionAsValue() + ", " +
                            "expense_category_id = " + expense.getExpensesCategory().getIdAsString() + ", " +
                            "currency_id = " + expense.getCurrency().getIdAsString() +
                            " WHERE id = " + expense.getIdAsString();
        return change(sql);
    }
}
