package sofka.saintclairhospitalback.service;

import sofka.saintclairhospitalback.dto.DTOMedicalSpecialty;

import java.util.List;

public interface IServiceMedicalSpecialty {
    List<DTOMedicalSpecialty> findAllMedicalSpecialty();
}
