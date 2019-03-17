package by.epam.javawebtraining.stanislaupalaukou.task01.model.entity;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.BikeBodyTypeException;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.SeatsNumberException;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.VehicleNameException;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.VehiclePriceException;

import java.util.Objects;

/**
 * @author Stanislau Palaukou on 16.03.2019
 * @project Task 01
 */

public class Bike extends PassengerTransport {

    private BodyType bodyType;

    /**
     * The entity class of bikes body types.
     */
    public enum BodyType {
        MOPED,
        SCOOTER,
        CRUISER,
        SPORT,
        MOTOCROSS,
    }

    public Bike() {}

    public Bike(String name, int price, int seatsNumber, BodyType bodyType)
            throws SeatsNumberException, VehiclePriceException, VehicleNameException, BikeBodyTypeException {
        super(name, price, seatsNumber);

        if (bodyType != null) {
            this.bodyType = bodyType;
        } else {
            throw new BikeBodyTypeException();
        }
    }

    public Bike(Bike bike)
            throws SeatsNumberException, VehiclePriceException, VehicleNameException, BikeBodyTypeException {

        this(bike.getName(), bike.getPrice(), bike.getSeatsNumber(), bike.getBodyType());
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(BodyType bodyType) throws BikeBodyTypeException {
        if (bodyType != null) {
            this.bodyType = bodyType;
        } else {
            throw new BikeBodyTypeException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Bike bike = (Bike) o;
        return bodyType == bike.bodyType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), bodyType);
    }

    @Override
    public String toString() {
        return "Bike {" + super.toString() +
                ", bodyType = " + bodyType +
                '}';
    }
}
