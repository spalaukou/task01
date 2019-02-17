package by.epam.javawebtraining.stanislaupalaukou.task01.controller;


import by.epam.javawebtraining.stanislaupalaukou.task01.model.container.Parking;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Car;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Truck;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Vehicle;

/**
 * @author Stanislau Palaukou on 14.02.2019
 * @project Task 01
 */

public class Main {
    public static void main(String[] args) {

        Vehicle car = new Car("Mercedes", 35000, 4, 350);
        Vehicle truck = new Truck("MAN", 60000, "cabover", 20_000);

        Parking parking = new Parking();
        parking.addVehicle(car);
        System.out.println(parking);
    }
}
