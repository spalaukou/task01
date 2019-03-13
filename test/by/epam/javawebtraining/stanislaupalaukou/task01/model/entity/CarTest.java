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

    @BeforeTest
    public void setUpCar()
            throws SeatsNumberException, VehiclePriceException, VehicleNameException, CarBodyTypeException {
        car = new Car ("BMW", 66_000, 4, Car.BodyType.SEDAN);
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

    @Test
    public void testCopyConstructorCar() throws SeatsNumberException, VehiclePriceException, VehicleNameException, CarBodyTypeException {
        Car expectedCar = new Car(car);

        Assert.assertEquals(expectedCar, car);
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


}
