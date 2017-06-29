package pe.edu.utp.planandsave.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by usuario on 27/06/2017.
 */
public class CardsEntity extends BaseEntity{
    public CardsEntity(Connection connection){ super(connection, "cards");}

    public CardsEntity() {super();}

    List<Card> findAll(UsersEntity usersEntity, SubscriptionsEntity subscriptionsEntity, CardTypesEntity cardTypesEntity){
        return  findByCriteria("",usersEntity, subscriptionsEntity , cardTypesEntity);
    }

    public Card findById(int id, UsersEntity usersEntity, SubscriptionsEntity subscriptionsEntity,
                         CardTypesEntity cardTypesEntity ){
        String criteria =" id= "+id;
        return findByCriteria( criteria, usersEntity, subscriptionsEntity, cardTypesEntity).get(0);
    }

    public List<Card> findByCriteria(String criteria, UsersEntity usersEntity, SubscriptionsEntity subscriptionsEntity,
                                        CardTypesEntity cardTypesEntity) {
        String sql = getDefaultQuery() + (criteria.isEmpty() ? "" : " WHERE " + criteria);
        List<Card> cards = new ArrayList<>();
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
            if (resultSet == null) return null;
            while (resultSet.next()) {
                cards.add(Card.build(resultSet,cardTypesEntity,usersEntity,subscriptionsEntity));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cards;
    }

}
