package exceptions;

public class OutOfQuotaException extends Exception{

    public OutOfQuotaException() {
        super("The caller is out of quota");
    }

    public OutOfQuotaException(String message) {
        super(message);
    }
}
