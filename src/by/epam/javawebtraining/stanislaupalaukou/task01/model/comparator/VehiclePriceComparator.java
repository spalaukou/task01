package by.epam.javawebtraining.stanislaupalaukou.task01.model.comparator;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Vehicle;

import java.util.Comparator;

/**
 *The comparator class implements Comparator
 * and compare two vehicles by their price.
 *
 * @author Stanislau Palaukou on 19.02.2019
 * @project Task 01
 */

public class VehiclePriceComparator implements Comparator<Vehicle> {

    @Override
    public int compare(Vehicle o1, Vehicle o2) {
        return o1.getPrice() - o2.getPrice();
    }
}
