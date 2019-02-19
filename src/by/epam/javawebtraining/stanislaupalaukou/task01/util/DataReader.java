package by.epam.javawebtraining.stanislaupalaukou.task01.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Stanislau Palaukou on 19.02.2019
 * @project Task 01
 */

public class DataReader {
  private final static String SEPARATOR = File.separator;
  private final static String path = "input" + SEPARATOR + "inputData.txt";
  private static List<String> linesArray = new ArrayList<>();

  public List<String> readFileStrings() throws FileNotFoundException {
    try (BufferedReader br = new BufferedReader(new FileReader(path))) {
      String currentLine;
      while ((currentLine = br.readLine()) != null) {
        String trimmedLine = currentLine.trim();
        linesArray.add(trimmedLine);
      }
    } catch (FileNotFoundException e) {
      System.out.println("File not found exception." + e);
    } catch (IOException e) {
      System.out.println("General I/O exception." + e);
    }
    return linesArray;
  }
}
