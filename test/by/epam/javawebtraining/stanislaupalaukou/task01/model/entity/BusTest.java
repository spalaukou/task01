package by.epam.javawebtraining.stanislaupalaukou.task01.model.entity;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.*;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author Stanislau Palaukou on 17.03.2019
 * @project Task 01
 */

public class BusTest {
    private Bus bus;
    private Bus expected;

    @BeforeTest
    public void setUpBus()
            throws SeatsNumberException, VehiclePriceException, VehicleNameException, BusBodyTypeException {
        bus = new Bus ("Scania", 60_000, 45, Bus.BodyType.TOURIST);
        expected = new Bus ("Scania", 60_000, 45, Bus.BodyType.TOURIST);
    }

    @Test
    public void testDefaultConstructorBus() {
        Bus actual = new Bus();

        String expectedName = null;
        int expectedPrice = 0;
        int expectedSeatsNumber = 0;
        Bus.BodyType expectedBodyType = null;

        Assert.assertEquals(expectedName, actual.getName());
        Assert.assertEquals(expectedPrice, actual.getPrice());
        Assert.assertEquals(expectedSeatsNumber, actual.getSeatsNumber());
        Assert.assertEquals(expectedBodyType, actual.getBodyType());
    }

    @Test
    public void testConstructorBus() {
        String expectedName = "Scania";
        int expectedPrice = 60_000;
        int expectedSeatsNumber = 45;
        Bus.BodyType expectedBodyType = Bus.BodyType.TOURIST;

        String actualName = bus.getName();
        int actualPrice = bus.getPrice();
        int actualSeatsNumber = bus.getSeatsNumber();
        Bus.BodyType actualBodyType = bus.getBodyType();

        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedPrice, actualPrice);
        Assert.assertEquals(expectedSeatsNumber, actualSeatsNumber);
        Assert.assertEquals(expectedBodyType, actualBodyType);
    }

    @Test (expectedExceptions = BusBodyTypeException.class)
    public void testConstructorBusException()
            throws SeatsNumberException, VehiclePriceException, VehicleNameException, BusBodyTypeException {
        new Bus ("Scania", 60_000, 45, null);
    }

    @Test
    public void testCopyConstructorBus()
            throws SeatsNumberException, VehiclePriceException, VehicleNameException, BusBodyTypeException {
        Bus expectedBus = new Bus(bus);

        Assert.assertEquals(expectedBus, bus);
    }

    @Test
    public void testSetBodyType() throws BusBodyTypeException {
        Bus.BodyType expectedBodyType = Bus.BodyType.TOURIST;

        bus.setBodyType(Bus.BodyType.TOURIST);
        Bus.BodyType actualBodyType = bus.getBodyType();

        Assert.assertEquals(expectedBodyType, actualBodyType);
    }

    @Test (expectedExceptions = BusBodyTypeException.class)
    public void testSetBodyTypeException() throws BusBodyTypeException {
        bus.setBodyType(null);
    }

    @Test
    public void testEquals() {
        Assert.assertTrue(bus.equals(expected));
    }

    @Test
    public void testHashCode() {
        Assert.assertEquals(expected.hashCode(), bus.hashCode());
    }

    @Test
    public void testToString() {
        String expectedString = "Bus {name = Scania, price = 60000, seatsNumber = 45, bodyType = TOURIST}";

        System.out.println(expected);
        Assert.assertEquals(expectedString, expected.toString());
    }

}
