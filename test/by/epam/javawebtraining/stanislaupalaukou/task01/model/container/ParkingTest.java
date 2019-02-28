package by.epam.javawebtraining.stanislaupalaukou.task01.model.container;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Car;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Vehicle;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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
    public void setupVehicles() {
        car1 = new Car("BMW", 66_000, 4, Car.BodyType.SEDAN);
        car2 = new Car("Renault", 15_000, 4, Car.BodyType.SEDAN);
        car3 = new Car("Volkswagen", 20_000, 4, Car.BodyType.COUPE);

        vehicles1 = new Vehicle[]{car1, car2};
        vehicles2 = new Vehicle[]{car1, car2, car3};

        parking1 = new Parking(vehicles1);
    }

    @Test
    public void testConstructorParking() {
        Parking parking2 = new Parking(null);

        Vehicle[] expected1 = vehicles1;
        Vehicle[] actual1 = parking1.getVehicles();

        Vehicle[] expected2 = null;
        Vehicle[] actual2 = parking2.getVehicles();

        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
    }

    @Test
    public void testGetVehicles() {
        Vehicle[] expected = vehicles1;

        Parking parking = new Parking(vehicles1);
        Vehicle[] actual = parking.getVehicles();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAddVehicle() {
        Parking expected = new Parking(vehicles2);
        Parking actual = new Parking(vehicles1);

        actual.addVehicle(car3);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testRemoveVehicle() {
        Parking expected1 = new Parking(vehicles1);
        Parking actual = new Parking(vehicles2);

        actual.removeVehicle(car3);

        Assert.assertEquals(expected1, actual);
    }

    @Test
    public void testIsOnPlace() {
        boolean actual1 = parking1.isOnPlace(car1);
        boolean actual2 = parking1.isOnPlace(car3);
        boolean actual3 = parking1.isOnPlace(null);

        Assert.assertTrue(actual1);
        Assert.assertFalse(actual2);
        Assert.assertFalse(actual3);
    }
}
