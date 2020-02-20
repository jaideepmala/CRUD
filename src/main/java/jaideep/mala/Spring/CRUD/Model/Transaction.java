package jaideep.mala.Spring.CRUD.Model;

import jaideep.mala.Spring.CRUD.Misc.StatusType;
import jaideep.mala.Spring.CRUD.Misc.TransactionType;

import javax.persistence.*;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "transaction_id")
    private Long trans_id;
    @ManyToOne
    @JoinColumn(name = "acc_no")
    private Account account;
    @Column(name = "transaction_type")
    private TransactionType transactionType;
    @Column(name = "status_type")
    private StatusType statusType;
    @Column(name = "amount")
    private long value;


    public Transaction() {
    }

    public Transaction(Account account, TransactionType transactionType,StatusType statusType, long value) {
        this.account = account;
        this.transactionType = transactionType;
        this.statusType = statusType;
        this.value = value;
    }

    public Long getTrans_id() {
        return trans_id;
    }

    public void setTrans_id(Long trans_id) {
        this.trans_id = trans_id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public StatusType getStatusType() {
        return statusType;
    }

    public void setStatusType(StatusType statusType) {
        this.statusType = statusType;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "trans_id=" + trans_id +
                ", account=" + account +
                ", transactionType=" + transactionType +
                ", statusType=" + statusType +
                ", value=" + value +
                '}';
    }
}

