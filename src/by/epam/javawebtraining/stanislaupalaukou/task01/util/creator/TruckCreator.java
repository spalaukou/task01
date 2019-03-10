package by.epam.javawebtraining.stanislaupalaukou.task01.util.creator;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Truck;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.CargoCapacityException;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.TruckBodyTypeException;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.VehicleNameException;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.VehiclePriceException;

/**
 * The util class creates Truck.
 *
 * @author Stanislau Palaukou on 10.03.2019
 * @project Task 01
 */

public abstract class TruckCreator {

    public static Truck create() {
        return new Truck();
    }

    public static Truck create(String name, int price, int seatsNumber, Truck.BodyType bodyType)
            throws TruckBodyTypeException, VehiclePriceException, CargoCapacityException, VehicleNameException {

        return new Truck(name, price, seatsNumber, bodyType);
    }
}
