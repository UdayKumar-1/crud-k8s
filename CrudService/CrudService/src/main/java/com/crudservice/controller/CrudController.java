package com.crudservice.controller;

import com.crudservice.dto.CrudDto;
import com.crudservice.entity.Crud;
import com.crudservice.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/cruds")
public class CrudController {
    @Autowired
    private CrudService crudService;
    @PostMapping("/insert")
    public ResponseEntity<?> addItem(@RequestBody Crud crud){
        System.out.println("crud "+crud);
        Crud crudDb=crudService.addItemService(crud);
        return crudDb!=null?ResponseEntity.ok("SuccessFully Inserted Item"):ResponseEntity.ok("Unable to add this task");
    }
    @GetMapping("/allItems")
    public ResponseEntity<?>getAllCrudItems(){
        List<CrudDto>allRecords=crudService.getAllCrudItems();
        return allRecords!=null?ResponseEntity.ok(allRecords):ResponseEntity.ok("No Records Found ");
    }
    @DeleteMapping("/deleteRecord")
    public ResponseEntity<?>deleteCrudRecord(@RequestParam("id")Long id){ //13
        crudService.deleteCrudRecordService(id);
        return new ResponseEntity<>("SuccessFully Deleted Record ",HttpStatus.OK);
    }
}
