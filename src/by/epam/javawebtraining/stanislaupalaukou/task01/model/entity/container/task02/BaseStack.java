package by.epam.javawebtraining.stanislaupalaukou.task01.model.entity.container.task02;

/**
 * @author Stanislau Palaukou on 18.03.2019
 * @project Task 01
 */

public interface BaseStack<E> extends BaseContainer<E> {

    public E push(E item);

    public E pop();
}
