package by.epam.javawebtraining.stanislaupalaukou.task01.util.creator;

import by.epam.javawebtraining.stanislaupalaukou.task01.view.ConsolePrinter;
import by.epam.javawebtraining.stanislaupalaukou.task01.view.FilePrinter;
import by.epam.javawebtraining.stanislaupalaukou.task01.view.Printable;
import by.epam.javawebtraining.stanislaupalaukou.task01.view.PrinterType;
import org.apache.log4j.Logger;

/**
 * The util class creates Printer by
 * the Printer Type, which is received as param
 * in included method.
 *
 * @see PrinterType
 *
 * @author Stanislau Palaukou on 18.02.2019
 * @project Task 01
 */

public class PrinterCreator {

  private static final Logger logger = Logger.getLogger(PrinterCreator.class);

  public static Printable create(PrinterType printerType) {
    Printable printer = null;

    switch (printerType) {
      case FILE:
        printer = new FilePrinter();
        break;
      case CONSOLE:
      default:
        printer = new ConsolePrinter();
        break;
    }
    logger.info("Printer has been created.");
    return printer;
  }
}
