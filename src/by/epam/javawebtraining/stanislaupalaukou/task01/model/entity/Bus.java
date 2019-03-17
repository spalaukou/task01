package by.epam.javawebtraining.stanislaupalaukou.task01.model.entity;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.BusBodyTypeException;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.SeatsNumberException;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.VehicleNameException;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.VehiclePriceException;

import java.util.Objects;

/**
 * @author Stanislau Palaukou on 16.03.2019
 * @project Task 01
 */

public class Bus extends PassengerTransport {

    private BodyType bodyType;

    /**
     * The entity class of buses body types.
     */
    public enum BodyType {
        MINI,
        CITY,
        SCHOOL,
        TOURIST
    }

    public Bus() {}

    public Bus(String name, int price, int seatsNumber, BodyType bodyType)
            throws SeatsNumberException, VehiclePriceException, VehicleNameException, BusBodyTypeException {
        super(name, price, seatsNumber);



        if (bodyType != null) {
            this.bodyType = bodyType;
        } else {
            throw new BusBodyTypeException();
        }

    }

    public Bus(Bus bus)
            throws SeatsNumberException, VehiclePriceException, VehicleNameException, BusBodyTypeException {

        this(bus.getName(), bus.getPrice(), bus.getSeatsNumber(), bus.getBodyType());
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(BodyType bodyType) throws BusBodyTypeException {
        if (bodyType != null) {
            this.bodyType = bodyType;
        } else {
            throw new BusBodyTypeException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Bus bus = (Bus) o;
        return bodyType == bus.bodyType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), bodyType);
    }

    @Override
    public String toString() {
        return "Bus {" + super.toString() +
                ", bodyType = " + bodyType +
                '}';
    }
}
