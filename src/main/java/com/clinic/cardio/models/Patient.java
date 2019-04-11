package com.clinic.cardio.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.core.style.ToStringCreator;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


enum Province{
    BC, ON, QC
}

@Entity
@Table(name = "patients")
@Getter @Setter
public class Patient extends Person {

    @Column(name = "address")
    @NotEmpty
    private String address;

    @Column(name = "city")
    @NotEmpty
    private String city;

    @Column(name = "province")
    @Enumerated(EnumType.STRING)
    @NotNull
    private Province province;

    @Column(name = "mobile_phone")
    @NotEmpty
    @Digits(fraction = 0, integer = 10)
    private String mobilePhone;



    @Override
    public String toString() {
        return new ToStringCreator(this)
                .append("id", this.getId()).append("new", this.isNew())
                .append("lastName", this.getLastName())
                .append("firstName", this.getFirstName())
                .append("gender", this.getGender())
                .append("DOB", this.getBirthDate())
                .append("address", this.getAddress())
                .append("city", this.getCity())
                .append("province", this.getProvince())
                .append("mobilePhone", this.getMobilePhone()).toString();
    }
}
