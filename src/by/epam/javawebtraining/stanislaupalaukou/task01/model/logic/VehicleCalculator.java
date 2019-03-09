package by.epam.javawebtraining.stanislaupalaukou.task01.model.logic;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Car;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.container.Parking;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.PassengerTransport;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Vehicle;
import org.apache.log4j.Logger;

/**
 * The logic class calculates different fields of Vehicles.
 *
 * @author Stanislau Palaukou on 24.02.2019
 * @project Task 01
 */

public class VehicleCalculator {

    private static final Logger logger = Logger.getLogger(VehicleCalculator.class);

    /**
     * The method calculates total price of all the Vehicles
     * in the parking lot, which is passed as param.
     *
     * @param parking of vehicles
     * @return total price of all the Vehicles
     */
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

    /**
     * The method calculates total number of seats of all the
     * vehicles in the parking lot, which is passed as param.
     *
     * @param parking of vehicles
     * @return total number of seats of all the vehicles
     */
    public static int totalSeats(Parking parking) {
        int totalSeats = 0;
        if(parking != null) {
            for (Vehicle vehicle : parking.getVehicles()) {
                if(vehicle.getClass() == Car.class) {
                    totalSeats += ((PassengerTransport) vehicle).getSeatsNumber();
                }

//                //Calculating totalSeats with catching ClassCastException - not for using
//                try {
//                    totalSeats += ((PassengerTransport) vehicle).getSeatsNumber();
//                } catch (ClassCastException e) {
//                    System.out.println("Vehicle is not passenger: " + vehicle);
//                }

            }
        }
        logger.info("Total seats has been calculated.");
        return totalSeats;
    }
}
