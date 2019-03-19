package by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.container;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Car;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Vehicle;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.*;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author Stanislau Palaukou on 24.02.2019
 * @project Task 01
 */

public class ArrayParkingTest {
    private Vehicle car1;
    private Vehicle car2;
    private Vehicle car3;

    private Vehicle[] vehicles;
    private Vehicle[] vehicles1;
    private Vehicle[] vehicles2;
    private Vehicle[] vehicles3;

    private ArrayParking parking;
    private ArrayParking parking1;
    private ArrayParking parking2;

    @BeforeTest
    public void setUpVehicles()
            throws SeatsNumberException, VehiclePriceException,
            VehicleNameException, CarBodyTypeException, VehicleArrayException {

        car1 = new Car("BMW", 66_000, 4, Car.BodyType.SEDAN);
        car2 = new Car("Renault", 15_000, 4, Car.BodyType.SEDAN);
        car3 = new Car("Volkswagen", 20_000, 4, Car.BodyType.COUPE);

        vehicles = null;
        vehicles1 = new Vehicle[0];
        vehicles2 = new Vehicle[]{car1, car2};
        vehicles3 = new Vehicle[]{car1, car2, car3};

        parking = null;
        parking1 = new ArrayParking();
        parking2 = new ArrayParking(vehicles2);
    }

    @Test
    public void testDefaultConstructor() {
        ArrayParking actual = new ArrayParking();
        ArrayParking expected = parking1;

        assertEquals(expected, actual);
    }

    @Test
    public void testConstructor() throws VehicleArrayException {
        ArrayParking expected = parking2;
        ArrayParking actual = new ArrayParking(new Vehicle[]{car1, car2});

        assertEquals(expected, actual);
    }

    @Test (expectedExceptions = VehicleArrayException.class)
    public void testConstructorException() throws VehicleArrayException {
        new ArrayParking(vehicles);
    }

    @Test
    public void testCopyConstructor() throws NullParkingException {
        ArrayParking expected = parking2;
        ArrayParking actual = new ArrayParking(expected);

        assertEquals(expected, actual);
    }

    @Test (expectedExceptions = NullParkingException.class)
    public void testCopyConstructorException() throws NullParkingException {
        new ArrayParking(parking);
    }

    @Test
    public void testGetVehicles() throws VehicleArrayException {
        Vehicle[] expected = vehicles1;

        ArrayParking parking = new ArrayParking(vehicles1);
        Vehicle[] actual = parking.getVehicles();

        assertEquals(expected, actual);
    }

    @Test
    public void testSetVehicles() throws NullParkingException {
        ArrayParking actualParking = new ArrayParking();
        Vehicle[] expected = vehicles1;
        actualParking.setVehicles(vehicles1);
        Vehicle[] actual = actualParking.getVehicles();

        assertEquals(expected, actual);
    }

    @Test (expectedExceptions = NullParkingException.class)
    public void testSetVehiclesException() throws NullParkingException {
        ArrayParking parking = new ArrayParking();
        parking.setVehicles(vehicles);
    }

    @Test
    public void testAddVehicle() throws NullVehicleException, VehicleArrayException {
        ArrayParking expected = new ArrayParking(vehicles3);
        ArrayParking actual = new ArrayParking(vehicles2);

        actual.addVehicle(car3);

        assertEquals(expected, actual);
    }

    @Test (expectedExceptions = NullVehicleException.class)
    public void testAddVehicleException() throws NullVehicleException {
        ArrayParking parking = new ArrayParking();

        parking.addVehicle(null);
    }

    @Test
    public void testRemoveVehicle() throws VehicleArrayException {
        ArrayParking expected = new ArrayParking(vehicles2);
        ArrayParking actual = new ArrayParking(vehicles3);

        actual.removeVehicle(car3);

        assertEquals(expected, actual);
    }

    @Test
    public void testRemoveVehicleNotFoundException() {
        parking2.removeVehicle(car3);
    }

    @Test
    public void testRemoveParkingIsEmptyException() throws VehicleArrayException {
        ArrayParking actual = new ArrayParking(vehicles1);
        actual.removeVehicle(car3);
        actual.removeVehicle(car2);
        actual.removeVehicle(car1);
        actual.removeVehicle(car1);
    }

}
