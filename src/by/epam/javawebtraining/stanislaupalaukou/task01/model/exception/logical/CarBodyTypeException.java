package by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical;

/**
 * @author Stanislau Palaukou on 10.03.2019
 * @project Task 01
 */

public class CarBodyTypeException extends LogicalException {
    public CarBodyTypeException() {
        super();
    }

    public CarBodyTypeException(String message) {
        super(message);
    }

    public CarBodyTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public CarBodyTypeException(Throwable cause) {
        super(cause);
    }

    protected CarBodyTypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
