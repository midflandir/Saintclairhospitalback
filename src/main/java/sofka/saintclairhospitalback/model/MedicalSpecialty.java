package sofka.saintclairhospitalback.model;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "medical_specialty")
public class MedicalSpecialty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "physician_in_charge", length = 45)
    private String physicianInCharge;

    @OneToMany(mappedBy = "fkMedicalSpecialty")
    private Set<Patient> patients = new LinkedHashSet<>();


}