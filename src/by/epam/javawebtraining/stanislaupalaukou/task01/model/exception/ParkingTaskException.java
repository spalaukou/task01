package by.epam.javawebtraining.stanislaupalaukou.task01.model.exception;

/**
 * The class describes conditions of task exceptions
 * that a reasonable application might want to catch.
 *
 * @author Stanislau Palaukou on 04.03.2019
 * @project Task 01
 */

public class ParkingTaskException extends Exception {
  public ParkingTaskException() {
    super();
  }

  public ParkingTaskException(String message) {
    super(message);
  }

  public ParkingTaskException(String message, Throwable cause) {
    super(message, cause);
  }

  public ParkingTaskException(Throwable cause) {
    super(cause);
  }

  protected ParkingTaskException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
