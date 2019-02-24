package by.epam.javawebtraining.stanislaupalaukou.task01.model.entity;

import java.util.Objects;

/**
 * @author Stanislau Palaukou on 17.02.2019
 * @project Task 01
 */

public abstract class CargoTransport extends Vehicle {

    private int cargoCapacity;

    public CargoTransport() {}

    public CargoTransport(String name, int price, int cargoCapacity) {
        super(name, price);
        this.cargoCapacity = cargoCapacity;
    }

    public int getWheelsNumber() {
        return cargoCapacity;
    }

    public void setWheelsNumber(int wheelsNumber) {
        this.cargoCapacity = wheelsNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CargoTransport that = (CargoTransport) o;
        return cargoCapacity == that.cargoCapacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cargoCapacity);
    }

    @Override
    public String toString() {
        return super.toString() +
                ", cargoCapacity = " + cargoCapacity;
    }
}
