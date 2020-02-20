package jaideep.mala.Spring.CRUD.DTO;


public class CreditResponseDTO {

    private String message;
    private Long creditID;


    public CreditResponseDTO() {
    }

    public CreditResponseDTO(String message, Long creditID) {
        this.message = message;
        this.creditID = creditID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getCreditID() {
        return creditID;
    }

    public void setCreditID(Long creditID) {
        this.creditID = creditID;
    }

    @Override
    public String toString() {
        return "CreditResponseDTO{" +
                "message='" + message + '\'' +
                ", creditID=" + creditID +
                '}';
    }
}
