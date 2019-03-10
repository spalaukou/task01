package by.epam.javawebtraining.stanislaupalaukou.task01.util.validator;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.ParkingIsEmptyException;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.technical.DataValidatorException;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * The util class validates Strings by RegEx
 * and adds validated Strings to List.
 *
 * @author Stanislau Palaukou on 19.02.2019
 * @project Task 01
 */

public class DataValidator {

    private static final Logger logger = Logger.getLogger(DataValidator.class);

    public final String DIGIT_PATTERN = "(\\s*\\w+\\s*){5}";

    private static List<String> validLines = new ArrayList<>();

    public List<String> validateStrings(List<String> originalLines) {
        try {
            if (originalLines != null) {
                for (String originalString : originalLines) {
                    if (originalString.matches(DIGIT_PATTERN)) {
                        validLines.add(originalString);
                    }
                }
                logger.info("Lines were checked.");
            } else {
                logger.info("DataValidatorException has been thrown.");
                throw new DataValidatorException("Strings for validation has not been found");
            }
        } catch (DataValidatorException e) {
            logger.info("Exception has been caught", e);
            e.printStackTrace();
        }
        return validLines;
    }

}
