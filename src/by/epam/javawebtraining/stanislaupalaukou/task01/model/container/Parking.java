package by.epam.javawebtraining.stanislaupalaukou.task01.model.container;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.PassengerTransport;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Vehicle;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.ParkingIsEmptyException;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.VehicleNotFoundException;

import java.util.Arrays;

/**
 * @author Stanislau Palaukou on 14.02.2019
 * @project Task 01
 */

public class Parking {

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

    public int totalPrice() {
        int totalPrice = 0;
        for(Vehicle vehicle : vehicles) {
            totalPrice += vehicle.getPrice();
        }
        return totalPrice;
    }

    public int totalSeats() {
        int totalSeats = 0;
        for(Vehicle vehicle : vehicles) {
            try {
                totalSeats += ((PassengerTransport) vehicle).getSeatsNumber();
            } catch (ClassCastException e) {
                System.out.println("Vehicle is not passenger: " + vehicle);
            }
        }
        return totalSeats;
    }

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

    public void removeVehicle(Vehicle vehicle) {
        try {
            if (vehicles != null && vehicles.length != 0) {
                if (vehicle != null && isOnPlace(vehicle)) {
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
                    throw new VehicleNotFoundException("Vehicle not found: " + vehicle);
                }
            } else {
                throw new ParkingIsEmptyException("Parking is empty");
            }
        } catch (ParkingIsEmptyException | VehicleNotFoundException e) {
            e.printStackTrace();
        }
    }

    private boolean isOnPlace(Vehicle vehicle) {
        boolean flag = false;
        for (int i = 0; i < vehicles.length; i++) {
            if (vehicle.equals(vehicles[i])) {
                flag = true;
                break;
            }
        }
        return flag;
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
