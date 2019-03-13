package by.epam.javawebtraining.stanislaupalaukou.task01.model.logic;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.comparator.VehicleNameComparator;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.comparator.VehiclePriceComparator;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Vehicle;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.container.Parking;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.NullParkingException;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.exception.logical.VehicleArrayException;
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
    private static Vehicle[] sort(Vehicle[] vehicles, Comparator<Vehicle> comparator) throws VehicleArrayException {

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
            return vehicles;

        } else {
            throw new VehicleArrayException();
        }
    }

    /**
     * The method sorts Parking of vehicles (which is
     * received as param) by price, uses the unified method sort.
     *
     * @see VehicleSorter#sort(Vehicle[], Comparator)
     *
     * @param parking will be sorted
     */
    public static void sortByPrice(Parking parking) throws NullParkingException, VehicleArrayException {
        if (parking != null) {

            Comparator<Vehicle> vehiclePriceComparator = new VehiclePriceComparator();
            sort(parking.getVehicles(), vehiclePriceComparator);

            logger.info("Parking has been sorted by price.");
        } else {
            throw new NullParkingException();
        }
    }

    /**
     * The method sorts Parking of vehicles (which is
     * received as param) by name, uses the unified method sort.
     *
     * @see VehicleSorter#sort(Vehicle[], Comparator)
     *
     * @param parking will be sorted
     */
    public static void sortByName(Parking parking) throws NullParkingException, VehicleArrayException {
        if (parking != null) {

            Comparator<Vehicle> vehicleNameComparator = new VehicleNameComparator();
            sort(parking.getVehicles(), vehicleNameComparator);

            logger.info("Parking has been sorted by name.");
        } else {
            throw new NullParkingException();
        }
    }

    /**
     * The method sorts Parking of vehicles (which is
     * received as param) by name and then by price,
     * uses the unified method sort.
     *
     * @see VehicleSorter#sort(Vehicle[], Comparator)
     *
     * @param parking will be sorted
     * @return sorted array of vehicles
     */
    public static void sortByNameByPrice(Parking parking) throws NullParkingException, VehicleArrayException {
        if (parking != null) {

            Comparator<Vehicle> vehicleNameComparator = new VehicleNameComparator();
            Comparator<Vehicle> vehiclePriceComparator = new VehiclePriceComparator();
            sort(parking.getVehicles(), vehicleNameComparator.thenComparing(vehiclePriceComparator));

            logger.info("Vehiles have been sorted by name and then by price.");
        } else {
            throw new NullParkingException();
        }
    }
}
