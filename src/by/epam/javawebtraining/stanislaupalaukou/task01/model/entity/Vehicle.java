package by.epam.javawebtraining.stanislaupalaukou.task01.model.entity;

import java.util.Objects;

/**
 * @author Stanislau Palaukou on 14.02.2019
 * @project Task 01
 */

public abstract class Vehicle {

    private String name;
    private int price;

    public Vehicle(){}

    public Vehicle(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name != null) {
            this.name = name;
        }
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if(price >= 0) {
            this.price = price;
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
