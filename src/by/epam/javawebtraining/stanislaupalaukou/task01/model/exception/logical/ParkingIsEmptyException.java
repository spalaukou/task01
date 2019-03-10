package by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical;

/**
 * The class describes conditions of empty parking
 * that a reasonable application might want to catch.
 *
 * @author Stanislau Palaukou on 23.02.2019
 * @project Task 01
 */

public class ParkingIsEmptyException extends LogicalException {

    public ParkingIsEmptyException() {
        super();
    }

    public ParkingIsEmptyException(String message) {
        super(message);
    }

    public ParkingIsEmptyException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParkingIsEmptyException(Throwable cause) {
        super(cause);
    }

    protected ParkingIsEmptyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
