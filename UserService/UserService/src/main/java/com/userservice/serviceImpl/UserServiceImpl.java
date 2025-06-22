package com.userservice.serviceImpl;

import com.userservice.entity.User;
import com.userservice.repository.UserRepository;
import com.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User userRegistrationService(User user){
        return userRepository.save(user);
    }

    @Override
    public User userLoginService(String email,String password) {
        User userDb =userRepository.findByEmailAndPassword(email, password);
        if(userDb!=null&&userDb.getPassword().equals(password)){
            return userDb;
        }
        else{
            return null;
        }
    }
    @Override
    public User getUserRecordService(Long id) {
        User user=userRepository.findById(id).get();
        return user.getId()!=null?user:null;
    }
}
