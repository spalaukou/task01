package by.epam.javawebtraining.stanislaupalaukou.task01.util.creator;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Car;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.CarBodyTypeException;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.SeatsNumberException;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.VehicleNameException;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.VehiclePriceException;

/**
 * The util class creates Car.
 *
 * @author Stanislau Palaukou on 10.03.2019
 * @project Task 01
 */

public abstract class CarCreator {

    public static Car create() {
        return new Car();
    }

    public static Car create(String name, int price, int seatsNumber, Car.BodyType bodyType)
            throws SeatsNumberException, VehiclePriceException, VehicleNameException, CarBodyTypeException {

        return new Car(name, price, seatsNumber, bodyType);
    }
}
