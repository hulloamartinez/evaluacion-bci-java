package cl.hulloa.evaluation.exception;

public class CallApiException extends RuntimeException{
    private String code;

    public CallApiException(String message, String code) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
