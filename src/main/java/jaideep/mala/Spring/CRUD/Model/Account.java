package jaideep.mala.Spring.CRUD.Model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Account")
public class Account {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long acc_no;
    @Column(name ="customer_name", nullable = false)
    private String customerName;
    @Column(name="email")
    private String email;
    @Column(name = "authorized_limit")
    private long authLimit;
    @Column(name = "available_limit")
    private long availLimit;
    @Column(name = "created_date")
    private Timestamp createdDate;
    @Column(name = "updated_date")
    private Timestamp updatedDate;

    public Account() {
    }

    public Account(String customerName, String email, long authLimit, long availLimit, Timestamp createdDate,
                   Timestamp updatedDate) {
        this.customerName = customerName;
        this.email = email;
        this.authLimit = authLimit;
        this.availLimit = availLimit;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public long getAcc_no() {
        return acc_no;
    }

    public void setAcc_no(long acc_no) {
        this.acc_no = acc_no;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getAuthLimit() {
        return authLimit;
    }

    public void setAuthLimit(long authLimit) {
        this.authLimit = authLimit;
    }

    public long getAvailLimit() {
        return availLimit;
    }

    public void setAvailLimit(long availLimit) {
        this.availLimit = availLimit;
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
        return "Account{" +
                "acc_no=" + acc_no +
                ", customerName='" + customerName + '\'' +
                ", email='" + email + '\'' +
                ", authLimit=" + authLimit +
                ", availLimit=" + availLimit +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                '}';
    }
}
