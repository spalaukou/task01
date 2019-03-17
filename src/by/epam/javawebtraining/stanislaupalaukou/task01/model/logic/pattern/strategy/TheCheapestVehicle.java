package by.epam.javawebtraining.stanislaupalaukou.task01.model.logic.pattern.strategy;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Vehicle;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.NullParkingException;

/**
 * @author Stanislau Palaukou on 12.03.2019
 * @project Task 01
 */

public class TheCheapestVehicle implements FindingBehavior {

    @Override
    public Vehicle find(Vehicle[] vehicles) throws NullParkingException {
        if (vehicles != null) {

            Vehicle theCheapest = null;
            if (vehicles.length != 0) {
                theCheapest = vehicles[0];
                for (int i = 0; i < vehicles.length; i++) {
                    if (vehicles[i].getPrice() < theCheapest.getPrice()) {
                        theCheapest = vehicles[i];
                    }
                }
            }
            return theCheapest;

        } else {
            throw new NullParkingException();
        }
    }
}
