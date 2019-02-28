package by.epam.javawebtraining.stanislaupalaukou.task01.model.factory;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Car;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Truck;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Vehicle;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.VehicleType;

/**
 * The Vehicle Factory class implements a Factory Design Pattern
 * (one of the Creational Design Patterns) and creates
 * various types of Vehicles.
 *
 * @author Stanislau Palaukou on 19.02.2019
 * @project Task 01
 */

public class VehicleFactory {

    /**
     * Method receives list of parameters and returns vehicle
     * object appropriate type.
     *
     * @param type
     * @param name
     * @param price
     * @param localField
     * @param bodyTypeString
     * @return
     */
    public static Vehicle createVehicle(VehicleType type, String name, int price, int localField, String bodyTypeString) {
        Vehicle toReturn = null;
        switch (type) {
            case CAR:
                for (Car.BodyType bodyType : Car.BodyType.values()) {
                    if(bodyTypeString.toUpperCase().equals(bodyType.name())) {
                        toReturn = new Car(name, price, localField, bodyType);
                    }
                }
            case TRUCK:
                for (Truck.BodyType bodyType : Truck.BodyType.values()) {
                    if(bodyTypeString.toUpperCase().equals(bodyType.name())) {
                        toReturn = new Truck(name, price, localField, bodyType);
                    }
                }
            default:
        }
        return toReturn;
    }
}
