package by.epam.javawebtraining.stanislaupalaukou.task01.model.logic.serializator;

import java.io.*;

/**
 * @author Stanislau Palaukou on 18.03.2019
 * @project Task 01
 */

public class MySerializator<T> {
  private static final String FILE_NAME = "output/serialized.txt";

  public void write(T t) {


    try (ObjectOutputStream objectOutputStream =
            new ObjectOutputStream((
                    new BufferedOutputStream(
                            new FileOutputStream(FILE_NAME))))) {

      objectOutputStream.writeObject(t);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void read() {

    try (ObjectInputStream objectInputStream =
                 new ObjectInputStream((
                         new BufferedInputStream(
                                 new FileInputStream(FILE_NAME))))) {


        T t = (T) objectInputStream.readObject();

        System.out.println("Deserialized object:");
        System.out.println(t);

    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
}
