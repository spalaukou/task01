package by.epam.javawebtraining.stanislaupalaukou.task01.util;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.container.Parking;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Vehicle;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.VehicleTypes;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.factory.VehicleFactory;

import java.util.List;

/**
 * @author Stanislau Palaukou on 18.02.2019
 * @project Task 01
 */

public class ParkingCreator {

    public static Parking create() {
        return new Parking();
    }

    public static Parking create(Vehicle[] vehicles) {
        return new Parking(vehicles);
    }

    public static Parking create(List<String> validLines) {
        Parking parking = new Parking();
        for (String validString : validLines) {
            String[] splitted = validString.split(" ");
            for(VehicleTypes type : VehicleTypes.values()) {
                if(splitted[0].toUpperCase().equals(type.name())) {
                    parking.addVehicle(VehicleFactory.createVehicle(type, splitted[1], Integer.parseInt(splitted[2])
                            , Integer.parseInt(splitted[3]), splitted[4].toUpperCase()));
                }
            }
        }
        return parking;
    }
}
