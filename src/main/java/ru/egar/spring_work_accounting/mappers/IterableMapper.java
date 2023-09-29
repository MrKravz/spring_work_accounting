package ru.egar.spring_work_accounting.mappers;

public interface IterableMapper<E, D> extends TwoSidedMapper<E, D> {

    Iterable<D> iterableMap(Iterable<E> entityIterable);
    Iterable<E> iterableRemap(Iterable<D> objectIterable);

}
