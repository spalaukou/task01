package by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical;

/**
 * @author Stanislau Palaukou on 17.03.2019
 * @project Task 01
 */

public class BusBodyTypeException extends LogicalException {
    public BusBodyTypeException() {
        super();
    }

    public BusBodyTypeException(String message) {
        super(message);
    }

    public BusBodyTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusBodyTypeException(Throwable cause) {
        super(cause);
    }

    protected BusBodyTypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
