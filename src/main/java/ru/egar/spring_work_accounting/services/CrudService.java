package ru.egar.spring_work_accounting.services;

public interface CrudService<T, ID> {

    T findById(ID id);
    ID save(T entity);
    ID update(T entity, ID id);
    void delete(ID id);

}
