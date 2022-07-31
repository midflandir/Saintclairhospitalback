package sofka.saintclairhospitalback.service;

import org.springframework.stereotype.Service;
import sofka.saintclairhospitalback.dto.DTOMedicalSpecialty;
import sofka.saintclairhospitalback.dto.DTOPatient;

import sofka.saintclairhospitalback.repository.PatientRepository;

@Service
public class ServicePatient implements IServicePatient {

    private final PatientRepository patientrepository;
    private final DTOEnttityConverters dtoEnttityConverters;

    public ServicePatient(PatientRepository patientrepository, DTOEnttityConverters dtoEnttityConverters) {
        this.patientrepository = patientrepository;
        this.dtoEnttityConverters = dtoEnttityConverters;
    }

    @Override
    public DTOPatient savePatientRegister(DTOMedicalSpecialty dtoMedicalSpecialty) {
        // List<DTOMedicalSpecialty> Entity_toDTO;
        dtoMedicalSpecialty = dtoEnttityConverters.adddate(dtoMedicalSpecialty);
        return dtoEnttityConverters.convertPatientEntitytoDTO(patientrepository.save(
                dtoEnttityConverters.convertDTOtoPatientEntity(dtoMedicalSpecialty.getPatients().get(0), dtoMedicalSpecialty)));

    }

    @Override
    public DTOPatient savePatientdate(DTOMedicalSpecialty dtoMedicalSpecialty) {
        // List<DTOMedicalSpecialty> Entity_toDTO;
        dtoMedicalSpecialty = dtoEnttityConverters.adddate(dtoMedicalSpecialty);

        Integer numberappoinments = dtoMedicalSpecialty.getPatients().get(0).getNumberOfApointments() + 1;
        dtoMedicalSpecialty.getPatients().get(0).setNumberOfApointments(numberappoinments);

        return dtoEnttityConverters.convertPatientEntitytoDTO(patientrepository.save(
                dtoEnttityConverters.convertDTOtoPatientEntity(dtoMedicalSpecialty.getPatients().get(0), dtoMedicalSpecialty)));

    }

    @Override
    public void deletePatient(Integer id) {
        patientrepository.deleteById(id);
    }


}
