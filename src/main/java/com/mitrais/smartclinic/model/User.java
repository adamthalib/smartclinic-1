package com.mitrais.smartclinic.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String dob;

    private String idNumber;

    private String gender;

    private String address;

    private String phone1;

    private String phone2;
}
