package by.epam.javawebtraining.stanislaupalaukou.task01.util;

/**
 * @author Stanislau Palaukou on 19.02.2019
 * @project Task 01
 */

public class ArrayCreator {

  public static final String DIGIT_PATTERN = "((\\s*)+)*,((\\s)+)*";

  public static String[] stringSplit(String originalString) {
    return originalString.split(DIGIT_PATTERN);
  }
}
