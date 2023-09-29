package ru.egar.spring_work_accounting.mappers;

public interface TwoSidedMapper<E, D> extends OneSidedMapper<E, D> {

    E remap(D object);

}
