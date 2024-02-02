package com.map.example.Controller;

import com.map.example.Repository.AddressRepo;
import com.map.example.Repository.StudentRepo;
import com.map.example.model.Address;
import com.map.example.model.Student;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Data

@RestController

public class StudentController {
    @Autowired
    StudentRepo stud;

    @Autowired
    AddressRepo addrepo;

    @GetMapping("/Student")
    public List<Student> getAllStudents(){
        List<Student> std =stud.findAll();
       return std;
    }

    @PostMapping("/Student")
    public Student addStudent(@RequestBody Student st) {
         Student sts =stud.save(st);
         List<Address> address=sts.getAddressList();
         address.forEach(address1 -> {
             address1.setStudent(sts);
             addrepo.save(address1);
         });




    return sts;

    }

}
