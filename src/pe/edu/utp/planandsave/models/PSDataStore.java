package pe.edu.utp.planandsave.models;

import java.sql.Connection;
import java.util.List;

/**
 * Created by usuario on 27/06/2017.
 */
public class PSDataStore {
    private Connection connection;
    private CurrenciesEntity currenciesEntity;

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
}
