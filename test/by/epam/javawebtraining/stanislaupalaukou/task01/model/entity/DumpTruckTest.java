package by.epam.javawebtraining.stanislaupalaukou.task01.model.entity;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.*;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author Stanislau Palaukou on 17.03.2019
 * @project Task 01
 */

public class DumpTruckTest {
    private DumpTruck dumpTruck;
    private DumpTruck expected;

    @BeforeTest
    public void setUpDumpTruck()
            throws DumpTruckBodyTypeException, VehiclePriceException, CargoCapacityException, VehicleNameException {
        dumpTruck = new DumpTruck ("MAZ", 55_000, 20_000, DumpTruck.BodyType.CONSTRUCTION);
        expected = new DumpTruck ("MAZ", 55_000, 20_000, DumpTruck.BodyType.CONSTRUCTION);
    }

    @Test
    public void testDefaultConstructorDumpTruck() {
        DumpTruck actual = new DumpTruck();

        String expectedName = null;
        int expectedPrice = 0;
        int expectedCargoCapacity = 0;
        DumpTruck.BodyType expectedBodyType = null;

        Assert.assertEquals(expectedName, actual.getName());
        Assert.assertEquals(expectedPrice, actual.getPrice());
        Assert.assertEquals(expectedCargoCapacity, actual.getCargoCapacity());
        Assert.assertEquals(expectedBodyType, actual.getBodyType());
    }

    @Test
    public void testConstructorDumpTruck() {
        String expectedName = "MAZ";
        int expectedPrice = 55_000;
        int expectedCargoCapacity = 20_000;
        DumpTruck.BodyType expectedBodyType = DumpTruck.BodyType.CONSTRUCTION;

        String actualName = dumpTruck.getName();
        int actualPrice = dumpTruck.getPrice();
        int actualCargoCapacity = dumpTruck.getCargoCapacity();
        DumpTruck.BodyType actualBodyType = dumpTruck.getBodyType();

        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedPrice, actualPrice);
        Assert.assertEquals(expectedCargoCapacity, actualCargoCapacity);
        Assert.assertEquals(expectedBodyType, actualBodyType);
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

        Assert.assertEquals(expectedDumpTruck, dumpTruck);
    }

    @Test
    public void testSetBodyType() throws DumpTruckBodyTypeException {
        DumpTruck.BodyType expectedBodyType = DumpTruck.BodyType.GARBAGE;

        dumpTruck.setBodyType(DumpTruck.BodyType.GARBAGE);
        DumpTruck.BodyType actualBodyType = dumpTruck.getBodyType();

        Assert.assertEquals(expectedBodyType, actualBodyType);
    }

    @Test (expectedExceptions = DumpTruckBodyTypeException.class)
    public void testSetBodyTypeException() throws DumpTruckBodyTypeException {
        dumpTruck.setBodyType(null);
    }


    @Test
    public void testEquals() {
        Assert.assertTrue(dumpTruck.equals(expected));
    }

    @Test
    public void testHashCode() {
        Assert.assertEquals(expected.hashCode(), dumpTruck.hashCode());
    }

    @Test
    public void testToString() {
        String expectedString = "DumpTruck {name = MAZ, price = 55000, cargoCapacity = 20000, bodyType = CONSTRUCTION}";
        System.out.println(expected);

        Assert.assertEquals(expectedString, expected.toString());
    }

}
