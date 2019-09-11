package com.clinic.cardio.models;

import com.clinic.cardio.models.EchoTestEnums.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.core.style.ToStringCreator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
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

    @Column(name = "description")
    private String description;

    @Column(name = "RV_FIELD")
    private String RV_FIELD;
    @Column(name = "AO_FIELD")
    private String AO_FIELD;
    @Column(name = "LA_FIELD")
    private String LA_FIELD;
    @Column(name = "LVS_FIELD")
    private String LVS_FIELD;
    @Column(name = "LVD_ENTRY")
    private String LVD_ENTRY;
    @Column(name = "SEPT_FIELD")
    private String SEPT_FIELD;
    @Column(name = "PW_FIELD")
    private String PW_FIELD;

    @Column(name = "EF")
    private String EF;
    @Column(name = "EA_FIRST")
    private String EA_FIRST;
    @Column(name = "EA_SECOND")
    private String EA_SECOND;
    @Column(name = "DT")
    private String DT;
    @Column(name = "IVRT")
    private String IVRT;
    @Column(name = "COMMENTS_LV")
    private String COMMENTS_LV;
    @Column(name = "P_HALF_AV")
    private String P_HALF_AV;
    @Column(name = "AVA")
    private String AVA;
    @Column(name = "LVOT")
    private String LVOT;
    @Column(name = "PG_AV")
    private String PG_AV;
    @Column(name = "MG_AV")
    private String MG_AV;
    @Column(name = "V1")
    private String V1;
    @Column(name = "V2")
    private String V2;
    @Column(name = "COMMENTS_AV")
    private String COMMENTS_AV;
    @Column(name = "P_HALF_MV")
    private String P_HALF_MV;
    @Column(name = "MG_MV")
    private String MG_MV;
    @Column(name = "MVA")
    private String MVA;
    @Column(name = "PG_MV")
    private String PG_MV;
    @Column(name = "COMMENTS_MV")
    private String COMMENTS_MV;
    @Column(name = "RVSP")
    private String RVSP;
    @Column(name = "PULMONIC_PG")
    private String PULMONIC_PG;
    @Column(name = "PULMONIC_MG")
    private String PULMONIC_MG;
    @Column(name = "COMMENTS_TPV")
    private String COMMENTS_TPV;

//  Enum field values

    @Column(name = "AI")
    @Enumerated(EnumType.STRING)
    private AI ai;

    @Column(name = "AORTA")
    @Enumerated(EnumType.STRING)
    private AORTA aorta;

    @Column(name = "ASAV")
    @Enumerated(EnumType.STRING)
    private ASAV asav;

    @Column(name = "AV")
    @Enumerated(EnumType.STRING)
    private AV av;

    @Column(name = "CLOT")
    @Enumerated(EnumType.STRING)
    private CLOT clot;

    @Column(name = "DIASFUNC")
    @Enumerated(EnumType.STRING)
    private DIASFUNC diasfunc;

    @Column(name = "GRADES")
    @Enumerated(EnumType.STRING)
    private GRADES grades;

    @Column(name = "IMAGEQUALITY")
    @Enumerated(EnumType.STRING)
    private IMAGEQUALITY imagequality;

    @Column(name = "LA")
    @Enumerated(EnumType.STRING)
    private LA la;

    @Column(name = "LVD")
    @Enumerated(EnumType.STRING)
    private LVD lvd;

    @Column(name = "LVH")
    @Enumerated(EnumType.STRING)
    private LVH lvh;

    @Column(name = "MR")
    @Enumerated(EnumType.STRING)
    private MR mr;

    @Column(name = "MS")
    @Enumerated(EnumType.STRING)
    private MS ms;

    @Column(name = "MV")
    @Enumerated(EnumType.STRING)
    private MV mv;

    @Column(name = "MVP")
    @Enumerated(EnumType.STRING)
    private MVP mvp;

    @Column(name = "PE")
    @Enumerated(EnumType.STRING)
    private PE pe;

    @Column(name = "PI")
    @Enumerated(EnumType.STRING)
    private PI pi;

    @Column(name = "PROPHYLAXIS")
    @Enumerated(EnumType.STRING)
    private PROPHYLAXIS prophylaxis;

    @Column(name = "PS")
    @Enumerated(EnumType.STRING)
    private PS ps;

    @Column(name = "PULHYP")
    @Enumerated(EnumType.STRING)
    private PULHYP pulhyp;

    @Column(name = "PV")
    @Enumerated(EnumType.STRING)
    private PV pv;

    @Column(name = "RA")
    @Enumerated(EnumType.STRING)
    private RA ra;

    @Column(name = "RV")
    @Enumerated(EnumType.STRING)
    private RV rv;

    @Column(name = "TR")
    @Enumerated(EnumType.STRING)
    private TR tr;

    @Column(name = "TV")
    @Enumerated(EnumType.STRING)
    private TV tv;

//  Enum field values END

@Override
    public String toString() {
        return new ToStringCreator(this)
                .append("id", this.getId()).append("new", this.isNew()).toString();
    }
}
