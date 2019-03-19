package by.epam.javawebtraining.stanislaupalaukou.task01.model.entity;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * @author Stanislau Palaukou on 17.03.2019
 * @project Task 01
 */

public class BusTest {
    private Bus bus;
    private Bus expected;
    private Bus actual;

    @BeforeTest
    public void setUpBus()
            throws SeatsNumberException, VehiclePriceException, VehicleNameException, BusBodyTypeException {
        bus = new Bus ("Scania", 60_000, 45, Bus.BodyType.TOURIST);
        expected = new Bus ("Scania", 60_000, 45, Bus.BodyType.TOURIST);
        actual = new Bus();
    }

    @Test
    public void testDefaultConstructorNameBus() {
        String expectedName = null;

        assertEquals(expectedName, actual.getName());
    }

    @Test
    public void testDefaultConstructorPriceBus() {
        int expectedPrice = 0;

        assertEquals(expectedPrice, actual.getPrice());
    }

    @Test
    public void testDefaultConstructorSeatsBus() {
        int expectedSeatsNumber = 0;

        assertEquals(expectedSeatsNumber, actual.getSeatsNumber());
    }

    @Test
    public void testDefaultConstructorBodyBus() {
        Bus.BodyType expectedBodyType = null;

        assertEquals(expectedBodyType, actual.getBodyType());
    }

    @Test
    public void testConstructorNameBus() {
        String expectedName = "Scania";
        String actualName = bus.getName();

        assertEquals(expectedName, actualName);
    }

    @Test
    public void testConstructorPriceBus() {
        int expectedPrice = 60_000;
        int actualPrice = bus.getPrice();

        assertEquals(expectedPrice, actualPrice);
    }

    @Test
    public void testConstructorSeatsBus() {
        int expectedSeatsNumber = 45;
        int actualSeatsNumber = bus.getSeatsNumber();

        assertEquals(expectedSeatsNumber, actualSeatsNumber);
    }

    @Test
    public void testConstructorBodyBus() {
        Bus.BodyType expectedBodyType = Bus.BodyType.TOURIST;
        Bus.BodyType actualBodyType = bus.getBodyType();

        assertEquals(expectedBodyType, actualBodyType);
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

        assertEquals(expectedBus, bus);
    }

    @Test
    public void testSetBodyType() throws BusBodyTypeException {
        Bus.BodyType expectedBodyType = Bus.BodyType.TOURIST;

        bus.setBodyType(Bus.BodyType.TOURIST);
        Bus.BodyType actualBodyType = bus.getBodyType();

        assertEquals(expectedBodyType, actualBodyType);
    }

    @Test (expectedExceptions = BusBodyTypeException.class)
    public void testSetBodyTypeException() throws BusBodyTypeException {
        bus.setBodyType(null);
    }

    @Test
    public void testEquals() {
        assertTrue(bus.equals(expected));
    }

    @Test
    public void testHashCode() {
        assertEquals(expected.hashCode(), bus.hashCode());
    }

    @Test
    public void testToString() {
        String expectedString = "Bus {name = Scania, price = 60000, seatsNumber = 45, bodyType = TOURIST}";

        assertEquals(expectedString, expected.toString());
    }

}
