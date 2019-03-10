package by.epam.javawebtraining.stanislaupalaukou.task01.util.reader;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.technical.InvalidFilePathException;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.technical.InvalidIOException;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.technical.TechnicalException;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The util class reads *.txt file and adds
 * read lines to List.
 *
 * @author Stanislau Palaukou on 19.02.2019
 * @project Task 01
 */

public class DataReader {

    private static final Logger logger = Logger.getLogger(DataReader.class);

    private final static String SEPARATOR = File.separator;
    private final static String path = "input" + SEPARATOR + "inputDat.txt";
    private static List<String> linesArray = new ArrayList<>();

    public List<String> readFileStrings() throws TechnicalException {

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String currentLine;
            while ((currentLine = br.readLine()) != null) {
                linesArray.add(currentLine.trim());
            }
            logger.info("File has been read.");
        } catch (FileNotFoundException e) {
            logger.warn("File not found exception.", e);
            System.out.println("File not found exception." + e);
            throw new InvalidFilePathException(e);
        } catch (IOException e) {
            logger.warn("General I/O exception.", e);
            System.out.println("General I/O exception." + e);
            throw new InvalidIOException(e);
        }

        return linesArray;
    }
}
