package com.map.example.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import  com.map.example.model.Profile;
import jakarta.persistence.*;

@Entity
@Table (name = "users")
public class Users{
   @Id
    private int uid;
    private String uname;
    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"user"})
    private Profile profile;

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Users() {
    }

    public Users(int uid, String uname) {
        this.uid = uid;
        this.uname = uname;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

//    public Address getAddress() {
//        return address;
//    }
//
//    public void setAddress(Address address) {
//        this.address = address;
//    }
//
//    public Users(Address address) {
//        this.address = address;
//    }


}
