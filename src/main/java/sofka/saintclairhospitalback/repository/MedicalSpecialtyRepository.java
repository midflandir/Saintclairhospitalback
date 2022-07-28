package sofka.saintclairhospitalback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sofka.saintclairhospitalback.model.MedicalSpecialty;

public interface MedicalSpecialtyRepository extends JpaRepository<MedicalSpecialty, Integer> {
}