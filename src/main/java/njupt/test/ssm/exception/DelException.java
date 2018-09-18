package njupt.test.ssm.exception;


public class DelException extends RuntimeException{

    /**
     * 调用父类方法
     * @param message
     */
    public DelException(String message) {
        super(message);
    }

    public DelException(String message, Throwable cause) {
        super(message, cause);
    }
}
