package by.epam.javawebtraining.stanislaupalaukou.task01.util.creator;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.*;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.*;

/**
 * @author Stanislau Palaukou on 17.03.2019
 * @project Task 01
 */

public abstract class VehicleCreator {

    public static Vehicle create(String name, int price, int localField, Object o) throws VehicleTypeException,
            SeatsNumberException, BikeBodyTypeException, VehiclePriceException, VehicleNameException,
            BusBodyTypeException, CarBodyTypeException,
            CargoCapacityException, DumpTruckBodyTypeException, TruckBodyTypeException, VanBodyTypeException {

        if (o != null) {

            Vehicle toReturn = null;

                if (o instanceof Bike.BodyType) {
                    toReturn = new Bike(name, price, localField, (Bike.BodyType) o);
                } else if (o instanceof Bus.BodyType) {
                    toReturn = new Bus(name, price, localField, (Bus.BodyType) o);
                } else if (o instanceof Car.BodyType) {
                    toReturn = new Car(name, price, localField, (Car.BodyType) o);
                } else if (o instanceof DumpTruck.BodyType) {
                    toReturn = new DumpTruck(name, price, localField, (DumpTruck.BodyType) o);
                } else if (o instanceof Truck.BodyType) {
                    toReturn = new Truck(name, price, localField, (Truck.BodyType) o);
                } else if (o instanceof Van.BodyType) {
                    toReturn = new Van(name, price, localField, (Van.BodyType) o);
                }

            return toReturn;
        }
        else {
            throw new VehicleTypeException();
        }
    }
}
