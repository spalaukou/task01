package by.epam.javawebtraining.stanislaupalaukou.task01.controller;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.container.Parking;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Car;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Truck;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Vehicle;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.ParkingTaskException;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.technical.TechnicalException;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.logic.VehicleCalculator;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.logic.VehicleFinder;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.logic.VehicleSorter;
import by.epam.javawebtraining.stanislaupalaukou.task01.util.creator.CarCreator;
import by.epam.javawebtraining.stanislaupalaukou.task01.util.creator.ParkingCreator;
import by.epam.javawebtraining.stanislaupalaukou.task01.util.creator.PrinterCreator;
import by.epam.javawebtraining.stanislaupalaukou.task01.util.creator.TruckCreator;
import by.epam.javawebtraining.stanislaupalaukou.task01.util.reader.DataReader;
import by.epam.javawebtraining.stanislaupalaukou.task01.util.validator.DataValidator;
import by.epam.javawebtraining.stanislaupalaukou.task01.view.Printable;
import by.epam.javawebtraining.stanislaupalaukou.task01.view.PrinterType;
import org.apache.log4j.Logger;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * The program represents the hierarchy of vehicles
 * including cargo and passenger vehicles, located in the parking lot.
 *
 * @author Stanislau Palaukou on 14.02.2019
 * @project Task 01
 */

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            logger.info("App has been launched.");

            Printable printer = PrinterCreator.create(PrinterType.CONSOLE);

            //Reading file
            DataReader dataReader = new DataReader();
            List<String> listString = null;
            try {
                listString = dataReader.readFileStrings();
            } catch (TechnicalException e) {
                e.printStackTrace();
            }
            printer.print(listString);

            //Validating strings
            DataValidator dataValidator = new DataValidator();
            List<String> validLines = dataValidator.validateStrings(listString);
            printer.print(validLines);

            //Filling parking with factory
            Parking parking = ParkingCreator.create(validLines);

            printer.print(parking);

            //Adding vehicles to parking from app
            Vehicle car1 = CarCreator.create("BMW", 66_000, 4, Car.BodyType.SEDAN);
            Vehicle car2 = CarCreator.create("Renault", 15_000, 4, Car.BodyType.SEDAN);
            Vehicle car3 = CarCreator.create("Volkswagen", 20_000, 4, Car.BodyType.COUPE);
            Vehicle car4 = CarCreator.create("Skoda", 18_000, 4, Car.BodyType.HATCHBACK);
            Vehicle truck = TruckCreator.create("Volvo", 80_000, 30_000, Truck.BodyType.CABOVER);

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
            printer.print("Total price of all the vehicles: " + VehicleCalculator.totalPrice(parking));

            //Finding total seats of all vehicles on parking lot
            printer.print("Total seats of all the vehicles: " + VehicleCalculator.totalSeats(parking));

            //Finding vehicles by critical properties
            printer.print("The dearest vehicle in the parking lot: " + Stream.of(parking.getVehicles()).max(Comparator
                    .comparing(Vehicle::getPrice)));
            printer.print("The dearest vehicle in the parking lot: " + VehicleFinder.findTheDearestVehicle(parking));
            printer.print("The cheapest vehicle in the parking lot: " + VehicleFinder.findTheCheapestVehicle(parking));

            //Removing all vehicles from the parking and demonstrating ParkingIsEmptyException
            parking.removeVehicle(car1);
            parking.removeVehicle(car2);
            parking.removeVehicle(car3);
            parking.removeVehicle(car4);
            parking.removeVehicle(truck);
            parking.removeVehicle(CarCreator.create("Mercedes", 35_000, 4, Car.BodyType.COUPE));
            parking.removeVehicle(CarCreator.create("Audi", 25_000, 4, Car.BodyType.COUPE));
            parking.removeVehicle(TruckCreator.create("Kenworth", 60_000, 20_000, Truck.BodyType.SLEEPER));
            parking.removeVehicle(CarCreator.create("Citroen", 10_000, 4, Car.BodyType.SEDAN));
            parking.removeVehicle(CarCreator.create("Citroen", 5_000, 4, Car.BodyType.HATCHBACK));
            printer.print(parking);
            parking.removeVehicle(car1);

            printer.print("The dearest vehicle in the parking lot: " + VehicleFinder.findTheDearestVehicle(parking));

            logger.info("App has been completed successfully.");
        } catch (ParkingTaskException e) {
            e.printStackTrace();
        }
    }
}
