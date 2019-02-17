package by.epam.javawebtraining.stanislaupalaukou.task01.model.entity;

import java.util.Objects;

/**
 * @author Stanislau Palaukou on 14.02.2019
 * @project Task 01
 */

public class Car extends PassengerTransport {

    private int trunkCapacity;

    public Car() {}

    public Car(String name, int price, int seatsNumber, int trunkVolume) {
        super(name, price, seatsNumber);
        this.trunkCapacity = trunkVolume;
    }

    public int getTrunkCapacity() {
        return trunkCapacity;
    }

    public void setTrunkCapacity(int trunkCapacity) {
        if(trunkCapacity >= 0) {
            this.trunkCapacity = trunkCapacity;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Car car = (Car) o;
        return trunkCapacity == car.trunkCapacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), trunkCapacity);
    }

    @Override
    public String toString() {
        return "Car {" + super.toString() +
                ", trunkCapacity = " + trunkCapacity +
                '}';
    }
}
