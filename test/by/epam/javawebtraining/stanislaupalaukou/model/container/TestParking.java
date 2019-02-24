package by.epam.javawebtraining.stanislaupalaukou.model.container;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Car;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Truck;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Vehicle;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author Stanislau Palaukou on 24.02.2019
 * @project Task 01
 */

public class TestParking {
    private Vehicle[] vehicles;

    @BeforeTest
    public void setVehicles() {
        Vehicle car1 = new Car("BMW", 66_000, 4, Car.BodyType.SEDAN);
        Vehicle car2 = new Car("Renault", 15_000, 4, Car.BodyType.SEDAN);
        Vehicle car3 = new Car("Volkswagen", 20_000, 4, Car.BodyType.COUPE);
        Vehicle car4 = new Car("Skoda", 18_000, 4, Car.BodyType.HATCHBACK);
        Vehicle truck = new Truck("Volvo", 80_000, 30_000, Truck.BodyType.CABOVER);

        Vehicle[] vehicles1 = {car1, car2, car3, car4, truck};
        Vehicle[] vehicles2 = {};
        Vehicle[] vehicles3 = null;
    }

    @Test
    public void testSetVehicles() {}

}
