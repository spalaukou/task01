package by.epam.javawebtraining.stanislaupalaukou.task01.model.logic;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Car;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Truck;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Vehicle;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.container.ArrayParking;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.*;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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
    private ArrayParking parking1;
    private ArrayParking parking2;
    private ArrayParking parking3;

    @BeforeTest
    public void setUpParking()
            throws SeatsNumberException, VehiclePriceException, VehicleNameException, CarBodyTypeException,
            CargoCapacityException, TruckBodyTypeException, VehicleArrayException {
        car1 = new Car("BMW", 66_000, 4, Car.BodyType.SEDAN);
        car2 = new Car("Renault", 15_000, 4, Car.BodyType.SEDAN);
        car3 = new Car("Volkswagen", 20_000, 4, Car.BodyType.COUPE);
        car4 = new Car("Skoda", 98_000, 4, Car.BodyType.HATCHBACK);
        truck = new Truck("Skoda", 80_000, 30_000, Truck.BodyType.CABOVER);

        Vehicle[] vehicles1 = new Vehicle[]{car1, car2, car3, car4, truck};
        Vehicle[] vehicles2 = {};

        parking1 = new ArrayParking(vehicles1);
        parking2 = null;
        parking3 = new ArrayParking(vehicles2);
    }

    @Test
    public void testSortByPrice() throws NullParkingException, VehicleArrayException {
        Vehicle[] sorted = {car2, car3, car1, truck, car4};
        ArrayParking expected = new ArrayParking(sorted);

        VehicleSorter.sortByPrice(parking1);

        Assert.assertEquals(expected, parking1);
    }

    @Test (expectedExceptions = NullParkingException.class)
    public void testSortByPriceNullParkingException()
            throws NullParkingException, VehicleArrayException {

        VehicleSorter.sortByPrice(parking2);
    }

    @Test (expectedExceptions = VehicleArrayException.class)
    public void testSortByPriceVehicleArrayException()
            throws NullParkingException, VehicleArrayException {

        VehicleSorter.sortByPrice(parking3);
    }

    @Test
    public void testSortByName() throws NullParkingException, VehicleArrayException {
        Vehicle[] sorted = {car1, car2, car4, truck, car3};
        ArrayParking expected = new ArrayParking(sorted);

        VehicleSorter.sortByName(parking1);

        Assert.assertEquals(expected, parking1);
    }

    @Test (expectedExceptions = NullParkingException.class)
    public void testSortByNameNullParkingException()
            throws NullParkingException, VehicleArrayException {

        VehicleSorter.sortByName(parking2);
    }

    @Test
    public void testSortByNameByPrice() throws VehicleArrayException, NullParkingException {
        Vehicle[] sorted = {car1, car2, truck, car4, car3};
        ArrayParking expected = new ArrayParking(sorted);

        VehicleSorter.sortByNameByPrice(parking1);

        Assert.assertEquals(expected, parking1);
    }

    @Test (expectedExceptions = NullParkingException.class)
    public void testSortByNameByPriceNullParkingException()
            throws NullParkingException, VehicleArrayException {

        VehicleSorter.sortByNameByPrice(parking2);
    }


}
