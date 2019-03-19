package by.epam.javawebtraining.stanislaupalaukou.task01.model.entity;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.SeatsNumberException;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.VehicleNameException;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.VehiclePriceException;

import java.io.Serializable;
import java.util.Objects;

/**
 * The abstract entity class includes base fields
 * and methods of all the passenger vehicles.
 *
 * @author Stanislau Palaukou on 17.02.2019
 * @project Task 01
 */

public class PassengerTransport extends Vehicle implements Serializable {

    private int seatsNumber;

    PassengerTransport() {}

    PassengerTransport(String name, int price, int seatsNumber)
            throws SeatsNumberException, VehicleNameException, VehiclePriceException {

        super(name, price);

        if (seatsNumber > 0) {
            this.seatsNumber = seatsNumber;
        } else {
            throw new SeatsNumberException();
        }
    }

    public int getSeatsNumber() {
        return seatsNumber;
    }

    public void setSeatsNumber(int seatsNumber) throws SeatsNumberException {
        if(seatsNumber > 0) {
            this.seatsNumber = seatsNumber;
        } else {
            throw new SeatsNumberException();
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PassengerTransport that = (PassengerTransport) o;
        return seatsNumber == that.seatsNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), seatsNumber);
    }

    @Override
    public String toString() {
        return super.toString() + ", seatsNumber = " + seatsNumber;
    }
}
