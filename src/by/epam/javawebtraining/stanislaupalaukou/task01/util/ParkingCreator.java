package by.epam.javawebtraining.stanislaupalaukou.task01.util;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.container.Parking;

import java.util.List;

/**
 * @author Stanislau Palaukou on 18.02.2019
 * @project Task 01
 */

public class ParkingCreator {

    public static Parking create() {
        return new Parking();
    }

    /*public static Parking create(Vehicle[] vehicles) {
        if (vehicles == null) {
            return null;
        }

        return new Parking(vehicles);
    }*/

    public static Parking create(List<String> validLines) {
        for (String validString : validLines) {
            String[] line = ArrayCreator.stringSplit(validString);
            String isType = line[0];
            int vehicleFieldsQuantity = 5;
            /*if (line.length > vehicleFieldsQuantity) {
                int[] dataNumbers = new int[line.length - 1];
                for (int i = 1; i < line.length; i++) {
                    dataNumbers[i - 1] = Integer.parseInt(line[i]);
                }
                for (TariffTypes type : TariffTypes.values()) {
                    if (isType.toUpperCase().equals(type.name())) {
                        TariffFactory tariffFactory = new TariffFactory();
                        Tariff newTariff = tariffFactory.createTariff(type, dataNumbers);
                        if(newTariff != null) {
                            company.add(newTariff);
                        }
                    }
                }
            }*/
        }
        return new Parking();
    }
}
