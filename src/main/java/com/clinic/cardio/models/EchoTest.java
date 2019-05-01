package com.clinic.cardio.models;

import com.clinic.cardio.models.EchoTestEnums.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "echotests")
@Getter @Setter
public class EchoTest extends BaseEntity{

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @Column(name = "visit_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate visitDate;

    @NotEmpty
    @Column(name = "description")
    private String description;

//  Enum field values

    @Column(name = "AI")
    @Enumerated(EnumType.STRING)
    @NotNull
    private AI ai;

    @Column(name = "AORTA")
    @Enumerated(EnumType.STRING)
    @NotNull
    private AORTA aorta;

    @Column(name = "AV")
    @Enumerated(EnumType.STRING)
    @NotNull
    private AV av;

    @Column(name = "CLOT")
    @Enumerated(EnumType.STRING)
    @NotNull
    private CLOT clot;

    @Column(name = "DIASFUNC")
    @Enumerated(EnumType.STRING)
    @NotNull
    private DIASFUNC diasfunc;

    @Column(name = "GRADES")
    @Enumerated(EnumType.STRING)
    @NotNull
    private GRADES grades;

    @Column(name = "IMAGEQUALITY")
    @Enumerated(EnumType.STRING)
    @NotNull
    private IMAGEQUALITY imagequality;

    @Column(name = "LA")
    @Enumerated(EnumType.STRING)
    @NotNull
    private LA la;

    @Column(name = "LVD")
    @Enumerated(EnumType.STRING)
    @NotNull
    private LVD lvd;

    @Column(name = "LVH")
    @Enumerated(EnumType.STRING)
    @NotNull
    private LVH lvh;

    @Column(name = "MR")
    @Enumerated(EnumType.STRING)
    @NotNull
    private MR mr;

    @Column(name = "MS")
    @Enumerated(EnumType.STRING)
    @NotNull
    private MS ms;

    @Column(name = "MV")
    @Enumerated(EnumType.STRING)
    @NotNull
    private MV mv;

    @Column(name = "MVP")
    @Enumerated(EnumType.STRING)
    @NotNull
    private MVP mvp;

    @Column(name = "PE")
    @Enumerated(EnumType.STRING)
    @NotNull
    private PE pe;

    @Column(name = "PI")
    @Enumerated(EnumType.STRING)
    @NotNull
    private PI pi;

    @Column(name = "PROPHYLAXIS")
    @Enumerated(EnumType.STRING)
    @NotNull
    private PROPHYLAXIS prophylaxis;

    @Column(name = "PS")
    @Enumerated(EnumType.STRING)
    @NotNull
    private PS ps;

    @Column(name = "PULHYP")
    @Enumerated(EnumType.STRING)
    @NotNull
    private PULHYP pulhyp;

    @Column(name = "PV")
    @Enumerated(EnumType.STRING)
    @NotNull
    private PV pv;

    @Column(name = "RA")
    @Enumerated(EnumType.STRING)
    @NotNull
    private RA ra;

    @Column(name = "RV")
    @Enumerated(EnumType.STRING)
    @NotNull
    private RV rv;

    @Column(name = "TR")
    @Enumerated(EnumType.STRING)
    @NotNull
    private TR tr;

    @Column(name = "TV")
    @Enumerated(EnumType.STRING)
    @NotNull
    private TV tv;

//  Enum field values END

}
