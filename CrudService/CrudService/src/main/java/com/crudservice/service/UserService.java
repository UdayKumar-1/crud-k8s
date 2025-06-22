package com.crudservice.service;

import com.crudservice.dto.UserDto;

public interface UserService {
    UserDto userRegistrationService(UserDto user);
    UserDto userLoginService(String name,String password);
    UserDto getUserRecordService(Long id);
}
