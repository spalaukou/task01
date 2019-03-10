package by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical;

/**
 * @author Stanislau Palaukou on 10.03.2019
 * @project Task 01
 */

public class SeatsNumberException extends LogicalException {
    public SeatsNumberException() {
        super();
    }

    public SeatsNumberException(String message) {
        super(message);
    }

    public SeatsNumberException(String message, Throwable cause) {
        super(message, cause);
    }

    public SeatsNumberException(Throwable cause) {
        super(cause);
    }

    protected SeatsNumberException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
