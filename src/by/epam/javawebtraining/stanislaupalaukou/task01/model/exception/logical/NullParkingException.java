package by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical;

/**
 * @author Stanislau Palaukou on 10.03.2019
 * @project Task 01
 */

public class NullParkingException extends LogicalException {
    public NullParkingException() {
        super();
    }

    public NullParkingException(String message) {
        super(message);
    }

    public NullParkingException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullParkingException(Throwable cause) {
        super(cause);
    }

    protected NullParkingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
