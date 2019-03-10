package by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical;

/**
 * @author Stanislau Palaukou on 10.03.2019
 * @project Task 01
 */

public class NullVehicleException extends LogicalException {
    public NullVehicleException() {
        super();
    }

    public NullVehicleException(String message) {
        super(message);
    }

    public NullVehicleException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullVehicleException(Throwable cause) {
        super(cause);
    }

    protected NullVehicleException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
