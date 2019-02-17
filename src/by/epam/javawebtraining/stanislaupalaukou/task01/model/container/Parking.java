package by.epam.javawebtraining.stanislaupalaukou.task01.model.container;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Vehicle;

import java.util.Arrays;

/**
 * @author Stanislau Palaukou on 14.02.2019
 * @project Task 01
 */

public class Parking {
  private Vehicle[] vehicles;

  public Parking() {}

  public Parking(Vehicle... vehicle) {
    this.vehicles = vehicle;
  }

  public Vehicle[] getVehicles() {
    return vehicles;
  }

  public void setVehicles(Vehicle[] vehicles) {
    if(vehicles != null) {
      this.vehicles = vehicles;
    }
  }

  public void addVehicle(Vehicle vehicle) {
    Vehicle[] newVehicles = new Vehicle[vehicles.length + 1];
      if(vehicle != null) {
        for(int i = 0; i < vehicles.length; i++){
          if(vehicle.equals(vehicles[i])){
            break;
          } else {
            newVehicles[i] = vehicles[i];
          }
        }
        vehicles[vehicles.length] = vehicle;
      }
  }

  public void removeVehicle(Vehicle vehicle) {
    Vehicle[] newVehicles = new Vehicle[vehicles.length - 1];
    for (int i = 0; i < vehicles.length; i++) {
      if (vehicle.equals(vehicles[i])) {
        i++;
      }
      newVehicles[i] = vehicles[i];
    }
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
    if(vehicles == null) {
      return "There is no vehicles in the parking lot";
    }
    return "Parking {" +
            "vehicles = " + Arrays.toString(vehicles) +
            '}';
  }
}
