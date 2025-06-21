package com.crudservice.service;

import com.crudservice.entity.Crud;

import java.util.List;

public interface CrudService {
    Crud addItemService(Crud crud);
    List<Crud> getAllCrudItems();
    void deleteCrudRecordService(Long id);
}
