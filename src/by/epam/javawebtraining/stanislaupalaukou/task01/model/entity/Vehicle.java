package by.epam.javawebtraining.stanislaupalaukou.task01.model.entity;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.VehicleNameException;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.VehiclePriceException;

import java.io.Serializable;
import java.util.Objects;

/**
 * The abstract entity class includes base fields
 * and methods of all the vehicles.
 *
 * @author Stanislau Palaukou on 14.02.2019
 * @project Task 01
 */

public class Vehicle implements Serializable {

    private String name;
    private int price;

    public Vehicle(){}

    public Vehicle(String name, int price) throws VehicleNameException, VehiclePriceException {

        if(name != null) {
            this.name = name;

            if(price > 0) {
                this.price = price;
            } else {
                throw new VehiclePriceException();
            }
        } else {
            throw new VehicleNameException();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws VehicleNameException {
        if(name != null) {
            this.name = name;
        } else {
            throw new VehicleNameException();
        }
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) throws VehiclePriceException {
        if(price > 0) {
            this.price = price;
        } else {
            throw new VehiclePriceException();
        }
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
