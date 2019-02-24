package by.epam.javawebtraining.stanislaupalaukou.task01.model.logic;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.container.Parking;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.PassengerTransport;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Vehicle;

/**
 * @author Stanislau Palaukou on 24.02.2019
 * @project Task 01
 */

public class VehicleCalculator {

    public static int totalPrice(Parking parking) {
        int totalPrice = 0;
        if(parking != null) {
            for (Vehicle vehicle : parking.getVehicles()) {
                totalPrice += vehicle.getPrice();
            }
        }
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
        return totalSeats;
    }
}
