package pe.edu.utp.planandsave.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Abraham on 17/06/2017.
 */
public class ExpensesCategoryEntity extends BaseEntity {

    public ExpensesCategoryEntity(Connection connection) {
        super(connection, "expenses_category");
    }

    public ExpensesCategoryEntity() {
    }

    List<ExpensesCategory> findAll(){
        return findByCriteria("");
    }

    public ExpensesCategory findById(int id){
        String criteria = " id = " + String.valueOf(id);
        return findByCriteria(criteria).get(0);
    }

    public ExpensesCategory findByName(String name){
        String criteria = " name = '" + name + "'";
        return findByCriteria(criteria).get(0);
    }

    public List<ExpensesCategory> findByCriteria(String criteria){
        String sql = getDefaultQuery() +(criteria.equalsIgnoreCase("") ? "" : " WHERE " + criteria);
        List<ExpensesCategory> expenseCategories = new ArrayList<>();
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
            if (resultSet == null) return null;
            while (resultSet.next()){
                expenseCategories.add(ExpensesCategory.build(resultSet));
            }
            return expenseCategories;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean add(ExpensesCategory expensesCategory) {
        String sql = "INSERT INTO expenses_category(id, name) " +
                "VALUES(" + expensesCategory.getIdAsString() + ", " +
                expensesCategory.getNameAsValue() + ")";
        return change(sql);
    }

}
