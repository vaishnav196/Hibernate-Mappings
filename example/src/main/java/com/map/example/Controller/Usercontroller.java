package com.map.example.Controller;

import com.map.example.Repository.ProfileRepo;
import com.map.example.Repository.UserRepo;
import com.map.example.model.Profile;
import com.map.example.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Usercontroller {
    @Autowired
    UserRepo Urepo;
     @Autowired
    ProfileRepo profileRepo;


    @GetMapping("/users")
    public List<Users>getAllUser(){
        List<Users> allUsers= Urepo.findAll();
        return allUsers;
    }
    @PostMapping("/user")
    public Users adduser(@RequestBody Users us){

         Users savedUser=Urepo.save(us);

             savedUser.getProfile().setUser(savedUser);
             profileRepo.save(savedUser.getProfile());



        return savedUser;
    }

}
