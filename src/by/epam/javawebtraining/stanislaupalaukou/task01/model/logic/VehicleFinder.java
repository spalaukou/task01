package by.epam.javawebtraining.stanislaupalaukou.task01.model.logic;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.container.Parking;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Vehicle;

/**
 * @author Stanislau Palaukou on 20.02.2019
 * @project Task 01
 */

public class VehicleFinder {

  public static Vehicle findTheCheapestVehicle(Parking parking) {
    Vehicle theCheapest = null;
    if(parking != null && parking.getVehicles() != null && parking.getVehicles().length != 0) {
      theCheapest = parking.getVehicles()[0];
      for (int i = 0; i < parking.getVehicles().length; i++) {
        if (parking.getVehicles()[i].getPrice() < theCheapest.getPrice()) {
          theCheapest = parking.getVehicles()[i];
        }
      }
    }
    return theCheapest;
  }

  public static Vehicle findTheDearestVehicle(Parking parking) {
    Vehicle theDearest = null;
    if(parking != null && parking.getVehicles() != null && parking.getVehicles().length != 0) {
      theDearest = parking.getVehicles()[0];
      for (int i = 0; i < parking.getVehicles().length; i++) {
        if (parking.getVehicles()[i].getPrice() > theDearest.getPrice()) {
          theDearest = parking.getVehicles()[i];
        }

      }
    }
    return theDearest;
  }
}
