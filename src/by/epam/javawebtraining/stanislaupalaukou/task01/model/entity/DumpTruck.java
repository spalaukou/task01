package by.epam.javawebtraining.stanislaupalaukou.task01.model.entity;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.CargoCapacityException;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.DumpTruckBodyTypeException;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.VehicleNameException;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.VehiclePriceException;

import java.util.Objects;

/**
 * @author Stanislau Palaukou on 16.03.2019
 * @project Task 01
 */

public class DumpTruck extends CargoTransport {

    private BodyType bodyType;

    /**
     * The entity class of dump trucks body types.
     */
    public enum BodyType {
        CONSTRUCTION,
        GARBAGE,
    }

    public DumpTruck() {}

    public DumpTruck(String name, int price, int cargoCapacity, BodyType bodyType)
            throws VehiclePriceException, CargoCapacityException, VehicleNameException, DumpTruckBodyTypeException {
        super(name, price, cargoCapacity);

        if (bodyType != null) {
            this.bodyType = bodyType;
        } else {
            throw new DumpTruckBodyTypeException();
        }
    }

    public DumpTruck(DumpTruck dumpTruck)
            throws DumpTruckBodyTypeException, VehiclePriceException, CargoCapacityException, VehicleNameException {

        this(dumpTruck.getName(), dumpTruck.getPrice(), dumpTruck.getCargoCapacity(), dumpTruck.getBodyType());
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(BodyType bodyType) throws DumpTruckBodyTypeException {
        if (bodyType != null) {
            this.bodyType = bodyType;
        } else {
            throw new DumpTruckBodyTypeException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DumpTruck dumpTruck = (DumpTruck) o;
        return bodyType == dumpTruck.bodyType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), bodyType);
    }

    @Override
    public String toString() {
        return "DumpTruck {" + super.toString() +
                ", bodyType = " + bodyType +
                '}';
    }
}
