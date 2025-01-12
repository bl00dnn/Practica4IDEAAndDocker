package com.example.praktika3.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "person")
public class PeopleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "firstname")
    String firstName;
    @Column(name = "lastname")
    String lastName;
    @Column(name = "age")
    int age;
    @Column(name = "gender")
    String gender;
    @Column(name = "email")
    String email;
    @Column(name = "phonenumber")
    String phone;
}
