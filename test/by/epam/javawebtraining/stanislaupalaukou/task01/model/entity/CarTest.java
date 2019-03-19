package by.epam.javawebtraining.stanislaupalaukou.task01.model.entity;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * @author Stanislau Palaukou on 24.02.2019
 * @project Task 01
 */

public class CarTest {
    private Car car;
    private Car expected;
    private Car actual;

    @BeforeTest
    public void setUpCar()
            throws SeatsNumberException, VehiclePriceException, VehicleNameException, CarBodyTypeException {
        car = new Car ("BMW", 66_000, 4, Car.BodyType.SEDAN);
        expected = new Car ("BMW", 66_000, 4, Car.BodyType.SEDAN);
        actual = new Car();
    }

    @Test
    public void testDefaultConstructorNameCar() {
        String expectedName = null;

        assertEquals(expectedName, actual.getName());
    }

    @Test
    public void testDefaultConstructorPriceCar() {
        int expectedPrice = 0;

        assertEquals(expectedPrice, actual.getPrice());
    }

    @Test
    public void testDefaultConstructorSeatsCar() {
        int expectedSeatsNumber = 0;

        assertEquals(expectedSeatsNumber, actual.getSeatsNumber());
    }

    @Test
    public void testDefaultConstructorBodyCar() {
        Car.BodyType expectedBodyType = null;

        assertEquals(expectedBodyType, actual.getBodyType());
    }

    @Test
    public void testConstructorNameCar() {
        String expectedName = "BMW";
        String actualName = car.getName();

        assertEquals(expectedName, actualName);
    }

    @Test
    public void testConstructorPriceCar() {
        int expectedPrice = 66000;
        int actualPrice = car.getPrice();

        assertEquals(expectedPrice, actualPrice);
    }

    @Test
    public void testConstructorSeatsCar() {
        int expectedSeatsNumber = 4;
        int actualSeatsNumber = car.getSeatsNumber();

        assertEquals(expectedSeatsNumber, actualSeatsNumber);
    }

    @Test
    public void testConstructorBodyCar() {
        Car.BodyType expectedBodyType = Car.BodyType.SEDAN;
        Car.BodyType actualBodyType = car.getBodyType();

        assertEquals(expectedBodyType, actualBodyType);
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

        assertEquals(expectedCar, car);
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

        assertEquals(expectedName, car.getName());
    }

    @Test (expectedExceptions = VehicleNameException.class)
    public void testSetNameException() throws VehicleNameException {
        car.setName(null);
    }

    @Test
    public void testSetPrice() throws VehiclePriceException {
        int expectedPrice = 12_000;
        car.setPrice(12_000);

        assertEquals(expectedPrice, car.getPrice());
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

        assertEquals(expectedBodyType, actualBodyType);
    }

    @Test (expectedExceptions = CarBodyTypeException.class)
    public void testSetBodyTypeException() throws CarBodyTypeException {
        car.setBodyType(null);
    }

    @Test
    public void testSetSeatsNumber() throws SeatsNumberException {
        car.setSeatsNumber(3);
        int expectedSeatsNumber = 3;

        assertEquals(expectedSeatsNumber, car.getSeatsNumber());
    }

    @Test (expectedExceptions = SeatsNumberException.class)
    public void testSetSeatsNumberException() throws SeatsNumberException {
        car.setSeatsNumber(-2);
    }

    @Test
    public void testGetSeatsNumber() {
        int expected = 4;
        int actual = car.getSeatsNumber();

        assertEquals(expected, actual);
    }

    @Test
    public void testEquals() {
        assertTrue(car.equals(expected));
    }

    @Test
    public void testHashCode() {
        assertEquals(expected.hashCode(), car.hashCode());
    }

    @Test
    public void testToString() {
        String expectedString = "Car {name = BMW, price = 66000, seatsNumber = 4, bodyType = SEDAN}";

        assertEquals(expectedString, expected.toString());
    }

}
