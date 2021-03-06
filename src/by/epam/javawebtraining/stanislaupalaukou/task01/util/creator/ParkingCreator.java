package by.epam.javawebtraining.stanislaupalaukou.task01.util.creator;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.container.AbstractContainer;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.container.ArrayParking;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Vehicle;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.VehicleType;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.*;
import by.epam.javawebtraining.stanislaupalaukou.task01.util.factory.VehicleFactory;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * The util class creates ArrayParking of Vehicles,
 * uses Vehicle Factory.
 *
 * @see
 *
 * @author Stanislau Palaukou on 18.02.2019
 * @project Task 01
 */

public class ParkingCreator {

    private static final Logger logger = Logger.getLogger(ParkingCreator.class);

    public static ArrayParking create() {
        return new ArrayParking();
    }

    public static ArrayParking create(Vehicle[] vehicles) throws VehicleArrayException {
        return new ArrayParking(vehicles);
    }

    public static ArrayParking create(List<String> validLines)
            throws LogicalException {
        
        ArrayParking parking = new ArrayParking();
        for (String validString : validLines) {
            String[] splitted = validString.split(" ");
            for(VehicleType type : VehicleType.values()) {
                if(splitted[0].toUpperCase().equals(type.name())) {
                    parking.addVehicle(VehicleFactory.createVehicle(type, splitted[1], Integer.parseInt(splitted[2])
                            , Integer.parseInt(splitted[3]), splitted[4].toUpperCase()));
                }
            }
        }
        logger.info("ArrayParking has been created.");
        return parking;
    }
}
