package by.epam.javawebtraining.stanislaupalaukou.task01.model.logic;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.comparator.VehiclePriceComparator;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Vehicle;

import java.util.Comparator;

/**
 * @author Stanislau Palaukou on 20.02.2019
 * @project Task 01
 */

public class VehicleSorter {

    public static void sort(Vehicle[] vehicles, Comparator<Vehicle> comparator) {
        for(int i = 0; i < vehicles.length; i++) {
            for(int j = i + 1; j < vehicles.length; j++) {
                if(comparator.compare(vehicles[i], vehicles[j]) > 0) {
                    Vehicle temp = vehicles[i];
                    vehicles[i] = vehicles[j];
                    vehicles[j] = temp;
                }
            }
        }
    }

    public static void sortByPrice(Vehicle[] vehicles) {
        Comparator vehiclePriceComparator = new VehiclePriceComparator();
        sort(vehicles, vehiclePriceComparator);
    }

    public static void sortByName(Vehicle[] vehicles) {
        sort(vehicles, Comparator.comparing(Vehicle::getName));
    }

    public static void sortByNameByPrice(Vehicle[] vehicles) {
        sort(vehicles, Comparator.comparing(Vehicle::getName).thenComparing(Vehicle::getPrice));
    }
}
