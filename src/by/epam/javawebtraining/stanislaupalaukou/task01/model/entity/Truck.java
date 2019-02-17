package by.epam.javawebtraining.stanislaupalaukou.task01.model.entity;

import java.util.Objects;

/**
 * @author Stanislau Palaukou on 17.02.2019
 * @project Task 01
 */

public class Truck extends CargoTransport {

    private int cargoCapacity;

    public Truck() {}

    public Truck(String name, int price, String type, int cargoCapacity) {
        super(name, price, type);
        this.cargoCapacity = cargoCapacity;
    }

    public int getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(int cargoCapacity) {
        if(cargoCapacity > 0) {
            this.cargoCapacity = cargoCapacity;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Truck truck = (Truck) o;
        return cargoCapacity == truck.cargoCapacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cargoCapacity);
    }

    @Override
    public String toString() {
        return "Truck {" + super.toString() +
                ", cargoCapacity = " + cargoCapacity +
                '}';
    }
}
