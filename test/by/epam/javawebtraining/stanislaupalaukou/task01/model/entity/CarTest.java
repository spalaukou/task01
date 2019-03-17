package by.epam.javawebtraining.stanislaupalaukou.task01.model.entity;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.*;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author Stanislau Palaukou on 24.02.2019
 * @project Task 01
 */

public class CarTest {
    private Car car;
    private Car expected;

    @BeforeTest
    public void setUpCar()
            throws SeatsNumberException, VehiclePriceException, VehicleNameException, CarBodyTypeException {
        car = new Car ("BMW", 66_000, 4, Car.BodyType.SEDAN);
        expected = new Car ("BMW", 66_000, 4, Car.BodyType.SEDAN);
    }

    @Test
    public void testDefaultConstructorCar() {
        Car actual = new Car();

        String expectedName = null;
        int expectedPrice = 0;
        int expectedSeatsNumber = 0;
        Car.BodyType expectedBodyType = null;

        Assert.assertEquals(expectedName, actual.getName());
        Assert.assertEquals(expectedPrice, actual.getPrice());
        Assert.assertEquals(expectedSeatsNumber, actual.getSeatsNumber());
        Assert.assertEquals(expectedBodyType, actual.getBodyType());
    }

    @Test
    public void testConstructorCar() {
        String expectedName = "BMW";
        int expectedPrice = 66000;
        int expectedSeatsNumber = 4;
        Car.BodyType expectedBodyType = Car.BodyType.SEDAN;

        String actualName = car.getName();
        int actualPrice = car.getPrice();
        int actualSeatsNumber = car.getSeatsNumber();
        Car.BodyType actualBodyType = car.getBodyType();

        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedPrice, actualPrice);
        Assert.assertEquals(expectedSeatsNumber, actualSeatsNumber);
        Assert.assertEquals(expectedBodyType, actualBodyType);
    }

    @Test (expectedExceptions = CarBodyTypeException.class)
    public void testConstructorCarException()
            throws SeatsNumberException, VehiclePriceException, VehicleNameException, CarBodyTypeException {
        new Car ("BMW", 66_000, 4, null);
    }

    @Test (expectedExceptions = SeatsNumberException.class)
    public void testConstructorCarSeatsException()
            throws SeatsNumberException, VehiclePriceException, VehicleNameException, CarBodyTypeException {
        new Car ("BMW", 66_000, 0, Car.BodyType.SEDAN);
    }

    @Test (expectedExceptions = VehicleNameException.class)
    public void testConstructorCarNameException()
            throws SeatsNumberException, VehiclePriceException, VehicleNameException, CarBodyTypeException {
        new Car (null, 66_000, 4, Car.BodyType.SEDAN);
    }

    @Test (expectedExceptions = VehiclePriceException.class)
    public void testConstructorCarPriceException()
            throws SeatsNumberException, VehiclePriceException, VehicleNameException, CarBodyTypeException {
        new Car ("BMW", 0, 4, Car.BodyType.SEDAN);
    }

    @Test
    public void testCopyConstructorCar()
            throws SeatsNumberException, VehiclePriceException, VehicleNameException, CarBodyTypeException {
        Car expectedCar = new Car(car);

        Assert.assertEquals(expectedCar, car);
    }

    @Test (expectedExceptions = SeatsNumberException.class)
    public void testCopyConstructorCarSeatsNumberException()
            throws SeatsNumberException, VehiclePriceException, VehicleNameException, CarBodyTypeException {
        new Car(new Car("BMW", 66_000, 0, Car.BodyType.SEDAN));
    }

    @Test (expectedExceptions = VehicleNameException.class)
    public void testCopyConstructorCarVehicleNameException()
            throws SeatsNumberException, VehiclePriceException, VehicleNameException, CarBodyTypeException {
        new Car(new Car(null, 66_000, 4, Car.BodyType.SEDAN));
    }

    @Test (expectedExceptions = VehiclePriceException.class)
    public void testCopyConstructorCarVehiclePriceException()
            throws SeatsNumberException, VehiclePriceException, VehicleNameException, CarBodyTypeException {
        new Car(new Car("BMW", -2, 4, Car.BodyType.SEDAN));
    }

    @Test
    public void testSetName() throws VehicleNameException {
        String expectedName = "Volvo";
        car.setName("Volvo");

        Assert.assertEquals(expectedName, car.getName());
    }

    @Test (expectedExceptions = VehicleNameException.class)
    public void testSetNameException() throws VehicleNameException {
        car.setName(null);
    }

    @Test
    public void testSetPrice() throws VehiclePriceException {
        int expectedPrice = 12_000;
        car.setPrice(12_000);

        Assert.assertEquals(expectedPrice, car.getPrice());
    }

    @Test (expectedExceptions = VehiclePriceException.class)
    public void testSetPriceException() throws VehiclePriceException {
        car.setPrice(-3);
    }

    @Test
    public void testSetBodyType() throws CarBodyTypeException {
        Car.BodyType expectedBodyType = Car.BodyType.HATCHBACK;

        car.setBodyType(Car.BodyType.HATCHBACK);
        Car.BodyType actualBodyType = car.getBodyType();

        Assert.assertEquals(expectedBodyType, actualBodyType);
    }

    @Test (expectedExceptions = CarBodyTypeException.class)
    public void testSetBodyTypeException() throws CarBodyTypeException {
        car.setBodyType(null);
    }

    @Test
    public void testSetSeatsNumber() throws SeatsNumberException {
        car.setSeatsNumber(3);
        int expectedSeatsNumber = 3;

        Assert.assertEquals(expectedSeatsNumber, car.getSeatsNumber());
    }

    @Test (expectedExceptions = SeatsNumberException.class)
    public void testSetSeatsNumberException() throws SeatsNumberException {
        car.setSeatsNumber(-2);
    }

    @Test
    public void testGetSeatsNumber() {
        int expected = 4;
        int actual = car.getSeatsNumber();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testEquals() {
        Assert.assertTrue(car.equals(expected));
    }

    @Test
    public void testHashCode() {
        Assert.assertEquals(expected.hashCode(), car.hashCode());
    }

    @Test
    public void testToString() {
        String expectedString = "Car {name = BMW, price = 66000, seatsNumber = 4, bodyType = SEDAN}";

        Assert.assertEquals(expectedString, expected.toString());
    }

}
