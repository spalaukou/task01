package by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical;

/**
 * @author Stanislau Palaukou on 10.03.2019
 * @project Task 01
 */

public class VehicleTypeException extends LogicalException {
    public VehicleTypeException() {
        super();
    }

    public VehicleTypeException(String message) {
        super(message);
    }

    public VehicleTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public VehicleTypeException(Throwable cause) {
        super(cause);
    }

    protected VehicleTypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
