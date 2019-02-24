package by.epam.javawebtraining.stanislaupalaukou.task01.controller;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.container.Parking;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Car;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Truck;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Vehicle;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.logic.VehicleCalculator;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.logic.VehicleFinder;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.logic.VehicleSorter;
import by.epam.javawebtraining.stanislaupalaukou.task01.util.*;
import by.epam.javawebtraining.stanislaupalaukou.task01.view.Printable;
import by.epam.javawebtraining.stanislaupalaukou.task01.view.PrinterType;
import org.apache.log4j.Logger;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Stanislau Palaukou on 14.02.2019
 * @project Task 01
 */

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("App has been launched.");

        Printable printer = PrinterCreator.create(PrinterType.CONSOLE);

        //Reading file
        DataReader dataReader = new DataReader();
        List<String> listString = dataReader.readFileStrings();
        printer.print(listString);

        //Validating strings
        DataValidator dataValidator = new DataValidator();
        List<String> validLines = dataValidator.validateStrings(listString);
        printer.print(validLines);

        //Filling parking with factory
        Parking parking = ParkingCreator.create(validLines);

        printer.print(parking);

        //Adding vehicles to parking from app
        Vehicle car1 = new Car("BMW", 66_000, 4, Car.BodyType.SEDAN);
        Vehicle car2 = new Car("Renault", 15_000, 4, Car.BodyType.SEDAN);
        Vehicle car3 = new Car("Volkswagen", 20_000, 4, Car.BodyType.COUPE);
        Vehicle car4 = new Car("Skoda", 18_000, 4, Car.BodyType.HATCHBACK);
        Vehicle truck = new Truck("Volvo", 80_000, 30_000, Truck.BodyType.CABOVER);

        //Demonstration of VehicleNotFoundException
        parking.removeVehicle(truck);

        //Adding vehicles to parking
        parking.addVehicle(car1);
        parking.addVehicle(car2);
        parking.addVehicle(car3);
        parking.addVehicle(car4);
        parking.addVehicle(truck);

        printer.print(parking);

        //Sorting vehicles
        VehicleSorter.sortByPrice(parking.getVehicles());
        printer.print(parking);

        VehicleSorter.sortByName(parking.getVehicles());
        printer.print(parking);

        VehicleSorter.sortByNameByPrice(parking.getVehicles());
        printer.print(parking);

        //Finding total price of all vehicles on parking lot
        printer.print("Total price of all vehicles: " + VehicleCalculator.totalPrice(parking));

        //Finding total seats of all vehicles on parking lot
        printer.print("Total seats of all vehicles: " + VehicleCalculator.totalSeats(parking));

        //Finding vehicles by critical properties
        printer.print("The dearest vehicle on parking: " + Stream.of(parking.getVehicles()).max(Comparator
                .comparing(Vehicle::getPrice)));
        printer.print("The dearest vehicle on parking: " + VehicleFinder.findTheDearestVehicle(parking));
        printer.print("The cheapest vehicle on parking: " + VehicleFinder.findTheCheapestVehicle(parking));

        //Removing all vehicles from the parking and demonstrating ParkingIsEmptyException
        parking.removeVehicle(car1);
        parking.removeVehicle(car2);
        parking.removeVehicle(car3);
        parking.removeVehicle(car4);
        parking.removeVehicle(truck);
        parking.removeVehicle(new Car("Mercedes", 35_000, 4, Car.BodyType.COUPE));
        parking.removeVehicle(new Car("Audi", 25_000, 4, Car.BodyType.COUPE));
        parking.removeVehicle(new Truck("Kenworth", 60_000, 20_000, Truck.BodyType.SLEEPER));
        parking.removeVehicle(new Car("Citroen", 10_000, 4, Car.BodyType.SEDAN));
        parking.removeVehicle(new Car("Citroen", 5_000, 4, Car.BodyType.HATCHBACK));
        printer.print(parking);
        parking.removeVehicle(car1);

        printer.print("The dearest vehicle on parking: " + VehicleFinder.findTheDearestVehicle(parking));

        logger.info("App has been completed successfully.");
    }
}
