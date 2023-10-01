package ru.egar.spring_work_accounting.abstraction.mappers;

public interface OneSidedIterableMapper<E, D> extends OneSidedMapper<E, D> {

    Iterable<D> iterableMap(Iterable<E> entityIterable);

}
