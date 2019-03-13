package by.epam.javawebtraining.stanislaupalaukou.task01.view;

/**
 * The view class implements Printable Interface
 * and prints Object (which is received as param in
 * included method) on Console.
 *
 * @see Printable
 *
 * @author Stanislau Palaukou on 17.02.2019
 * @project Task 01
 */

public class ConsolePrinter implements Printable{

    @Override
    public void print(Object o) {
        System.out.println(o);
    }
}
