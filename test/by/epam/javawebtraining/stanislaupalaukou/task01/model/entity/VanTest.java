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

public class VanTest {
    private Van van;
    private Van expected;
    private Van actual;

    @BeforeTest
    public void setUpVan() {
        try {
            van = new Van("Iveco", 40_000, 3_500, Van.BodyType.BOX);
            expected = new Van("Iveco", 40_000, 3_500, Van.BodyType.BOX);
            actual = new Van();
        } catch (LogicalException e) {

        }
    }

    @Test
    public void testDefaultConstructorNameVan() {
        String expectedName = null;

        assertEquals(expectedName, actual.getName());
    }

    @Test
    public void testDefaultConstructorPriceVan() {
        int expectedPrice = 0;

        assertEquals(expectedPrice, actual.getPrice());
    }

    @Test
    public void testDefaultConstructorCargoVan() {
        int expectedCargoCapacity = 0;

        assertEquals(expectedCargoCapacity, actual.getCargoCapacity());
    }

    @Test
    public void testDefaultConstructorBodyVan() {
        Truck.BodyType expectedBodyType = null;

        assertEquals(expectedBodyType, actual.getBodyType());
    }

    @Test
    public void testConstructorNameVan() {
        String expectedName = "Iveco";
        String actualName = van.getName();

        assertEquals(expectedName, actualName);
    }

    @Test
    public void testConstructorPriceVan() {
        int expectedPrice = 40_000;
        int actualPrice = van.getPrice();

        assertEquals(expectedPrice, actualPrice);
    }

    @Test
    public void testConstructorCargoVan() {
        int expectedCargoCapacity = 3_500;
        int actualCargoCapacity = van.getCargoCapacity();

        assertEquals(expectedCargoCapacity, actualCargoCapacity);
    }

    @Test
    public void testConstructorBodyVan() {
        Van.BodyType expectedBodyType = Van.BodyType.BOX;
        Van.BodyType actualBodyType = van.getBodyType();

        assertEquals(expectedBodyType, actualBodyType);
    }

    @Test (expectedExceptions = VanBodyTypeException.class)
    public void testConstructorVanException() throws LogicalException {
        new Van ("Iveco", 40_000, 3_500, null);
    }

    @Test
    public void testCopyConstructorVan()
            throws VehiclePriceException, VehicleNameException, CargoCapacityException, VanBodyTypeException {
        Van expectedVan = new Van(van);

        assertEquals(expectedVan, van);
    }

    @Test
    public void testSetBodyType() throws VanBodyTypeException {
        Van.BodyType expectedBodyType = Van.BodyType.MULTISTOP;

        van.setBodyType(Van.BodyType.MULTISTOP);
        Van.BodyType actualBodyType = van.getBodyType();

        assertEquals(expectedBodyType, actualBodyType);
    }

    @Test (expectedExceptions = VanBodyTypeException.class)
    public void testSetBodyTypeException() throws VanBodyTypeException {
        van.setBodyType(null);
    }


    @Test
    public void testEquals() {
        assertTrue(van.equals(expected));
    }

    @Test
    public void testHashCode() {
        assertEquals(expected.hashCode(), van.hashCode());
    }

    @Test
    public void testToString() {
        String expectedString = "Van {name = Iveco, price = 40000, cargoCapacity = 3500, bodyType = BOX}";

        assertEquals(expectedString, expected.toString());
    }

}
