package by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical;

/**
 * @author Stanislau Palaukou on 10.03.2019
 * @project Task 01
 */

public class TruckBodyTypeException extends LogicalException {
    public TruckBodyTypeException() {
        super();
    }

    public TruckBodyTypeException(String message) {
        super(message);
    }

    public TruckBodyTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public TruckBodyTypeException(Throwable cause) {
        super(cause);
    }

    protected TruckBodyTypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
