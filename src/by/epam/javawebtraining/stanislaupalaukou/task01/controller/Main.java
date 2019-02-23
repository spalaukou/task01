package by.epam.javawebtraining.stanislaupalaukou.task01.controller;


import by.epam.javawebtraining.stanislaupalaukou.task01.model.container.Parking;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Car;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Truck;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Vehicle;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.VehicleNotFoundException;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.logic.VehicleFinder;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.logic.VehicleSorter;
import by.epam.javawebtraining.stanislaupalaukou.task01.util.*;
import by.epam.javawebtraining.stanislaupalaukou.task01.view.Printable;
import by.epam.javawebtraining.stanislaupalaukou.task01.view.PrinterType;

import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.stream.Stream;

/**
 * @author Stanislau Palaukou on 14.02.2019
 * @project Task 01
 */

public class Main {
    public static void main(String[] args) {

       /* Parking parking = ParkingCreator.create();

        DataReader dataReader = new DataReader();
        List<String> listString = dataReader.readFileStrings();

        System.out.println(listString);

        DataValidator dataValidator = new DataValidator();
        List<String> validLines = dataValidator.validateStrings(listString);

        System.out.println(validLines);*/

        //TODO: Factory to create vehicles
        Vehicle car = new Car("Mercedes", 35_000, 4, 350);
        Vehicle truck = new Truck("Iveco", 60_000, "Cabover", 20_000);
        Vehicle car2 = new Car("Citroen", 10_000, 4, 350);
        Vehicle car3 = new Car("Audi", 25_000, 4, 350);
        Vehicle car4 = new Car("Citroen", 5_000, 4, 350);

        Parking parking = ParkingCreator.create();

        parking.addVehicle(car);
        parking.removeVehicle(null);
        /*parking.addVehicle(car3);
        parking.addVehicle(car2);
        parking.addVehicle(truck);
        parking.addVehicle(car4);*/


        Printable printer = PrinterCreator.create(PrinterType.CONSOLE);
        printer.print(parking);

        VehicleSorter.sortByPrice(parking.getVehicles());
        printer.print(parking);
        VehicleSorter.sortByName(parking.getVehicles());
        printer.print(parking);
        VehicleSorter.sortByNameByPrice(parking.getVehicles());
        printer.print(parking);

        printer.print("The dearest vehicle on parking: " + Stream.of(parking.getVehicles()).max(Comparator.comparing(Vehicle::getPrice)));

        printer.print("The dearest vehicle on parking: " + VehicleFinder.findDearestVehicle(parking));
        printer.print("The cheapest vehicle on parking: " + VehicleFinder.findTheCheapestVehicle(parking));

    }
}
