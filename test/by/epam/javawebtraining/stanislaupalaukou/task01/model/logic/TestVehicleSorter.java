package by.epam.javawebtraining.stanislaupalaukou.task01.model.logic;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Car;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Truck;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Vehicle;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @author Stanislau Palaukou on 24.02.2019
 * @project Task 01
 */

public class TestVehicleSorter {
    private Vehicle car1;
    private Vehicle car2;
    private Vehicle car3;
    private Vehicle car4;
    private Vehicle truck;
    private Vehicle[] vehicles1;
    private Vehicle[] vehicles2;
    private Vehicle[] vehicles3;

    @BeforeTest
    public void setParking() {
        car1 = new Car("BMW", 66_000, 4, Car.BodyType.SEDAN);
        car2 = new Car("Renault", 15_000, 4, Car.BodyType.SEDAN);
        car3 = new Car("Volkswagen", 20_000, 4, Car.BodyType.COUPE);
        car4 = new Car("Skoda", 98_000, 4, Car.BodyType.HATCHBACK);
        truck = new Truck("Skoda", 80_000, 30_000, Truck.BodyType.CABOVER);

        vehicles1 = new Vehicle[]{car1, car2, car3, car4, truck};
        vehicles2 = new Vehicle[0];
        vehicles3 = null;
    }

    @Test
    public void testSortByPrice() {
        Vehicle[] expected1 = {car2, car3, car1, truck, car4};
        Vehicle[] actual1 = VehicleSorter.sortByPrice(vehicles1);

        Vehicle[] expected2 = {};
        Vehicle[] actual2 = VehicleSorter.sortByPrice(vehicles2);

        Vehicle[] expected3 = null;
        Vehicle[] actual3 = VehicleSorter.sortByPrice(vehicles3);

        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
        Assert.assertEquals(expected3, actual3);
    }

    @Test
    public void testSortByName() {
        Vehicle[] expected1 = {car1, car2, car4, truck, car3};
        Vehicle[] actual1 = VehicleSorter.sortByName(vehicles1);

        Vehicle[] expected2 = {};
        Vehicle[] actual2 = VehicleSorter.sortByName(vehicles2);

        Vehicle[] expected3 = null;
        Vehicle[] actual3 = VehicleSorter.sortByName(vehicles3);

        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
        Assert.assertEquals(expected3, actual3);
    }

    @Test
    public void testSortByNameByPrice() {
        Vehicle[] expected1 = {car1, car2, truck, car4, car3};
        Vehicle[] actual1 = VehicleSorter.sortByNameByPrice(vehicles1);
        System.out.println(Arrays.toString(actual1));

        Vehicle[] expected2 = {};
        Vehicle[] actual2 = VehicleSorter.sortByNameByPrice(vehicles2);

        Vehicle[] expected3 = null;
        Vehicle[] actual3 = VehicleSorter.sortByNameByPrice(vehicles3);

        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
        Assert.assertEquals(expected3, actual3);
    }

}
