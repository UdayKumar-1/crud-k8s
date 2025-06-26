package com.crudservice.serviceImpl;

import com.crudservice.dto.CrudDto;
import com.crudservice.dto.UserDto;
import com.crudservice.entity.Crud;
import com.crudservice.repository.CrudRepository;
import com.crudservice.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static com.crudservice.constants.URLParameters.USER_SERVICE_BASE_URL;

@Service
public class CrudServiceImpl implements CrudService {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CrudRepository crudRepository;

    @Override
    public Crud addItemService(Crud crud) {
        Crud crudDb = crudRepository.save(crud);
        return crudDb.getUserId() != null ? crudDb : null;
    }

    @Override
    public List<CrudDto> getAllCrudItems() {
        List<Crud> allDbRecords = crudRepository.findAll();

        List<CrudDto> allCrudRecords = allDbRecords.stream().map((val) -> {
            CrudDto c = new CrudDto();
            c.setId(val.getId());
            c.setText(val.getText());
            c.setUser(getUserById(val.getUserId()));
            return c;
        }).toList();

        return !allCrudRecords.isEmpty() ? allCrudRecords : null;
    }
    @Override
    public void deleteCrudRecordService(Long id) {  //13
        crudRepository.deleteById(id);
    }

    public UserDto getUserById(Long userId) {
        String url = USER_SERVICE_BASE_URL+"/users/getUser?userId=" + userId;
        return restTemplate.getForObject(url, UserDto.class);
    }
}
