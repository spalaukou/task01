package by.epam.javawebtraining.stanislaupalaukou.task01.util;

import by.epam.javawebtraining.stanislaupalaukou.task01.view.ConsolePrinter;
import by.epam.javawebtraining.stanislaupalaukou.task01.view.FilePrinter;
import by.epam.javawebtraining.stanislaupalaukou.task01.view.Printable;
import by.epam.javawebtraining.stanislaupalaukou.task01.view.PrinterType;

/**
 * @author Stanislau Palaukou on 18.02.2019
 * @project Task 01
 */

public class PrinterCreator {
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

    return printer;
  }
}
