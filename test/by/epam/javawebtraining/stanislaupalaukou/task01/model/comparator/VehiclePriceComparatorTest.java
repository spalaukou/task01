package by.epam.javawebtraining.stanislaupalaukou.task01.model.comparator;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Car;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Vehicle;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Comparator;

/**
 * @author Stanislau Palaukou on 24.02.2019
 * @project Task 01
 */

public class VehiclePriceComparatorTest {
    private Vehicle car1;
    private Vehicle car2;

    @BeforeTest
    public void setupVehicles() {
        car1 = new Car("BMW", 66_000, 4, Car.BodyType.SEDAN);
        car2 = new Car("Renault", 15_000, 4, Car.BodyType.SEDAN);
    }

    @Test
    public void testCompare() {
        Comparator comparator = new VehiclePriceComparator();
        int expected = 51_000;
        int actual = comparator.compare(car1, car2);

        Assert.assertEquals(expected, actual);
    }
}
