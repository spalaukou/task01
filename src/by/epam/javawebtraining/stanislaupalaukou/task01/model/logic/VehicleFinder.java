package by.epam.javawebtraining.stanislaupalaukou.task01.model.logic;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.container.Parking;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Vehicle;

/**
 * @author Stanislau Palaukou on 20.02.2019
 * @project Task 01
 */

public class VehicleFinder {

  public static Vehicle findTheCheapestVehicle(Parking parking) {

    Vehicle theCheapest = parking.getVehicles()[0];
    for (int i = 0; i < parking.getVehicles().length; i++) {
      if (parking.getVehicles()[i].getPrice() < theCheapest.getPrice()) {
        theCheapest = parking.getVehicles()[i];
      }
    }
    return theCheapest;
  }

  public static Vehicle findDearestVehicle(Parking parking) {
    Vehicle dearest = parking.getVehicles()[0];
    for (int i = 0; i < parking.getVehicles().length; i++) {
      if (parking.getVehicles()[i].getPrice() > dearest.getPrice()) {
        dearest = parking.getVehicles()[i];
      }

    }
    return dearest;
  }
}
