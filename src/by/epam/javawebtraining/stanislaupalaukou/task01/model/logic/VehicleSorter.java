package by.epam.javawebtraining.stanislaupalaukou.task01.model.logic;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.comparator.VehicleNameComparator;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.comparator.VehiclePriceComparator;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Vehicle;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.container.Parking;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.NullParkingException;
import org.apache.log4j.Logger;

import java.util.Comparator;

/**
 * The logic class sorts Vehicles in
 * the parking lot by different params.
 *
 * @author Stanislau Palaukou on 20.02.2019
 * @project Task 01
 */

public class VehicleSorter {

    private static final Logger logger = Logger.getLogger(VehicleSorter.class);

    /**
     * The unified method sorts array of Vehicles by
     * the comparator, which are received as params.
     *
     * @param vehicles will be sorted
     * @param comparator - param, by which vehicles will be sorted
     * @return sorted array of vehicles
     */
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

    /**
     * The method sorts array of vehicles (which is
     * received as param) by price, uses the unified method sort.
     *
     * @see VehicleSorter#sort(Vehicle[], Comparator)
     *
     * @param vehicles will be sorted
     * @return sorted array of vehicles
     */
    public static Vehicle[] sortByPrice(Vehicle[] vehicles) {
        Vehicle[] newVehicles = vehicles;
        if(vehicles != null) {
            Comparator<Vehicle> vehiclePriceComparator = new VehiclePriceComparator();
            newVehicles = sort(newVehicles, vehiclePriceComparator);
        }
        logger.info("Vehicles have been sorted by price.");
        return newVehicles;
    }

    public static void sortByPrice(Parking parking) throws NullParkingException {
        if (parking == null) {
            throw new NullParkingException();
        }

        Comparator<Vehicle> vehiclePriceComparator = new VehiclePriceComparator();
        sort(parking.getVehicles(), vehiclePriceComparator);

        logger.info("Parking has been sorted by price.");
    }

    /**
     * The method sorts array of vehicles (which is
     * received as param) by name, uses the unified method sort.
     *
     * @see VehicleSorter#sort(Vehicle[], Comparator)
     *
     * @param vehicles will be sorted
     * @return sorted array of vehicles
     */
    public static Vehicle[] sortByName(Vehicle[] vehicles) {
        Vehicle[] newVehicles = vehicles;
        if(vehicles != null) {
//            sort(newVehicles, Comparator.comparing(Vehicle::getName));

            Comparator<Vehicle> vehicleNameComparator = new VehicleNameComparator();
            sort(newVehicles, vehicleNameComparator);
        }
        logger.info("Vehicles have been sorted by name.");
        return newVehicles;
    }

    public static void sortByName(Parking parking) throws NullParkingException {
        if (parking == null) {
            throw new NullParkingException();
        }

        Comparator<Vehicle> vehicleNameComparator = new VehicleNameComparator();
        sort(parking.getVehicles(), vehicleNameComparator);

        logger.info("Parking has been sorted by name.");
    }

    /**
     * The method sorts array of vehicles (which is
     * received as param) by name and then by price,
     * uses the unified method sort.
     *
     * @see VehicleSorter#sort(Vehicle[], Comparator)
     *
     * @param vehicles will be sorted
     * @return sorted array of vehicles
     */
    public static Vehicle[] sortByNameByPrice(Vehicle[] vehicles) {
        Vehicle[] newVehicles = vehicles;
        if (vehicles != null) {
            Comparator<Vehicle> vehicleNameComparator = new VehicleNameComparator();
            Comparator<Vehicle> vehiclePriceComparator = new VehicleNameComparator();
            sort(newVehicles, vehicleNameComparator.thenComparing(vehiclePriceComparator));

//            sort(newVehicles, Comparator.comparing(Vehicle::getName).thenComparing(Vehicle::getPrice));
        }
        logger.info("Vehiles have been sorted by name and then by price.");
        return newVehicles;
    }

    public static void sortByNameByPrice(Parking parking) throws NullParkingException {
        if (parking == null) {
            throw new NullParkingException();
        }

        Comparator<Vehicle> vehicleNameComparator = new VehicleNameComparator();
        Comparator<Vehicle> vehiclePriceComparator = new VehiclePriceComparator();
        sort(parking.getVehicles(), vehicleNameComparator.thenComparing(vehiclePriceComparator));

        logger.info("Vehiles have been sorted by name and then by price.");
    }

}
