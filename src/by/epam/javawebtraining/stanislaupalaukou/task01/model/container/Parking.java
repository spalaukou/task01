package by.epam.javawebtraining.stanislaupalaukou.task01.model.container;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Vehicle;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.ParkingIsEmptyException;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.VehicleNotFoundException;
import org.apache.log4j.Logger;

import java.util.Arrays;

/**
 * The entity container class includes an array of vehicles
 * and can add and remove vehicles from it.
 *
 * @author Stanislau Palaukou on 14.02.2019
 * @project Task 01
 */

public class Parking {

    private static final Logger logger = Logger.getLogger(Parking.class);

    private Vehicle[] vehicles;

    public Parking() {
        vehicles = new Vehicle[0];
    }

    public Parking(Vehicle[] vehicle) {
        this.vehicles = vehicle;
    }

    public Vehicle[] getVehicles() {
        return vehicles;
    }

    public void setVehicles(Vehicle[] vehicles) {
        if (vehicles != null) {
            this.vehicles = vehicles;
        }
    }

    /**
     * Method adds vehicle in the parking lot.
     * @param vehicle will be added in the parking lot
     */
    public void addVehicle(Vehicle vehicle) {
        if (vehicle != null && !isOnPlace(vehicle)) {
            Vehicle[] newVehicles = new Vehicle[vehicles.length + 1];

            for (int i = 0; i < vehicles.length; i++) {
                newVehicles[i] = vehicles[i];
            }

            newVehicles[vehicles.length] = vehicle;
            vehicles = newVehicles;
        }
    }

    /**
     * Method removes vehicle from the parking lot,
     * if the parking lot is not empty and there is that vehicle.
     *
     * If the parking lot is empty, the ParkingIsEmptyException will be thrown.
     *
     * If there is no vehicle in the parking lot, the VehicleNotFoundException
     * will be thrown.
     *
     * @param vehicle will be removed from the parking lot
     */
    public void removeVehicle(Vehicle vehicle) {
        try {
            if (vehicles != null && vehicles.length != 0) {
                if (isOnPlace(vehicle)) {
                    Vehicle[] newVehicles = new Vehicle[vehicles.length - 1];
                    for (int i = 0, j = 0; i < vehicles.length; i++, j++) {
                        if (!vehicle.equals(vehicles[i])) {
                            newVehicles[j] = vehicles[i];
                        } else {
                            j--;
                        }
                    }
                    vehicles = newVehicles;
                } else {
                    logger.info("VehicleNotFoundException has been thrown.");
                    throw new VehicleNotFoundException("Vehicle not found: " + vehicle);
                }
            } else {
                logger.info("ParkingIsEmptyException has been thrown.");
                throw new ParkingIsEmptyException("Parking is empty");
            }
        } catch (ParkingIsEmptyException | VehicleNotFoundException e) {
            logger.info("Exception has been caught", e);
            e.printStackTrace();
        }
    }

    /**
     * The method checks if the vehicle is in the parking lot or not
     * and returns boolean response.
     *
     * @param vehicle will be checked in the method
     * @return boolean response from the method
     */
    private boolean isOnPlace(Vehicle vehicle) {
        if(vehicle != null) {
            for (int i = 0; i < vehicles.length; i++) {
                if (vehicle.equals(vehicles[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parking parking = (Parking) o;
        return Arrays.equals(vehicles, parking.vehicles);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(vehicles);
    }

    @Override
    public String toString() {
        if (vehicles == null) {
            return "There is no vehicles in the parking lot";
        }
        return "Parking " +
                Arrays.toString(vehicles);
    }
}
