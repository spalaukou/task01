package by.epam.javawebtraining.stanislaupalaukou.task01.model.entity;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * @author Stanislau Palaukou on 17.03.2019
 * @project Task 01
 */

public class DumpTruckTest {
    private DumpTruck dumpTruck;
    private DumpTruck expected;
    private DumpTruck actual;

    @BeforeTest
    public void setUpDumpTruck()
            throws DumpTruckBodyTypeException, VehiclePriceException, CargoCapacityException, VehicleNameException {
        dumpTruck = new DumpTruck ("MAZ", 55_000, 20_000, DumpTruck.BodyType.CONSTRUCTION);
        expected = new DumpTruck ("MAZ", 55_000, 20_000, DumpTruck.BodyType.CONSTRUCTION);
        actual = new DumpTruck();
    }

    @Test
    public void testDefaultConstructorNameDumpTruck() {
        String expectedName = null;

        assertEquals(expectedName, actual.getName());
    }

    @Test
    public void testDefaultConstructorPriceDumpTruck() {
        int expectedPrice = 0;

        assertEquals(expectedPrice, actual.getPrice());
    }

    @Test
    public void testDefaultConstructorCargoDumpTruck() {
        int expectedCargoCapacity = 0;

        assertEquals(expectedCargoCapacity, actual.getCargoCapacity());
    }

    @Test
    public void testDefaultConstructorBodyDumpTruck() {
        DumpTruck.BodyType expectedBodyType = null;

        assertEquals(expectedBodyType, actual.getBodyType());
    }

    @Test
    public void testConstructorNameDumpTruck() {
        String expectedName = "MAZ";
        String actualName = dumpTruck.getName();

        assertEquals(expectedName, actualName);
    }

    @Test
    public void testConstructorPriceDumpTruck() {
        int expectedPrice = 55_000;
        int actualPrice = dumpTruck.getPrice();

        assertEquals(expectedPrice, actualPrice);
    }

    @Test
    public void testConstructorCargoDumpTruck() {
        int expectedCargoCapacity = 20_000;
        int actualCargoCapacity = dumpTruck.getCargoCapacity();

        assertEquals(expectedCargoCapacity, actualCargoCapacity);
    }

    @Test
    public void testConstructorBodyDumpTruck() {
        DumpTruck.BodyType expectedBodyType = DumpTruck.BodyType.CONSTRUCTION;
        DumpTruck.BodyType actualBodyType = dumpTruck.getBodyType();

        assertEquals(expectedBodyType, actualBodyType);
    }

    @Test (expectedExceptions = DumpTruckBodyTypeException.class)
    public void testConstructorDumpTruckException()
            throws CargoCapacityException, VehiclePriceException, VehicleNameException, DumpTruckBodyTypeException {
        new DumpTruck ("MAZ", 55_000, 20_000,null);
    }

    @Test
    public void testCopyConstructorCar()
            throws VehiclePriceException, VehicleNameException, CargoCapacityException, DumpTruckBodyTypeException {
        DumpTruck expectedDumpTruck = new DumpTruck(dumpTruck);

        assertEquals(expectedDumpTruck, dumpTruck);
    }

    @Test
    public void testSetBodyType() throws DumpTruckBodyTypeException {
        DumpTruck.BodyType expectedBodyType = DumpTruck.BodyType.GARBAGE;

        dumpTruck.setBodyType(DumpTruck.BodyType.GARBAGE);
        DumpTruck.BodyType actualBodyType = dumpTruck.getBodyType();

        assertEquals(expectedBodyType, actualBodyType);
    }

    @Test (expectedExceptions = DumpTruckBodyTypeException.class)
    public void testSetBodyTypeException() throws DumpTruckBodyTypeException {
        dumpTruck.setBodyType(null);
    }


    @Test
    public void testEquals() {
        assertTrue(dumpTruck.equals(expected));
    }

    @Test
    public void testHashCode() {
        assertEquals(expected.hashCode(), dumpTruck.hashCode());
    }

    @Test
    public void testToString() {
        String expectedString = "DumpTruck {name = MAZ, price = 55000, cargoCapacity = 20000, bodyType = CONSTRUCTION}";

        assertEquals(expectedString, expected.toString());
    }

}
