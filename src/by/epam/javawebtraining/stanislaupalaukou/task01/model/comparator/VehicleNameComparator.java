package by.epam.javawebtraining.stanislaupalaukou.task01.model.comparator;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Vehicle;

import java.util.Comparator;

/**
 * @author Stanislau Palaukou on 09.03.2019
 * @project Task 01
 */

public class VehicleNameComparator implements Comparator<Vehicle> {

    @Override
    public int compare(Vehicle o1, Vehicle o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
