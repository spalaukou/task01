package by.epam.javawebtraining.stanislaupalaukou.task01.view;

import java.io.FileWriter;
import java.io.IOException;

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
        if (o == null){
            return;
        }
        try (FileWriter fileWriter = new FileWriter("output/outputData.txt", true)){
            fileWriter.write(o.toString() + '\n');
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
