package sofka.saintclairhospitalback.service;

import org.springframework.stereotype.Service;
import sofka.saintclairhospitalback.dto.DTOMedicalSpecialty;
import sofka.saintclairhospitalback.dto.DTOPatient;
import sofka.saintclairhospitalback.model.MedicalSpecialty;
import sofka.saintclairhospitalback.model.Patient;
import sofka.saintclairhospitalback.repository.MedicalSpecialtyRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceMedicalSpecialty implements IServiceMedicalSpecialty{

    private final MedicalSpecialtyRepository medicalspecialtyrepository;

    public ServiceMedicalSpecialty(MedicalSpecialtyRepository medicalspecialtyrepository) {
        this.medicalspecialtyrepository = medicalspecialtyrepository;
    }

    @Override
    public List<DTOMedicalSpecialty> findAllMedicalSpecialty() {
        List<DTOMedicalSpecialty> EntitytoDTO;

        EntitytoDTO = convertMedicalEntitytoDTO(medicalspecialtyrepository.findAll());

        return EntitytoDTO;
    }

    private List<DTOMedicalSpecialty> convertMedicalEntitytoDTO(List<MedicalSpecialty> medicalspecialtylist){
        List<DTOMedicalSpecialty> EntitytoDTO = new ArrayList<>();
        for (int i = 0; i< medicalspecialtylist.size(); i++){
            DTOMedicalSpecialty auxdtospeciualty = new DTOMedicalSpecialty();
            auxdtospeciualty.setId(medicalspecialtylist.get(i).getId());
            auxdtospeciualty.setPhysicianInCharge(medicalspecialtylist.get(i).getPhysicianInCharge());
            auxdtospeciualty.setName(medicalspecialtylist.get(i).getName());
            auxdtospeciualty.setPatients(convertPatientEntitytoDTO(medicalspecialtylist.get(i).getPatients()));
            EntitytoDTO.add(auxdtospeciualty);
        }

        return EntitytoDTO;
    }

    private List<DTOPatient> convertPatientEntitytoDTO(List<Patient> patientlist){
        List<DTOPatient> DTOpatientlist = new ArrayList<>();
        for (int i = 0; i< patientlist.size(); i++){

            DTOPatient auxdtopatient = new DTOPatient();

            auxdtopatient.setId(patientlist.get(i).getId());
            auxdtopatient.setName(patientlist.get(i).getName());
            auxdtopatient.setAge(patientlist.get(i).getAge());
            auxdtopatient.setIdentificationNumber(patientlist.get(i).getIdentificationNumber());

            String[] dates = patientlist.get(i).getDate().split(",");
            auxdtopatient.setDate(Arrays.stream(dates).collect(Collectors.toList()));

            auxdtopatient.setNumberOfApointments(patientlist.get(i).getNumberOfApointments());
            DTOpatientlist.add(auxdtopatient);
        }

        return DTOpatientlist;
    }




}
