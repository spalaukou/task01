package by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical;

/**
 * @author Stanislau Palaukou on 17.03.2019
 * @project Task 01
 */

public class BikeBodyTypeException extends LogicalException {
    public BikeBodyTypeException() {
        super();
    }

    public BikeBodyTypeException(String message) {
        super(message);
    }

    public BikeBodyTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public BikeBodyTypeException(Throwable cause) {
        super(cause);
    }

    protected BikeBodyTypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
