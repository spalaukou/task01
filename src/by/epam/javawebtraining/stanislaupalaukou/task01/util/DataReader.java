package by.epam.javawebtraining.stanislaupalaukou.task01.util;

import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Stanislau Palaukou on 19.02.2019
 * @project Task 01
 */

public class DataReader {

    private static final Logger logger = Logger.getLogger(DataReader.class);

    private final static String SEPARATOR = File.separator;
    private final static String path = "input" + SEPARATOR + "inputData.txt";
    private static List<String> linesArray = new ArrayList<>();

    public List<String> readFileStrings() {

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String currentLine;
            while ((currentLine = br.readLine()) != null) {
                linesArray.add(currentLine.trim());
            }
            logger.info("File has been read.");
        } catch (FileNotFoundException e) {
            logger.warn("File not found exception.", e);
            System.out.println("File not found exception." + e);
        } catch (IOException e) {
            logger.warn("General I/O exception.", e);
            System.out.println("General I/O exception." + e);
        }

        return linesArray;
    }
}
