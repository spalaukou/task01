package by.epam.javawebtraining.stanislaupalaukou.task01.util;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.container.Parking;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Vehicle;

/**
 * @author Stanislau Palaukou on 18.02.2019
 * @project Task 01
 */

public class ParkingCreator {

  public static Parking create(Vehicle[] vehicles) {
    if(vehicles == null) {
      return null;
    }

    return new Parking(vehicles);
  }
}
