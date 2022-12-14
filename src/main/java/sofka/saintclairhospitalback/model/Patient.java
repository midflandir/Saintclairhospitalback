package sofka.saintclairhospitalback.model;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Data
@Table(name = "patient",
        uniqueConstraints = {@UniqueConstraint(name = "Uniquepatientinmedicalspecialty",
                columnNames = {"fk_medical_specialty", "identification_number"})})
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
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