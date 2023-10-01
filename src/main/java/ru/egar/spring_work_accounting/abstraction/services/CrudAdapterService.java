package ru.egar.spring_work_accounting.abstraction.services;

public interface CrudAdapterService<Request, Response, ID> {

    Response findById(ID id);
    ID save(Request entity);
    ID update(Request entity, ID id);
    void delete(ID id);

}
