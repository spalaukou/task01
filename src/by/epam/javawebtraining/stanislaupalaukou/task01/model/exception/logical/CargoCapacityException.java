package by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical;

/**
 * @author Stanislau Palaukou on 10.03.2019
 * @project Task 01
 */

public class CargoCapacityException extends LogicalException {
    public CargoCapacityException() {
        super();
    }

    public CargoCapacityException(String message) {
        super(message);
    }

    public CargoCapacityException(String message, Throwable cause) {
        super(message, cause);
    }

    public CargoCapacityException(Throwable cause) {
        super(cause);
    }

    protected CargoCapacityException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
