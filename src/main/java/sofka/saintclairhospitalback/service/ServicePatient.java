package sofka.saintclairhospitalback.service;

import org.springframework.stereotype.Service;
import sofka.saintclairhospitalback.dto.DTOMedicalSpecialty;
import sofka.saintclairhospitalback.dto.DTOPatient;
import sofka.saintclairhospitalback.model.MedicalSpecialty;
import sofka.saintclairhospitalback.model.Patient;
import sofka.saintclairhospitalback.repository.PatientRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicePatient implements IServicePatient{

    private final PatientRepository patientrepository;

    public ServicePatient(PatientRepository patientrepository) {
        this.patientrepository = patientrepository;
    }

    @Override
    public DTOPatient savePatientRegister(DTOMedicalSpecialty dtoMedicalSpecialty) {
       // List<DTOMedicalSpecialty> Entity_toDTO;

        return convertPatientEntitytoDTO(patientrepository.save(
                convertDTOtoPatientEntity(dtoMedicalSpecialty.getPatients().get(0), dtoMedicalSpecialty)));


    }

    @Override
    public void deletePatient(Integer id){
        patientrepository.deleteById(id);
    }
    private Patient convertDTOtoPatientEntity(DTOPatient DTOpatient, DTOMedicalSpecialty dtoMedicalSpecialty) {
        Patient aux_patient = new Patient();

        aux_patient.setId(DTOpatient.getId());
        aux_patient.setName(DTOpatient.getName());
        aux_patient.setAge(DTOpatient.getAge());
        aux_patient.setIdentificationNumber(DTOpatient.getIdentificationNumber());
        aux_patient.setDate(String.join(",", DTOpatient.getDate()));
        aux_patient.setNumberOfApointments(DTOpatient.getNumberOfApointments());
        aux_patient.setFkMedicalSpecialty(convertDTOtoEntity(dtoMedicalSpecialty));

        return aux_patient;
    }
    public MedicalSpecialty convertDTOtoEntity(DTOMedicalSpecialty specialty){

        MedicalSpecialty auxdtospeciualty = new MedicalSpecialty();
        auxdtospeciualty.setId(specialty.getId());
        auxdtospeciualty.setPhysicianInCharge(specialty.getPhysicianInCharge());
        auxdtospeciualty.setName(specialty.getName());
        auxdtospeciualty.setPatients(null);

        return auxdtospeciualty;
    }

    private DTOMedicalSpecialty convertMedicalEntitytoDTOsingle(MedicalSpecialty medicalspecialty){

        DTOMedicalSpecialty auxdtospeciualty = new DTOMedicalSpecialty();
        auxdtospeciualty.setId(medicalspecialty.getId());
        auxdtospeciualty.setPhysicianInCharge(medicalspecialty.getPhysicianInCharge());
        auxdtospeciualty.setName(medicalspecialty.getName());
        auxdtospeciualty.setPatients(null);

        return auxdtospeciualty;
    }


    private DTOPatient convertPatientEntitytoDTO(Patient patient){

            DTOPatient auxdtopatient = new DTOPatient();

            auxdtopatient.setId(patient.getId());
            auxdtopatient.setName(patient.getName());
            auxdtopatient.setAge(patient.getAge());
            auxdtopatient.setIdentificationNumber(patient.getIdentificationNumber());

            String[] dates = patient.getDate().split(",");
            auxdtopatient.setDate(Arrays.stream(dates).collect(Collectors.toList()));

            auxdtopatient.setNumberOfApointments(patient.getNumberOfApointments());


        return auxdtopatient;
    }

}
