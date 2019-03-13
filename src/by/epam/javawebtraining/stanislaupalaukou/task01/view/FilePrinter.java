package by.epam.javawebtraining.stanislaupalaukou.task01.view;


import java.io.*;

/**
 * The view class implements Printable Interface
 * and prints Object (which is received as param
 * in included method) in File.
 *
 * @see Printable
 *
 * @author Stanislau Palaukou on 17.02.2019
 * @project Task 01
 */

public class FilePrinter implements Printable {

    @Override
    public void print(Object o) {
        if (o == null) {
            return;
        }

        String fileName = "output/outputData.txt";

        try (Writer bufferedWriter = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(fileName, true)))) {

            bufferedWriter.write(o.toString() + "\n");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
