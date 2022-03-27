package ssq.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;


@ToString
@Getter
@Setter
@Entity(name="transaction")
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="traction_id")
    private Long transactionId;

    private String accountNumber;

    private String type;

    private String amount;

    private String currency;

    private String accountFrom;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getAccountFrom() {
        return accountFrom;
    }

    public void setAccountFrom(String accountFrom) {
        this.accountFrom = accountFrom;
    }

    @Override
    public String toString() {
        return "TransactionObject{" +
                "AccountNum='" + accountNumber + '\'' +
                ", type='" + type + '\'' +
                ", amount='" + amount + '\'' +
                ", currency='" + currency + '\'' +
                ", accountFrom='" + accountFrom + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionEntity that = (TransactionEntity) o;
        return Objects.equals(accountNumber, that.accountNumber) && Objects.equals(type, that.type) && Objects.equals(amount, that.amount) && Objects.equals(currency, that.currency) && Objects.equals(accountFrom, that.accountFrom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, type, amount, currency, accountFrom);
    }
}
