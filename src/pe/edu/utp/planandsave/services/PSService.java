package pe.edu.utp.planandsave.services;

import pe.edu.utp.planandsave.models.ExpensesCategory;
import pe.edu.utp.planandsave.models.Currency;
import pe.edu.utp.planandsave.models.PSDataStore;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by usuario on 16/06/2017.
 */
public class PSService {
    Connection connection;
    PSDataStore dataStore;

    public PSService(InitialContext ctx) {
        try {
            connection = ((DataSource) ctx.lookup("jdbc/MySQLPSDataSource")).getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public PSService() {
        try {
            InitialContext ctx = new InitialContext();
            connection = ((DataSource) ctx.lookup("jdbc/MySQLPSDataSource")).getConnection();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection() {
        return connection;
    }

    private PSDataStore getDataStore(){
        if (dataStore == null){
            dataStore = new PSDataStore(getConnection());
        }
        return dataStore;
    }

    public List<Currency> getCurrencies(){
        return getDataStore().findAllCurrencies();
    }

    /*--------------------------------------------------------------*/

    public List<ExpensesCategory> getExpenseCategories() {
        return getDataStore().findAllExpenseCategories();
    }

    public boolean createExpenseCategory(ExpensesCategory expensesCategory){
        return getDataStore().createExpenseCategory(expensesCategory);
    }



    /*
    public List<Region> getRegions() {
        return getDataStore().findAllRegions();
    }
     */
}
