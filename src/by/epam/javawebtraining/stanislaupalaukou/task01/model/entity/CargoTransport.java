package by.epam.javawebtraining.stanislaupalaukou.task01.model.entity;

import java.util.Objects;

/**
 * @author Stanislau Palaukou on 17.02.2019
 * @project Task 01
 */

public abstract class CargoTransport extends Vehicle {

    private String cargoType;

    public CargoTransport() {}

    public CargoTransport(String name, int price, String type) {
        super(name, price);
        this.cargoType = type;
    }

    public String getCargoType() {
        return cargoType;
    }

    public void setCargoType(String cargoType) {
        this.cargoType = cargoType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CargoTransport that = (CargoTransport) o;
        return cargoType.equals(that.cargoType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cargoType);
    }

    @Override
    public String toString() {
        return super.toString() +
                ", cargoType=" + cargoType;
    }
}
