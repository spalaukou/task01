package by.epam.javawebtraining.stanislaupalaukou.task01.model.entity;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.CarBodyTypeException;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.SeatsNumberException;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.VehicleNameException;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.VehiclePriceException;

import java.io.Serializable;
import java.util.Objects;

/**
 * The entity class includes base fields
 * and methods of all the cars.
 *
 * @author Stanislau Palaukou on 14.02.2019
 * @project Task 01
 */

public class Car extends PassengerTransport implements Serializable {

    private BodyType bodyType;

    /**
     * The entity class of cars body types.
     */
    public enum BodyType {
        SEDAN,
        HATCHBACK,
        COUPE
    }

    public Car() {}

    public Car(String name, int price, int seatsNumber, BodyType bodyType)
            throws SeatsNumberException, VehiclePriceException, VehicleNameException, CarBodyTypeException {
        super(name, price, seatsNumber);

        if (bodyType != null) {
            this.bodyType = bodyType;
        } else {
            throw new CarBodyTypeException();
        }

    }

    public Car(Car car)
            throws SeatsNumberException, VehiclePriceException, VehicleNameException, CarBodyTypeException {

        this(car.getName(), car.getPrice(), car.getSeatsNumber(), car.getBodyType());
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(BodyType bodyType) throws CarBodyTypeException {
        if (bodyType != null) {
            this.bodyType = bodyType;
        } else {
            throw new CarBodyTypeException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Car car = (Car) o;
        return bodyType == car.bodyType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), bodyType);
    }

    @Override
    public String toString() {
        return "Car {" + super.toString() +
                ", bodyType = " + bodyType +
                '}';
    }
}