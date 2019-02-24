package by.epam.javawebtraining.stanislaupalaukou.model.entity;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Car;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author Stanislau Palaukou on 24.02.2019
 * @project Task 01
 */

public class TestCar {
    private Car car;

    @BeforeTest
    public void setCar() {
        car = new Car ("BMW", 66_000, 4, Car.BodyType.SEDAN);
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

    @Test
    public void testSetBodyType() {
        Car.BodyType expectedBodyType = Car.BodyType.HATCHBACK;

        car.setBodyType(Car.BodyType.HATCHBACK);
        Car.BodyType actualBodyType = car.getBodyType();

        Assert.assertEquals(expectedBodyType, actualBodyType);
    }
}
