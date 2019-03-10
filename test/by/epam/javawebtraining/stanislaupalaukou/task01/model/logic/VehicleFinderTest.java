package by.epam.javawebtraining.stanislaupalaukou.task01.model.logic;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.container.Parking;
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

public class VehicleFinderTest {
    private Parking parking1;
    private Parking parking2;
    private Parking parking3;
    private Vehicle car1;
    private Vehicle car2;
    private Vehicle car3;
    private Vehicle car4;
    private Vehicle truck;

    @BeforeTest
    public void setUpParking() throws VehiclePriceException, VehicleNameException,
            SeatsNumberException, CarBodyTypeException,
            CargoCapacityException, TruckBodyTypeException {
        car1 = new Car("BMW", 66_000, 4, Car.BodyType.SEDAN);
        car2 = new Car("Renault", 15_000, 4, Car.BodyType.SEDAN);
        car3 = new Car("Volkswagen", 20_000, 4, Car.BodyType.COUPE);
        car4 = new Car("Skoda", 18_000, 4, Car.BodyType.HATCHBACK);
        truck = new Truck("Volvo", 80_000, 30_000, Truck.BodyType.CABOVER);

        Vehicle[] vehicles1 = {car1, car2, car3, car4, truck};
        Vehicle[] vehicles2 = {};

        parking1 = new Parking(vehicles1);
        parking2 = new Parking(vehicles2);
        parking3 = null;
    }

    @Test
    public void testFindTheCheapestVehicle() throws NullParkingException {
        Vehicle expected = car2;
        Vehicle actual = VehicleFinder.findTheCheapestVehicle(parking1);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindTheCheapestVehicleParkingIsEmpty() throws NullParkingException {
        Vehicle expected = null;
        Vehicle actual = VehicleFinder.findTheCheapestVehicle(parking2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindTheCheapestVehicleParkingIsNull() throws NullParkingException {
        Vehicle expected = null;
        Vehicle actual = VehicleFinder.findTheCheapestVehicle(parking3);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindTheDearestVehicle() throws NullParkingException {
        Vehicle expected = truck;
        Vehicle actual = VehicleFinder.findTheDearestVehicle(parking1);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindTheDearestVehicleParkingIsEmpty() throws NullParkingException {
        Vehicle expected = null;
        Vehicle actual = VehicleFinder.findTheDearestVehicle(parking2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindTheDearestVehicleParkingIsNull() throws NullParkingException {
        Vehicle expected = null;
        Vehicle actual = VehicleFinder.findTheDearestVehicle(parking3);

        Assert.assertEquals(expected, actual);
    }
}
