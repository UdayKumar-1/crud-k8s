package com.crudservice.service;

import com.crudservice.entity.User;

public interface UserService {
    User userRegistrationService(User user);
    User userLoginService(String name,String password);
    User getUserRecordService(Long id);
}
