package by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.technical;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.ParkingTaskException;

/**
 * The class describes conditions of technical task exceptions
 * that a reasonable application might want to catch.
 *
 * @author Stanislau Palaukou on 10.03.2019
 * @project Task 01
 */

public class TechnicalException extends ParkingTaskException {
    public TechnicalException() {
        super();
    }

    public TechnicalException(String message) {
        super(message);
    }

    public TechnicalException(String message, Throwable cause) {
        super(message, cause);
    }

    public TechnicalException(Throwable cause) {
        super(cause);
    }

    protected TechnicalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
