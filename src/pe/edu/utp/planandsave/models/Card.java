package pe.edu.utp.planandsave.models;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by usuario on 27/06/2017.
 */
public class Card {
    private  int id;
    private  int number;
    private User user;
    private CardsType cardsType;

    public Card(){
    }

    public Card(int id, int number, User user, CardsType cardsType){
        this.setId(id);
        this.setNumber(number);
        this.setUser(user);
        this.setCardsType(cardsType);
    }

    public int getId() {return id;}

    public String getIdAsString(){ return String.valueOf(getId());
    }

    public Card setId(int id) {
        this.id = id;
        return this;
    }

    public int getNumber() {return number;}

    public String getNumberAsString(){return String.valueOf(getNumber());
    }

    public Card setNumber(int number) {
        this.number = number;
        return this;
    }

    public User getUser() {return user;}

    public  String getUserAsString(){return String.valueOf(getUser());}

    public Card setUser(User user) {
        this.user = user;
        return this;
    }

    public CardsType getCardsType() {return cardsType;}

    public String getCardsTypeAsString(){ return String.valueOf(getCardsType());}

    public Card setCardsType(CardsType cardsType) {
        this.cardsType = cardsType;
        return this;
    }

    public  static Card build(ResultSet resultSet, CardTypesEntity cardTypesEntity,
                              UsersEntity usersEntity, SubscriptionsEntity subscriptionsEntity){
        try {
            return  (new Card())
                    .setId(resultSet.getInt("id"))
                    .setNumber(resultSet.getInt("number"))
                    .setUser(usersEntity.findById(resultSet.getInt("user_id"), subscriptionsEntity))
                    .setCardsType(cardTypesEntity.findById(resultSet.getInt("card_type_id")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
