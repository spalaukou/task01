package by.epam.javawebtraining.stanislaupalaukou.task01.util.factory;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.*;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.*;

/**
 * The Vehicle Factory class implements a Factory Design Pattern
 * (one of the Creational Design Patterns) and creates
 * various types of Vehicles.
 *
 * @author Stanislau Palaukou on 19.02.2019
 * @project Task 01
 */

public class VehicleFactory {

  /**
   * Method receives list of parameters and returns vehicle
   * object appropriate type.
   *
   * @param type
   * @param name
   * @param price
   * @param localField
   * @param bodyTypeString
   * @return Vehicle
   */
  public static Vehicle createVehicle(VehicleType type, String name, int price, int localField, String bodyTypeString)
          throws LogicalException {

    if (type != null) {

      Vehicle toReturn = null;

      switch (type) {
        case BIKE:
          toReturn = new Bike(name, price, localField, Bike.BodyType.valueOf(bodyTypeString));
          break;
        case BUS:
          toReturn = new Bus(name, price, localField, Bus.BodyType.valueOf(bodyTypeString));
          break;
        case CAR:
          toReturn = new Car(name, price, localField, Car.BodyType.valueOf(bodyTypeString));
          break;
        case TRUCK:
          toReturn = new Truck(name, price, localField, Truck.BodyType.valueOf(bodyTypeString));
          break;
        case VAN:
          toReturn = new Van(name, price, localField, Van.BodyType.valueOf(bodyTypeString));
          break;
        case DUMPTRUCK:
          toReturn = new DumpTruck(name, price, localField, DumpTruck.BodyType.valueOf(bodyTypeString));
          break;
        default:
      }
      return toReturn;

    } else {
      throw new VehicleTypeException();
    }
  }
}
