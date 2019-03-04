package by.epam.javawebtraining.stanislaupalaukou.task01.model.logic;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.container.Parking;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Car;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Truck;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Vehicle;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author Stanislau Palaukou on 24.02.2019
 * @project Task 01
 */

public class VehicleCalculatorTest {
    private Parking parking1;
    private Parking parking2;
    private Parking parking3;

    @BeforeTest
    public void setUpParking() {
        Vehicle car1 = new Car("BMW", 66_000, 4, Car.BodyType.SEDAN);
        Vehicle car2 = new Car("Renault", 15_000, 4, Car.BodyType.SEDAN);
        Vehicle car3 = new Car("Volkswagen", 20_000, 4, Car.BodyType.COUPE);
        Vehicle car4 = new Car("Skoda", 18_000, 4, Car.BodyType.HATCHBACK);
        Vehicle truck = new Truck("Volvo", 80_000, 30_000, Truck.BodyType.CABOVER);

        Vehicle[] vehicles1 = {car1, car2, car3, car4, truck};
        Vehicle[] vehicles2 = {};

        parking1 = new Parking(vehicles1);
        parking2 = new Parking(vehicles2);
        parking3 = null;
    }

    @Test
    public void testTotalPrice() {
        int expected = 199_000;
        int actual = VehicleCalculator.totalPrice(parking1);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testTotalPriceParkingIsEmpty() {
        int expected = 0;
        int actual = VehicleCalculator.totalPrice(parking2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testTotalPriceParkingIsNull() {
        int expected = 0;
        int actual = VehicleCalculator.totalPrice(parking3);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void TestTotalSeats() {
        int expected = 16;
        int actual = VehicleCalculator.totalSeats(parking1);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void TestTotalSeatsParkingIsEmpty() {
        int expected = 0;
        int actual = VehicleCalculator.totalSeats(parking2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void TestTotalSeatsParkingIsNull() {
        int expected = 0;
        int actual = VehicleCalculator.totalSeats(parking3);

        Assert.assertEquals(expected, actual);
    }
}
