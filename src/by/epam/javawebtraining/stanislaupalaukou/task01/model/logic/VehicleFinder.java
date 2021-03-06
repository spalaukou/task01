package by.epam.javawebtraining.stanislaupalaukou.task01.model.logic;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Vehicle;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.container.ArrayParking;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.NullParkingException;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.VehicleArrayException;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.logic.pattern.strategy.FindingBehavior;
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

  private FindingBehavior findingBehavior;

  public void setFindingBehavior(FindingBehavior findingBehavior) {
    this.findingBehavior = findingBehavior;
  }

  public Vehicle executeFindingBehavior(ArrayParking parking) throws NullParkingException {
    return findingBehavior.find(parking.getVehicles());
  }

  /**
   * The method finds the cheapest Vehicle
   * in the parking lot, which is passed as param.
   *
   * @param parking
   * @return
   */
  public static Vehicle findTheCheapestVehicle(ArrayParking parking) throws NullParkingException, VehicleArrayException {

    if (parking != null) {

      Vehicle theCheapest;
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
  public static Vehicle findTheDearestVehicle(ArrayParking parking) throws NullParkingException, VehicleArrayException {

    if (parking != null) {

      Vehicle theDearest;
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
