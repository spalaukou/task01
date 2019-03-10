package by.epam.javawebtraining.stanislaupalaukou.task01.model.entity;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.CargoCapacityException;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.TruckBodyTypeException;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.VehicleNameException;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.VehiclePriceException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author Stanislau Palaukou on 24.02.2019
 * @project Task 01
 */

public class TruckTest {
    private Truck truck;

    @BeforeTest
    public void setUpTruck()
            throws TruckBodyTypeException, VehiclePriceException, CargoCapacityException, VehicleNameException {
        truck = new Truck ("Volvo", 80_000, 30_000, Truck.BodyType.CABOVER);
    }

    @Test
    public void testConstructorTruck() {
        String expectedName = "Volvo";
        int expectedPrice = 80000;
        int expectedCargoCapacity = 30000;
        Truck.BodyType expectedBodyType = Truck.BodyType.CABOVER;

        String actualName = truck.getName();
        int actualPrice = truck.getPrice();
        int actualCargoCapacity = truck.getCargoCapacity();
        Truck.BodyType actualBodyType = truck.getBodyType();

        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedPrice, actualPrice);
        Assert.assertEquals(expectedCargoCapacity, actualCargoCapacity);
        Assert.assertEquals(expectedBodyType, actualBodyType);
    }

    @Test
    public void testSetBodyType() throws TruckBodyTypeException {
        Truck.BodyType expectedBodyType = Truck.BodyType.SLEEPER;

        truck.setBodyType(Truck.BodyType.SLEEPER);
        Truck.BodyType actualBodyType = truck.getBodyType();

        Assert.assertEquals(expectedBodyType, actualBodyType);
    }
}
