package by.epam.javawebtraining.stanislaupalaukou.task01.model.entity;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.CargoCapacityException;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.VehicleNameException;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.VehiclePriceException;

import java.util.Objects;

/**
 * The abstract entity class includes base fields
 * and methods of all the cargo vehicles.
 *
 * @author Stanislau Palaukou on 17.02.2019
 * @project Task 01
 */

public abstract class CargoTransport extends Vehicle {

    private int cargoCapacity;

    public CargoTransport() {}

    public CargoTransport(String name, int price, int cargoCapacity)
            throws VehicleNameException, VehiclePriceException, CargoCapacityException {

        super(name, price);
        if (cargoCapacity > 0) {
            this.cargoCapacity = cargoCapacity;
        } else {
            throw new CargoCapacityException();
        }
    }

    public int getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(int cargoCapacity) throws CargoCapacityException {
        if(cargoCapacity > 0) {
            this.cargoCapacity = cargoCapacity;
        } else {
            throw new CargoCapacityException();
        }
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
