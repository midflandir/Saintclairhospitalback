package sofka.saintclairhospitalback.service;

import sofka.saintclairhospitalback.dto.DTOMedicalSpecialty;
import sofka.saintclairhospitalback.dto.DTOPatient;

public interface IServicePatient {

    DTOPatient savePatientRegister(DTOMedicalSpecialty dtoMedicalSpecialty);

    void deletePatient(Integer id);
}
