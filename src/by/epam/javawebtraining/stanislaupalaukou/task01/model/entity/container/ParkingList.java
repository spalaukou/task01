package by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.container;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Vehicle;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.NullParkingException;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.NullVehicleException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The entity container class includes vehicles based on
 * List and can add and remove vehicles from it.
 *
 * @author Stanislau Palaukou on 10.03.2019
 * @project Task 01
 */

public class ParkingList implements AbstractParking<List<Vehicle>> {

    private List<Vehicle> vehicleList;

    public ParkingList() {
        vehicleList = new ArrayList<>();
    }

    public ParkingList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    public ParkingList(ParkingList parkingList) {
        vehicleList = parkingList.getVehicles();
    }

    @Override
    public List<Vehicle> getVehicles() {
        return vehicleList;
    }

    @Override
    public void setVehicles(List<Vehicle> vehicles) throws NullParkingException {
        if (vehicles == null) {
            throw new NullParkingException();
        }
        vehicleList = vehicles;
    }

    @Override
    public void addVehicle(Vehicle vehicle) throws NullVehicleException {
        if (vehicle == null) {
            throw new NullVehicleException();
        }
        vehicleList.add(vehicle);
    }

    @Override
    public void removeVehicle(Vehicle vehicle) {
        vehicleList.remove(vehicle);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkingList that = (ParkingList) o;
        return Objects.equals(vehicleList, that.vehicleList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicleList);
    }

    @Override
    public String toString() {
        return "ParkingList{" +
                "vehicleList=" + vehicleList +
                '}';
    }
}
