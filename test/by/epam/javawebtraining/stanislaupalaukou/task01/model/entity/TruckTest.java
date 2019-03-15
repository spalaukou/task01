package by.epam.javawebtraining.stanislaupalaukou.task01.model.entity;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.*;
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
    public void testDefaultConstructorTruck() {
        Truck actual = new Truck();

        String expectedName = null;
        int expectedPrice = 0;
        int expectedCargoCapacity = 0;
        Truck.BodyType expectedBodyType = null;

        Assert.assertEquals(expectedName, actual.getName());
        Assert.assertEquals(expectedPrice, actual.getPrice());
        Assert.assertEquals(expectedCargoCapacity, actual.getCargoCapacity());
        Assert.assertEquals(expectedBodyType, actual.getBodyType());
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

    @Test (expectedExceptions = TruckBodyTypeException.class)
    public void testConstructorCarException()
            throws CargoCapacityException, VehiclePriceException, VehicleNameException, TruckBodyTypeException {
        new Truck ("Volvo", 80_000, 30_000,null);
    }

    @Test
    public void testCopyConstructorCar()
            throws VehiclePriceException, VehicleNameException, CargoCapacityException, TruckBodyTypeException {
        Truck expectedTruck = new Truck(truck);

        Assert.assertEquals(expectedTruck, truck);
    }

    @Test
    public void testSetBodyType() throws TruckBodyTypeException {
        Truck.BodyType expectedBodyType = Truck.BodyType.SLEEPER;

        truck.setBodyType(Truck.BodyType.SLEEPER);
        Truck.BodyType actualBodyType = truck.getBodyType();

        Assert.assertEquals(expectedBodyType, actualBodyType);
    }

    @Test (expectedExceptions = TruckBodyTypeException.class)
    public void testSetBodyTypeException() throws TruckBodyTypeException {
        truck.setBodyType(null);
    }

}
