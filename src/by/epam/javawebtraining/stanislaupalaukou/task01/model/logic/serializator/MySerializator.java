package by.epam.javawebtraining.stanislaupalaukou.task01.model.logic.serializator;

import by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.Vehicle;

import java.io.*;

/**
 * @author Stanislau Palaukou on 18.03.2019
 * @project Task 01
 */

public class MySerializator {
  private static final String FILE_NAME = "output/serialized.txt";

  public static void write(Vehicle vehicle) {


    try (ObjectOutputStream objectOutputStream =
            new ObjectOutputStream((
                    new BufferedOutputStream(
                            new FileOutputStream(FILE_NAME))))) {

      objectOutputStream.writeObject(vehicle);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void read() {

    Vehicle vehicle;

    try (ObjectInputStream objectInputStream =
                 new ObjectInputStream((
                         new BufferedInputStream(
                                 new FileInputStream(FILE_NAME))))) {

        vehicle = (Vehicle) objectInputStream.readObject();

        System.out.println("Deserialized object:");
        System.out.println(vehicle);

    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
}
