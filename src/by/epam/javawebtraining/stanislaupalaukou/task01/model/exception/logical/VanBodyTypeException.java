package by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical;

/**
 * @author Stanislau Palaukou on 17.03.2019
 * @project Task 01
 */

public class VanBodyTypeException extends LogicalException {
    public VanBodyTypeException() {
        super();
    }

    public VanBodyTypeException(String message) {
        super(message);
    }

    public VanBodyTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public VanBodyTypeException(Throwable cause) {
        super(cause);
    }

    protected VanBodyTypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
