package ru.egar.spring_work_accounting.abstraction.mappers;

public interface TwoSidedIterableMapper<E, D> extends TwoSidedMapper<E, D> {

    Iterable<D> iterableMap(Iterable<E> entityIterable);
    Iterable<E> iterableRemap(Iterable<D> objectIterable);

}
