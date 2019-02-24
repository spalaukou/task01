package by.epam.javawebtraining.stanislaupalaukou.task01.util;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Stanislau Palaukou on 19.02.2019
 * @project Task 01
 */

public class DataValidator {

    private static final Logger logger = Logger.getLogger(DataValidator.class);

    public final String DIGIT_PATTERN = "(\\s*\\w+\\s*){5}";

    private static List<String> validLines = new ArrayList<>();

    public List<String> validateStrings(List<String> originalLines) {
        for (String originalString : originalLines) {
            if (originalString.matches(DIGIT_PATTERN)) {
                validLines.add(originalString);
            }
        }
        logger.info("Lines were checked.");
        return validLines;
    }

}
