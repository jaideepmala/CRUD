package jaideep.mala.Spring.CRUD.DTO;


public class OutputDTO {

    private String message;
    private Long accNum;


    public OutputDTO() {
    }

    public OutputDTO(String message, Long accNum) {
        this.message = message;
        this.accNum = accNum;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getAccNum() {
        return accNum;
    }

    public void setAccNum(Long accNum) {
        this.accNum = accNum;
    }

    @Override
    public String toString() {
        return "ResponseDTO{" +
                "message='" + message + '\'' +
                ", accNum=" + accNum +
                '}';
    }
}
