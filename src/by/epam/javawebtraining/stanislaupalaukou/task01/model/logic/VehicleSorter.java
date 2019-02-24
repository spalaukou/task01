package by.epam.javawebtraining.stanislaupalaukou.task01.model.logic;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.comparator.VehiclePriceComparator;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Vehicle;
import org.apache.log4j.Logger;

import java.util.Comparator;

/**
 * @author Stanislau Palaukou on 20.02.2019
 * @project Task 01
 */

public class VehicleSorter {

    private static final Logger logger = Logger.getLogger(VehicleSorter.class);

    public static Vehicle[] sort(Vehicle[] vehicles, Comparator<Vehicle> comparator) {
        Vehicle[] newVehicles = vehicles;
        if(vehicles != null) {
            for (int i = 0; i < vehicles.length; i++) {
                for (int j = i + 1; j < vehicles.length; j++) {
                    if (comparator.compare(vehicles[i], vehicles[j]) > 0) {
                        Vehicle temp = vehicles[i];
                        vehicles[i] = vehicles[j];
                        vehicles[j] = temp;
                    }
                }
            }
        }
        return newVehicles;
    }

    public static Vehicle[] sortByPrice(Vehicle[] vehicles) {
        Vehicle[] newVehicles = vehicles;
        if(vehicles != null) {
            Comparator vehiclePriceComparator = new VehiclePriceComparator();
            newVehicles = sort(newVehicles, vehiclePriceComparator);
        }
        logger.info("Vehiles have been sorted by price.");
        return newVehicles;
    }

    public static Vehicle[] sortByName(Vehicle[] vehicles) {
        Vehicle[] newVehicles = vehicles;
        if(vehicles != null) {
            sort(newVehicles, Comparator.comparing(Vehicle::getName));
        }
        logger.info("Vehiles have been sorted by name.");
        return newVehicles;
    }

    public static Vehicle[] sortByNameByPrice(Vehicle[] vehicles) {
        Vehicle[] newVehicles = vehicles;
        if (vehicles != null) {
            sort(newVehicles, Comparator.comparing(Vehicle::getName).thenComparing(Vehicle::getPrice));
        }
        logger.info("Vehiles have been sorted by name and then by price.");
        return newVehicles;
    }

}
