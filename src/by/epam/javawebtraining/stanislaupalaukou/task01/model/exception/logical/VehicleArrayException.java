package by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical;

/**
 * @author Stanislau Palaukou on 10.03.2019
 * @project Task 01
 */

public class VehicleArrayException extends LogicalException {
    public VehicleArrayException() {
        super();
    }

    public VehicleArrayException(String message) {
        super(message);
    }

    public VehicleArrayException(String message, Throwable cause) {
        super(message, cause);
    }

    public VehicleArrayException(Throwable cause) {
        super(cause);
    }

    protected VehicleArrayException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
