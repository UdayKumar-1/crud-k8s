package com.crudservice.serviceImpl;

import com.crudservice.entity.Crud;
import com.crudservice.repository.CrudRepository;
import com.crudservice.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrudServiceImpl implements CrudService {

    @Autowired
    private CrudRepository crudRepository;

    @Override
    public Crud addItemService(Crud crud) {
        Crud crudDb = crudRepository.save(crud);
        return crudDb.getUserId() != null ? crudDb : null;
    }

    @Override
    public List<Crud> getAllCrudItems() {
        List<Crud> allDbRecords = crudRepository.findAll();

        return !allDbRecords.isEmpty() ? allDbRecords : null;
    }
    @Override
    public void deleteCrudRecordService(Long id) {  //13
        crudRepository.deleteById(id);
    }

}
