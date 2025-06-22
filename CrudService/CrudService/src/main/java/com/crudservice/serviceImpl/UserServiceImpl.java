package com.crudservice.serviceImpl;

import com.crudservice.dto.UserDto;
import com.crudservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
//    @Autowired
//    private UserRepository userRepository;
    @Override
    public UserDto userRegistrationService(UserDto user){
//        return userRepository.save(user);
        return null;
    }

    @Override
    public UserDto userLoginService(String email, String password) {
        UserDto userDb =null;//userRepository.findByEmailAndPassword(email, password);
        if(userDb!=null&&userDb.getPassword().equals(password)){
            return userDb;
        }
        else{
            return null;
        }
    }
    @Override
    public UserDto getUserRecordService(Long id) {
        UserDto user=null;//userRepository.findById(id).get();
        return user.getId()!=null?user:null;
    }
}
