package by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.container;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.NullParkingException;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.NullVehicleException;

/**
 * The universal entity container class.
 *
 * @author Stanislau Palaukou on 10.03.2019
 * @project Task 01
 */

public interface AbstractContainer<T> {

  T[] getVehicles();

  void setVehicles(T[] t) throws NullParkingException;

  void addVehicle(T t) throws NullVehicleException;

  void removeVehicle(T t);

}