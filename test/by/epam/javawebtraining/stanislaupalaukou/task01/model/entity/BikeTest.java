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

public class BikeTest {
    private Bike bike;
    private Bike actual;
    private Bike expected;

    @BeforeTest
    public void setUpBike()
            throws SeatsNumberException, VehiclePriceException, VehicleNameException, BikeBodyTypeException {
        bike = new Bike ("BMW", 25_000, 1, Bike.BodyType.SPORT);
        expected = new Bike ("BMW", 25_000, 1, Bike.BodyType.SPORT);
        actual = new Bike();
    }

    @Test
    public void testDefaultConstructorNameBike() {
        String expectedName = null;

        assertEquals(expectedName, actual.getName());
    }

    @Test
    public void testDefaultConstructorPriceBike() {
        int expectedPrice = 0;

        assertEquals(expectedPrice, actual.getPrice());
    }

    @Test
    public void testDefaultConstructorSeatsBike() {
        int expectedSeatsNumber = 0;

        assertEquals(expectedSeatsNumber, actual.getSeatsNumber());
    }

    @Test
    public void testDefaultConstructorBodyBike() {
        Bike.BodyType expectedBodyType = null;

        assertEquals(expectedBodyType, actual.getBodyType());
    }

    @Test
    public void testConstructorNameBike() {
        String expectedName = "BMW";
        String actualName = bike.getName();

        assertEquals(expectedName, actualName);
    }

    @Test
    public void testConstructorPriceBike() {
        int expectedPrice = 25000;
        int actualPrice = bike.getPrice();

        assertEquals(expectedPrice, actualPrice);
    }

    @Test
    public void testConstructorSeatsBike() {
        int expectedSeatsNumber = 1;
        int actualSeatsNumber = bike.getSeatsNumber();

        assertEquals(expectedSeatsNumber, actualSeatsNumber);
    }

    @Test
    public void testConstructorBodyBike() {
        Bike.BodyType expectedBodyType = Bike.BodyType.SPORT;
        Bike.BodyType actualBodyType = bike.getBodyType();

        assertEquals(expectedBodyType, actualBodyType);
    }

    @Test (expectedExceptions = BikeBodyTypeException.class)
    public void testConstructorBikeException()
            throws SeatsNumberException, VehiclePriceException, VehicleNameException, BikeBodyTypeException {
        new Bike ("BMW", 25_000, 1, null);
    }

    @Test
    public void testCopyConstructorBike()
            throws SeatsNumberException, VehiclePriceException, VehicleNameException, BikeBodyTypeException {
        Bike expectedBike = new Bike(bike);

        assertEquals(expectedBike, bike);
    }

    @Test
    public void testSetBodyType() throws BikeBodyTypeException {
        Bike.BodyType expectedBodyType = Bike.BodyType.SPORT;

        bike.setBodyType(Bike.BodyType.SPORT);
        Bike.BodyType actualBodyType = bike.getBodyType();

        assertEquals(expectedBodyType, actualBodyType);
    }

    @Test (expectedExceptions = BikeBodyTypeException.class)
    public void testSetBodyTypeException() throws BikeBodyTypeException {
        bike.setBodyType(null);
    }

    @Test
    public void testEquals() {
        assertTrue(bike.equals(expected));
    }

    @Test
    public void testHashCode() {
        assertEquals(expected.hashCode(), bike.hashCode());
    }

    @Test
    public void testToString() {
        String expectedString = "Bike {name = BMW, price = 25000, seatsNumber = 1, bodyType = SPORT}";

        assertEquals(expectedString, expected.toString());
    }

}
