package by.epam.javawebtraining.stanislaupalaukou.task01.factory;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Car;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Truck;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Vehicle;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.VehicleType;
import by.epam.javawebtraining.stanislaupalaukou.task01.util.factory.VehicleFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Stanislau Palaukou on 24.02.2019
 * @project Task 01
 */

public class VehicleFactoryTest {

    @Test
    public void testCreateVehicleCar() {
        Vehicle expected = new Car("BMW", 66_000, 4, Car.BodyType.SEDAN);

        Vehicle actual = VehicleFactory.createVehicle(VehicleType.CAR, "BMW", 66_000, 4, "sedan");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCreateVehicleTruck() {
        Vehicle expected = new Truck("Volvo", 80_000, 30_000, Truck.BodyType.CABOVER);

        Vehicle actual = VehicleFactory.createVehicle(VehicleType.TRUCK, "Volvo", 80_000, 30_000, "CABOVER");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCreateVehicleNull() {
        Vehicle expected = null;

        Vehicle actual = VehicleFactory.createVehicle(VehicleType.CAR, "BMW", 66_000, 4, "invalidType");

        Assert.assertEquals(expected, actual);
    }
}
