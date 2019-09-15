package com.clinic.cardio.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;
import org.springframework.core.style.ToStringCreator;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.*;


enum Province{
    BC("BC"),
    ON("ON"),
    QC("QC");

    private final String displayName;
    Province(String displayName) {
        this.displayName = displayName;
    }
    public String getDisplayName() {
        return displayName;
    }
}

@Entity
@Table(name = "patients")
@Getter @Setter
public class Patient extends Person {

    @Column(name = "OHIP", unique = true)
    @NotEmpty
    @Digits(fraction = 0, integer = 10)
    private String ohip;

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

    @Column(name = "postal_code")
    @NotEmpty
    @Pattern(regexp = "[ABCEGHJKLMNPRSTVXY][0-9][ABCEGHJKLMNPRSTVWXYZ][0-9][ABCEGHJKLMNPRSTVWXYZ][0-9]", message = "" +
            "Format is \"M0E0E0\"")
    private String postalCode;

    @Column(name = "mobile_phone")
    @NotEmpty
    @Digits(fraction = 0, integer = 10)
    private String mobilePhone;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patient")
    private Set<EchoTest> echoTests;

    private Set<EchoTest> getEchoTestsInternal() {
        if (this.echoTests == null) {
            this.echoTests = new HashSet<>();
        }
        return this.echoTests;
    }

    protected void setEchoTestsInternal(Set<EchoTest> echoTests) {
        this.echoTests = echoTests;
    }

    public List<EchoTest> getEchoTests() {
        List<EchoTest> sortedEchoTests= new ArrayList<>(getEchoTestsInternal());
        PropertyComparator.sort(sortedEchoTests,
                new MutableSortDefinition("visitDate", true, true));
        return Collections.unmodifiableList(sortedEchoTests);
    }

    public void addEchoTest(EchoTest echoTest) {
        if (echoTest.isNew()) {
            getEchoTestsInternal().add(echoTest);
        }
        echoTest.setPatient(this);
    }

    // TODO: Change attribute
    public EchoTest getEchoTest(String name) {
        return getEchoTest(name, false);
    }


    public EchoTest getEchoTest(String name, boolean ignoreNew) {
        name = name.toLowerCase();
        for (EchoTest echoTest : getEchoTestsInternal()) {
            if (!ignoreNew || !echoTest.isNew()) {
                String compName = echoTest.getName();
                compName = compName.toLowerCase();
                if (compName.equals(name)) {
                    return echoTest;
                }
            }
        }
        return null;
    }

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
