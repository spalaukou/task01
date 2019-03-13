package by.epam.javawebtraining.stanislaupalaukou.task01.model.logic;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.container.Parking;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Vehicle;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.NullParkingException;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.NullVehicleException;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.VehicleArrayException;
import org.apache.log4j.Logger;

/**
 * The logic class finds Vehicles in
 * the parking lot by extreme params.
 *
 * @author Stanislau Palaukou on 20.02.2019
 * @project Task 01
 */

public class VehicleFinder {

  private static final Logger logger = Logger.getLogger(VehicleFinder.class);

  /**
   * The method finds the cheapest Vehicle
   * in the parking lot, which is passed as param.
   *
   * @param parking
   * @return
   */
  public static Vehicle findTheCheapestVehicle(Parking parking) throws NullParkingException, VehicleArrayException {

    if (parking != null) {

      Vehicle theCheapest = null;
      if (parking.getVehicles() != null && parking.getVehicles().length != 0) {
        theCheapest = parking.getVehicles()[0];
        for (int i = 0; i < parking.getVehicles().length; i++) {
          if (parking.getVehicles()[i].getPrice() < theCheapest.getPrice()) {
            theCheapest = parking.getVehicles()[i];
          }
        }

      } else {
        throw new VehicleArrayException();
      }

      logger.info("The cheapest vehicle has been found");
      return theCheapest;

    } else {
      throw new NullParkingException();
    }
  }

  /**
   * The method finds the dearest Vehicle
   * in the parking lot, which is passed as param.
   *
   * @param parking
   * @return
   */
  public static Vehicle findTheDearestVehicle(Parking parking) throws NullParkingException, VehicleArrayException {

    if (parking != null) {

      Vehicle theDearest = null;
      if (parking.getVehicles() != null && parking.getVehicles().length != 0) {
        theDearest = parking.getVehicles()[0];
        for (int i = 0; i < parking.getVehicles().length; i++) {
          if (parking.getVehicles()[i].getPrice() > theDearest.getPrice()) {
            theDearest = parking.getVehicles()[i];
          }
        }

      } else {
        throw new VehicleArrayException();
      }

      logger.info("The dearest vehicle has been found");
      return theDearest;

    } else {
      throw new NullParkingException();
    }
  }
}
