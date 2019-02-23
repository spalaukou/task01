package by.epam.javawebtraining.stanislaupalaukou.task01.model.exception;

/**
 * @author Stanislau Palaukou on 23.02.2019
 * @project Task 01
 */

public class VehicleNotFoundException extends Exception {

    public VehicleNotFoundException() {
        super();
    }

    public VehicleNotFoundException(String message) {
        super(message);
    }

    public VehicleNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public VehicleNotFoundException(Throwable cause) {
        super(cause);
    }

    protected VehicleNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}