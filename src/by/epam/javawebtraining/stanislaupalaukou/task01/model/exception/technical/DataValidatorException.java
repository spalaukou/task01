package by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.technical;

/**
 * @author Stanislau Palaukou on 10.03.2019
 * @project Task 01
 */

public class DataValidatorException extends TechnicalException {
    public DataValidatorException() {
        super();
    }

    public DataValidatorException(String message) {
        super(message);
    }

    public DataValidatorException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataValidatorException(Throwable cause) {
        super(cause);
    }

    protected DataValidatorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
