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
    private Truck expected;

    @BeforeTest
    public void setUpTruck()
            throws TruckBodyTypeException, VehiclePriceException, CargoCapacityException, VehicleNameException {
        truck = new Truck ("Volvo", 80_000, 30_000, Truck.BodyType.CABOVER);
        expected = new Truck ("Volvo", 80_000, 30_000, Truck.BodyType.CABOVER);
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
    public void testConstructorTruckException()
            throws CargoCapacityException, VehiclePriceException, VehicleNameException, TruckBodyTypeException {
        new Truck ("Volvo", 80_000, 30_000,null);
    }


    @Test (expectedExceptions = CargoCapacityException.class)
    public void testConstructorCarSeatsException()
            throws VehiclePriceException, VehicleNameException, CargoCapacityException, TruckBodyTypeException {
        new Truck ("Volvo", 80_000, 0, Truck.BodyType.CABOVER);
    }

    @Test (expectedExceptions = VehicleNameException.class)
    public void testConstructorCarNameException()
            throws VehiclePriceException, VehicleNameException, CargoCapacityException, TruckBodyTypeException {
        new Truck (null, 80_000, 30_000, Truck.BodyType.CABOVER);
    }

    @Test (expectedExceptions = VehiclePriceException.class)
    public void testConstructorCarPriceException()
            throws VehiclePriceException, VehicleNameException, CargoCapacityException, TruckBodyTypeException {
        new Truck ("Volvo", 0, 30_000, Truck.BodyType.CABOVER);
    }

    @Test
    public void testCopyConstructorTruck()
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

    @Test
    public void testSetCargoCapacity() throws CargoCapacityException {
        truck.setCargoCapacity(1_000);
        int expectedCargoCapacity = 1_000;

        Assert.assertEquals(expectedCargoCapacity, truck.getCargoCapacity());
    }

    @Test (expectedExceptions = CargoCapacityException.class)
    public void testSetCargoCapacityException() throws CargoCapacityException {
        truck.setCargoCapacity(-1);
    }

    @Test
    public void testEquals() {
        Assert.assertTrue(truck.equals(expected));
    }

    @Test
    public void testHashCode() {
        Assert.assertEquals(expected.hashCode(), truck.hashCode());
    }

    @Test
    public void testToString() {
        String expectedString = "Truck {name = Volvo, price = 80000, cargoCapacity = 30000, bodyType = CABOVER}";
        System.out.println(expected);

        Assert.assertEquals(expectedString, expected.toString());
    }

}
