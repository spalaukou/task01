package by.epam.javawebtraining.stanislaupalaukou.task01.model.logic;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.comparator.VehiclePriceComparator;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Vehicle;

import java.util.Comparator;

/**
 * @author Stanislau Palaukou on 20.02.2019
 * @project Task 01
 */

public class VehicleSorter {

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
        return newVehicles;
    }

    public static Vehicle[] sortByName(Vehicle[] vehicles) {
        Vehicle[] newVehicles = vehicles;
        if(vehicles != null) {
            sort(newVehicles, Comparator.comparing(Vehicle::getName));
        }
        return newVehicles;
    }

    public static Vehicle[] sortByNameByPrice(Vehicle[] vehicles) {
        Vehicle[] newVehicles = vehicles;
        if (vehicles != null) {
            sort(newVehicles, Comparator.comparing(Vehicle::getName).thenComparing(Vehicle::getPrice));
        }
        return newVehicles;
    }

}
