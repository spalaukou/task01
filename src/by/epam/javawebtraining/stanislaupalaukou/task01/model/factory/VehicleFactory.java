package by.epam.javawebtraining.stanislaupalaukou.task01.model.factory;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Car;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Truck;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Vehicle;
import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.VehicleTypes;

/**
 * @author Stanislau Palaukou on 19.02.2019
 * @project Task 01
 */

public class VehicleFactory {

    public Vehicle createVehicle(VehicleTypes type, String[] vehicleFields) {

        switch(type){

            case CAR:
                return new Car();

            case TRUCK:
                return new Truck();

                default:
                    System.out.println("Wrong vehicle type");
        }

        return null;
    }

    public static Car createCar(String name, int price, int seatsNumber, int trunkVolume) {
        return new Car(name, price, seatsNumber, trunkVolume);
    }
}
