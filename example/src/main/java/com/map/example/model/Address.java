package com.map.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "address")
public class Address {
    @Id
    @Column(name = "aid")
    private int id;
    @Column(name = "city")
    private String city;
    @Column(name = "country")
    private String country;

    @ManyToOne
    @JoinColumn(name = "student_id")
    @JsonIgnore
    private Student student;
}
