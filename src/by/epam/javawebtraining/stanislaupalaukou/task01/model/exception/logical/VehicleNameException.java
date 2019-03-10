package by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical;

/**
 * @author Stanislau Palaukou on 10.03.2019
 * @project Task 01
 */

public class VehicleNameException extends LogicalException {
    public VehicleNameException() {
        super();
    }

    public VehicleNameException(String message) {
        super(message);
    }

    public VehicleNameException(String message, Throwable cause) {
        super(message, cause);
    }

    public VehicleNameException(Throwable cause) {
        super(cause);
    }

    protected VehicleNameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
