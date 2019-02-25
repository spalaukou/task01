package by.epam.javawebtraining.stanislaupalaukou.task01.model.entity;

import java.util.Objects;

/**
 * The entity class includes base fields
 * and methods of all the trucks.
 *
 * @author Stanislau Palaukou on 17.02.2019
 * @project Task 01
 */

public class Truck extends CargoTransport {

    private BodyType bodyType;

    /**
     * The entity class of trucks' body types.
     */
    public enum BodyType {
        CABOVER,
        SLEEPER
    }

    public Truck() {}

    public Truck(String name, int price, int cargoCapacity, BodyType bodyType) {
        super(name, price, cargoCapacity);
        this.bodyType = bodyType;
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Truck truck = (Truck) o;
        return bodyType == truck.bodyType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), bodyType);
    }

    @Override
    public String toString() {
        return "Truck {" + super.toString() +
                ", bodyType = " + bodyType +
                '}';
    }
}
