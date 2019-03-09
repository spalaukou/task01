package by.epam.javawebtraining.stanislaupalaukou.task01.model.entity;

import java.util.Objects;

/**
 * The abstract entity class includes base fields
 * and methods of all the passenger vehicles.
 *
 * @author Stanislau Palaukou on 17.02.2019
 * @project Task 01
 */

public abstract class PassengerTransport extends Vehicle {

    private int seatsNumber;

    public PassengerTransport() {}

    public PassengerTransport(String name, int price, int seatsNumber) {
        super(name, price);
        this.seatsNumber = seatsNumber;
    }

    public PassengerTransport(PassengerTransport passengerTransport) {
        this(passengerTransport.getName(), passengerTransport.getPrice(), passengerTransport.getSeatsNumber());
    }

    public int getSeatsNumber() {
        return seatsNumber;
    }

    public void setSeatsNumber(int seatsNumber) {
        if(seatsNumber > 0) {
            this.seatsNumber = seatsNumber;
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
