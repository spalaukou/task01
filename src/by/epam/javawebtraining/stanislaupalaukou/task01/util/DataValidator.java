package by.epam.javawebtraining.stanislaupalaukou.task01.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Stanislau Palaukou on 19.02.2019
 * @project Task 01
 */

public class DataValidator {
  public final String DIGIT_PATTERN = "(car|truck)(,\\s*\\w+)+";
  static List<String> validLines = new ArrayList<>();

  public List<String> validateStrings(List<String> originalLines) {
    for(String originalString : originalLines) {
      if(originalString.matches(DIGIT_PATTERN)) {
        String[] line = ArrayCreator.stringSplit(originalString);
        validLines.add(originalString);
      }
    }
    return validLines;
  }
}
