package jaideep.mala.Spring.CRUD.Model;

import jaideep.mala.Spring.CRUD.Misc.StatusType;
import jaideep.mala.Spring.CRUD.Misc.TransactionType;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "statement")
public class Statement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long statId;
    @Column(name = "acc_no")
    private long accNum;
    @Column(name = "amount")
    private long amount;
    @Column(name = "type")
    private TransactionType transactionType;
    @Column(name = "status")
    private StatusType status;
    @Column(name = "created_date")
    private Timestamp createdDate;
    @Column(name = "updated_date")
    private Timestamp updatedDate;

    public Statement() {
    }

    public Statement(long accNum, long amount, TransactionType transactionType, StatusType status, Timestamp createdDate, Timestamp updatedDate) {
        this.accNum = accNum;
        this.amount = amount;
        this.transactionType = transactionType;
        this.status = status;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public long getStatId() {
        return statId;
    }

    public void setStatId(long statId) {
        this.statId = statId;
    }

    public long getAccNum() {
        return accNum;
    }

    public void setAccNum(long accNum) {
        this.accNum = accNum;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public StatusType getStatus() {
        return status;
    }

    public void setStatus(StatusType status) {
        this.status = status;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Timestamp getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Timestamp updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public String toString() {
        return "Statement{" +
                "statId=" + statId +
                ", accNum=" + accNum +
                ", amount=" + amount +
                ", transactionType=" + transactionType +
                ", status='" + status + '\'' +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                '}';
    }
}
