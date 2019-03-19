package by.epam.javawebtraining.stanislaupalaukou.task01.model.entity;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * @author Stanislau Palaukou on 24.02.2019
 * @project Task 01
 */

public class TruckTest {
    private Truck truck;
    private Truck expected;
    private Truck actual;

    @BeforeTest
    public void setUpTruck()
            throws TruckBodyTypeException, VehiclePriceException, CargoCapacityException, VehicleNameException {
        truck = new Truck ("Volvo", 80_000, 30_000, Truck.BodyType.CABOVER);
        expected = new Truck ("Volvo", 80_000, 30_000, Truck.BodyType.CABOVER);
        actual = new Truck();
    }

    @Test
    public void testDefaultConstructorNameTruck() {
        String expectedName = null;

        assertEquals(expectedName, actual.getName());
    }

    @Test
    public void testDefaultConstructorPriceTruck() {
        int expectedPrice = 0;

        assertEquals(expectedPrice, actual.getPrice());
    }

    @Test
    public void testDefaultConstructorCargoTruck() {
        int expectedCargoCapacity = 0;

        assertEquals(expectedCargoCapacity, actual.getCargoCapacity());
    }

    @Test
    public void testDefaultConstructorBodyTruck() {
        Truck.BodyType expectedBodyType = null;

        assertEquals(expectedBodyType, actual.getBodyType());
    }

    @Test
    public void testConstructorNameTruck() {
        String expectedName = "Volvo";
        String actualName = truck.getName();

        assertEquals(expectedName, actualName);
    }

    @Test
    public void testConstructorPriceTruck() {
        int expectedPrice = 80000;
        int actualPrice = truck.getPrice();

        assertEquals(expectedPrice, actualPrice);
    }

    @Test
    public void testConstructorCargoTruck() {
        int expectedCargoCapacity = 30000;
        int actualCargoCapacity = truck.getCargoCapacity();

        assertEquals(expectedCargoCapacity, actualCargoCapacity);
    }

    @Test
    public void testConstructorBodyTruck() {
        Truck.BodyType expectedBodyType = Truck.BodyType.CABOVER;
        Truck.BodyType actualBodyType = truck.getBodyType();

        assertEquals(expectedBodyType, actualBodyType);
    }

    @Test (expectedExceptions = TruckBodyTypeException.class)
    public void testConstructorTruckException()
            throws CargoCapacityException, VehiclePriceException, VehicleNameException, TruckBodyTypeException {
        new Truck ("Volvo", 80_000, 30_000,null);
    }


    @Test (expectedExceptions = CargoCapacityException.class)
    public void testConstructorCarSeatsException()
            throws VehiclePriceException, VehicleNameException, CargoCapacityException, TruckBodyTypeException {
        new Truck ("Volvo", 80_000, 0, Truck.BodyType.CABOVER);
    }

    @Test (expectedExceptions = VehicleNameException.class)
    public void testConstructorCarNameException()
            throws VehiclePriceException, VehicleNameException, CargoCapacityException, TruckBodyTypeException {
        new Truck (null, 80_000, 30_000, Truck.BodyType.CABOVER);
    }

    @Test (expectedExceptions = VehiclePriceException.class)
    public void testConstructorCarPriceException()
            throws VehiclePriceException, VehicleNameException, CargoCapacityException, TruckBodyTypeException {
        new Truck ("Volvo", 0, 30_000, Truck.BodyType.CABOVER);
    }

    @Test
    public void testCopyConstructorTruck()
            throws VehiclePriceException, VehicleNameException, CargoCapacityException, TruckBodyTypeException {
        Truck expectedTruck = new Truck(truck);

        assertEquals(expectedTruck, truck);
    }

    @Test
    public void testSetBodyType() throws TruckBodyTypeException {
        Truck.BodyType expectedBodyType = Truck.BodyType.SLEEPER;

        truck.setBodyType(Truck.BodyType.SLEEPER);
        Truck.BodyType actualBodyType = truck.getBodyType();

        assertEquals(expectedBodyType, actualBodyType);
    }

    @Test (expectedExceptions = TruckBodyTypeException.class)
    public void testSetBodyTypeException() throws TruckBodyTypeException {
        truck.setBodyType(null);
    }

    @Test
    public void testSetCargoCapacity() throws CargoCapacityException {
        truck.setCargoCapacity(1_000);
        int expectedCargoCapacity = 1_000;

        assertEquals(expectedCargoCapacity, truck.getCargoCapacity());
    }

    @Test (expectedExceptions = CargoCapacityException.class)
    public void testSetCargoCapacityException() throws CargoCapacityException {
        truck.setCargoCapacity(-1);
    }

    @Test
    public void testEquals() {
        assertTrue(truck.equals(expected));
    }

    @Test
    public void testHashCode() {
        assertEquals(expected.hashCode(), truck.hashCode());
    }

    @Test
    public void testToString() {
        String expectedString = "Truck {name = Volvo, price = 80000, cargoCapacity = 30000, bodyType = CABOVER}";

        assertEquals(expectedString, expected.toString());
    }

}
