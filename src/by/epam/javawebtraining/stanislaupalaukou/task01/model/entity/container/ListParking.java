package by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.container;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Vehicle;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.NullParkingException;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.NullVehicleException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * The entity container class includes vehicles based on
 * List and can add and remove vehicles from it.
 *
 * @author Stanislau Palaukou on 10.03.2019
 * @project Task 01
 */

public class ListParking implements AbstractContainer<Vehicle> {

  private List<Vehicle> vehicleList;

  public ListParking() {
    vehicleList = new ArrayList<>();
  }

  public ListParking(List<Vehicle> vehicleList) {
    this.vehicleList = vehicleList;
  }

  public ListParking(ListParking parkingList) {
    vehicleList = Arrays.asList(parkingList.getVehicles());
  }

  @Override
  public Vehicle[] getVehicles() {
    return (Vehicle[]) vehicleList.toArray();
  }

  @Override
  public void setVehicles(Vehicle[] vehicles) throws NullParkingException {
    if (vehicles != null) {
      vehicleList = Arrays.asList(vehicles);
    } else {
      throw new NullParkingException();
    }
  }

  @Override
  public void addVehicle(Vehicle vehicle) throws NullVehicleException {
    if (vehicle != null) {
      vehicleList.add(vehicle);
    } else {
      throw new NullVehicleException();
    }
  }

  @Override
  public void removeVehicle(Vehicle vehicle) {
    if (vehicle != null) {
      vehicleList.remove(vehicle);
    } else {
      try {
        throw new NullVehicleException();
      } catch (NullVehicleException e) {
        e.printStackTrace();
      }
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ListParking that = (ListParking) o;
    return Objects.equals(vehicleList, that.vehicleList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(vehicleList);
  }

  @Override
  public String toString() {
    return "ListParking{" +
            "vehicleList=" + vehicleList +
            '}';
  }
}