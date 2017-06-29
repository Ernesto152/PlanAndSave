package pe.edu.utp.planandsave.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by usuario on 27/06/2017.
 */
public class CardTypesEntity extends BaseEntity{
    public CardTypesEntity(Connection connection){ super(connection, "cards_type");
    }
    public CardTypesEntity(){}

    List<CardsType> findAll(){return findByCriteria("");}

    public CardsType findById(int id){
        String criteria= "id="+String.valueOf(id);
        return findByCriteria(criteria).get(0);
    }

    public List<CardsType> findByCriteria(String criteria){
        String sql=getDefaultQuery()+(criteria.equalsIgnoreCase("") ?"":"WHERE"+criteria);
        List<CardsType> cardsTypes = new ArrayList<>();
        try{
            ResultSet resultSet =getConnection().createStatement().executeQuery(sql);
            if (resultSet==null) return  null;
            while (resultSet.next()){
                cardsTypes.add(CardsType.build(resultSet));
            }
            return cardsTypes;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
