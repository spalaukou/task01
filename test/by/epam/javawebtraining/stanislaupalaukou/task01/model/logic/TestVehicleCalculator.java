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

public class TestVehicleCalculator {
    private Parking parking1;
    private Parking parking2;
    private Parking parking3;

    @BeforeTest
    public void setParking() {
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
        int expected1 = 199_000;
        int actual1 = VehicleCalculator.totalPrice(parking1);

        int expected2 = 0;
        int actual2 = VehicleCalculator.totalPrice(parking2);

        int expected3 = 0;
        int actual3 = VehicleCalculator.totalPrice(parking3);

        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
        Assert.assertEquals(expected3, actual3);
    }

    @Test
    public void TestTotalSeats() {
        int expected1 = 16;
        int actual1 = VehicleCalculator.totalSeats(parking1);

        int expected2 = 0;
        int actual2 = VehicleCalculator.totalSeats(parking2);

        int expected3 = 0;
        int actual3 = VehicleCalculator.totalSeats(parking3);

        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
        Assert.assertEquals(expected3, actual3);
    }
}
