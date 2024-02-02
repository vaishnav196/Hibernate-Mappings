package com.map.example.model;
import com.map.example.model.Users;
import jakarta.persistence.*;

@Entity
@Table(name = "profiles")
public class Profile {
    @Id
    private int pid;
    private String Pname;
    @OneToOne
    @JoinColumn(name = "user_id")
    private Users user;

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Profile(int pid, String pname) {
        this.pid = pid;
        Pname = pname;
    }

    public Profile() {
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return Pname;
    }

    public void setPname(String pname) {
        Pname = pname;
    }
}
