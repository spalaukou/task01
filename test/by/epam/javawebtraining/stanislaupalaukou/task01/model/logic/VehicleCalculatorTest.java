package by.epam.javawebtraining.stanislaupalaukou.task01.model.logic;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.container.ArrayParking;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Car;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Truck;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Vehicle;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.*;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author Stanislau Palaukou on 24.02.2019
 * @project Task 01
 */

public class VehicleCalculatorTest {
    private ArrayParking parking1;
    private ArrayParking parking2;
    private ArrayParking parking3;

    @BeforeTest
    public void setUpParking()
            throws SeatsNumberException, VehiclePriceException, VehicleNameException, CarBodyTypeException,
            CargoCapacityException, TruckBodyTypeException, VehicleArrayException {
        Vehicle car1 = new Car("BMW", 66_000, 4, Car.BodyType.SEDAN);
        Vehicle car2 = new Car("Renault", 15_000, 4, Car.BodyType.SEDAN);
        Vehicle car3 = new Car("Volkswagen", 20_000, 4, Car.BodyType.COUPE);
        Vehicle car4 = new Car("Skoda", 18_000, 4, Car.BodyType.HATCHBACK);
        Vehicle truck = new Truck("Volvo", 80_000, 30_000, Truck.BodyType.CABOVER);

        Vehicle[] vehicles1 = {car1, car2, car3, car4, truck};
        Vehicle[] vehicles2 = {};

        parking1 = new ArrayParking(vehicles1);
        parking2 = new ArrayParking(vehicles2);
        parking3 = null;
    }

    @Test
    public void testTotalPrice() throws NullParkingException {
        int expected = 199_000;
        int actual = VehicleCalculator.totalPrice(parking1);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testTotalPriceParkingIsEmpty() throws NullParkingException {
        int expected = 0;
        int actual = VehicleCalculator.totalPrice(parking2);

        Assert.assertEquals(expected, actual);
    }

    @Test (expectedExceptions = NullParkingException.class)
    public void testTotalPriceParkingIsNullException() throws NullParkingException {
        VehicleCalculator.totalPrice(parking3);
    }

    @Test
    public void TestTotalSeats() throws NullParkingException {
        int expected = 16;
        int actual = VehicleCalculator.totalSeats(parking1);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void TestTotalSeatsParkingIsEmpty() throws NullParkingException {
        int expected = 0;
        int actual = VehicleCalculator.totalSeats(parking2);

        Assert.assertEquals(expected, actual);
    }

    @Test (expectedExceptions = NullParkingException.class)
    public void TestTotalSeatsParkingIsNullException() throws NullParkingException {
        VehicleCalculator.totalSeats(parking3);
    }
}
