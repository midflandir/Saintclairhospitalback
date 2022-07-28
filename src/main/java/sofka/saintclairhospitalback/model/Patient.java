package sofka.saintclairhospitalback.model;

import javax.persistence.*;

@Entity
@Table(name = "patient")
public class Patient {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_medical_specialty")
    private MedicalSpecialty fkMedicalSpecialty;

    @Column(name = "name", length = 45)
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "identification_number")
    private Long identificationNumber;

    @Column(name = "date")
    private String date;

    @Column(name = "number_of_apointments")
    private Integer numberOfApointments;

}