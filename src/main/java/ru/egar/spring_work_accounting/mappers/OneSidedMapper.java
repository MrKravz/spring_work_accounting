package ru.egar.spring_work_accounting.mappers;

public interface OneSidedMapper<E, D> {

    D map(E entity);

}
