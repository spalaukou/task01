package by.epam.javawebtraining.stanislaupalaukou.task01.controller;


import by.epam.javawebtraining.stanislaupalaukou.task01.model.container.Parking;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Car;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Truck;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Vehicle;
import by.epam.javawebtraining.stanislaupalaukou.task01.util.ParkingCreator;
import by.epam.javawebtraining.stanislaupalaukou.task01.util.PrinterCreator;
import by.epam.javawebtraining.stanislaupalaukou.task01.view.Printable;
import by.epam.javawebtraining.stanislaupalaukou.task01.view.PrinterType;

/**
 * @author Stanislau Palaukou on 14.02.2019
 * @project Task 01
 */

public class Main {
    public static void main(String[] args) {

        //TODO: Factory to create vehicles
        Vehicle car = new Car("Mercedes", 35000, 4, 350);
        Vehicle truck = new Truck("MAN", 60000, "Cabover", 20_000);
        Vehicle car2 = new Car("Audi", 10000, 4, 350);

        Vehicle[] vehicles = {car};

        Parking parking = ParkingCreator.create(vehicles);

        parking.addVehicle(car2);
        parking.removeVehicle(car2);
        parking.addVehicle(truck);
        parking.removeVehicle(truck);


        Printable printer = PrinterCreator.create(PrinterType.CONSOLE);
        printer.print(parking);
    }
}
