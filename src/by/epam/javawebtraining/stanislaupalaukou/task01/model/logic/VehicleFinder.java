package by.epam.javawebtraining.stanislaupalaukou.task01.model.logic;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.container.Parking;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Vehicle;
import org.apache.log4j.Logger;

/**
 * @author Stanislau Palaukou on 20.02.2019
 * @project Task 01
 */

public class VehicleFinder {

  private static final Logger logger = Logger.getLogger(VehicleFinder.class);

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
    logger.info("The cheapest vehicle has been found");
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
    logger.info("The dearest vehicle has been found");
    return theDearest;
  }
}
