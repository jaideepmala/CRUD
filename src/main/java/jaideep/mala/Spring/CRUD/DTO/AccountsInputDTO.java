package jaideep.mala.Spring.CRUD.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountsInputDTO {

    @JsonProperty("customer_name")
    private String customerName;

    @JsonProperty("email")
    private String email;

    @JsonProperty("authorised_limit")
    private int authLimit;

    public AccountsInputDTO() {
    }

    public AccountsInputDTO(String customerName, String email, int authLimit) {
        this.customerName = customerName;
        this.email = email;
        this.authLimit = authLimit;
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

    public int getAuthLimit() {
        return authLimit;
    }

    public void setAuthLimit(int authLimit) {
        this.authLimit = authLimit;
    }

    @Override
    public String toString() {
        return "AccountsInputDTO{" +
                "customerName='" + customerName + '\'' +
                ", email='" + email + '\'' +
                ", authLimit=" + authLimit +
                '}';
    }
}
