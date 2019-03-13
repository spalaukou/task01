package by.epam.javawebtraining.stanislaupalaukou.task01.model.logic;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Car;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Truck;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Vehicle;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.container.Parking;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.*;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @author Stanislau Palaukou on 24.02.2019
 * @project Task 01
 */

public class VehicleSorterTest {
    private Vehicle car1;
    private Vehicle car2;
    private Vehicle car3;
    private Vehicle car4;
    private Vehicle truck;
    private Vehicle[] vehicles1;
    private Vehicle[] vehicles2;
    private Vehicle[] vehicles3;
    private Parking parking1;
    private Parking parking2;
    private Parking parking3;

    @BeforeTest
    public void setUpParking()
            throws SeatsNumberException, VehiclePriceException, VehicleNameException, CarBodyTypeException,
            CargoCapacityException, TruckBodyTypeException, VehicleArrayException {
        car1 = new Car("BMW", 66_000, 4, Car.BodyType.SEDAN);
        car2 = new Car("Renault", 15_000, 4, Car.BodyType.SEDAN);
        car3 = new Car("Volkswagen", 20_000, 4, Car.BodyType.COUPE);
        car4 = new Car("Skoda", 98_000, 4, Car.BodyType.HATCHBACK);
        truck = new Truck("Skoda", 80_000, 30_000, Truck.BodyType.CABOVER);

        vehicles1 = new Vehicle[]{car1, car2, car3, car4, truck};
        vehicles2 = new Vehicle[0];
        vehicles3 = null;

        parking1 = new Parking(vehicles1);
        parking1 = new Parking(vehicles2);
        parking1 = new Parking(vehicles3);
    }

    /*@Test
    public void testSortByPrice() throws NullParkingException, VehicleArrayException {
        Vehicle[] expected = {car2, car3, car1, truck, car4};
        Vehicle[] actual = VehicleSorter.sortByPrice(parking1);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSortByPriceVehiclesArrayIsEmpty() {
        Vehicle[] expected = {};
        Vehicle[] actual = VehicleSorter.sortByPrice(vehicles2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSortByPriceVehiclesArrayIsNull() {
        Vehicle[] expected = null;
        Vehicle[] actual = VehicleSorter.sortByPrice(vehicles3);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSortByName() {
        Vehicle[] expected = {car1, car2, car4, truck, car3};
        Vehicle[] actual = VehicleSorter.sortByName(vehicles1);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSortByNameVehiclesArrayIsEmpty() {
        Vehicle[] expected = {};
        Vehicle[] actual = VehicleSorter.sortByName(vehicles2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSortByNameVehiclesArrayIsNull() {
        Vehicle[] expected = null;
        Vehicle[] actual = VehicleSorter.sortByName(vehicles3);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSortByNameByPrice() {
        Vehicle[] expected = {car1, car2, truck, car4, car3};
        Vehicle[] actual = VehicleSorter.sortByNameByPrice(vehicles1);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSortByNameByPriceVehiclesArrayIsEmpty() {
        Vehicle[] expected = {};
        Vehicle[] actual = VehicleSorter.sortByNameByPrice(vehicles2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSortByNameByPriceVehiclesArrayIsNull() {
        Vehicle[] expected = null;
        Vehicle[] actual = VehicleSorter.sortByNameByPrice(vehicles3);

        Assert.assertEquals(expected, actual);
    }*/

}
