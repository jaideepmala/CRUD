package jaideep.mala.Spring.CRUD.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Id;
import java.sql.Timestamp;

public class AccountsOutputDTO {

    @Id
    @JsonProperty("id")
    private String id;

    @JsonProperty("customername")
    private String customerName;

    @JsonProperty("email")
    private String emailId;

    @JsonProperty("authorisedLimit")
    private int authorizedLimit;

    @JsonProperty("availableLimit")
    private int availableLimit;

    @JsonProperty("createdDate")
    private Timestamp createdDate;

    @JsonProperty("updatedDate")
    private Timestamp updatedDate;

    public AccountsOutputDTO() {
    }

    public AccountsOutputDTO(String id, String customerName, String emailId, int authorizedLimit, int availableLimit,
                             Timestamp createdDate, Timestamp updatedDate) {
        this.id = id;
        this.customerName = customerName;
        this.emailId = emailId;
        this.authorizedLimit = authorizedLimit;
        this.availableLimit = availableLimit;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public int getAuthorizedLimit() {
        return authorizedLimit;
    }

    public void setAuthorizedLimit(int authorizedLimit) {
        this.authorizedLimit = authorizedLimit;
    }

    public int getAvailableLimit() {
        return availableLimit;
    }

    public void setAvailableLimit(int availableLimit) {
        this.availableLimit = availableLimit;
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
        return "Customer{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", emailId='" + emailId + '\'' +
                ", authorizedLimit=" + authorizedLimit +
                ", availableLimit=" + availableLimit +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                '}';
    }


}
