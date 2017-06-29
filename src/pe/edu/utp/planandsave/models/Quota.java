package pe.edu.utp.planandsave.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by usuario on 27/06/2017.
 */
public class Quota {
    private int id;
    private int number;
    private Date paymentDate;
    private float amount;
    private Debt debt;

    public Quota(){
    }
    public Quota(int id, int number, Date paymentDate,float amount, Debt debt) {
        this.setId(id);
        this.setNumber(number);
        this.setPaymentDate(paymentDate);
        this.setAmount(amount);
        this.setDebt(debt);
    }

    public int getId() { return id;  }

    public String getIdAsString() {return String.valueOf(getId());}

    public Quota setId(int id) {
        this.id = id;
        return this;
    }

    public int getNumber() { return number;}

    public String getNumberAsString() { return String.valueOf(getId());}

    public Quota setNumber(int number) {
        this.number = number;
        return this;
    }

    public Date getPaymentDate() { return paymentDate; }

    public String getPaymentDateAsValue() { return "'" + getPaymentDate() + "'";}

    public Quota setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
        return this;
    }

    public float getAmount() { return amount; }

    public String getAmountAsString() {return String.valueOf(getAmount());}

    public Quota setAmount(float amount) {
        this.amount = amount;
        return this;
    }

    public Debt getDebt() { return debt;}

    public String getDebtAsString() {return String.valueOf(getDebt());}

    public Quota setDebt(Debt debt) {
        this.debt = debt;
        return this;
    }

    public static Quota build(ResultSet resultSet, DebtsEntity debtsEntity, UsersEntity usersEntity, SubscriptionsEntity subscriptionsEntity,
                              ExpensesCategoryEntity expensesCategoryEntity, CurrenciesEntity currenciesEntity ){
        try {
            return (new Quota())
                    .setId(resultSet.getInt("id"))
                    .setNumber(resultSet.getInt("number"))
                    .setPaymentDate(resultSet.getDate("payment_date"))
                    .setAmount(resultSet.getFloat("amount"))
                    .setDebt(debtsEntity.findById(resultSet.getInt("debt_id"), usersEntity,
                            subscriptionsEntity, expensesCategoryEntity, currenciesEntity));

        } catch (SQLException e) {
            e.printStackTrace();

        }

        return null;
    }


}