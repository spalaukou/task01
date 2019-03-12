package by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.container;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Car;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Vehicle;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author Stanislau Palaukou on 24.02.2019
 * @project Task 01
 */

public class ParkingTest {
    private Vehicle car1;
    private Vehicle car2;
    private Vehicle car3;

    private Vehicle[] vehicles1;
    private Vehicle[] vehicles2;

    private Parking parking1;

    @BeforeTest
    public void setUpVehicles()
            throws SeatsNumberException, VehiclePriceException, VehicleNameException, CarBodyTypeException, VehicleArrayException {
        car1 = new Car("BMW", 66_000, 4, Car.BodyType.SEDAN);
        car2 = new Car("Renault", 15_000, 4, Car.BodyType.SEDAN);
        car3 = new Car("Volkswagen", 20_000, 4, Car.BodyType.COUPE);

        vehicles1 = new Vehicle[]{car1, car2};
        vehicles2 = new Vehicle[]{car1, car2, car3};

        parking1 = new Parking(vehicles1);
    }

    @Test
    public void testConstructor() throws VehicleArrayException {
        Parking parking2 = new Parking((Vehicle[]) null);

        Vehicle[] expected1 = vehicles1;
        Vehicle[] actual1 = parking1.getVehicles();

        Vehicle[] expected2 = null;
        Vehicle[] actual2 = parking2.getVehicles();

        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
    }

    @Test
    public void testDefaultConstructor() throws VehicleArrayException {
        Parking actual = new Parking();
        Parking expected = new Parking(new Vehicle[0]);

        assertEquals(expected, actual);
    }

    @Test
    public void testGetVehicles() throws VehicleArrayException {
        Vehicle[] expected = vehicles1;

        Parking parking = new Parking(vehicles1);
        Vehicle[] actual = parking.getVehicles();

        assertEquals(expected, actual);
    }

    @Test
    public void testSetVehicles() throws NullParkingException {
        Parking actualParking = new Parking();
        Vehicle[] expected = vehicles1;
        actualParking.setVehicles(vehicles1);
        Vehicle[] actual = actualParking.getVehicles();

        assertEquals(expected, actual);
    }

    @Test
    public void testAddVehicle() throws NullVehicleException, VehicleArrayException {
        Parking expected = new Parking(vehicles2);
        Parking actual = new Parking(vehicles1);

        actual.addVehicle(car3);

        assertEquals(expected, actual);
    }

    @Test
    public void testRemoveVehicle() throws VehicleArrayException {
        Parking expected = new Parking(vehicles1);
        Parking actual = new Parking(vehicles2);

        actual.removeVehicle(car3);

        assertEquals(expected, actual);
    }

    @Test
    public void testRemoveVehicleVehicleNotFoundException() {
        Parking actual = null;
        try {
            actual = new Parking(vehicles1);
        } catch (VehicleArrayException e) {
            e.printStackTrace();
        }
        actual.removeVehicle(car3);
    }

    @Test
    public void testRemoveParkingIsEmptyException() throws VehicleArrayException {
        Parking actual = new Parking(vehicles1);
        actual.removeVehicle(car3);
        actual.removeVehicle(car2);
        actual.removeVehicle(car1);
        actual.removeVehicle(car1);
    }

    /*@Test
    public void testIsOnPlace() {
        boolean actual1 = parking1.isOnPlace(car1);
        boolean actual2 = parking1.isOnPlace(car3);
        boolean actual3 = parking1.isOnPlace(null);

        Assert.assertTrue(actual1);
        Assert.assertFalse(actual2);
        Assert.assertFalse(actual3);
    }*/
}
