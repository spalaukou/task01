package by.epam.javawebtraining.stanislaupalaukou.task01.model.exception;

/**
 * The class describes conditions of task exceptions
 * that a reasonable application might want to catch.
 *
 * @author Stanislau Palaukou on 04.03.2019
 * @project Task 01
 */

public class TaskException extends Exception {
  public TaskException() {
    super();
  }

  public TaskException(String message) {
    super(message);
  }

  public TaskException(String message, Throwable cause) {
    super(message, cause);
  }

  public TaskException(Throwable cause) {
    super(cause);
  }

  protected TaskException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
