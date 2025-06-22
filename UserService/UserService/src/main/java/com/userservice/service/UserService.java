package com.userservice.service;

import com.userservice.entity.User;

public interface UserService {
    User userRegistrationService(User user);
    User userLoginService(String name,String password);
    User getUserRecordService(Long id);
}
