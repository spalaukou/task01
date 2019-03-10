package by.epam.javawebtraining.stanislaupalaukou.task01.model.entity;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.VehicleNameException;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.VehiclePriceException;

import java.util.Objects;

/**
 * The abstract entity class includes base fields
 * and methods of all the vehicles.
 *
 * @author Stanislau Palaukou on 14.02.2019
 * @project Task 01
 */

public abstract class Vehicle {

    private String name;
    private int price;

    public Vehicle(){}

    public Vehicle(String name, int price) throws VehicleNameException, VehiclePriceException {
        if(name == null) {
            throw new VehicleNameException();
        } else if (price <= 0) {
            throw new VehiclePriceException();
        }

        this.name = name;
        this.price = price;
    }

    public Vehicle(Vehicle vehicle) {
        this.name = vehicle.name;
        this.price = vehicle.price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws VehicleNameException {
        if(name == null) {
            throw new VehicleNameException();
        }
            this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) throws VehiclePriceException {
        if(price <= 0) {
            throw new VehiclePriceException();
        }
            this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return price == vehicle.price &&
                name.equals(vehicle.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public String toString() {
        return "name = " + name +
                ", price = " + price;
    }
}
