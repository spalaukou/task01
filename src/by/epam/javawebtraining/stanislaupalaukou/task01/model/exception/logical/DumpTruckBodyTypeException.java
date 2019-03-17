package by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical;

/**
 * @author Stanislau Palaukou on 17.03.2019
 * @project Task 01
 */

public class DumpTruckBodyTypeException extends LogicalException {
    public DumpTruckBodyTypeException() {
        super();
    }

    public DumpTruckBodyTypeException(String message) {
        super(message);
    }

    public DumpTruckBodyTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public DumpTruckBodyTypeException(Throwable cause) {
        super(cause);
    }

    protected DumpTruckBodyTypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
