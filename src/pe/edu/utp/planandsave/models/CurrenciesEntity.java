package pe.edu.utp.planandsave.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Abraham on 17/06/2017.
 */
public class CurrenciesEntity extends BaseEntity {

    public CurrenciesEntity(Connection connection) {
        super(connection, "currencies");
    }

    public CurrenciesEntity() {
    }

    List<Currency> findAll() {
        return findByCriteria("");
    }

    public Currency findById(int id) {
        String criteria = " id = " + String.valueOf(id);
        return findByCriteria(criteria).get(0);
    }

    public List<Currency> findByCriteria(String criteria) {
        //String sql = getDefaultQuery() + criteria == "" ? "" : " WHERE " + criteria;
        String sql = getDefaultQuery() +
                (criteria.equalsIgnoreCase("") ? "" : " WHERE " + criteria);
        List<Currency> currencies = new ArrayList<>();
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
            if (resultSet == null) return null;
            while (resultSet.next()) {
                currencies.add(Currency.build(resultSet));
            }
            return currencies;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
    public List<Region> findByCriteria(String criteria) {
        String sql = getDefaultQuery() +
                (criteria.equalsIgnoreCase("") ? "" : " WHERE " + criteria);
        List<Region> regions = new ArrayList<>();
        try {
            ResultSet resultSet = getConnection()
                    .createStatement()
                    .executeQuery(sql);
            if(resultSet == null) return null;
            while(resultSet.next()) {
                regions.add((new Region())
                        .setId(resultSet.getInt("region_id"))
                        .setName(resultSet.getString("region_name")));
            }
            return regions;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
     */
}
