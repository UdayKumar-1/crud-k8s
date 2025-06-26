package com.crudservice.service;

import com.crudservice.dto.CrudDto;
import com.crudservice.entity.Crud;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CrudService {
    Crud addItemService(Crud crud);
    List<CrudDto> getAllCrudItems();
    void deleteCrudRecordService(Long id);
}
