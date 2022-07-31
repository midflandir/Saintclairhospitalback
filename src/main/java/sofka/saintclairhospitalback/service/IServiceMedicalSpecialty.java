package sofka.saintclairhospitalback.service;

import sofka.saintclairhospitalback.dto.DTOMedicalSpecialty;

import java.util.List;

public interface IServiceMedicalSpecialty {
    List<DTOMedicalSpecialty> findAllMedicalSpecialty();

    void deleteSpecialty(Integer id);

    DTOMedicalSpecialty saveSpecialtyRegister(DTOMedicalSpecialty specialty);

    DTOMedicalSpecialty updateSpecialty(DTOMedicalSpecialty specialty);
}
