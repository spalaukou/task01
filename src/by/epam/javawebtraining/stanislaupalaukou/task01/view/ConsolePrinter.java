package by.epam.javawebtraining.stanislaupalaukou.task01.view;

/**
 * @author Stanislau Palaukou on 17.02.2019
 * @project Task 01
 */

public class ConsolePrinter implements Printable{

    @Override
    public void print(Object o) {
        if(o == null) {
            return;
        }
        System.out.println(o);
    }
}
