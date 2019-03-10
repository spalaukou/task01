package by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.ParkingTaskException;

/**
 * The class describes conditions of logical task exceptions
 * that a reasonable application might want to catch.
 *
 * @author Stanislau Palaukou on 10.03.2019
 * @project Task 01
 */

public class LogicalException extends ParkingTaskException {
    public LogicalException() {
        super();
    }

    public LogicalException(String message) {
        super(message);
    }

    public LogicalException(String message, Throwable cause) {
        super(message, cause);
    }

    public LogicalException(Throwable cause) {
        super(cause);
    }

    protected LogicalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
