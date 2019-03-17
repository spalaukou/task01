package by.epam.javawebtraining.stanislaupalaukou.task01.model.entity;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.*;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author Stanislau Palaukou on 17.03.2019
 * @project Task 01
 */

public class BikeTest {
    private Bike bike;
    private Bike expected;

    @BeforeTest
    public void setUpBike()
            throws SeatsNumberException, VehiclePriceException, VehicleNameException, BikeBodyTypeException {
        bike = new Bike ("BMW", 25_000, 1, Bike.BodyType.SPORT);
        expected = new Bike ("BMW", 25_000, 1, Bike.BodyType.SPORT);
    }

    @Test
    public void testDefaultConstructorBike() {
        Bike actual = new Bike();

        String expectedName = null;
        int expectedPrice = 0;
        int expectedSeatsNumber = 0;
        Bike.BodyType expectedBodyType = null;

        Assert.assertEquals(expectedName, actual.getName());
        Assert.assertEquals(expectedPrice, actual.getPrice());
        Assert.assertEquals(expectedSeatsNumber, actual.getSeatsNumber());
        Assert.assertEquals(expectedBodyType, actual.getBodyType());
    }

    @Test
    public void testConstructorBike() {
        String expectedName = "BMW";
        int expectedPrice = 25000;
        int expectedSeatsNumber = 1;
        Bike.BodyType expectedBodyType = Bike.BodyType.SPORT;

        String actualName = bike.getName();
        int actualPrice = bike.getPrice();
        int actualSeatsNumber = bike.getSeatsNumber();
        Bike.BodyType actualBodyType = bike.getBodyType();

        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedPrice, actualPrice);
        Assert.assertEquals(expectedSeatsNumber, actualSeatsNumber);
        Assert.assertEquals(expectedBodyType, actualBodyType);
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

        Assert.assertEquals(expectedBike, bike);
    }

    @Test
    public void testSetBodyType() throws BikeBodyTypeException {
        Bike.BodyType expectedBodyType = Bike.BodyType.SPORT;

        bike.setBodyType(Bike.BodyType.SPORT);
        Bike.BodyType actualBodyType = bike.getBodyType();

        Assert.assertEquals(expectedBodyType, actualBodyType);
    }

    @Test (expectedExceptions = BikeBodyTypeException.class)
    public void testSetBodyTypeException() throws BikeBodyTypeException {
        bike.setBodyType(null);
    }

    @Test
    public void testEquals() {
        Assert.assertTrue(bike.equals(expected));
    }

    @Test
    public void testHashCode() {
        Assert.assertEquals(expected.hashCode(), bike.hashCode());
    }

    @Test
    public void testToString() {
        String expectedString = "Bike {name = BMW, price = 25000, seatsNumber = 1, bodyType = SPORT}";

        System.out.println(expected);
        Assert.assertEquals(expectedString, expected.toString());
    }

}
