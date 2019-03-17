package by.epam.javawebtraining.stanislaupalaukou.task01.model.entity;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.CargoCapacityException;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.VanBodyTypeException;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.VehicleNameException;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.VehiclePriceException;

import java.util.Objects;

/**
 * @author Stanislau Palaukou on 16.03.2019
 * @project Task 01
 */

public class Van extends CargoTransport {

    private BodyType bodyType;

    /**
     * The entity class of vans body types.
     */
    public enum BodyType {
        FULLSIZE,
        MULTISTOP,
        BOX,
    }

    public Van() {}

    public Van(String name, int price, int cargoCapacity, BodyType bodyType)
            throws VehiclePriceException, CargoCapacityException, VehicleNameException, VanBodyTypeException {
        super(name, price, cargoCapacity);

        if (bodyType != null) {
            this.bodyType = bodyType;
        } else {
            throw new VanBodyTypeException();
        }
    }

    public Van(Van van)
            throws VanBodyTypeException, VehiclePriceException, CargoCapacityException, VehicleNameException {

        this(van.getName(), van.getPrice(), van.getCargoCapacity(), van.getBodyType());
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(BodyType bodyType) throws VanBodyTypeException {
        if (bodyType != null) {
            this.bodyType = bodyType;
        } else {
            throw new VanBodyTypeException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Van van = (Van) o;
        return bodyType == van.bodyType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), bodyType);
    }

    @Override
    public String toString() {
        return "Van {" + super.toString() +
                ", bodyType = " + bodyType +
                '}';
    }
}
