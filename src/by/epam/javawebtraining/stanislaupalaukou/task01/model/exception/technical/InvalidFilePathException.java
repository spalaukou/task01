package by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.technical;

/**
 * @author Stanislau Palaukou on 10.03.2019
 * @project Task 01
 */

public class InvalidFilePathException extends TechnicalException {
    public InvalidFilePathException() {
        super();
    }

    public InvalidFilePathException(String message) {
        super(message);
    }

    public InvalidFilePathException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidFilePathException(Throwable cause) {
        super(cause);
    }

    protected InvalidFilePathException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
