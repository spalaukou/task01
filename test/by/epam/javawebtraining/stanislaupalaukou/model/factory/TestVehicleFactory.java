package by.epam.javawebtraining.stanislaupalaukou.model.factory;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Car;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Truck;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Vehicle;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.VehicleTypes;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.factory.VehicleFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Stanislau Palaukou on 24.02.2019
 * @project Task 01
 */

public class TestVehicleFactory {

    @Test
    public void testCreateVehicle() {
        Vehicle expectedCar = new Car("BMW", 66_000, 4, Car.BodyType.SEDAN);
        Vehicle expectedTruck = new Truck("Volvo", 80_000, 30_000, Truck.BodyType.CABOVER);
        Vehicle expectedNull = null;

        Vehicle actualCar = VehicleFactory.createVehicle(VehicleTypes.CAR, "BMW", 66_000, 4, "sedan");
        Vehicle actualTruck = VehicleFactory.createVehicle(VehicleTypes.TRUCK, "Volvo", 80_000, 30_000, "CABOVER");
        Vehicle actualNull = VehicleFactory.createVehicle(VehicleTypes.CAR, "BMW", 66_000, 4, "invalidType");

        Assert.assertEquals(expectedCar, actualCar);
        Assert.assertEquals(expectedTruck, actualTruck);
        Assert.assertEquals(expectedNull, actualNull);
    }
}
