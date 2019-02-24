package by.epam.javawebtraining.stanislaupalaukou.task01.model.factory;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Car;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Truck;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Vehicle;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.VehicleTypes;

/**
 * @author Stanislau Palaukou on 19.02.2019
 * @project Task 01
 */

public class VehicleFactory {

    public static Vehicle createVehicle(VehicleTypes type, String name, int price, int localField, String bodyTypeString) {
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
