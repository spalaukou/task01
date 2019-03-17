package by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.container.task02;

/**
 * @author Stanislau Palaukou on 18.03.2019
 * @project Task 01
 */

public interface BaseQueue<E> extends BaseContainer<E> {

    boolean add(E e);

    E remove();
}
