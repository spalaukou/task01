package by.epam.javawebtraining.stanislaupalaukou.task01.model.logic;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.container.ArrayParking;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Car;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Truck;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Vehicle;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.*;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author Stanislau Palaukou on 24.02.2019
 * @project Task 01
 */

public class VehicleFinderTest {
    private ArrayParking parking1;
    private ArrayParking parking2;
    private Vehicle car1;
    private Vehicle car2;
    private Vehicle car3;
    private Vehicle car4;
    private Vehicle truck;

    @BeforeTest
    public void setUpParking() throws VehiclePriceException, VehicleNameException,
            SeatsNumberException, CarBodyTypeException,
            CargoCapacityException, TruckBodyTypeException, VehicleArrayException {
        car1 = new Car("BMW", 66_000, 4, Car.BodyType.SEDAN);
        car2 = new Car("Renault", 15_000, 4, Car.BodyType.SEDAN);
        car3 = new Car("Volkswagen", 20_000, 4, Car.BodyType.COUPE);
        car4 = new Car("Skoda", 18_000, 4, Car.BodyType.HATCHBACK);
        truck = new Truck("Volvo", 80_000, 30_000, Truck.BodyType.CABOVER);

        Vehicle[] vehicles1 = {car1, car2, car3, car4, truck};
        Vehicle[] vehicles2 = {};

        parking1 = new ArrayParking(vehicles1);
        parking2 = new ArrayParking(vehicles2);
    }

    @Test
    public void testFindTheCheapestVehicle() throws NullParkingException, VehicleArrayException {
        Vehicle expected = car2;
        Vehicle actual = VehicleFinder.findTheCheapestVehicle(parking1);

        assertEquals(expected, actual);
    }

    @Test (expectedExceptions = NullParkingException.class)
    public void testFindTheCheapestVehicleNullParkingException() throws NullParkingException, VehicleArrayException {
        VehicleFinder.findTheCheapestVehicle(null);
    }

    @Test (expectedExceptions = VehicleArrayException.class)
    public void testFindTheCheapestVehicleArrayException() throws NullParkingException, VehicleArrayException {
        VehicleFinder.findTheCheapestVehicle(parking2);
    }

    @Test
    public void testFindTheDearestVehicle() throws NullParkingException, VehicleArrayException {
        Vehicle expected = truck;
        Vehicle actual = VehicleFinder.findTheDearestVehicle(parking1);

        assertEquals(expected, actual);
    }

    @Test (expectedExceptions = NullParkingException.class)
    public void testFindTheDearestVehicleNullParkingException() throws NullParkingException, VehicleArrayException {
        VehicleFinder.findTheDearestVehicle(null);
    }

    @Test (expectedExceptions = VehicleArrayException.class)
    public void testFindTheDearestVehicleArrayException() throws NullParkingException, VehicleArrayException {
        VehicleFinder.findTheDearestVehicle(parking2);
    }

}
