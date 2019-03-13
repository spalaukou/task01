package by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.container;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Vehicle;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.*;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.logic.pattern.strategy.FindingBehavior;
import org.apache.log4j.Logger;

import java.util.Arrays;

/**
 * The entity container class includes an array of vehicles
 * and can add and remove vehicles from it.
 *
 * @author Stanislau Palaukou on 14.02.2019
 * @project Task 01
 */

public class Parking implements AbstractContainer<Vehicle[]> {

    private static final Logger logger = Logger.getLogger(Parking.class);

    private FindingBehavior findingBehavior;

    private Vehicle[] vehicles;

    public Parking() {
        vehicles = new Vehicle[0];
    }

    public Parking(Vehicle[] vehicle) throws VehicleArrayException {
        if (vehicle != null) {
            this.vehicles = vehicle;
        }
        throw new VehicleArrayException();
    }

    public Parking(Parking parking) throws NullParkingException {
        if(parking != null) {
            this.vehicles = parking.vehicles;
        } else {
            throw new NullParkingException();
        }
    }

    @Override
    public Vehicle[] getVehicles() {
        return vehicles;
    }

    @Override
    public void setVehicles(Vehicle[] vehicles) throws NullParkingException {
        if (vehicles != null) {
            this.vehicles = vehicles;
        } else {
            throw new NullParkingException();
        }
    }

    public void setFindingBehavior(FindingBehavior findingBehavior) {
        this.findingBehavior = findingBehavior;
    }

    public Vehicle executeFindingBehavior() throws NullParkingException {
        return findingBehavior.find(vehicles);
    }

    @Override
    public void addVehicle(Vehicle vehicle) throws NullVehicleException {
        if (vehicle != null && !isOnPlace(vehicle)) {
            Vehicle[] newVehicles = new Vehicle[vehicles.length + 1];

            for (int i = 0; i < vehicles.length; i++) {
                newVehicles[i] = vehicles[i];
            }

            newVehicles[vehicles.length] = vehicle;
            vehicles = newVehicles;
        } else {
            throw new NullVehicleException();
        }
    }

    @Override
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

    private boolean isOnPlace(Vehicle vehicle) {
        if(vehicle != null) {
            for (Vehicle vehicleItem : vehicles) {
                if (vehicle.equals(vehicleItem)) {
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
