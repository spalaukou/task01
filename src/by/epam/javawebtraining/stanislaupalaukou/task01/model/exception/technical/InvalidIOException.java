package by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.technical;

/**
 * @author Stanislau Palaukou on 10.03.2019
 * @project Task 01
 */

public class InvalidIOException extends TechnicalException {
    public InvalidIOException() {
        super();
    }

    public InvalidIOException(String message) {
        super(message);
    }

    public InvalidIOException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidIOException(Throwable cause) {
        super(cause);
    }

    protected InvalidIOException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
