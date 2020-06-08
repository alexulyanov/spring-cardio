package com.clinic.cardio.model;

import lombok.Data;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;



@Data
@Entity
@Table(name = "patients")
public class Patient implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String gender;

    @Column(name = "date_of_birth")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    @Column(name = "OHIP", unique = true)
    private String ohip;

    private String address;

    private String city;

    private String province;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "mobile_phone")
    private String mobilePhone;


    public boolean isNew() {
        return this.id == null;
    }

}
