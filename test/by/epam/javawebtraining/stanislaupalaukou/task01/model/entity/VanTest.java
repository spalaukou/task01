package by.epam.javawebtraining.stanislaupalaukou.task01.model.entity;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.*;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author Stanislau Palaukou on 17.03.2019
 * @project Task 01
 */

public class VanTest {
    private Van van;
    private Van expected;

    @BeforeTest
    public void setUpVan()
            throws VanBodyTypeException, VehiclePriceException, CargoCapacityException, VehicleNameException {
        van = new Van ("Iveco", 40_000, 3_500, Van.BodyType.BOX);
        expected = new Van ("Iveco", 40_000, 3_500, Van.BodyType.BOX);
    }

    @Test
    public void testDefaultConstructorVan() {
        Van actual = new Van();

        String expectedName = null;
        int expectedPrice = 0;
        int expectedCargoCapacity = 0;
        Truck.BodyType expectedBodyType = null;

        Assert.assertEquals(expectedName, actual.getName());
        Assert.assertEquals(expectedPrice, actual.getPrice());
        Assert.assertEquals(expectedCargoCapacity, actual.getCargoCapacity());
        Assert.assertEquals(expectedBodyType, actual.getBodyType());
    }

    @Test
    public void testConstructorVan() {
        String expectedName = "Iveco";
        int expectedPrice = 40_000;
        int expectedCargoCapacity = 3_500;
        Van.BodyType expectedBodyType = Van.BodyType.BOX;

        String actualName = van.getName();
        int actualPrice = van.getPrice();
        int actualCargoCapacity = van.getCargoCapacity();
        Van.BodyType actualBodyType = van.getBodyType();

        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedPrice, actualPrice);
        Assert.assertEquals(expectedCargoCapacity, actualCargoCapacity);
        Assert.assertEquals(expectedBodyType, actualBodyType);
    }

    @Test (expectedExceptions = VanBodyTypeException.class)
    public void testConstructorVanException()
            throws CargoCapacityException, VehiclePriceException, VehicleNameException, VanBodyTypeException {
        new Van ("Iveco", 40_000, 3_500, null);
    }

    @Test
    public void testCopyConstructorVan()
            throws VehiclePriceException, VehicleNameException, CargoCapacityException, VanBodyTypeException {
        Van expectedVan = new Van(van);

        Assert.assertEquals(expectedVan, van);
    }

    @Test
    public void testSetBodyType() throws VanBodyTypeException {
        Van.BodyType expectedBodyType = Van.BodyType.MULTISTOP;

        van.setBodyType(Van.BodyType.MULTISTOP);
        Van.BodyType actualBodyType = van.getBodyType();

        Assert.assertEquals(expectedBodyType, actualBodyType);
    }

    @Test (expectedExceptions = VanBodyTypeException.class)
    public void testSetBodyTypeException() throws VanBodyTypeException {
        van.setBodyType(null);
    }


    @Test
    public void testEquals() {
        Assert.assertTrue(van.equals(expected));
    }

    @Test
    public void testHashCode() {
        Assert.assertEquals(expected.hashCode(), van.hashCode());
    }

    @Test
    public void testToString() {
        String expectedString = "Van {name = Iveco, price = 40000, cargoCapacity = 3500, bodyType = BOX}";
        System.out.println(expected);

        Assert.assertEquals(expectedString, expected.toString());
    }

}
