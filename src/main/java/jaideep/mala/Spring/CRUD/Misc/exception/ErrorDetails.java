package jaideep.mala.Spring.CRUD.Misc.exception;

public class ErrorDetails {
    private String message;
    private int errorCode;

    public ErrorDetails(String message, int errorCode) {
        super();
        this.message = message;
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String toString() {
        return "ErrorDetails{" +
                "message='" + message + '\'' +
                ", errorCode='" + errorCode + '\'' +
                '}';
    }
}
