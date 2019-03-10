package by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical;

/**
 * @author Stanislau Palaukou on 10.03.2019
 * @project Task 01
 */

public class VehiclePriceException extends LogicalException {
    public VehiclePriceException() {
        super();
    }

    public VehiclePriceException(String message) {
        super(message);
    }

    public VehiclePriceException(String message, Throwable cause) {
        super(message, cause);
    }

    public VehiclePriceException(Throwable cause) {
        super(cause);
    }

    protected VehiclePriceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
