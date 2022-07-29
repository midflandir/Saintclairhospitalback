package sofka.saintclairhospitalback.service;

import org.springframework.beans.factory.annotation.Autowired;
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
        List<DTOMedicalSpecialty> Entity_toDTO;

        Entity_toDTO = convertMedicalEntitytoDTO(medicalspecialtyrepository.findAll());

        return Entity_toDTO;
    }


    public DTOMedicalSpecialty saveSpecialtyRegister(DTOMedicalSpecialty specialty) {

       return convertMedicalEntitytoDTOsingle(medicalspecialtyrepository.save(convertDTOtoEntity(specialty)));

    }


    public MedicalSpecialty convertDTOtoEntity(DTOMedicalSpecialty specialty){

        MedicalSpecialty auxdtospeciualty = new MedicalSpecialty();
        auxdtospeciualty.setId(specialty.getId());
        auxdtospeciualty.setPhysicianInCharge(specialty.getPhysicianInCharge());
        auxdtospeciualty.setName(specialty.getName());
        auxdtospeciualty.setPatients(convertDTOtoPatientEntity(specialty.getPatients()));

        return auxdtospeciualty;
    }

    private DTOMedicalSpecialty convertMedicalEntitytoDTOsingle(MedicalSpecialty medicalspecialty){

            DTOMedicalSpecialty auxdtospeciualty = new DTOMedicalSpecialty();
            auxdtospeciualty.setId(medicalspecialty.getId());
            auxdtospeciualty.setPhysicianInCharge(medicalspecialty.getPhysicianInCharge());
            auxdtospeciualty.setName(medicalspecialty.getName());
            auxdtospeciualty.setPatients(convertPatientEntitytoDTO(medicalspecialty.getPatients()));

        return auxdtospeciualty;
    }

    private List<Patient> convertDTOtoPatientEntity(List<DTOPatient> DTOpatientlist){
        List<Patient> patient_list = new ArrayList<>();
        for (int i = 0; i< DTOpatientlist.size(); i++){

            Patient aux_dto_patient = new Patient();

            aux_dto_patient.setId(DTOpatientlist.get(i).getId());
            aux_dto_patient.setName(DTOpatientlist.get(i).getName());
            aux_dto_patient.setAge(DTOpatientlist.get(i).getAge());
            aux_dto_patient.setIdentificationNumber(DTOpatientlist.get(i).getIdentificationNumber());
            aux_dto_patient.setDate( String.join(", ", DTOpatientlist.get(i).getDate()));
            aux_dto_patient.setNumberOfApointments(DTOpatientlist.get(i).getNumberOfApointments());
            patient_list.add(aux_dto_patient);
        }

        return patient_list;
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
