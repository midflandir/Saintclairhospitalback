package sofka.saintclairhospitalback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sofka.saintclairhospitalback.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
}