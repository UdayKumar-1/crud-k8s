package com.userservice.controller;

import com.userservice.entity.User;
import com.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/registration")
    public ResponseEntity<?> userRegistration(@RequestBody User user){
        System.out.println(user);
        User userDb=userService.userRegistrationService(user);
        return userDb!=null?ResponseEntity.ok(userDb):ResponseEntity.ok("Failed to Register");
    }
    @GetMapping("/login")
    public ResponseEntity<?> userLogin(@RequestParam("email")String email,@RequestParam("password")String password){
        System.out.println("name "+email+" password "+password);
        User userDb=userService.userLoginService(email,password);
        return userDb!=null?ResponseEntity.ok(userDb):ResponseEntity.ok("Wrong Credentials please try again ");
    }
    @GetMapping("/getUser")
    public User getUserRecord(@RequestParam("userId")Long userId){
        User user=userService.getUserRecordService(userId);
        return user.getId()!=null?user:null;
    }

}
