package jaideep.mala.Spring.CRUD.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransactionInputDTO {
    @JsonProperty("acc_no")
    private long acc_no;

    @JsonProperty("amount")
    private long amount;

    @JsonProperty("description")
    private String description;

    public TransactionInputDTO() {
    }

    public TransactionInputDTO(long acc_no, long amount, String description) {
        this.acc_no = acc_no;
        this.amount = amount;
        this.description = description;
    }

    public long getAcc_no() {
        return acc_no;
    }

    public void setAcc_no(long acc_no) {
        this.acc_no = acc_no;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "DebitInputDTO{" +
                "acc_no=" + acc_no +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                '}';
    }
}
