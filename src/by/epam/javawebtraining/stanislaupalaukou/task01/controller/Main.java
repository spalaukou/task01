package by.epam.javawebtraining.stanislaupalaukou.task01.controller;


import by.epam.javawebtraining.stanislaupalaukou.task01.model.comparator.VehiclePriceComparator;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.container.Parking;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Car;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Truck;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Vehicle;
import by.epam.javawebtraining.stanislaupalaukou.task01.util.*;
import by.epam.javawebtraining.stanislaupalaukou.task01.view.Printable;
import by.epam.javawebtraining.stanislaupalaukou.task01.view.PrinterType;

import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Stanislau Palaukou on 14.02.2019
 * @project Task 01
 */

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

       /* Parking parking = ParkingCreator.create();

        DataReader dataReader = new DataReader();
        List<String> listString = dataReader.readFileStrings();

        System.out.println(listString);

        DataValidator dataValidator = new DataValidator();
        List<String> validLines = dataValidator.validateStrings(listString);

        System.out.println(validLines);*/





        //TODO: Factory to create vehicles
        Vehicle car = new Car("Mercedes", 35000, 4, 350);
        Vehicle truck = new Truck("MAN", 60000, "Cabover", 20_000);
        Vehicle car2 = new Car("Audi", 10000, 4, 350);
        Vehicle car3 = new Car("Audi", 25000, 4, 350);


        Parking parking = ParkingCreator.create();

        parking.addVehicle(car);
        parking.addVehicle(car3);
        parking.addVehicle(car2);
        //parking.removeVehicle(car2);
        parking.addVehicle(truck);

        //parking.removeVehicle(truck);

        Printable printer = PrinterCreator.create(PrinterType.CONSOLE);
        printer.print(parking);

        VehicleSorter vehicleSorter = new VehicleSorter();
        vehicleSorter.sortByPrice(parking.getVehicles());
        printer.print(parking);
        vehicleSorter.sortByName(parking.getVehicles());
        printer.print(parking);
        vehicleSorter.sortByNameByPrice(parking.getVehicles());
        printer.print(parking);
        Stream.of(parking.getVehicles()).max(Comparator.comparing(Vehicle::getPrice));

    }
}
