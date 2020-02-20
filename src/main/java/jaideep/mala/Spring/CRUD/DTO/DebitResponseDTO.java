package jaideep.mala.Spring.CRUD.DTO;


public class DebitResponseDTO {

    private String message;
    private Long debitID;


    public DebitResponseDTO() {
    }

    public DebitResponseDTO(String message, Long transId) {
        this.message = message;
        this.debitID = transId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getDebitID() {
        return debitID;
    }

    public void setDebitID(Long debitID) {
        this.debitID = debitID;
    }

    @Override
    public String toString() {
        return "DebitResponseDTO{" +
                "message='" + message + '\'' +
                ", debitID=" + debitID +
                '}';
    }
}
