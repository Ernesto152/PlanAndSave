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
    private ExpensesEntity expensesEntity;
    private DebtsEntity debtsEntity;
    private PeriodsEntity periodsEntity;
    private QuotasEntity quotasEntity;


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

    //Currencies
    private CurrenciesEntity getCurrenciesEntity(){
        if (currenciesEntity == null){
            currenciesEntity = new CurrenciesEntity(getConnection());
        }
        return currenciesEntity;
    }

    public List<Currency> findAllCurrencies(){
        return getCurrenciesEntity().findAll();
    }

    public Currency findCurrencyById(int id){
        return getCurrenciesEntity().findById(id);
    }

    //Subscriptions
    private SubscriptionsEntity getSubscriptionsEntity(){
        if (subscriptionsEntity == null){
            subscriptionsEntity = new SubscriptionsEntity(getConnection());
        }
        return  subscriptionsEntity;
    }

    public List<Subscription> findAllSubscriptions(){
        return getSubscriptionsEntity().findAll();
    }

    public Subscription findSubscriptionsById(int id){
        return getSubscriptionsEntity().findById(id);
    }

    //Users
    private UsersEntity getUsersEntity(){
        if (usersEntity == null){
            usersEntity = new UsersEntity(getConnection());
        }
        return  usersEntity;
    }

    public List<User> findAllUsers(){
        return getUsersEntity().findAll(getSubscriptionsEntity());
    }
    
    public User findUsersByEmail(String email, String password){
        return getUsersEntity().findByEmail(email, password, getSubscriptionsEntity());
    }
    
    public User findUsersById(int id){
        return getUsersEntity().findById(id, getSubscriptionsEntity());
    }

    public boolean createUser(User user){
        return getUsersEntity().add(user);
    }

    //Incomes
    private IncomesEntity getIncomesEntity(){
        if (incomesEntity == null){
            incomesEntity = new IncomesEntity(getConnection());
        }
        return  incomesEntity;
    }

    public List<Income> findAllIncomes(){
        return getIncomesEntity().findAll(getUsersEntity(),getSubscriptionsEntity(),getCurrenciesEntity());
    }

    public Income findIncomesById(int id){
        return getIncomesEntity().findById(id,getUsersEntity(),getSubscriptionsEntity(),getCurrenciesEntity());
    }

    public boolean createIncome(Income income){
        return getIncomesEntity().add(income);
    }

    public boolean deleteIncome(Income income){
        return getIncomesEntity().delete(income);
    }

    //Expenses

    private ExpensesEntity getExpensesEntity(){
        if(expensesEntity == null){
            expensesEntity = new ExpensesEntity(getConnection());
        }
        return expensesEntity;
    }

    public List<Expense> findAllExpenses(){
        return  getExpensesEntity().findAll(getUsersEntity(),getSubscriptionsEntity(),getExpensesCategoryEntity(),getCurrenciesEntity());
    }

    public boolean createExpense(Expense expense){
        return getExpensesEntity().add(expense);
    }

    // Expense Categories
    private ExpensesCategoryEntity getExpensesCategoryEntity(){
        if(expensesCategoryEntity == null){
            expensesCategoryEntity = new ExpensesCategoryEntity(getConnection());
        }
        return expensesCategoryEntity;
    }

    public List<ExpensesCategory> findAllExpenseCategories() {
        return getExpensesCategoryEntity().findAll();
    }

    public ExpensesCategory findExpenseCategoriesById(int id){
        return  getExpensesCategoryEntity().findById(id);
    }

    public boolean createExpenseCategory(ExpensesCategory expensesCategory){
        return getExpensesCategoryEntity().add(expensesCategory);
    }

    // Debts

    private DebtsEntity getDebtsEntity(){
        if(debtsEntity == null){
            debtsEntity = new DebtsEntity(getConnection());
        }
        return debtsEntity;
    }

    public Debt findDebtsById(int id){
        return getDebtsEntity().findById(id, getUsersEntity(), getSubscriptionsEntity(), getExpensesCategoryEntity(), getCurrenciesEntity(), getPeriodsEntity());
    }

    public boolean createDebt(Debt debt){return getDebtsEntity().add(debt);}

    public List<Debt> findAllDebts(){
        return  getDebtsEntity().findAll(getUsersEntity(),getSubscriptionsEntity(),getExpensesCategoryEntity(),getCurrenciesEntity(), getPeriodsEntity());
    }


    //Quotes
    private QuotasEntity getQuotasEntity(){
        if(quotasEntity == null){
            quotasEntity = new QuotasEntity(getConnection());
        }
        return quotasEntity;
    }

    public Quota findQuotaById(int id){
        return getQuotasEntity().findById(id, getDebtsEntity(), getUsersEntity(), getSubscriptionsEntity(), getExpensesCategoryEntity(), getCurrenciesEntity(), getPeriodsEntity());
    }

    public boolean createQuota(Quota quota){
        return getQuotasEntity().add(quota);
    }




    // Periods
    private PeriodsEntity getPeriodsEntity(){
        if(periodsEntity == null){
            periodsEntity = new PeriodsEntity(getConnection());
        }
        return periodsEntity;
    }

    public List<Period> findAllPeriods(){
        return getPeriodsEntity().findAll();
    }

    public Period findPeriodById(int id){
        return getPeriodsEntity().findById(id);
    }


}
