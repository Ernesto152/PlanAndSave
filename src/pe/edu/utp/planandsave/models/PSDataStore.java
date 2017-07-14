package pe.edu.utp.planandsave.models;

import java.sql.Connection;
import java.util.List;

/**
 * Created by usuario on 27/06/2017.
 */
public class PSDataStore {
    private Connection connection;
    private CurrenciesEntity currenciesEntity;

    private ExpensesCategoryEntity expensesCategoryEntity;

    private UsersEntity usersEntity;
    private SubscriptionsEntity subscriptionsEntity;
    private IncomesEntity incomesEntity;

    public PSDataStore(Connection connection) {
        this.setConnection(connection);
    }

    public PSDataStore() {
    }

    public Connection getConnection() {
        return connection;
    }

    public PSDataStore setConnection(Connection connection) {
        this.connection = connection;
        return this;
    }

    private CurrenciesEntity getCurrenciesEntity(){
        if (currenciesEntity == null){
            currenciesEntity = new CurrenciesEntity(getConnection());
        }
        return currenciesEntity;
    }

    public List<Currency> findAllCurrencies(){
        return getCurrenciesEntity().findAll();
    }

    /*----------------------------------------------------

    private SubscriptionsEntity getSubscriptionsEntity(){
        if (subscriptionsEntity == null){
            subscriptionsEntity = new SubscriptionsEntity(getConnection());
        }
        return  subscriptionsEntity;
    }

    public List<Subscription> findAllSubscriptions(){
        return getSubscriptionsEntity().findAll();
    }

    private UsersEntity getUsersEntity(){
        if (usersEntity == null){
            usersEntity = new UsersEntity(getConnection());
        }
        return  usersEntity;
    }

    public List<User> findAllUsers(){
        return getUsersEntity().findAll(getSubscriptionsEntity());
    }

    private IncomesEntity getIncomesEntity(){
        if (incomesEntity == null){
            incomesEntity = new IncomesEntity(getConnection());
        }
        return  incomesEntity;
    }

    public List<Income> findAllIncomes(){
        return getIncomesEntity().findAll(getUsersEntity(),getSubscriptionsEntity(),getCurrenciesEntity());
    }

    public boolean createIncome(Income income){
        return getIncomesEntity().add(income);
    }

    ------------------------------------------------------------*/
    private ExpensesCategoryEntity getExpensesCategoryEntity(){
        if(expensesCategoryEntity == null){
            expensesCategoryEntity = new ExpensesCategoryEntity(getConnection());
        }
        return expensesCategoryEntity;
    }

    public List<ExpensesCategory> findAllExpenseCategories() {
        return getExpensesCategoryEntity().findAll();
    }

    public boolean createExpenseCategory(ExpensesCategory expensesCategory){
        return getExpensesCategoryEntity().add(expensesCategory);
    }

}
