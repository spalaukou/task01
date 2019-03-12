package by.epam.javawebtraining.stanislaupalaukou.task01.model.logic.pattern.strategy;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Vehicle;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.NullParkingException;

/**
 * @author Stanislau Palaukou on 12.03.2019
 * @project Task 01
 */

public interface FindingBehavior {
    Vehicle find(Vehicle[] vehicles) throws NullParkingException;
}
