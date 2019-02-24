package by.epam.javawebtraining.stanislaupalaukou.task01.model.logic;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.container.Parking;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.PassengerTransport;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Vehicle;
import org.apache.log4j.Logger;

/**
 * @author Stanislau Palaukou on 24.02.2019
 * @project Task 01
 */

public class VehicleCalculator {

    private static final Logger logger = Logger.getLogger(VehicleCalculator.class);

    public static int totalPrice(Parking parking) {
        int totalPrice = 0;
        if(parking != null) {
            for (Vehicle vehicle : parking.getVehicles()) {
                totalPrice += vehicle.getPrice();
            }
        }
        logger.info("Total price has been calculated.");
        return totalPrice;
    }

    public static int totalSeats(Parking parking) {
        int totalSeats = 0;
        if(parking != null) {
            for (Vehicle vehicle : parking.getVehicles()) {
                try {
                    totalSeats += ((PassengerTransport) vehicle).getSeatsNumber();
                } catch (ClassCastException e) {
                    System.out.println("Vehicle is not passenger: " + vehicle);
                }
            }
        }
        logger.info("Total seats has been calculated.");
        return totalSeats;
    }
}
